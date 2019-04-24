package com.curou.oa.service;

import com.curou.oa.entity.SearchBase;
import com.curou.oa.models.Menu;

import java.util.List;

public interface MenuService {

    List<List<Menu>> getAll();

    List<Menu> list(SearchBase searchBase);

    void add(Menu menu);

    void update(Menu menu);
}
