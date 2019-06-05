package com.curou.oa.controller;

import com.curou.oa.entity.SearchBase;
import com.curou.oa.entity.TableBase;
import com.curou.oa.models.Menu;
import com.curou.oa.models.MenuSort;
import com.curou.oa.models.extend.MenuExtend;
import com.curou.oa.service.MenuService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class MenuController {


    @Autowired
    MenuService service;


//    @RequestMapping("/addMenu")
//    @ResponseBody
//    public Map<String, Object> addMenu(@RequestBody Menu menu) {
//        service.add(menu);
//        Map<String, Object> map = new HashMap<>();
//        map.put("result","success");
//        return map;
//    }


    @RequestMapping("/menu/getAll")
    @ResponseBody
    public List<List<Menu>> initMenu() {
        return service.getAll();
    }


    @RequestMapping("/menu/list")
    @ResponseBody
    public TableBase<Menu> getStock(SearchBase searchBase){
        PageHelper.startPage(searchBase.getPage(),searchBase.getLimit());
        List<Menu> list = service.list(searchBase);
        PageInfo pageInfo = new PageInfo<>(list,searchBase.getLimit());
        TableBase<Menu> table = new TableBase<>();
        table.setCode(0);
        table.setData(list);
        table.setMsg("");
        table.setCount(pageInfo.getTotal());
        return table;
    }

    @RequestMapping("/subMenu/add")
    @ResponseBody
    public Map<String,String> addSubMenu(@RequestBody  Menu menu) {
        Map<String, String> map = new HashMap<>();
        service.addSubMenu(menu);
        map.put("result", "success");
        return map;
    }


    @RequestMapping("/menu/delete")
    @ResponseBody
    public Map<String,String> delete(String id) {
        Map<String, String> map = new HashMap<>();
        service.delete(id);
        map.put("success", "1");
        return map;
    }

    @RequestMapping("/menu/update")
    @ResponseBody
    public Map<String,String> update(@RequestBody Menu menu) {
        Map<String, String> map = new HashMap<>();
        service.update(menu);
        map.put("result", "success");
        return map;
    }

    @RequestMapping("/menu/drag")
    @ResponseBody
    public Map<String,String> drag(@RequestBody Menu menu) {
        Map<String, String> map = new HashMap<>();
        service.drag(menu);
        map.put("result", "success");
        return map;
    }

    @RequestMapping("/menu/move")
    @ResponseBody
    public Map<String,String> drag(@RequestBody List<Menu> list) {
        Map<String, String> map = new HashMap<>();
        service.move(list);
        map.put("result", "success");
        return map;
    }

    @RequestMapping("/menu/menuIncludeChildren")
    @ResponseBody
    public List<MenuExtend> menuIncludeChildren() {
        return service.getMenuIncludeChildrenBySort();
    }

    @RequestMapping("/menu/menuWithChildren")
    @ResponseBody
    public List<Menu> menuWithChildren() {
        return service.getMenuWithChildrenBySort();
    }


    @RequestMapping("/menu/menuWithChildrenForTable")
    @ResponseBody
    public TableBase<Menu> menuWithChildrenForTable() {
        TableBase<Menu> table = new TableBase<>();
        table.setCode(0);
        List<Menu> list = service.getMenuWithChildrenBySort();
        table.setData(list);
        table.setMsg("");
        long count = (int) list.size();
        table.setCount(count);
        return table;
    }



}
