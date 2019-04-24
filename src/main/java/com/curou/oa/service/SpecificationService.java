package com.curou.oa.service;

import com.curou.oa.entity.SearchBase;
import com.curou.oa.entity.TableBase;
import com.curou.oa.models.Specification;

import java.util.List;

public interface SpecificationService {

    Integer add(Specification specification);

    TableBase<Specification> get(SearchBase searchBase);

    void update(List<Specification> list);

    void delete(List<String> list);

    Specification getById(String id);

    List<Specification> getAll();
}
