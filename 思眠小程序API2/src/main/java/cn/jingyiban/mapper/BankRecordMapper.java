package cn.jingyiban.mapper;

import cn.jingyiban.pojo.Bank;
import cn.jingyiban.pojo.BankRecord;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BankRecordMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(BankRecord record);

    int insertSelective(BankRecord record);

    BankRecord selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BankRecord record);

    int updateByPrimaryKey(BankRecord record);

    /*根据用户查询记录*/
    List<Bank> selectByUserID(Integer user_id);
}