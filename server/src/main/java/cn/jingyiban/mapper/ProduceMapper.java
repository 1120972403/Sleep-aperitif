package cn.jingyiban.mapper;

import cn.jingyiban.pojo.Produce;
import cn.jingyiban.pojo.ProduceType;
import cn.jingyiban.utils.JsonReust;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProduceMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Produce record);

    int insertSelective(Produce record);

    Produce selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Produce record);

    int updateByPrimaryKeyWithBLOBs(Produce record);

    int updateByPrimaryKey(Produce record);

    List<ProduceType> select();


    List<Produce> getlist(Integer type_id);
}