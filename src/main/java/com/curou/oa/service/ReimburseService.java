package com.curou.oa.service;

import com.curou.oa.entity.SearchBase;
import com.curou.oa.entity.TableBase;
import com.curou.oa.models.Reimburse;

import java.util.List;

public interface ReimburseService {
    Integer add(Reimburse reimburse);

    TableBase<Reimburse> get(SearchBase searchBase);

    Reimburse getById(String id);

    void update(List<Reimburse> list);

    void delete(List<String> list);
}
