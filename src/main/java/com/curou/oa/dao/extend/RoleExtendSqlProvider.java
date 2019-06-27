package com.curou.oa.dao.extend;

import com.curou.oa.entity.SearchBase;
import org.apache.commons.lang3.StringUtils;

public class RoleExtendSqlProvider {

    public String roleList(SearchBase search){
        String sql = "select a.id,a.name,a.create_time_utc,a.modify_time_utc ,group_concat(d.name) as perm,group_concat(d.perm_id) as permId from";
        StringBuffer sb = new StringBuffer();
        sb.append(sql);
        sb.append("(SELECT * from role WHERE 1=1 ");
        if(StringUtils.isNotBlank(search.getKeyword())){
            sb.append(" and role.name like '%"+search.getKeyword()+"%'");
        }
        sb.append(") as a ");
        sb.append("left join");
        sb.append(" (select b.*,c.`name` from roles_permissions  as b left join permission as c  on  b.perm_id=c.id) as d");
        sb.append(" on a.id=d.role_id");
        sb.append(" GROUP BY a.id");
        if(StringUtils.isNotBlank(search.getOrderBy())){
            sb.append(" order by "+search.getOrderBy());
        }else{
            sb.append(" ORDER BY create_time_utc desc");
        }
        return sb.toString();
    }
}
