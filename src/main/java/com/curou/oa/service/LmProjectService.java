package com.curou.oa.service;

import com.curou.oa.entity.SearchBase;
import com.curou.oa.models.LmProject;

import java.util.List;

public interface LmProjectService {

    List<LmProject> getAll(SearchBase searchBase);
}
