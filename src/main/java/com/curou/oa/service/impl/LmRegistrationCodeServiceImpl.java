package com.curou.oa.service.impl;

import com.curou.oa.dao.LmRegistrationCodeMapper;
import com.curou.oa.dao.extend.LmRegistrationCodeExtendMapper;
import com.curou.oa.entity.LmRegistrationCodeSearch;
import com.curou.oa.models.LmRegistrationCode;
import com.curou.oa.models.LmRegistrationCodeExample;
import com.curou.oa.service.LmRegistrationCodeService;
import com.curou.oa.utils.Exception.AjaxException;
import com.curou.oa.utils.ListUtils;
import com.curou.oa.vo.request.LmRegistrationCodeReq;
import com.curou.oa.vo.response.LmRegistrationCodeRes;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class LmRegistrationCodeServiceImpl implements LmRegistrationCodeService {

    @Autowired
    LmRegistrationCodeExtendMapper mapper;

    public List<LmRegistrationCodeRes> list(LmRegistrationCodeSearch search) {
        List<LmRegistrationCodeRes> list = mapper.list(search);
        return list;
    }

    public void add(LmRegistrationCodeReq lmRegistrationCode) {
        int count = lmRegistrationCode.getCount();
        for (int i = 0; i < count; i++) {
            lmRegistrationCode.setId(UUID.randomUUID().toString());
            if(lmRegistrationCode.getProType().equals("1")){
                String code = UUID.randomUUID().toString();
                code = code.toUpperCase();
                code = code.replaceAll("-","");
                code = "MO"+code;
                lmRegistrationCode.setCode(code);
            }
            else if(lmRegistrationCode.getProType().equals("2")){
                String code = UUID.randomUUID().toString();
                code = code.toLowerCase();
                code = code.replaceAll("-","");
                code = "GW" + code;
                lmRegistrationCode.setCode(code);
            }else{
                lmRegistrationCode.setCode(UUID.randomUUID().toString());
            }
            lmRegistrationCode.setStatus(0);
            lmRegistrationCode.setCreateTimeUtc(new Date());
            lmRegistrationCode.setModifyTimeUtc(new Date());
            lmRegistrationCode.setBindStatus(0);
            lmRegistrationCode.setFreezeStatus(0);

            mapper.insert(lmRegistrationCode);
        }
    }


    //重新绑定
    public void bind(LmRegistrationCode lmRegistrationCode) {
        LmRegistrationCodeExample example = new LmRegistrationCodeExample();
        LmRegistrationCodeExample.Criteria criteria = example.createCriteria();
        criteria.andCodeEqualTo(lmRegistrationCode.getCode());
        List<LmRegistrationCode> lmRegistrationCodes = mapper.selectByExample(example);
        LmRegistrationCode update = lmRegistrationCodes.get(0);
        update.setModifyTimeUtc(new Date());
        update.setBindStatus(1);
        update.setDeviceNo(lmRegistrationCode.getDeviceNo());
        mapper.updateByPrimaryKeySelective(update);
    }

    //解绑
    public void unbind(String id) {
        LmRegistrationCode lmRegistrationCode = mapper.selectByPrimaryKey(id);
        lmRegistrationCode.setBindStatus(0);
        mapper.updateByPrimaryKeySelective(lmRegistrationCode);
    }


    //激活
    public void checkCode(LmRegistrationCode lmRegistrationCode) {
        LmRegistrationCodeExample example = new LmRegistrationCodeExample();
        LmRegistrationCodeExample.Criteria criteria = example.createCriteria();
        criteria.andCodeEqualTo(lmRegistrationCode.getCode());
        List<LmRegistrationCode> lmRegistrationCodes = mapper.selectByExample(example);
        if(ListUtils.isNullOrEmpty(lmRegistrationCodes)){
            throw new AjaxException("激活码不存在！");
        }
        LmRegistrationCode update = lmRegistrationCodes.get(0);
        if(update.getStatus()==0){
            Date date = new Date();
            update.setActivationTime(date);
            Calendar rightNow = Calendar.getInstance();
            rightNow.setTime(date);
            if(update.getCardType().equals("1")){
                rightNow.add(Calendar.MONTH,1);//日期加1个月
            }
            if(update.getCardType().equals("2")){
                rightNow.add(Calendar.YEAR,1);//日期+1年
            }
            if(update.getCardType().equals("3")){
                rightNow.add(Calendar.DATE,1);//日期加1个天
            }
            if(update.getCardType().equals("4")){
                rightNow.add(Calendar.HOUR,1);//日期加1个小时
            }
            Date expirationTime=rightNow.getTime();
            update.setExpirationTime(expirationTime);
            update.setModifyTimeUtc(new Date());
            update.setBindStatus(1);
            update.setStatus(1);
            update.setDeviceNo(lmRegistrationCode.getDeviceNo());
            mapper.updateByPrimaryKey(update);
        }else{
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            long date = new Date().getTime();
            long expirationTime = update.getExpirationTime().getTime();
            if(date>expirationTime){
                throw new AjaxException("激活码已过期！");
            }
            if(update.getFreezeStatus()==1){
                throw new AjaxException("激活码已冻结！");
            }
            if(!update.getDeviceNo().equals(lmRegistrationCode.getDeviceNo())&&update.getBindStatus()==1){
                throw new AjaxException("请在绑定的机器上使用！");
            }
            if(!update.getProType().equals(lmRegistrationCode.getProType())){
                throw new AjaxException("激活的项目与激活码所属项目不符！");
            }
            if(update.getBindStatus()==0){
                update.setBindStatus(1);
                update.setDeviceNo(lmRegistrationCode.getDeviceNo());
                mapper.updateByPrimaryKey(update);
            }
        }
    }


    //续期
    public void renewalCode (LmRegistrationCodeReq LmRegistrationCodeReq) {
        LmRegistrationCode lmRegistrationCode = mapper.selectByPrimaryKey(LmRegistrationCodeReq.getId());
        Date date = lmRegistrationCode.getExpirationTime();
        Calendar rightNow = Calendar.getInstance();
        rightNow.setTime(date);
        if(LmRegistrationCodeReq.getCardType().equals("1")){
            rightNow.add(Calendar.MONTH,LmRegistrationCodeReq.getCount());//日期加1个月
        }
        if(LmRegistrationCodeReq.getCardType().equals("2")){
            rightNow.add(Calendar.YEAR,LmRegistrationCodeReq.getCount());//日期+1年
        }
        Date expirationTime=rightNow.getTime();
        lmRegistrationCode.setExpirationTime(expirationTime);
        lmRegistrationCode.setModifyTimeUtc(new Date());
        mapper.updateByPrimaryKey(lmRegistrationCode);
    }

    //冻结或解冻
    public void freezeCode (String id) {
        LmRegistrationCode lmRegistrationCode = mapper.selectByPrimaryKey(id);
        if(lmRegistrationCode.getFreezeStatus()==0){
            lmRegistrationCode.setFreezeStatus(1);
        }else{
            lmRegistrationCode.setFreezeStatus(0);
        }
        mapper.updateByPrimaryKey(lmRegistrationCode);
    }

    //删除
    public void del (String id) {
        mapper.deleteByPrimaryKey(id);
    }



}
