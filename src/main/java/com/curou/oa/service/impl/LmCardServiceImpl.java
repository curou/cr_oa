package com.curou.oa.service.impl;

import com.curou.oa.dao.LmCardMapper;
import com.curou.oa.entity.SearchBase;
import com.curou.oa.models.LmCard;
import com.curou.oa.models.LmCardExample;
import com.curou.oa.service.LmCardService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class LmCardServiceImpl implements LmCardService {

    @Autowired
    LmCardMapper mapper;

    @Override
    public List<LmCard> getAll(SearchBase searchBase) {
        LmCardExample example = new LmCardExample();
        List<LmCard> list = mapper.selectByExample(example);
        return list;
    }
}
