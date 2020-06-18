package cn.jingyiban.utils;

/**
 * @Description: 自定义响应数据结构
 * 				这个类是提供给门户，ios，安卓，微信商城用的
 * 				门户接受此类数据后需要使用本类的方法转换成对于的数据类型格式（类，或者list）
 * 				其他自行处理,它主要是做一些响应的状态以及消息进行返回，并且你也需要包装一些自己的的数据，都是没有问题，
 * 				200：表示成功
 * 				500：表示错误，错误信息在msg字段中
 * 				501：bean验证错误，不管多少个错误都以map形式返回
 * 				502：拦截器拦截到用户token出错
 * 				555：异常抛出信息
 */

public class JsonReust {
    // 响应业务状态
    private Integer status;

    // 响应消息
    private String msg;

    // 响应中的数据
    private Object data;


    public static JsonReust build(Integer status, String msg, Object data) {
        return new JsonReust(status, msg, data);
    }

    public static JsonReust ok(Object data) {
        return new JsonReust(data);
    }

    public static JsonReust ok() {
        return new JsonReust(null);
    }

    public static JsonReust errorMsg(String msg) {
        return new JsonReust(500, msg, null);
    }

    public static JsonReust errorMap(Object data) {
        return new JsonReust(501, "error", data);
    }

    public static JsonReust errorTokenMsg(String msg) {
        return new JsonReust(502, msg, null);
    }

    public static JsonReust errorException(String msg) {
        return new JsonReust(555, msg, null);
    }

    public JsonReust() {

    }


    public JsonReust(Integer status, String msg, Object data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    public JsonReust(Object data) {
        this.status = 200;
        this.msg = "OK";
        this.data = data;//data = {"id":"dsssd","title":"dsddsds"};
    }
//
//    public Boolean isOK() {
//        return this.status == 200;
//    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

}
