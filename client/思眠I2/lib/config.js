//小程序配置文件

var apiUrl = "http://127.0.0.1:8888"
var imgUrl = ""
var config = {
  apiUrl,
  imgUrl
};
//统一规定 小程序端上传图片等一律加上上传的域名
//服务器端统一不加
module.exports = config