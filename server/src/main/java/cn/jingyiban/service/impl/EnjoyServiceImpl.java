package cn.jingyiban.service.impl;

import cn.jingyiban.mapper.EnjoyMapper;
import cn.jingyiban.pojo.Bank;
import cn.jingyiban.pojo.Enjoy;
import cn.jingyiban.service.IEnjoyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class EnjoyServiceImpl implements IEnjoyService {

    @Autowired
    EnjoyMapper enjoyMapper;

    Map<String, Object> map = new HashMap<>();

    /*查*/
    @Override
    public Map<String, Object> getList(Integer type) {
        List<Enjoy> banLists = enjoyMapper.selectByType(type);
        map.put("data", banLists);
        return map;

    }
    /*加*/
    @Override
    public void addList(Enjoy enjoy) {
        enjoy.setViewNum(0);
        enjoy.setCreateTime(new Date());
        enjoyMapper.insertSelective(enjoy);
    }

    /*更新*/
    @Override
    public void updateByID(Enjoy enjoy) {
        enjoyMapper.updateByPrimaryKeySelective(enjoy);
    }

    /*删除*/
    @Override
    public void deleteByid(Integer id) {
        enjoyMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Enjoy getDeatil(Integer id) {
        /*每次查询热度加一*/
        Enjoy enjoy;
        enjoy  = enjoyMapper.selectByPrimaryKey(id);
        if(enjoy!=null){
            enjoy.setViewNum(enjoy.getViewNum()+1);
            enjoyMapper.updateByPrimaryKeySelective(enjoy);
        }
        return enjoyMapper.selectByPrimaryKey(id);
    }
}
