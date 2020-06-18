package cn.jingyiban.controller;

import cn.jingyiban.pojo.Doctor;
import cn.jingyiban.pojo.DoctorApply;
import cn.jingyiban.service.IDoctorService;
import cn.jingyiban.utils.JsonReust;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("/doctor")
public class DoctorController {

    @Autowired
    IDoctorService doctorService;

    @RequestMapping("/login")
    @ResponseBody
    public JsonReust registerOrlogin(@RequestParam("code") String code){

        String resultString = doctorService.getOpenid(code);

        // 解析json
        JSONObject jsonObject = (JSONObject) JSONObject.parse(resultString);
        String openid;
        if(jsonObject.containsKey("errcode"))
        {
            return JsonReust.errorMap(jsonObject);
        }
        //先获取openid
        openid=jsonObject.get("openid") + "";
        Doctor doctorResult;
        doctorResult = doctorService.queryOpenidIsExit(openid);
        if(doctorResult==null){//注册
            System.out.println("进来了");
            doctorResult =  doctorService.insert(openid);
        }
        //此用户存在，可登录
        return JsonReust.ok(doctorResult);
    }

    /*信息维护*/
    @RequestMapping("/updateInfo")
    @ResponseBody
    public JsonReust updateInfo(Doctor doctor){
        try {
            Doctor doctorResult = doctorService.updateInfo(doctor);
            return JsonReust.ok(doctorResult);
        }catch (Exception e) {
            return JsonReust.errorMsg("失败,请检查是否按照文档在写");
        }
    }

    /*医生提交申请*/
    @RequestMapping("/apply")
    @ResponseBody
    public JsonReust apply(DoctorApply doctorApply){
        doctorService.apply(doctorApply);
        return JsonReust.ok();
    }

    /*医生查看就诊于自己的列表*/

    /*医生查看病人列表*/

    /*医生进行案例诊断*/

    /*医生查看自己的收益*/

    /*医生的病人聊天列表*/
}
