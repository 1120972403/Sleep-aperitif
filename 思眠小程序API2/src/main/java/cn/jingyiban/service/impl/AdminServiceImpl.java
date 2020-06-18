package cn.jingyiban.service.impl;

import cn.jingyiban.mapper.AdminMapper;
import cn.jingyiban.mapper.OrderMapper;
import cn.jingyiban.pojo.Admin;
import cn.jingyiban.pojo.Order;
import cn.jingyiban.service.IAdminService;
import cn.jingyiban.utils.Config;
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
public class AdminServiceImpl  implements IAdminService {
    @Autowired
    AdminMapper adminMapper;

    Admin admin = new Admin();

    @Override
    public String getOpenid(String code) {
        // 创建Httpclient对象
        CloseableHttpClient httpclient = HttpClients.createDefault();
        String resultString = "";
        CloseableHttpResponse response = null;
        String url="https://api.weixin.qq.com/sns/jscode2session?appid="+ Config.appid2+"&secret="+Config.appsecret2+"&js_code="+code+"&grant_type=authorization_code";
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
    public Admin queryOpenidIsExit(String openid) {
        return adminMapper.queryOpenidIsExit(openid);
    }

    @Override
    public Admin insert(String openid) {
        admin.setOpenid(openid);
        admin.setCreateTime(new Date());
        adminMapper.insert(admin);
        return adminMapper.queryOpenidIsExit(openid);
    }

    @Override
    public Admin updateInfo(Admin admin) {
        adminMapper.updateByPrimaryKeySelective(admin);
        Admin result = adminMapper.selectByPrimaryKey(admin.getId());
        return result;
    }

    @Autowired
    OrderMapper orderMapper;
    @Override
    public List<Order> userPayList() {
        return orderMapper.getuserPayList();
    }

    /*管理员维护邮编号*/
    @Override
    public int updateAddressNum(Integer orderId, String address_num) {
        Order order = new Order();
        order.setStatus(3);
        order.setId(orderId);
        order.setNum(address_num);
        return orderMapper.updateByPrimaryKeySelective(order);
    }


}
