package com.curou.oa.dao.extend;

import com.curou.oa.entity.UserSearch;
import org.apache.commons.lang3.StringUtils;

public class UserExtendSqlProvider {

    public String userList(UserSearch search){
        String sql = "select a.*,group_concat(b.role) as role,group_concat(b.role_id) as role_id,c.name as department from";
        StringBuffer sb = new StringBuffer();
        sb.append(sql);
        sb.append(" (SELECT * from user where 1 = 1");
        if(StringUtils.isNotBlank(search.getName())){
            sb.append(" and name like '%"+search.getName()+"%'");
        }
        if(StringUtils.isNotBlank(search.getMobilePhone())){
            sb.append(" and mobile_phone like '%"+search.getMobilePhone()+"%'");
        }
        if(StringUtils.isNotBlank(search.getDepartment())){
            sb.append(" and department_id ='"+search.getDepartment()+"'");
        }
        if(StringUtils.isNotBlank(search.getSex())){
            sb.append(" and sex = '"+search.getSex()+"'");
        }
        sb.append(")as a ");
        sb.append(" left join");
        sb.append(" (SELECT user_roles.*,role.`name` as role from user_roles left join role on user_roles.role_id = role.id) as b");
        sb.append(" on a.id = b.user_id");
        sb.append(" left join department as c on a.department_id = c.id");
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
