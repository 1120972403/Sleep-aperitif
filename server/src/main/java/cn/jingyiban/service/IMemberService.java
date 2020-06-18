package cn.jingyiban.service;

import cn.jingyiban.pojo.Member;
import cn.jingyiban.pojo.Order;
import cn.jingyiban.utils.JsonReust;

import java.util.List;

public interface IMemberService {
    Member queryOpenidIsExit(String openid);

    Member insert(String openid);
    //获取openid
    String getOpenid(String code);


    Member updateInfo(Member member);

    /*获取我的所有订单*/
    List<Order> getMyProduceList(Integer user_id);

    /*根据ID取消我的订单*/
    int cancelMyProduceList(Integer id);

    /*用户下单产品*/
    int orderProduce(Order order);

    /*支付成功接口*/
    int paymentMyProduceList(Integer id);

    /*用户确定收货*/
    int sureGoods(Integer id);

    /*获取医生列表*/
    JsonReust getdoctorlist();
}
