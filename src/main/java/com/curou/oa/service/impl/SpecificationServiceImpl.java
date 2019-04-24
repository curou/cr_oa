package com.curou.oa.service.impl;

import com.curou.oa.dao.SpecificationMapper;
import com.curou.oa.entity.SearchBase;
import com.curou.oa.entity.TableBase;
import com.curou.oa.models.Specification;
import com.curou.oa.models.SpecificationExample;
import com.curou.oa.service.SpecificationService;
import com.curou.oa.utils.ListUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class SpecificationServiceImpl implements SpecificationService {

    @Autowired
    SpecificationMapper mapper;

    @Override
    public Integer add(Specification specification) {
        SpecificationExample example = new SpecificationExample();
        SpecificationExample.Criteria criteria = example.createCriteria();
        criteria.andSpecNameEqualTo(specification.getSpecName());
        List<Specification> list = mapper.selectByExample(example);
        if(ListUtils.isNotNullOrEmpty(list)){
            return 0;
        }
        String id = UUID.randomUUID().toString();
        specification.setSpecId(id);
        specification.setSpecCreateTimeUtc(new Date());
        specification.setSpecModifyTimeUtc(new Date());
        int insert = mapper.insert(specification);
        return insert;
    }

    @Override
    public TableBase<Specification> get(SearchBase searchBase) {
        PageHelper.startPage(searchBase.getPage(),searchBase.getLimit());
        SpecificationExample example = new SpecificationExample();
        SpecificationExample.Criteria criteria = example.createCriteria();

        if(searchBase.getBeginDate()!=null){
            criteria.andSpecCreateTimeUtcGreaterThanOrEqualTo(searchBase.getBeginDate());
        }
        if (searchBase.getEndDate()!= null) {
            criteria.andSpecCreateTimeUtcLessThanOrEqualTo(searchBase.getEndDate());
        }
        if(searchBase.getKeyword()!=null){
            criteria.andSpecNameLike("%"+searchBase.getKeyword()+"%");
        }
        if(searchBase.getOrderBy()!=null){
            example.setOrderByClause(searchBase.getOrderBy());
        }else{
            example.setOrderByClause("spec_create_time_utc desc");
        }
        List<Specification> list = mapper.selectByExample(example);
        PageInfo pageInfo = new PageInfo<>(list,searchBase.getLimit());
        TableBase<Specification> table = new TableBase<>();
        table.setCode(0);
        table.setData(list);
        table.setMsg("");
        table.setCount(pageInfo.getTotal());
        return table;
    }

    @Override
    public void update(List<Specification> list) {
        for (Specification specification : list) {
            mapper.updateByPrimaryKeySelective(specification);
        }
    }

    @Override
    public void delete(List<String> list) {
        for (String str : list) {
            mapper.deleteByPrimaryKey(str);
        }
    }

    @Override
    public Specification getById(String id) {
        return mapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Specification> getAll() {
        SpecificationExample example = new SpecificationExample();
        SpecificationExample.Criteria criteria = example.createCriteria();
        List<Specification> list = mapper.selectByExample(example);
        return list;
    }
}
