package com.curou.oa.controller;

import com.curou.oa.entity.SearchBase;
import com.curou.oa.models.LmCard;
import com.curou.oa.models.LmProject;
import com.curou.oa.service.LmCardService;
import com.curou.oa.service.LmProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class LmController {

    @Autowired
    LmProjectService lmProjectService;

    @Autowired
    LmCardService lmCardService;

    @RequestMapping("getAllCard")
    @ResponseBody
    public List<LmCard> getAllCard(SearchBase searchBase){
        return lmCardService.getAll(searchBase);
    }

    @RequestMapping("getAllProject")
    @ResponseBody
    public List<LmProject> getAllPro(SearchBase searchBase){
        return lmProjectService.getAll(searchBase);
    }
}
