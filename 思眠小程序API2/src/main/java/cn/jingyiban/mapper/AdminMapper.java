package cn.jingyiban.mapper;

import cn.jingyiban.pojo.Admin;
import cn.jingyiban.pojo.Member;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AdminMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Admin record);

    int insertSelective(Admin record);

    Admin selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Admin record);

    int updateByPrimaryKey(Admin record);

    /*检查是否存在openid*/
    Admin queryOpenidIsExit(String openid);
}