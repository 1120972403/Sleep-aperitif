package cn.jingyiban.mapper;

import cn.jingyiban.pojo.Order;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OrderMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Order record);

    int insertSelective(Order record);

    Order selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Order record);

    int updateByPrimaryKey(Order record);

    /*根据用户获取所有的订单*/
    List<Order> getMyProduceList(Integer user_id);

    /*查询已经支付的列表*/
    List<Order> getuserPayList();
}