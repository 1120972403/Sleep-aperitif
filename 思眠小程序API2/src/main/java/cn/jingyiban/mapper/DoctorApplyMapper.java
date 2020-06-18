package cn.jingyiban.mapper;

import cn.jingyiban.pojo.Bank;
import cn.jingyiban.pojo.DoctorApply;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DoctorApplyMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(DoctorApply record);

    int insertSelective(DoctorApply record);

    DoctorApply selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(DoctorApply record);

    int updateByPrimaryKey(DoctorApply record);

    /*获取全部申请列表*/
    List<Bank> selectAll();
}