package cn.jingyiban.service.impl;


import cn.jingyiban.mapper.DoctorMapper;
import cn.jingyiban.mapper.MemberMapper;
import cn.jingyiban.mapper.OrderMapper;
import cn.jingyiban.pojo.Doctor;
import cn.jingyiban.pojo.Member;
import cn.jingyiban.pojo.Order;
import cn.jingyiban.service.IMemberService;
import cn.jingyiban.utils.Config;
import cn.jingyiban.utils.JsonReust;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.util.Date;
import java.util.List;

@Service
public class MemberServiceImlpl implements IMemberService {

    @Autowired
    MemberMapper memberMapper;

    Member member = new Member();
    @Override
    public Member queryOpenidIsExit(String openid) {
        return memberMapper.queryOpenidIsExit(openid);
    }

    @Override
    public Member insert(String openid) {
        member.setOpenid(openid);
        member.setCreateTime(new Date());
        memberMapper.insert(member);
        return memberMapper.queryOpenidIsExit(openid);
    }

    @Override
    public String getOpenid(String code) {
        // 创建Httpclient对象
        CloseableHttpClient httpclient = HttpClients.createDefault();
        String resultString = "";
        CloseableHttpResponse response = null;
        String url="https://api.weixin.qq.com/sns/jscode2session?appid="+Config.appid1+"&secret="+Config.appsecret1+"&js_code="+code+"&grant_type=authorization_code";
        try {
            // 创建uri
            URIBuilder builder = new URIBuilder(url);
            URI uri = builder.build();

            // 创建http GET请求
            HttpGet httpGet = new HttpGet(uri);

            // 执行请求
            response = httpclient.execute(httpGet);
            // 判断返回状态是否为200
            if (response.getStatusLine().getStatusCode() == 200) {
                resultString = EntityUtils.toString(response.getEntity(), "UTF-8");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return resultString;

    }

    @Override
    public Member updateInfo(Member member) {
        member.setUpdateTime(new Date());
        memberMapper.updateByPrimaryKeySelective(member);
        Member result = memberMapper.selectByPrimaryKey(member.getUid());
        return result;
    }

    @Autowired
    OrderMapper orderMapper;

    /*获取我的所有订单*/
    @Override
    public List<Order> getMyProduceList(Integer user_id) {
        return orderMapper.getMyProduceList(user_id);
    }

    /*用户下单接口*/
    @Override
    public int orderProduce(Order order) {
        order.setCreateTime(new Date());
        /*下单即为待付款*/
        order.setStatus(1);
        return orderMapper.insertSelective(order);
    }
    /*取消我的订单 0为取消*/
    @Override
    public int cancelMyProduceList(Integer id) {
        Order order = new Order();
        order.setId(id);
        order.setUpdateTime(new Date());
        order.setStatus(0);
        return orderMapper.updateByPrimaryKeySelective(order);
    }
    /*支付*/
    @Override
    public int paymentMyProduceList(Integer id) {
        Order order = new Order();
        order.setUpdateTime(new Date());
        order.setId(id);
        /*支付变状态为2即代发货*/
        order.setStatus(2);
        return orderMapper.updateByPrimaryKeySelective(order);
    }

    @Override
    public int sureGoods(Integer id) {
        Order order = new Order();
        order.setUpdateTime(new Date());
        order.setId(id);
        /*4代表已经收获*/
        order.setStatus(4);
        return orderMapper.updateByPrimaryKeySelective(order);
    }

    @Autowired
    DoctorMapper doctorMapper;
    /*获取医生列表*/
    @Override
    public JsonReust getdoctorlist() {
        List<Doctor> lists = doctorMapper.selectAll();
        return JsonReust.ok(lists);
    }

}
