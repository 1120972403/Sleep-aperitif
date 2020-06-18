// pages/producedetail/producedetail.js
const $http = require('../../lib/config.js').apiUrl
Page({

  /**
   * 页面的初始数据
   */
  data: {

  },
  gocar(e){
    var id = e.currentTarget.dataset.id
    wx.navigateTo({
      url:'/pages/shopcard/shopcard?id='+id
    })
  },
  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    console.log(options.id)
    wx.request({
      url: $http+'/produce/getDetail?id='+options.id,
      success:(res)=>{
        console.log(res.data.data)
        this.setData({
          detail:res.data.data
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