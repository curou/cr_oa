package com.curou.oa.controller;

import com.curou.oa.entity.LmRegistrationCodeSearch;
import com.curou.oa.entity.TableBase;
import com.curou.oa.models.LmRegistrationCode;
import com.curou.oa.service.LmRegistrationCodeService;
import com.curou.oa.utils.Exception.AjaxException;
import com.curou.oa.vo.request.LmRegistrationCodeReq;
import com.curou.oa.vo.response.LmRegistrationCodeRes;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.*;

@Controller
public class LmRegistrationCodeController {

    @Autowired
    LmRegistrationCodeService service;

    @Value("${lm.key}")
    private Integer lmKey;

    @RequestMapping("lmRegistrationCode/add")
    @ResponseBody
    public Map<String,String> add(@RequestBody LmRegistrationCodeReq lmRegistrationCode){
        Map<String, String> map = new HashMap<>();
        map.put("result", "success");
        service.add(lmRegistrationCode);
        return map;
    }

    @RequestMapping("lmRegistrationCode/list")
    @ResponseBody
    public TableBase<LmRegistrationCodeRes> list(LmRegistrationCodeSearch searchBase){
        PageHelper.startPage(searchBase.getPage(),searchBase.getLimit());
        List<LmRegistrationCodeRes> list = service.list(searchBase);
        PageInfo pageInfo = new PageInfo<>(list,searchBase.getLimit());
        TableBase<LmRegistrationCodeRes> table = new TableBase<>();
        table.setCode(0);
        table.setData(list);
        table.setMsg("");
        table.setCount(pageInfo.getTotal());
        return table;
    }

    @RequestMapping("lmRegistrationCode/del")
    @ResponseBody
    public Map<String,String> del(String id){
        Map<String, String> map = new HashMap<>();
        map.put("result", "success");
        service.del(id);
        return map;
    }

    //测试
    public static void main(String[] args) {
        long time = 1558442572000l;
        time = ((time+5)*6-3)*4;
        Object obj = new SimpleHash("MD5", time+"", null, 1);
        String str = obj.toString();
        System.out.println(str);

        int random = 10618;
        random = (random - 1993)*2+5;
        str += random;
        System.out.println(str);
        Object temp = new SimpleHash("MD5", str, null, 1);
        String strTemp = temp.toString();
        System.out.println(strTemp);

        String id = UUID.randomUUID().toString();
        id = id.toLowerCase();
        id = id.replaceAll("-","");
        id = "GW"+id;
        System.out.println(id);
    }

    @RequestMapping("lmRegistrationCode/check")
    @ResponseBody
    public Map<String,String> check(LmRegistrationCodeReq lmRegistrationCode){
        //校验请求合法性
        Long time = lmRegistrationCode.getTime();
        //校验请求时间是不是超过30秒
        long gap = 30*1000;//30秒
        gap = time+gap;
        Date afterDate = new Date(gap);//30秒后的时间
        Date date = new Date();
        if(afterDate.before(date)){
            throw new AjaxException("非法访问！");
        }
        time = ((time+5)*6-3)*4;
        Object obj = new SimpleHash("MD5", time+"", null, 1);
        String str = obj.toString();

        if(!str.equals(lmRegistrationCode.getMsg())){
            throw new AjaxException("非法访问！");
        }

        Map<String, String> map = new HashMap<>();
        LmRegistrationCode check = new LmRegistrationCode();
        BeanUtils.copyProperties(lmRegistrationCode,check);
        service.checkCode(check);
        int random = lmRegistrationCode.getRandom();
        random = (random - lmKey)*2+5;
        str += random;
        obj = new SimpleHash("MD5", str, null, 1);
        str = obj.toString();
        map.put("result", str);
        return map;
    }

    @RequestMapping("lmRegistrationCode/renewal")
    @ResponseBody
    public Map<String,String> renewal(@RequestBody LmRegistrationCodeReq LmRegistrationCodeReq){
        Map<String, String> map = new HashMap<>();
        map.put("result", "success");
        service.renewalCode(LmRegistrationCodeReq);
        return map;
    }

    @RequestMapping("lmRegistrationCode/freeze")
    @ResponseBody
    public Map<String,String> freeze(String id){
        Map<String, String> map = new HashMap<>();
        map.put("result", "success");
        service.freezeCode(id);
        return map;
    }

    @RequestMapping("lmRegistrationCode/unbind")
    @ResponseBody
    public Map<String,String> unbind(String id){
        Map<String, String> map = new HashMap<>();
        map.put("result", "success");
        service.unbind(id);
        return map;
    }

}
