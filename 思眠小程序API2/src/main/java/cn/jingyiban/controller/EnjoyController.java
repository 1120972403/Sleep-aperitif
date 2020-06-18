package cn.jingyiban.controller;

import cn.jingyiban.pojo.Enjoy;
import cn.jingyiban.service.IEnjoyService;
import cn.jingyiban.utils.JsonReust;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
@RequestMapping("/enjoy")
public class EnjoyController {
    /*1为音乐 2为健康饮食 3为助眠咨询*/
    @Autowired
    IEnjoyService enjoyService;
    /*查找*/
    @RequestMapping("/list")
    @ResponseBody
    public JsonReust list(@RequestParam("type") Integer type){
        try {
            Map<String, Object> banResult = (Map<String, Object>) enjoyService.getList(type);
            return JsonReust.ok(banResult);
        }catch (Exception e) {
            return JsonReust.errorMsg("失败,请检查是否按照文档在写");
        }
    }

    /*请求单个*/
    @RequestMapping("/getDeatil")
    @ResponseBody
    public JsonReust getDeatil(@RequestParam("id") Integer id){
        try {
            Enjoy enjoyResult =  enjoyService.getDeatil(id);
            return JsonReust.ok(enjoyResult);
        }catch (Exception e) {
            return JsonReust.errorMsg("失败,请检查是否按照文档在写");
        }

    }


    /*增加*/

    @RequestMapping("/add")
    @ResponseBody
    public JsonReust list(Enjoy enjoy){
        try {
            enjoyService.addList(enjoy);
            return JsonReust.ok();
        }catch (Exception e) {
            return JsonReust.errorMsg("失败,请检查是否按照文档在写");
        }
    }

    /*修改*/

    @RequestMapping("/update")
    @ResponseBody
    public JsonReust update(Enjoy enjoy){
        try {
            enjoyService.updateByID(enjoy);
            return JsonReust.ok();
        }catch (Exception e) {
            return JsonReust.errorMsg("失败,请检查是否按照文档在写");
        }
    }

    /*删除*/
    @RequestMapping("/delete")
    @ResponseBody
    public JsonReust delete(@RequestParam("id") Integer id){
        try {
            enjoyService.deleteByid(id);
            return JsonReust.ok();
        }catch (Exception e) {
            return JsonReust.errorMsg("失败,请检查是否按照文档在写");
        }
    }

}
