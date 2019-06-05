package com.curou.oa.dao.extend;

import com.curou.oa.entity.LmRegistrationCodeSearch;
import org.apache.commons.lang3.StringUtils;

public class LmRegistrationCodeExtendSqlProvider {

    public String list(LmRegistrationCodeSearch search){
        StringBuffer sb = new StringBuffer();
        String sql = "select a.*,b.card_name,c.pro_name\n" +
                "from lm_registration_code as a ,lm_card as b,lm_project as c where a.pro_type=c.id\n" +
                " and a.card_type=b.id  ";
        sb.append(sql);
        if(search.getBeginDate()!=null){
            sb.append(" and a.activation_time>='"+search.getBeginStr()+"'");
        }
        if(search.getEndDate()!=null){
            sb.append(" and a.activation_time<='"+search.getEndStr()+"'");
        }
        if(StringUtils.isNotBlank(search.getKeyword())){
            sb.append(" and a.remark like '%"+search.getKeyword()+"%'");
        }
        if(search.getStatus()!=null){
            sb.append(" and a.status="+search.getStatus());
        }
        if(StringUtils.isNotBlank(search.getCardType())){
            sb.append(" and a.card_type="+search.getCardType());
        }
        if (StringUtils.isNotBlank(search.getProType())) {
            sb.append(" and a.pro_type="+search.getProType());
        }
        if(StringUtils.isNotBlank(search.getOrderBy())){
            sb.append(" order by "+search.getOrderBy());
        }else{
            sb.append(" order by a.create_time_utc desc");
        }

        return sb.toString();
    }
}
