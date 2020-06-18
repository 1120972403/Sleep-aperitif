package cn.jingyiban.mapper;

import cn.jingyiban.pojo.ProduceType;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProduceTypeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ProduceType record);

    int insertSelective(ProduceType record);

    ProduceType selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ProduceType record);

    int updateByPrimaryKey(ProduceType record);

    /*获取所有列表*/
    List<ProduceType> select();

    /*按类分商品*/
    List<ProduceType> selectTypeProduce();
}