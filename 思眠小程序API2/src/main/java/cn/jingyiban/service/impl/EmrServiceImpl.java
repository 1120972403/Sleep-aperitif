package cn.jingyiban.service.impl;

import cn.jingyiban.mapper.EmrMapper;
import cn.jingyiban.pojo.Emr;
import cn.jingyiban.service.IEmrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class EmrServiceImpl implements IEmrService {

    @Autowired
    EmrMapper emrMapper;
    @Override
    public int InsertUserEmr(Emr emr) {
        emr.setUserTime(new Date());
        return emrMapper.insertSelective(emr);
    }

    /*如果要返回多个数据，用列表然后放在map中*/
    @Override
    public  Map<String, Object> getMyEmrList(Integer user_id) {
        Map<String, Object> map = new HashMap<>();
        List<Emr> result= emrMapper.selectEmrListByUserId(user_id);
        map.put("data", result);
        return  map;
    }

    @Override
    public List<Emr> test(Integer user_id) {
        return emrMapper.selectEmrListByUserId(user_id);
    }


}
