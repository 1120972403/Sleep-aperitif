package cn.jingyiban.mapper;

import cn.jingyiban.pojo.Doctor;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DoctorMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Doctor record);

    int insertSelective(Doctor record);

    Doctor selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Doctor record);

    int updateByPrimaryKeyWithBLOBs(Doctor record);

    int updateByPrimaryKey(Doctor record);

    /*检查openid是否存在*/
    Doctor queryOpenidIsExit(String openid);

    /*获取所有医生*/
    List<Doctor> selectAll();
}