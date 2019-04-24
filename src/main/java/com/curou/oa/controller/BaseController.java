package com.curou.oa.controller;

import com.curou.oa.models.CompanyInfo;
import com.curou.oa.models.UploadDetail;
import com.curou.oa.models.UploadUser;
import com.curou.oa.models.User;
import com.curou.oa.service.CompanyInfoService;
import com.curou.oa.service.UploadDetailService;
import com.curou.oa.service.UploadUserService;
import com.curou.oa.utils.Exception.AjaxException;
import com.curou.oa.utils.ListUtils;
import com.jagregory.shiro.freemarker.ShiroTags;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.FastDateFormat;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import sun.misc.UUDecoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.*;

@Controller
public class BaseController {

    @Autowired
    CompanyInfoService companyInfoService;

    @Autowired
    UploadUserService uploadUserService;

    @Autowired
    UploadDetailService uploadDetailService;

    @RequestMapping("jump")
    public String jump(String url) {
        return url;
    }

    @RequestMapping("upload")
    @ResponseBody
    public Map<String, String> upload(HttpServletResponse response, HttpServletRequest request) throws Exception{
        User user = (User) SecurityUtils.getSubject().getSession().getAttribute("user");
        //获取接收文件的对象
        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        //获取上传的文件（存放在内存中）
        MultipartFile multipartFile = multipartRequest.getFile("file");
        //获取文件上传的地址
        String path = request.getSession().getServletContext().getRealPath("upload");
        //判断文件夹是否存在
        File file = new File(path);
        if(!file.exists()){
            file.mkdirs();
        }
        //获取文件名
        String fileName = multipartFile.getOriginalFilename();
        //在上传的文件夹中以这个文件名创建一个文件
        File target = new File(path, fileName);
        //文件写入
        multipartFile.transferTo(target);
        List<List<Cell>> list = new ArrayList<>();
        String msg = "";
        String uploadDetailId = "";
        try {
            list = loadFile(target,0,1);
            UploadDetail uploadDetail = new UploadDetail();
            uploadDetailId = UUID.randomUUID().toString();
            uploadDetail.setId(uploadDetailId);
            uploadDetail.setCreateTimeUtc(new Date());
            uploadDetail.setUserId(user.getId());
            uploadDetail.setCount(list.size());


            int index = 1;
            int effective = 0;
            for (List<Cell> cells : list) {
                String companyInfoId = UUID.randomUUID().toString();

                //上传明细跟用户信息关联表
                UploadUser uploadUser = new UploadUser();
                String uploadUserId = UUID.randomUUID().toString();
                uploadUser.setId(uploadUserId);
                uploadUser.setUploadDetailId(uploadDetailId);



                CompanyInfo companyInfo = new CompanyInfo();
                String companyName = getCellValue(cells.get(0));
                String regNo = getCellValue(cells.get(1));
                String regName = getCellValue(cells.get(2));
                companyInfo.setCreateTimeUtc(new Date());
                companyInfo.setModifyTimeUtc(new Date());
                companyInfo.setCompanyName(companyName);
                companyInfo.setId(companyInfoId);
                companyInfo.setRegName(regName);
                companyInfo.setRegNo(regNo);
                String phone = null;
                List<CompanyInfo> cfList = companyInfoService.getByRegNoAndRegName(companyInfo);
                if(ListUtils.isNotNullOrEmpty(cfList)){
                    CompanyInfo temp = cfList.get(0);
                    phone = temp.getContactPhone();
                    if(StringUtils.isBlank(phone)){
                        phone = sendGet(regNo,regName);
                        if(isNumeric(phone)){
                            companyInfo.setContactPhone(phone);
                            companyInfoService.update(companyInfo);
                            effective++;
                        }
                    }else{
                        effective++;
                    }
                    uploadUser.setCompanyInfoId(temp.getId());
                    uploadUser.setSort(index++);
                    uploadUserService.add(uploadUser);
                }else{
                    phone = sendGet(regNo,regName);
                    if(isNumeric(phone)){
                        companyInfo.setContactPhone(phone);
                        effective++;
                    }
                    companyInfoService.add(companyInfo);
                    uploadUser.setCompanyInfoId(companyInfoId);
                    uploadUser.setSort(index++);
                    uploadUserService.add(uploadUser);
                }
            }
            uploadDetail.setEffectiveCount(effective);
            uploadDetailService.add(uploadDetail);

        }catch (Exception e){
            msg = e.getMessage();
            System.out.println(msg);
        }




        Map<String, String> map = new HashMap<>();
        if(StringUtils.isBlank(msg)){
            map.put("result", uploadDetailId);
        }else{
            map.put("error", msg);
        }


        return map;
    }

