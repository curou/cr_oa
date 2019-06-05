package com.curou.oa.service.impl;

import com.curou.oa.dao.MenuSortMapper;
import com.curou.oa.dao.extend.MenuExtendMapper;
import com.curou.oa.entity.SearchBase;
import com.curou.oa.models.*;
import com.curou.oa.models.extend.MenuExtend;
import com.curou.oa.service.MenuService;
import com.curou.oa.service.UserService;
import com.curou.oa.utils.ListUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class MenuServiceImpl implements MenuService {

    @Autowired
    MenuExtendMapper mapper;

    @Autowired
    MenuSortMapper menuSortMapper;

    @Autowired
    UserService userService;



    public List<List<Menu>> getAll(){
        MenuExample menuExample = new MenuExample();
        menuExample.setOrderByClause("sort,sub_sort");
        List<Menu> list = mapper.selectByExample(menuExample);
        return ListUtils.splitToMultipleListByFiled("sort", list);
    }

    public void addSubMenu(Menu menu){
        String id = UUID.randomUUID().toString();
        menu.setId(id);

        MenuExample example = new MenuExample();
        MenuExample.Criteria criteria = example.createCriteria();
        criteria.andPidEqualTo(menu.getPid());
        List<Menu> menus = mapper.selectByExample(example);
        int index = -1;
        for (Menu temp : menus) {
            MenuSortExample menuSortExample = new MenuSortExample();
            MenuSortExample.Criteria menuSortCriteria1 = menuSortExample.createCriteria();
            menuSortCriteria1.andMenuIdEqualTo(temp.getId());
            List<MenuSort> menuSorts = menuSortMapper.selectByExample(menuSortExample);
            int sort = menuSorts.get(0).getSort();
            if(sort>index){
                index = sort;
            }
        }
        mapper.insert(menu);
        MenuSort menuSort = new MenuSort();
        menuSort.setId(UUID.randomUUID().toString());
        menuSort.setMenuId(id);
        menuSort.setSort(index+1);
        menuSortMapper.insert(menuSort);
    }


    @Override
    public List<Menu> list(SearchBase searchBase) {
        MenuExample example = new MenuExample();
        MenuExample.Criteria criteria = example.createCriteria();
//        criteria.andSubSortEqualTo(0);
        example.setOrderByClause("sort");
        if(StringUtils.isNotBlank(searchBase.getKeyword())){
            criteria.andTitleLike("%" + searchBase.getKeyword() + "%");
        }
        List<Menu> menus = mapper.selectByExample(example);
        return menus;
    }

    public void update(Menu newMenu) {
//        if(newMenu.getSort()==null){
            mapper.updateByPrimaryKeySelective(newMenu);
//        }else{
            //查询原有主菜单及子菜单的集合
//            Menu old = mapper.selectByPrimaryKey(newMenu.getId());
//            MenuExample example = new MenuExample();
//            MenuExample.Criteria criteria = example.createCriteria();
//            criteria.andSortEqualTo(old.getSort());
//            List<Menu> oldMenus = mapper.selectByExample(example);
//            if(newMenu.getSort()==old.getSort()){
//                mapper.updateByPrimaryKeySelective(newMenu);
//            }else if(newMenu.getSort()>old.getSort()){
//                MenuExample example1 = new MenuExample();
//                MenuExample.Criteria criteria1 = example1.createCriteria();
//                criteria1.andSortGreaterThan(old.getSort());
//                criteria1.andSortLessThanOrEqualTo(newMenu.getSort());
//                List<Menu> newMenus = mapper.selectByExample(example1);
//                for (Menu menu : newMenus) {
//                    menu.setSort(menu.getSort()-1);
//                    mapper.updateByPrimaryKey(menu);
//                }
//                for (Menu oldMenu : oldMenus) {
//                    oldMenu.setSort(newMenu.getSort());
//                    mapper.updateByPrimaryKey(oldMenu);
//                }
//            }else{
//                MenuExample example1 = new MenuExample();
//                MenuExample.Criteria criteria1 = example1.createCriteria();
//                criteria1.andSortGreaterThanOrEqualTo(newMenu.getSort());
//                criteria1.andSortLessThan(old.getSort());
//                List<Menu> newMenus = mapper.selectByExample(example1);
//                for (Menu menu : newMenus) {
//                    menu.setSort(menu.getSort()+1);
//                    mapper.updateByPrimaryKey(menu);
//                }
//                for (Menu oldMenu : oldMenus) {
//                    oldMenu.setSort(newMenu.getSort());
//                    mapper.updateByPrimaryKey(oldMenu);
//                }
//            }


        }
//    }

    public void drag(Menu menu) {


        MenuExample example = new MenuExample();
        MenuExample.Criteria criteria = example.createCriteria();
        criteria.andPidEqualTo(menu.getPid());
        List<Menu> menus = mapper.selectByExample(example);
        if(ListUtils.isNotNullOrEmpty(menus)){
            List<String> list = new ArrayList<>();
            for (Menu temp : menus) {
                list.add(temp.getId());
            }
            MenuSortExample sortExample = new MenuSortExample();
            MenuSortExample.Criteria sortCriteria = sortExample.createCriteria();
            sortCriteria.andMenuIdIn(list);
            sortExample.setOrderByClause("sort desc");
            List<MenuSort> menuSorts = menuSortMapper.selectByExample(sortExample);
            if(ListUtils.isNotNullOrEmpty(menuSorts)){
                int index = menuSorts.get(0).getSort();
                index+=1;
                MenuSortExample sortExample2 = new MenuSortExample();
                MenuSortExample.Criteria sortCriteria2 = sortExample2.createCriteria();
                sortCriteria2.andMenuIdEqualTo(menu.getId());
                List<MenuSort> menuSorts2 = menuSortMapper.selectByExample(sortExample2);
                if(ListUtils.isNotNullOrEmpty(menuSorts2)){
                    MenuSort menuSort = menuSorts2.get(0);
                    menuSort.setSort(index);
                    menuSortMapper.updateByPrimaryKey(menuSort);
                }

            }
        }else{
            MenuSortExample sortExample2 = new MenuSortExample();
            MenuSortExample.Criteria sortCriteria2 = sortExample2.createCriteria();
            sortCriteria2.andMenuIdEqualTo(menu.getId());
            List<MenuSort> menuSorts2 = menuSortMapper.selectByExample(sortExample2);
            if(ListUtils.isNotNullOrEmpty(menuSorts2)){
                MenuSort menuSort = menuSorts2.get(0);
                menuSort.setSort(0);
                menuSortMapper.updateByPrimaryKey(menuSort);
            }
        }

        mapper.updateByPrimaryKeySelective(menu);



    }

    public void move(List<Menu> list){
        Menu menu1 = list.get(0);
        Menu menu2 = list.get(1);
        String id1 = menu1.getId();
        String id2 = menu2.getId();

        MenuSortExample sortExample = new MenuSortExample();
        MenuSortExample.Criteria sortCriteria = sortExample.createCriteria();
        sortCriteria.andMenuIdEqualTo(id1);
        List<MenuSort> menuSorts = menuSortMapper.selectByExample(sortExample);
        MenuSort menuSort1 = menuSorts.get(0);


        MenuSortExample sortExample2 = new MenuSortExample();
        MenuSortExample.Criteria sortCriteria2 = sortExample2.createCriteria();
        sortCriteria2.andMenuIdEqualTo(id2);
        List<MenuSort> menuSorts2 = menuSortMapper.selectByExample(sortExample2);
        MenuSort menuSort2 = menuSorts2.get(0);

        int sort1 = menuSort1.getSort();
        int sort2 = menuSort2.getSort();
        menuSort1.setSort(sort2);
        menuSortMapper.updateByPrimaryKey(menuSort1);
        menuSort2.setSort(sort1);
        menuSortMapper.updateByPrimaryKey(menuSort2);


    }

    public void delete(String id){
        mapper.deleteByPrimaryKey(id);
        MenuSortExample example = new MenuSortExample();
        MenuSortExample.Criteria criteria = example.createCriteria();
        criteria.andMenuIdEqualTo(id);
        menuSortMapper.deleteByExample(example);
        deleteChildren(id);

    }

    public void deleteChildren(String pid){
        MenuExample example = new MenuExample();
        MenuExample.Criteria criteria = example.createCriteria();
        criteria.andPidEqualTo(pid);
        List<Menu> list = mapper.selectByExample(example);
        for (Menu menu : list) {
            mapper.deleteByPrimaryKey(menu.getId());
            MenuSortExample sortExample = new MenuSortExample();
            MenuSortExample.Criteria sortCriteria = sortExample.createCriteria();
            sortCriteria.andMenuIdEqualTo(menu.getId());
            menuSortMapper.deleteByExample(sortExample);
            deleteChildren(menu.getId());
        }
    }

    public List<MenuExtend>  getMenuIncludeChildrenBySort(){
        User user = (User) SecurityUtils.getSubject().getSession().getAttribute("user");
        List<String> permissions = userService.getPermsIdByUserAccount(user.getAccount());
        List<MenuExtend> list = mapper.getListBySort("0",permissions);
        List<MenuExtend> menuIncludeChildrenList = includeChildren(list,permissions);
        return menuIncludeChildrenList;
    }

    public List<MenuExtend> includeChildren(List<MenuExtend> list,List<String> permissions) {
        for (MenuExtend menuExtend : list) {
            String id = menuExtend.getId();
            List<MenuExtend> childrenList = mapper.getListBySort(id,permissions);
            if(ListUtils.isNotNullOrEmpty(childrenList)){
                includeChildren(childrenList,permissions);
                menuExtend.setList(childrenList);
            }
        }
        return list;

    }

    public List<Menu>  getMenuWithChildrenBySort(){
        User user = (User) SecurityUtils.getSubject().getSession().getAttribute("user");
        List<String> permissions = userService.getPermsIdByUserAccount(user.getAccount());
        List<MenuExtend> list = mapper.getListBySort("0",permissions);
        List<MenuExtend> tempList = new ArrayList<>();
        addChildren(list,tempList,permissions);
        List<Menu> menuWithChildrenList = new ArrayList<>();
        for (MenuExtend menuExtend : tempList) {
            Menu menu = new Menu();
            BeanUtils.copyProperties(menuExtend, menu);
            menuWithChildrenList.add(menu);
        }
        return menuWithChildrenList;
    }

    public void addChildren(List<MenuExtend> list,List<MenuExtend> tempList,List<String> permissions) {
        for (MenuExtend menuExtend : list) {
            tempList.add(menuExtend);
            String id = menuExtend.getId();
            List<MenuExtend> childrenList = mapper.getListBySort(id,permissions);
            if(ListUtils.isNotNullOrEmpty(childrenList)){
                addChildren(childrenList,tempList,permissions);
            }

        }

    }

}
