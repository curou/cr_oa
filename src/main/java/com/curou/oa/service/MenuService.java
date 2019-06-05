package com.curou.oa.service;

import com.curou.oa.entity.SearchBase;
import com.curou.oa.models.Menu;
import com.curou.oa.models.MenuSort;
import com.curou.oa.models.extend.MenuExtend;

import java.util.List;

public interface MenuService {

    List<List<Menu>> getAll();

    List<Menu> list(SearchBase searchBase);


    void delete(String id);

    void update(Menu menu);

    void addSubMenu(Menu menu);

    void drag(Menu menu);

    void move(List<Menu> list);

    List<MenuExtend> getMenuIncludeChildrenBySort();
    List<Menu> getMenuWithChildrenBySort();

}