    @RequestMapping("exportCompanyInfo")
    public void exportCompanyInfo(String uploadDetailId,HttpServletRequest request, HttpServletResponse response) throws Exception{
        List<CompanyInfo> datasList = companyInfoService.getCompanyInfoByUploadDetailId(uploadDetailId);
        String[] headers = { "企业名称", "统一社会信用代码","法定代表人","联系方式"};
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet();
        //设置列宽
        sheet.setDefaultColumnWidth((short) 18);
        //创建第一行的对象，第一行一般用于填充标题内容。从第二行开始一般是数据
        HSSFRow row = sheet.createRow(0);
        for (short i = 0; i < headers.length; i++) {
            //创建单元格，每行多少数据就创建多少个单元格
            HSSFCell cell = row.createCell(i);
            HSSFRichTextString text = new HSSFRichTextString(headers[i]);
            //给单元格设置内容
            cell.setCellValue(text);
        }

        //遍历集合，将每个集合元素对象的每个值填充到单元格中
        for(int i=0;i<datasList.size();i++){
            CompanyInfo companyInfo = datasList.get(i);
            //从第二行开始填充数据
            row = sheet.createRow(i+1);
            //该集合只记录数量和时间，这两个值来自statisticsModel。如果对象比较复杂，需要额外转换，比如Date类型的日期，int，float类型的数值
            List<String> datas=new ArrayList<>();

            String companyName = companyInfo.getCompanyName();
            String regNo = companyInfo.getRegNo();
            String regName = companyInfo.getRegName();
            String phone = companyInfo.getContactPhone();
            datas.add(companyName);
            datas.add(regNo);
            datas.add(regName);
            datas.add(phone);
            for (int j=0;j<datas.size();j++) {
                String string=datas.get(j);
                HSSFCell cell = row.createCell(j);
                HSSFRichTextString richString = new HSSFRichTextString(string);
                HSSFFont font3 = workbook.createFont();

                richString.applyFont(font3);
                cell.setCellValue(richString);
            }

        }

        response.setContentType("application/octet-stream");
        response.setHeader("Content-disposition", "attachment;filename="+"Devices.xls");//Excel文件名
        try {
            response.flushBuffer();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        //将workbook中的内容写入输出流中
        workbook.write(response.getOutputStream());

    }

    /**
     * 检验是不是数字
     *
     * @author hlh
     *
     */
    public boolean isNumeric(String str) {
        String bigStr;
        try {
            bigStr = new BigDecimal(str).toString();
        } catch (Exception e) {
            return false;// 异常 说明包含非数字。
        }
        return true;
    }


    public List<List<Cell>> loadFile(File excel, int sheetIndex, int lineIndex) throws Exception{
        List<List<Cell>> fList = new ArrayList<List<Cell>>();

            String[] split = excel.getName().split("\\."); // .是特殊字符，需要转义
            Workbook wb = null;
            // 根据文件后缀（xls/xlsx）进行判断
            if ("xls".equals(split[1])) {
                FileInputStream fis = new FileInputStream(excel); // 文件流对象
                wb = new HSSFWorkbook(fis);
            } else if ("xlsx".equals(split[1])) {
                FileInputStream fis = new FileInputStream(excel); // 文件流对象
                wb = new XSSFWorkbook(fis);
            } else {
                throw new AjaxException("文件类型错误!");
            }

            // 开始解析产品表
            Sheet sheet = wb.getSheetAt(sheetIndex); // 读取sheet 0
            int firstRowIndex = sheet.getFirstRowNum() + lineIndex; // 起始行下标,+1跳过标题
            int lastRowIndex = sheet.getLastRowNum(); // 最末行下标
            int firstCellIndex = 0; // 每行起始列下标
            int lastCellIndex = sheet.getRow(0).getLastCellNum (); // 行中最后一个不为空的列

//            if(lastRowIndex>500){
//                throw new AjaxException("查询数目超过500条!");
//            }
            if(lastCellIndex!=3){
                throw new AjaxException("列数错误!应该为“企业名称”、“统一社会信用代码”、“法定代表人”3列数据！");
            }


            for (int rIndex = firstRowIndex; rIndex <= lastRowIndex; rIndex++) { // 遍历行
                List<Cell> list = new ArrayList<Cell>();
                Row row = sheet.getRow(rIndex);
                int index = 0;
                if (row != null) {
                    for (int cIndex = firstCellIndex; cIndex < lastCellIndex; cIndex++) { // 遍历列
                        Cell cell = row.getCell(cIndex);
                        if (cell == null || StringUtils.isBlank(cell.toString())) {
                            index++;
                        }
                        list.add(cell);
                    }
                }
                //lastCellIndex + 1是最末列，及整行所有列的值都为null
                if (index == (lastCellIndex + 1) || row == null) {
                    // 跳过空白行继续查看后面的数据用continue，有空白行，后面的数据直接舍弃用break；
                    break;
                }
                fList.add(list);
            }
            wb.close();


        return fList;
    }

    public String getCellValue(Cell cell) {
        String val = "";
        if (cell != null && !"".equals(cell.toString().trim())) {
            switch (cell.getCellType()) {
                case NUMERIC:
                    if (DateUtil.isCellDateFormatted(cell)) {// 判断是不是日期类型
                        val = FastDateFormat.getInstance("yyyy-MM-dd HH:mm:ss")
                                .format(DateUtil.getJavaDate(cell.getNumericCellValue()));
                    } else {
                        return String.valueOf(cell.getNumericCellValue());
                    }
                    break;
                case STRING:
                    val = cell.getStringCellValue().trim();
                    break;
                default:
                    return val;

            }
        }
        return val;

    }
    @RequestMapping("getFtl")
    @ResponseBody
    public Map<String, String> getFtl(String path) throws Exception {
        Configuration cfg = new Configuration(Configuration.VERSION_2_3_21);
        cfg.setClassForTemplateLoading(this.getClass(),"/web");
        Template t = cfg.getTemplate(path);
        //最关键在这里，不使用与文件相关的Writer
        Map<String, Object> root = new HashMap<>();
        root.put("shiro", new ShiroTags());
        StringWriter stringWriter=new StringWriter();
        t.process(root, stringWriter);
        Map<String, String> map = new HashMap<>();
        map.put("result", stringWriter.toString());
        return map;
    }




    @RequestMapping("icon")
    public String icon() throws Exception {
        return "icon";
    }

    @RequestMapping("searchPhone")
    @ResponseBody
    public Map<String, String> searchPhone(String regNo, String regName) throws Exception {
        Map<String, String> map = new HashMap<>();
        map.put("success", sendGet(regNo, regName));
        return map;
    }


    // HTTP GET请求
    public String sendGet(String regNo, String regName) throws Exception {

        //String url = "http://61.154.11.191/creditpub/fjLogin/pop_contact?regNo=92350582MA31YJXN9M&contactName=洪龙华";
        String url = "http://61.154.11.191/creditpub/fjLogin/pop_contact?regNo=" + regNo + "&contactName=" + regName;
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();

        //默认值我GET
        con.setRequestMethod("GET");

        //添加请求头
        con.setRequestProperty("User-Agent", "Mozilla/5.0");

        int responseCode = con.getResponseCode();
        System.out.println("Sending 'GET' request to URL : " + url);
        System.out.println("Response Code : " + responseCode);

        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        //打印结果
        System.out.println(response.toString());
        String str = response.toString();
        str = StringUtils.substringAfter(str, "<td id=\"liaisonTelephone\">");
        str = StringUtils.substringBefore(str, "</td>");
        System.out.println(str);
        if (StringUtils.isBlank(str)) {
            str = "该企业尚未备案，或当日完成备案的要到下一个工作日生效！";
        }
        return str;
    }

}
