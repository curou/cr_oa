package com.curou.oa.controller;


import com.curou.oa.entity.SpecificationDetailSearch;
import com.curou.oa.entity.TableBase;
import com.curou.oa.models.SpecificationDetail;
import com.curou.oa.service.SpecificationDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class SpecificationDetailController {

    @Autowired
    SpecificationDetailService service;

    @RequestMapping("addSpecificationDetail")
    @ResponseBody
    public Map<String,Object> addSpecificationDetail(@RequestBody SpecificationDetail specificationDetail){
        Map<String, Object> map = new HashMap<>();
        int result = service.add(specificationDetail);
        if(result==1){
            map.put("result", "success");
        }
        if(result==0){
            map.put("result", "repeatName");
        }
        return map;

    }


    @RequestMapping("getSpecificationDetail")
    @ResponseBody
    public TableBase<SpecificationDetail> getSpecificationDetail(SpecificationDetailSearch searchBase){
        return service.get(searchBase);
    }

    @RequestMapping("updateSpecificationDetail")
    @ResponseBody
    public Map<String,Object> updateSpecificationDetail(@RequestBody List<SpecificationDetail> list){
        Map<String, Object> map = new HashMap<>();
        service.update(list);
        map.put("result", "success");
        return map;
    }

    @RequestMapping("deleteSpecificationDetail")
    @ResponseBody
    public Map<String,Object> deleteSpecificationDetail(@RequestBody List<String> list){
        Map<String, Object> map = new HashMap<>();
        service.delete(list);
        map.put("result", "success");
        return map;
    }

    @RequestMapping("getAllSpecificationDetail")
    @ResponseBody
    public List<SpecificationDetail> getALL(SpecificationDetailSearch searchBase){
        Map<String, Object> map = new HashMap<>();
       List<SpecificationDetail> list =  service.getAll(searchBase);
        map.put("result", "success");
        return list;
    }
}
