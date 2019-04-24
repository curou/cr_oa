package com.curou.oa.service.impl;

import com.curou.oa.dao.extend.MenuExtendMapper;
import com.curou.oa.entity.SearchBase;
import com.curou.oa.models.Menu;
import com.curou.oa.models.MenuExample;
import com.curou.oa.service.MenuService;
import com.curou.oa.utils.ListUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    MenuExtendMapper mapper;

    public List<List<Menu>> getAll(){
        MenuExample menuExample = new MenuExample();
        menuExample.setOrderByClause("sort,sub_sort");
        List<Menu> list = mapper.selectByExample(menuExample);
        return ListUtils.get("sort", list);
    }

    public void add(Menu menu){
        int last = mapper.getMaxSort();
        menu.setSort(last+1);
        menu.setSubSort(0);
        menu.setUrl("main");
        mapper.insert(menu);
    }

    @Override
    public List<Menu> list(SearchBase searchBase) {
        MenuExample example = new MenuExample();
        MenuExample.Criteria criteria = example.createCriteria();
        criteria.andSubSortEqualTo(0);
        example.setOrderByClause("sort");
        if(StringUtils.isNotBlank(searchBase.getKeyword())){
            criteria.andTitleLike("%" + searchBase.getKeyword() + "%");
        }
        List<Menu> menus = mapper.selectByExample(example);
        return menus;
    }

    public void update(Menu newMenu) {
        if(newMenu.getSort()==null){
            mapper.updateByPrimaryKeySelective(newMenu);
        }else{
            //查询原有主菜单及子菜单的集合
            Menu old = mapper.selectByPrimaryKey(newMenu.getId());
            MenuExample example = new MenuExample();
            MenuExample.Criteria criteria = example.createCriteria();
            criteria.andSortEqualTo(old.getSort());
            List<Menu> oldMenus = mapper.selectByExample(example);
            if(newMenu.getSort()==old.getSort()){
                mapper.updateByPrimaryKeySelective(newMenu);
            }else if(newMenu.getSort()>old.getSort()){
                MenuExample example1 = new MenuExample();
                MenuExample.Criteria criteria1 = example1.createCriteria();
                criteria1.andSortGreaterThan(old.getSort());
                criteria1.andSortLessThanOrEqualTo(newMenu.getSort());
                List<Menu> newMenus = mapper.selectByExample(example1);
                for (Menu menu : newMenus) {
                    menu.setSort(menu.getSort()-1);
                    mapper.updateByPrimaryKey(menu);
                }
                for (Menu oldMenu : oldMenus) {
                    oldMenu.setSort(newMenu.getSort());
                    mapper.updateByPrimaryKey(oldMenu);
                }
            }else{
                MenuExample example1 = new MenuExample();
                MenuExample.Criteria criteria1 = example1.createCriteria();
                criteria1.andSortGreaterThanOrEqualTo(newMenu.getSort());
                criteria1.andSortLessThan(old.getSort());
                List<Menu> newMenus = mapper.selectByExample(example1);
                for (Menu menu : newMenus) {
                    menu.setSort(menu.getSort()+1);
                    mapper.updateByPrimaryKey(menu);
                }
                for (Menu oldMenu : oldMenus) {
                    oldMenu.setSort(newMenu.getSort());
                    mapper.updateByPrimaryKey(oldMenu);
                }
            }







        }
    }
}
