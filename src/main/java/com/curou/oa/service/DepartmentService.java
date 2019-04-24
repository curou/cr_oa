package com.curou.oa.service;

import com.curou.oa.entity.SearchBase;
import com.curou.oa.models.Department;

import java.util.List;

public interface DepartmentService {
    List<Department> get(SearchBase searchBase);
}
