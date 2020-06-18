package cn.jingyiban.service.impl;

import cn.jingyiban.mapper.DoctorApplyMapper;
import cn.jingyiban.mapper.DoctorMapper;
import cn.jingyiban.pojo.Admin;
import cn.jingyiban.pojo.Bank;
import cn.jingyiban.pojo.Doctor;
import cn.jingyiban.pojo.DoctorApply;
import cn.jingyiban.service.IDoctorService;
import cn.jingyiban.utils.Config;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.print.Doc;
import java.net.URI;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DoctorServiceImpl implements IDoctorService {

    @Autowired
    DoctorMapper doctorMapper;
    @Autowired
    DoctorApplyMapper doctorApplyMapper;
    @Override
    public String getOpenid(String code) {
        // 创建Httpclient对象
        CloseableHttpClient httpclient = HttpClients.createDefault();
        String resultString = "";
        CloseableHttpResponse response = null;
        String url="https://api.weixin.qq.com/sns/jscode2session?appid="+ Config.appid3+"&secret="+Config.appsecret3+"&js_code="+code+"&grant_type=authorization_code";
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
    public Doctor queryOpenidIsExit(String openid) {
        return doctorMapper.queryOpenidIsExit(openid);
    }

    @Override
    public Doctor insert(String openid) {
        Doctor doctor = new Doctor();
        doctor.setOpenid(openid);
        doctorMapper.insert(doctor);
        return doctorMapper.queryOpenidIsExit(openid);
    }
    /*医生信息维护*/
    @Override
    public Doctor updateInfo(Doctor doctor) {
        doctorMapper.updateByPrimaryKeySelective(doctor);
        return doctorMapper.selectByPrimaryKey(doctor.getId());
    }

    /*医生提交申请*/
    @Override
    public void apply(DoctorApply doctorApply) {
        doctorApply.setCreateTime(new Date());
        doctorApplyMapper.insert(doctorApply);
    }
    Map<String, Object> map = new HashMap<>();
    /*管理员获取医生申请列表*/
    @Override
    public Map<String, Object> ApplyList() {
        List<Bank> banLists = doctorApplyMapper.selectAll();
        map.put("data", banLists);
        return map;
    }

    /*管理员审核医生申请*/
    @Override
    public void checkDoctorApply(Doctor doctor) {
        doctorMapper.updateByPrimaryKeySelective(doctor);
    }
}
