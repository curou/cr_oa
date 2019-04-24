package com.curou.oa.service;

import com.curou.oa.entity.SpecificationDetailSearch;
import com.curou.oa.entity.TableBase;
import com.curou.oa.models.SpecificationDetail;

import java.util.List;

public interface SpecificationDetailService {

    Integer add(SpecificationDetail specification);

    TableBase<SpecificationDetail> get(SpecificationDetailSearch searchBase);

    void update(List<SpecificationDetail> list);

    void delete(List<String> list);

    List<SpecificationDetail> getAll(SpecificationDetailSearch searchBase);

    SpecificationDetail getById(String id);

}
