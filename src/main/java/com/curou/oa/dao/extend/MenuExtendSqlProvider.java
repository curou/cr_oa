package com.curou.oa.dao.extend;

import java.util.List;

public class MenuExtendSqlProvider {

    public String getListByPermissionsAndSort(String pid, List<String> permissions){
        StringBuffer sb = new StringBuffer();
        sb.append("select a.*,b.sort from menu as a , menu_sort  as b where a.pid = '"+pid+"' and (");
        for (int i = 0; i < permissions.size(); i++) {
            sb.append("a.permission_id ='"+permissions.get(i)+"' or ");
        }
        sb.append("a.permission_id = '0')   and a.id = b.menu_id ORDER BY sort");
        return sb.toString();
    }
}
