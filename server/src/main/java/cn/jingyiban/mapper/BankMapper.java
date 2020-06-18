package cn.jingyiban.mapper;

import cn.jingyiban.pojo.Bank;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BankMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Bank record);

    int insertSelective(Bank record);

    Bank selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Bank record);

    int updateByPrimaryKey(Bank record);

    /*根据类型获取试题列表*/
    List<Bank> getTypeBanKList(Integer type);
}