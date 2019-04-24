package com.curou.oa.controller;

import com.curou.oa.entity.SearchBase;
import com.curou.oa.entity.TableBase;
import com.curou.oa.models.Specification;
import com.curou.oa.service.SpecificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class SpecificationController {

    @Autowired
    SpecificationService service;

    @RequestMapping("addSpecification")
    @ResponseBody
    public Map<String,Object> addSpecification(@RequestBody Specification specification){
        Map<String, Object> map = new HashMap<>();
        int result = service.add(specification);
        if(result==1){
            map.put("result", "success");
        }
        if(result==0){
            map.put("result", "repeatName");
        }
        return map;

    }


    @RequestMapping("getSpecification")
    @ResponseBody
    public TableBase<Specification> getSpecification(SearchBase searchBase){
        return service.get(searchBase);
    }

    @RequestMapping("updateSpecification")
    @ResponseBody
    public Map<String,Object> updateSpecification(@RequestBody List<Specification> list){
        Map<String, Object> map = new HashMap<>();
        service.update(list);
        map.put("result", "success");
        return map;
    }

    @RequestMapping("deleteSpecification")
    @ResponseBody
    public Map<String,Object> deleteSpecification(@RequestBody List<String> list){
        Map<String, Object> map = new HashMap<>();
        service.delete(list);
        map.put("result", "success");
        return map;
    }

    @RequestMapping("getAllSpecification")
    @ResponseBody
    public List<Specification> getALL(){
        Map<String, Object> map = new HashMap<>();
        List<Specification> list =  service.getAll();
        map.put("result", "success");
        return list;
    }





}
