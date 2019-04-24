package com.curou.oa.service.impl;

import com.curou.oa.dao.ReimburseMapper;
import com.curou.oa.entity.SearchBase;
import com.curou.oa.entity.TableBase;
import com.curou.oa.models.Reimburse;
import com.curou.oa.models.ReimburseExample;
import com.curou.oa.service.ReimburseService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ReimburseServiceImpl implements ReimburseService {

    @Autowired
    ReimburseMapper mapper;

    @Override
    public Integer add(Reimburse reimburse) {
        int insert = mapper.insert(reimburse);
        return insert;
    }

    @Override
    public TableBase<Reimburse> get(SearchBase searchBase) {
        PageHelper.startPage(searchBase.getPage(),searchBase.getLimit());
        ReimburseExample example = new ReimburseExample();
        ReimburseExample.Criteria criteria = example.createCriteria();
        if(searchBase.getKeyword()!=null){
            criteria.andContentLike("%"+searchBase.getKeyword()+"%");
        }
        List<Reimburse> list = mapper.selectByExample(example);
        PageInfo pageInfo = new PageInfo<>(list,searchBase.getLimit());
        TableBase<Reimburse> table = new TableBase<>();
        table.setCode(0);
        table.setData(list);
        table.setMsg("");
        table.setCount(pageInfo.getTotal());
        return table;
    }

    public Reimburse getById(String id){
        return mapper.selectByPrimaryKey(id);
    }

    @Override
    public void update(List<Reimburse> list) {
        for (Reimburse reimburse : list) {
            mapper.updateByPrimaryKeySelective(reimburse);
        }
    }

    @Override
    public void delete(List<String> list) {
        for (String str : list) {
            mapper.deleteByPrimaryKey(str);
        }
    }
}
