package com.curou.oa.service.impl;

import com.curou.oa.dao.SpecificationDetailMapper;
import com.curou.oa.entity.SpecificationDetailSearch;
import com.curou.oa.entity.TableBase;
import com.curou.oa.models.SpecificationDetail;
import com.curou.oa.models.SpecificationDetailExample;
import com.curou.oa.service.SpecificationDetailService;
import com.curou.oa.utils.ListUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class SpecificationDetailServiceImpl implements SpecificationDetailService {

    @Autowired
    SpecificationDetailMapper mapper;

    @Override
    public Integer add(SpecificationDetail specificationDetail) {
        SpecificationDetailExample specificationDetailExample = new SpecificationDetailExample();
        SpecificationDetailExample.Criteria criteria = specificationDetailExample.createCriteria();
        criteria.andValueEqualTo(specificationDetail.getValue());
        List<SpecificationDetail> list = mapper.selectByExample(specificationDetailExample);
        if(ListUtils.isNotNullOrEmpty(list)){
            return 0;
        }
        String id = UUID.randomUUID().toString();
        specificationDetail.setId(id);
        specificationDetail.setCreateTimeUtc(new Date());
        specificationDetail.setModifyTimeUtc(new Date());
        int insert = mapper.insert(specificationDetail);
        return insert;
    }

    @Override
    public TableBase<SpecificationDetail> get(SpecificationDetailSearch searchBase) {
        PageHelper.startPage(searchBase.getPage(),searchBase.getLimit());
        SpecificationDetailExample specificationDetailExample = new SpecificationDetailExample();
        SpecificationDetailExample.Criteria criteria = specificationDetailExample.createCriteria();
        if(StringUtils.isNotEmpty(searchBase.getSpecId())){
            criteria.andSpecIdEqualTo(searchBase.getSpecId());
        }
        if(searchBase.getBeginDate()!=null){
            criteria.andCreateTimeUtcGreaterThanOrEqualTo(searchBase.getBeginDate());
        }
        if (searchBase.getEndDate()!= null) {
            criteria.andCreateTimeUtcLessThanOrEqualTo(searchBase.getEndDate());
        }
        if(searchBase.getKeyword()!=null){
            criteria.andValueLike("%"+searchBase.getKeyword()+"%");
        }
        if(searchBase.getOrderBy()!=null){
            specificationDetailExample.setOrderByClause(searchBase.getOrderBy());
        }else{
            specificationDetailExample.setOrderByClause("create_time_utc desc");
        }
        List<SpecificationDetail> list = mapper.selectByExample(specificationDetailExample);
        PageInfo pageInfo = new PageInfo<>(list,searchBase.getLimit());
        TableBase<SpecificationDetail> table = new TableBase<>();
        table.setCode(0);
        table.setData(list);
        table.setMsg("");
        table.setCount(pageInfo.getTotal());
        return table;
    }

    @Override
    public void update(List<SpecificationDetail> list) {
        for (SpecificationDetail specificationDetail : list) {
            mapper.updateByPrimaryKeySelective(specificationDetail);
        }
    }

    @Override
    public void delete(List<String> list) {
        for (String str : list) {
            mapper.deleteByPrimaryKey(str);
        }
    }

    @Override
    public List<SpecificationDetail> getAll(SpecificationDetailSearch searchBase) {
        SpecificationDetailExample example = new SpecificationDetailExample();
        SpecificationDetailExample.Criteria criteria = example.createCriteria();
        if(StringUtils.isNotEmpty(searchBase.getSpecId())){
            criteria.andSpecIdEqualTo(searchBase.getSpecId());
        }
        List<SpecificationDetail> list = mapper.selectByExample(example);
        return list;
    }

    @Override
    public SpecificationDetail getById(String id) {
        return mapper.selectByPrimaryKey(id);
    }
}
