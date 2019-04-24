package com.curou.oa.controller;

import com.curou.oa.entity.SearchBase;
import com.curou.oa.entity.TableBase;
import com.curou.oa.models.UploadDetail;
import com.curou.oa.service.UploadDetailService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("uploadDetail")
public class UploadDetailController {

    @Autowired
    UploadDetailService service;

    @GetMapping("/list")
    @ResponseBody
    public TableBase list(SearchBase search){
        PageHelper.startPage(search.getPage(),search.getLimit());
        List<UploadDetail> list = service.list(search);
        PageInfo pageInfo = new PageInfo<>(list,search.getLimit());
        TableBase tableBase  = new TableBase();
        tableBase.setData(list);
        tableBase.setCode(0);
        tableBase.setMsg("");
        tableBase.setCount(pageInfo.getTotal());
        return tableBase;
    }


}
