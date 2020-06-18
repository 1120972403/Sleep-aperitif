package cn.jingyiban.controller;

import cn.jingyiban.mapper.OrderMapper;
import cn.jingyiban.pojo.Admin;
import cn.jingyiban.pojo.Doctor;
import cn.jingyiban.pojo.Order;
import cn.jingyiban.service.IAdminService;
import cn.jingyiban.service.IDoctorService;
import cn.jingyiban.utils.JsonReust;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    IAdminService adminService;

    @Autowired
    IDoctorService doctorService;
    @RequestMapping("/login")
    @ResponseBody
    public JsonReust registerOrlogin(@RequestParam("code") String code){

        String resultString = adminService.getOpenid(code);

        // 解析json
        JSONObject jsonObject = (JSONObject) JSONObject.parse(resultString);
        String openid;
        if(jsonObject.containsKey("errcode"))
        {
            return JsonReust.errorMap(jsonObject);
        }
        //先获取openid
        openid=jsonObject.get("openid") + "";
        Admin adminResult;
        adminResult = adminService.queryOpenidIsExit(openid);
        if(adminResult==null){//注册
            System.out.println("进来了");
            adminResult =  adminService.insert(openid);
        }
        //此用户存在，可登录
        return JsonReust.ok(adminResult);
    }

    /*信息维护*/
    @RequestMapping("/updateInfo")
    @ResponseBody
    public JsonReust updateInfo(Admin admin){
        try {
            Admin adminResult = adminService.updateInfo(admin);
            return JsonReust.ok(adminResult);
        }catch (Exception e) {
            return JsonReust.errorMsg("失败,请检查是否按照文档在写");
        }
    }

    /*管理员查看医生申请列表*/
    @RequestMapping("/ApplyList")
    @ResponseBody
    public JsonReust ApplyList(){
        try {
            Map<String, Object> banResult =  doctorService.ApplyList();
            return JsonReust.ok(banResult);
        }catch (Exception e) {
            return JsonReust.errorMsg("失败,请检查是否按照文档在写");
        }
    }
    /*管理员审核医生材料*/
    @RequestMapping("/checkDoctorApply")
    @ResponseBody
    public JsonReust checkDoctorApply(Doctor doctor){
        try {
           doctorService.checkDoctorApply(doctor);
            return JsonReust.ok();
        }catch (Exception e) {
            return JsonReust.errorMsg("失败,请检查是否按照文档在写");
        }
    }
    /*先查询支付的列表*/
    @RequestMapping("/userPayList")
    @ResponseBody
    public JsonReust userPayList(){
        try {
          List<Order> result =  adminService.userPayList();
            return JsonReust.ok(result);
        }catch (Exception e) {
            return JsonReust.errorMsg("失败,请检查是否按照文档在写");
        }
    }

    /*管理员修改快递编号*/
    @RequestMapping("/updateAddressNum")
    @ResponseBody
    public JsonReust updateAddressNum(@RequestParam("order_id") Integer order_id,
                                      @RequestParam("address_num") String  address_num){
        try {
            int result =  adminService.updateAddressNum(order_id,address_num);
            return JsonReust.ok("订单编号维护成功");
        }catch (Exception e) {
            return JsonReust.errorMsg("失败,请检查是否按照文档在写");
        }
    }



    /*管理员查看所有就诊列表*/


    /*管理员进行答题得分数据分析*/

    /*查看所有用户 所有医生 所有聊天记录条数 商品总数量 */

    /*管理员查看评论*/


}
