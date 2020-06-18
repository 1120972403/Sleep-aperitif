package cn.jingyiban.service;

import cn.jingyiban.pojo.Enjoy;

import java.util.Map;

public interface IEnjoyService {
    Map<String, Object> getList(Integer type);

    void addList(Enjoy enjoy);

    void updateByID(Enjoy enjoy);

    void deleteByid(Integer id);

    /*查询详细*/
    Enjoy getDeatil(Integer id);
}
