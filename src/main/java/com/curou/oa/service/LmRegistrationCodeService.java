package com.curou.oa.service;

import com.curou.oa.entity.LmRegistrationCodeSearch;
import com.curou.oa.models.LmRegistrationCode;
import com.curou.oa.models.LmRegistrationCodeExample;
import com.curou.oa.vo.request.LmRegistrationCodeReq;
import com.curou.oa.vo.response.LmRegistrationCodeRes;

import java.util.List;

public interface LmRegistrationCodeService {

    List<LmRegistrationCodeRes> list(LmRegistrationCodeSearch search);

    void add(LmRegistrationCodeReq lmRegistrationCode);


    void checkCode(LmRegistrationCode lmRegistrationCode);


   void renewalCode (LmRegistrationCodeReq LmRegistrationCodeReq);

    void del(String id);

    void freezeCode(String id);

    void unbind(String id);
}
