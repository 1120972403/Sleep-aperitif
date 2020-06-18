package cn.jingyiban.mapper;

import cn.jingyiban.pojo.Bank;
import cn.jingyiban.pojo.Emr;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Mapper
public interface EmrMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Emr record);

    int insertSelective(Emr record);

    Emr selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Emr record);

    int updateByPrimaryKey(Emr record);

    List<Emr> selectEmrListByUserId(Integer user_id);
}