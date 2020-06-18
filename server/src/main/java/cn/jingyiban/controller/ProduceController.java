package cn.jingyiban.controller;

import cn.jingyiban.pojo.Produce;
import cn.jingyiban.pojo.ProduceType;
import cn.jingyiban.service.IProduceService;
import cn.jingyiban.utils.JsonReust;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
/*解决跨域问题*/
@CrossOrigin
@RequestMapping("/produce")
public class ProduceController {

    @Autowired
    IProduceService produceService;

    /*商品列表*/
    @RequestMapping("/list")
    @ResponseBody
    public JsonReust list(){
        List<ProduceType> result = produceService.getlist();
        return JsonReust.ok(result);
    }


    /*商品类别*/
    @RequestMapping("/getType")
    @ResponseBody
    public JsonReust getType(){
        List<ProduceType> result = produceService.getType();
        return JsonReust.ok(result);
    }

    /*商品添加*/
    @RequestMapping("/add")
    @ResponseBody
    public JsonReust add(Produce produce){
        produceService.add(produce);
        return JsonReust.ok();
    }

    /*商品详细*/
    @RequestMapping("/getDetail")
    @ResponseBody
    public JsonReust getDetail( @RequestParam("id") Integer id){
       Produce produce =  produceService.getDetail(id);
        return JsonReust.ok(produce);
    }

    /*商品删除*/
    @RequestMapping("delete")
    @ResponseBody
    public JsonReust delete( @RequestParam("id") Integer id){
        produceService.delete(id);
        return JsonReust.ok();
    }


    /*商品维护*/
    @RequestMapping("/update")
    @ResponseBody
    public JsonReust update(Produce produce){
        produceService.update(produce);
        return JsonReust.ok();
    }
    /*首页随机取出前三*/
    @RequestMapping("/getlist")
    @ResponseBody
    public JsonReust getlist(Integer type_id){

        return  produceService.getlistbytype(type_id);
    }

}
