package cn.jingyiban.mapper;

import cn.jingyiban.pojo.Enjoy;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface EnjoyMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Enjoy record);

    int insertSelective(Enjoy record);

    Enjoy selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Enjoy record);

    int updateByPrimaryKeyWithBLOBs(Enjoy record);

    int updateByPrimaryKey(Enjoy record);

    /*根据类型查询*/
    List<Enjoy> selectByType(Integer type);
}