package com.curou.oa.service.impl;

import com.curou.oa.dao.LmProjectMapper;
import com.curou.oa.entity.SearchBase;
import com.curou.oa.models.LmProject;
import com.curou.oa.models.LmProjectExample;
import com.curou.oa.service.LmProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class LmProjectServiceImpl implements LmProjectService {

    @Autowired
    LmProjectMapper mapper;

    @Override
    public List<LmProject> getAll(SearchBase searchBase) {
        LmProjectExample example = new LmProjectExample();
        List<LmProject> list = mapper.selectByExample(example);
        return list;
    }
}
