package cn.jingyiban.service;

import cn.jingyiban.pojo.Produce;
import cn.jingyiban.pojo.ProduceType;
import cn.jingyiban.utils.JsonReust;

import java.util.List;

public interface IProduceService {
    void add(Produce produce);

    void update(Produce produce);

    Produce getDetail(Integer id);

    List<ProduceType> getType();

    List<ProduceType> getlist();

    int delete(Integer id);

    JsonReust getlistbytype(Integer type_id);
}
