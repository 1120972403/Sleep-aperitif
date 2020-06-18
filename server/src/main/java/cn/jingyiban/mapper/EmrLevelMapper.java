package cn.jingyiban.mapper;

import cn.jingyiban.pojo.EmrLevel;

public interface EmrLevelMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(EmrLevel record);

    int insertSelective(EmrLevel record);

    EmrLevel selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(EmrLevel record);

    int updateByPrimaryKeyWithBLOBs(EmrLevel record);

    int updateByPrimaryKey(EmrLevel record);
}