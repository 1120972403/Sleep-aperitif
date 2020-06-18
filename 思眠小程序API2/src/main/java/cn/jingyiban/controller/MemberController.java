package cn.jingyiban.controller;

import cn.jingyiban.pojo.BankRecord;
import cn.jingyiban.pojo.Emr;
import cn.jingyiban.pojo.Member;
import cn.jingyiban.pojo.Order;
import cn.jingyiban.service.IBankService;
import cn.jingyiban.service.IEmrService;
import cn.jingyiban.service.IMemberService;
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
@RequestMapping("/user")
public class MemberController {
    @Autowired
    IMemberService memberService;

    @Autowired
    IBankService bankService;

    @Autowired
    IEmrService emrService;
    /*登录注册*/
    @RequestMapping("/login")
    @ResponseBody
    public JsonReust registerOrlogin(@RequestParam("code") String code){

        String resultString = memberService.getOpenid(code);

        // 解析json
        JSONObject jsonObject = (JSONObject) JSONObject.parse(resultString);
        String openid;
        if(jsonObject.containsKey("errcode"))
        {
            return JsonReust.errorMap(jsonObject);
        }
        //先获取openid
        openid=jsonObject.get("openid") + "";
        Member memberResult;
        memberResult = memberService.queryOpenidIsExit(openid);
        if(memberResult==null){//注册
            System.out.println("进来了");
            memberResult =  memberService.insert(openid);
        }
        //此用户存在，可登录
        return JsonReust.ok(memberResult);
    }

    /*信息维护*/
    @RequestMapping("/updateInfo")
    @ResponseBody
    public JsonReust updateInfo(Member member){
        try {
            Member memberResult = memberService.updateInfo(member);
             return JsonReust.ok(memberResult);
        }catch (Exception e) {
            return JsonReust.errorMsg("失败,请检查是否按照文档在写");
        }
    }
    /*获取答题信息 1为第一类型答题，2为第二项答题*/
    @RequestMapping("/getTypeBanKList")
    @ResponseBody
    public JsonReust getTypeBanKList(@RequestParam("type") Integer type){
        try {
            Map<String, Object> banResult = (Map<String, Object>) bankService.getTypeBanKList(type);
            return JsonReust.ok(banResult);
        }catch (Exception e) {
            return JsonReust.errorMsg("失败,请检查是否按照文档在写");
        }
    }

    /*记录答题过程*/
    @RequestMapping(path="/getRecord")
    @ResponseBody
    public JsonReust getRecord(BankRecord bankRecord) {
        try {
          bankService.saveRecord(bankRecord);
          return JsonReust.ok();
        } catch (Exception e) {
            return JsonReust.errorMsg("失败,请检查是否按照文档在写");
        }
    }

    /*用户查看自己的答题过程记录*/
    @RequestMapping("/getMyBankRecord")
    @ResponseBody
    public JsonReust getMyBankRecord(@RequestParam("user_id") Integer user_id){
        try {
            Map<String, Object> result = (Map<String, Object>) bankService.getMyBankRecord(user_id);
            return JsonReust.ok(result);
        }catch (Exception e) {
            return JsonReust.errorMsg("失败,请检查是否按照文档在写");
        }
    }

    /*答题结束存入emr病情诊断表*/
    @RequestMapping("/setEmr")
    @ResponseBody
    public JsonReust setEmr(Emr emr){
        try {
            emrService.InsertUserEmr(emr);
            return JsonReust.ok();
        }catch (Exception e) {
            return JsonReust.errorMsg("失败,请检查是否按照文档在写");
        }
    }

    /*用户查看自己emr*/
    @RequestMapping("/getMyEmr")
    @ResponseBody
    public JsonReust getMyEmrList(@RequestParam("user_id") Integer user_id ){
        Map<String, Object>  result= emrService.getMyEmrList(user_id);
        return JsonReust.ok(result);
    }

    /*这是一个测试  也可以用list接收所有*/
//    @RequestMapping("/test")
//    @ResponseBody
//    public JsonReust test(@RequestParam("user_id") Integer user_id ){
//       List<Emr> result= emrService.test(user_id);
//        return JsonReust.ok(result);
//    }


    /*用户下单产品*/
    @RequestMapping("/orderProduce")
    @ResponseBody
    public JsonReust orderProduce(Order order){
       int result = memberService.orderProduce(order);
        return JsonReust.ok(result);
    }

    /*查看我的订单*/
    @RequestMapping("/getMyProduceList")
    @ResponseBody
    public JsonReust getMyProduceList(@RequestParam("user_id") Integer user_id){
        List<Order> result = memberService.getMyProduceList(user_id);
        return JsonReust.ok(result);
    }
    /*取消我的订单*/
    @RequestMapping("/cancelMyProduceList")
    @ResponseBody
    public JsonReust cancelMyProduceList(@RequestParam("id") Integer id){
        int num =  memberService.cancelMyProduceList(id);
        return JsonReust.ok("取消订单成功");
    }
    /*确定支付接口*/
    @RequestMapping("/payment")
    @ResponseBody
    public JsonReust payment (@RequestParam("id") Integer id){
        int num =  memberService.paymentMyProduceList(id);
        return JsonReust.ok("支付成功,请等待收货");
    }

    /*确定收货*/
    @RequestMapping("/sureGoods")
    @ResponseBody
    public JsonReust sureGoods (@RequestParam("id") Integer id){
        int num =  memberService.sureGoods(id);
        return JsonReust.ok("我确定我收货");
    }

    /*获取医生列表*/
    /*我的医生*/
    @RequestMapping("/getdoctorlist")
    @ResponseBody
    public JsonReust getdoctorlist (){
        return  memberService.getdoctorlist();

    }
    /*医患交流*/


}
