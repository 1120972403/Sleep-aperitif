// pages/produce/produce.js
const $http = require('../../lib/config.js').apiUrl
Page({

  /**
   * 页面的初始数据
   */
  data: {

  },
  // 立即购买
  gocar(e){
    var id = e.currentTarget.dataset.id
    wx.navigateTo({
      url:'/pages/shopcard/shopcard?id='+id
    })
  },
  godetail(e) {
    var id = e.currentTarget.dataset.id
    wx.navigateTo({
      url: "/pages/producedetail/producedetail?id="+id
    })
  },
  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    wx.request({
      url: $http + '/produce/list',
      success:(res)=>{
        console.log(res.data.data[0].produces)
        this.setData({
          list:res.data.data[0].produces
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