package com.curou.oa.dao.extend;

public class CompanyInfoExtendSqlProvider {

    public String getCompanyInfoByUploadDetailId(String uploadDetailId){
        StringBuffer sb = new StringBuffer();
        String sql = "SELECT c.reg_no,c.reg_name,c.company_name,c.contact_phone from (select id from upload_detail where id = #{uploadDetailId}) as a left join upload_user as b on a.id = b.upload_detail_id\n" +
                "left join company_info as c on b.company_info_id = c.id order by b.sort";
        sb.append(sql);

        return sb.toString();
    }
}
