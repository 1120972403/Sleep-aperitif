package cn.jingyiban.service;

import cn.jingyiban.pojo.Emr;

import java.util.List;
import java.util.Map;

public interface IEmrService {
    int InsertUserEmr(Emr emr);

    Map<String, Object> getMyEmrList(Integer user_id);


    List<Emr> test(Integer user_id);
}
