// pages/index/index.js

const $http = require('../../lib/config.js').apiUrl
Page({

  /**
   * 页面的初始数据
   */
  data: {
    swiperList: [{
        imgUrl: "/images/u348.png"
      },
      {
        imgUrl: "https://img.alicdn.com/imgextra/i3/1064400149/O1CN01Aq6QyI1CyHbz2MDp6_!!0-saturn_solar.jpg_220x220.jpg_.webp"
      },
      {
        imgUrl: "https://img.alicdn.com/imgextra/i2/483590175/O1CN01oZ5FgC1DABtwe5pY9_!!0-saturn_solar.jpg_220x220.jpg_.webp"
      },
    ],
    tabberList: [{
        img: "/images/yinyue.png",
        url: "/",
        name: "音乐"
      },
      {
        img: "/images/doctor.png",
        url: "/pages/doctorlist/doctorlist",
        name: "医师推荐"
      },
      {
        img: "/images/produce.png",
        url: "/pages/produce/produce",
        name: "助眠产品"
      },
      {
        img: "/images/yinshi.png",
        url: "/pages/enjoylist/enjoylist",
        name: "饮食推荐"
      },
      {
        img: "/images/changshi.png",
        url: "/pages/enjoylist/enjoylist",
        name: "助眠常识"
      },
      {
        img: "/images/jiankang.png",
        url: "/pages/myhealth/myhealth",
        name: "我的健康"
      }
    ],
    recommed: []

  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
      this.getProducelist()
  },
//首页三条商品推荐
getProducelist(){
  wx.request({
    url: $http + '/produce/getlist',
    success:(res)=>{
      console.log(res.data.data)
      this.setData({
        recommed:res.data.data
      })
    }
  })
},
  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function () {

  },

  /**
   * 生命周期函数--监听页面显示
   */
  onShow: function () {

  },

  /**
   * 生命周期函数--监听页面隐藏
   */
  onHide: function () {

  },

  /**
   * 生命周期函数--监听页面卸载
   */
  onUnload: function () {

  },

  /**
   * 页面相关事件处理函数--监听用户下拉动作
   */
  onPullDownRefresh: function () {

  },

  /**
   * 页面上拉触底事件的处理函数
   */
  onReachBottom: function () {

  },

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage: function () {

  }
})