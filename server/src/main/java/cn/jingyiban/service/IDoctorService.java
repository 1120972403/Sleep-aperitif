package cn.jingyiban.service;


import cn.jingyiban.pojo.Doctor;
import cn.jingyiban.pojo.DoctorApply;

import java.util.Map;

public interface IDoctorService {
    String getOpenid(String code);

    Doctor queryOpenidIsExit(String openid);

    Doctor insert(String openid);

    Doctor updateInfo(Doctor doctor);

    /*医生提交申请*/
    void apply(DoctorApply doctorApply);

    /*管理员获取医生申请列表*/
    Map<String, Object> ApplyList();

    /*管理员审核医生申请*/
    void checkDoctorApply(Doctor doctor);
}
