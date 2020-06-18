// pages/doctorlist/doctorlist.js
const $http = require('../../lib/config.js').apiUrl
Page({

  /**
   * 页面的初始数据
   */
  data: {
    list: []

  },
  chat(){
    wx.navigateTo({
      url: '/pages/chat/chat',
    })
  },
  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    wx.request({
      url:$http+'/user/getdoctorlist',
      success:(res)=>{
        console.log(res.data.data)
        var list = res.data.data
        for(var i = 0, len =res.data.data.length;i<len;i++ ){
          list[i].tag = list[i].name.substring(0,1); 
        }
        this.setData({
          list
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