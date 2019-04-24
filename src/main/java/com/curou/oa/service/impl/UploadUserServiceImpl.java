package com.curou.oa.service.impl;

import com.curou.oa.dao.UploadUserMapper;
import com.curou.oa.models.UploadUser;
import com.curou.oa.service.UploadUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UploadUserServiceImpl implements UploadUserService {

    @Autowired
    UploadUserMapper mapper;
    @Override
    public int add(UploadUser uploadUser) {
        return mapper.insert(uploadUser);
    }
}
