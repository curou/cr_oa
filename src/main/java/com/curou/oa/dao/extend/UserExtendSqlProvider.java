package com.curou.oa.dao.extend;

import com.curou.oa.entity.UserSearch;
import org.apache.commons.lang3.StringUtils;

public class UserExtendSqlProvider {

    public String userList(UserSearch search){
        String sql = "select a.*,group_concat(c.name) as role,group_concat(b.role_id) as roleId ,d.name as department\n" +
                "from  user as a ,user_roles  as b ,role as c ,department as d  where a.id=b.user_id and b.role_id=c.id and a.department_id = d.id";
        StringBuffer sb = new StringBuffer();
        sb.append(sql);
        if(StringUtils.isNotBlank(search.getName())){
            sb.append(" and a.name like '%"+search.getName()+"%'");
        }
        if(StringUtils.isNotBlank(search.getMobilePhone())){
            sb.append(" and a.mobile_phone like '%"+search.getMobilePhone()+"%'");
        }
        if(StringUtils.isNotBlank(search.getDepartment())){
            sb.append(" and a.department_id ='"+search.getDepartment()+"'");
        }
        if(StringUtils.isNotBlank(search.getSex())){
            sb.append(" and a.sex = '"+search.getSex()+"'");
        }
        sb.append(" GROUP BY a.id");
        if(StringUtils.isNotBlank(search.getOrderBy())){
            sb.append(" order by "+search.getOrderBy());
        }else{
            sb.append(" ORDER BY create_time_utc desc");
        }
        return sb.toString();
    }

    public String getPermsFlagByUserAccount(String account){
        StringBuffer sb = new StringBuffer();
        sb.append("select d.flag from user as a,user_roles as b,roles_permissions as c,permission as d where a.id=b.user_id and b.role_id = c.role_id and c.perm_id = d.id and a.account='"+account+"'");
        return sb.toString();
    }

    public String getPermsIdByUserAccount(String account){
        StringBuffer sb = new StringBuffer();
        sb.append("select d.id from user as a,user_roles as b,roles_permissions as c,permission as d where a.id=b.user_id and b.role_id = c.role_id and c.perm_id = d.id and a.account='"+account+"'");
        return sb.toString();
    }

}
