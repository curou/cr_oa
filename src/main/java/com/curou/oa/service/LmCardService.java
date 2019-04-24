package com.curou.oa.service;

import com.curou.oa.entity.SearchBase;
import com.curou.oa.models.LmCard;

import java.util.List;

public interface LmCardService {

    List<LmCard> getAll(SearchBase searchBase);
}
