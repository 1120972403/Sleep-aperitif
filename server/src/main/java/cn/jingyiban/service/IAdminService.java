package cn.jingyiban.service;

import cn.jingyiban.pojo.Admin;
import cn.jingyiban.pojo.Order;

import java.util.List;

public interface IAdminService  {
    String getOpenid(String code);

    Admin queryOpenidIsExit(String openid);

    Admin insert(String openid);

    Admin updateInfo(Admin admin);

    /*管理员查看已经支付列表*/
    List<Order> userPayList();

    /*管理员维护订单号*/
    int updateAddressNum(Integer orderId, String address_num);
}
