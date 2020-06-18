// pages/enjoylist/enjoylist.js
const $http = require('../../lib/config.js').apiUrl
Page({

  /**
   * 页面的初始数据
   */
  data: {
    tablist: [{
      name: "饮食推荐"
    }, {
      name: "助眠常识"
    }, ],
    tabindex: 0,
    recommed: []
  },
  changeTab(e) {
    var index =  e.currentTarget.dataset.index
    this.setData({
      tabindex: index
    })
    if(index==0){

      this.setData({
        recommed:this.data.yslist
      })
    }
    else{

      this.setData({
        recommed:this.data.zmlist
      })
    }
  },
  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    // 2为健康饮食 3为助眠产品
    wx.request({
      url: $http + '/enjoy/list?type=2',
      success:(res)=>{
        this.setData({
          yslist:res.data.data.data,
          recommed:res.data.data.data
        })
          console.log(res.data.data.data)
      }

    })
    wx.request({
      url: $http + '/enjoy/list?type=3',
      success:(res)=>{
        this.setData({
          zmlist:res.data.data.data
        })
          console.log(res.data.data)
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