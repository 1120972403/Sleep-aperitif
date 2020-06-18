package cn.jingyiban.mapper;

import cn.jingyiban.pojo.Member;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberMapper {
    int deleteByPrimaryKey(Integer uid);

    int insert(Member record);

    int insertSelective(Member record);

    Member selectByPrimaryKey(Integer uid);

    int updateByPrimaryKeySelective(Member record);

    int updateByPrimaryKey(Member record);

    Member queryOpenidIsExit(String openid);
}