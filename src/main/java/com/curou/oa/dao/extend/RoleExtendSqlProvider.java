package com.curou.oa.dao.extend;

import com.curou.oa.entity.SearchBase;
import org.apache.commons.lang3.StringUtils;

public class RoleExtendSqlProvider {

    public String roleList(SearchBase search){
        String sql = "select a.id,a.name,a.create_time_utc,a.modify_time_utc ,group_concat(c.name) as perm,group_concat(c.id) as permId\n" +
                "from role as a ,roles_permissions  as b ,permission as c  where a.id=b.role_id and b.perm_id=c.id ";

        StringBuffer sb = new StringBuffer();
        sb.append(sql);
        if(StringUtils.isNotBlank(search.getKeyword())){
            sb.append(" and a.name like '%"+search.getKeyword()+"%'");
        }
        sb.append(" GROUP BY a.id");
        if(StringUtils.isNotBlank(search.getOrderBy())){
            sb.append(" order by "+search.getOrderBy());
        }else{
            sb.append(" ORDER BY create_time_utc desc");
        }
        return sb.toString();
    }
}
