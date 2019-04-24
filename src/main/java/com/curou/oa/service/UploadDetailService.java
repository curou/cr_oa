package com.curou.oa.service;

import com.curou.oa.entity.SearchBase;
import com.curou.oa.models.UploadDetail;

import java.util.List;

public interface UploadDetailService {

    int add(UploadDetail uploadDetail);

    List<UploadDetail> list(SearchBase searchBase);
}


