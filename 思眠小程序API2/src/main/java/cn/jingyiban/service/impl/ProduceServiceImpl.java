package cn.jingyiban.service.impl;

import cn.jingyiban.mapper.ProduceMapper;
import cn.jingyiban.mapper.ProduceTypeMapper;
import cn.jingyiban.pojo.Produce;
import cn.jingyiban.pojo.ProduceType;
import cn.jingyiban.service.IProduceService;
import cn.jingyiban.utils.JsonReust;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class ProduceServiceImpl implements IProduceService {

    @Autowired
    ProduceMapper produceMapper;

    @Autowired
    ProduceTypeMapper produceTypeMapper;

    /*获取商品列表*/
    @Override
    public List<ProduceType>  getlist() {
        return produceTypeMapper.selectTypeProduce();
    }

    @Override
    public int delete(Integer id) {
        return produceMapper.deleteByPrimaryKey(id);
    }

    /*首页取出前三*/
    @Override
    public JsonReust getlistbytype(Integer type_id) {
        List<Produce> list =  produceMapper.getlist(type_id);
        return JsonReust.ok(list);
    }

    /*商品添加*/
    @Override
    public void add(Produce produce) {
        produce.setViewNum(0);
        produce.setCreateTime(new Date());
        produceMapper.insert(produce);
    }
    /*商品更新*/
    @Override
    public void update(Produce produce) {
        produceMapper.updateByPrimaryKeySelective(produce);
    }

    /*获取商品详细*/
    @Override
    public Produce getDetail(Integer id) {
        Produce produce;
        produce  = produceMapper.selectByPrimaryKey(id);
        if(produce!=null){
            produce.setViewNum(produce.getViewNum()+1);
            produceMapper.updateByPrimaryKeySelective(produce);
        }
       return produceMapper.selectByPrimaryKey(id);
    }
    /*获取商品类别列表*/
    @Override
    public List<ProduceType> getType() {
        return produceTypeMapper.select();
    }



}
