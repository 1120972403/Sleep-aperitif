// pages/shopcard/shopcard.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    current: 0,
    tablist: [{
        name: "待付款"
      },
      {
        name: "待发货"
      },
      {
        name: "待收货"
      },
      {
        name: "已完成"
      },
      {
        name: "已取消"
      },
    ],
    num: 1, //数量
    oldprice: 299,
    totalprice: 299
  },
  // 切换tabblist
  change(e) {
    console.log(e.currentTarget.dataset.index)
    var index = e.currentTarget.dataset.index
    this.setData({
      current: index
    })
  },
  add() {
    var num = parseInt(this.data.num) + 1
    var price = this.data.oldprice * num
    this.setData({
      num,
      totalprice: price
    })
  },
  jian() {

    if (this.data.num > 1) {
      var num = parseInt(this.data.num) - 1
      var price = this.data.totalprice - this.data.oldprice
      console.log(price)
      this.setData({
        num,
        totalprice: price
      })
    } else {
      wx.showModal({
        cancelColor: 'cancelColor',
        cancelText: '取消',
        complete: (res) => {},
        confirmColor: 'confirmColor',
        confirmText: '确定',
        content: "您确定要取消购买此商品吗",
        fail: (res) => {},
        showCancel: true,
        success: (result) => {
          wx.showToast({
            title: '已取消',
            icon: "success"
          })

        },

      })
    }

  },
  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    console.log(options.id)
  },
  pay() {
    wx.showModal({
      cancelColor: 'cancelColor',
      cancelText: '取消',
      complete: (res) => {},
      confirmColor: 'confirmColor',
      confirmText: '确定',
      content: "您购买了" + this.data.num + "件,应该支付" + this.data.totalprice + "元",
      fail: (res) => {},
      showCancel: true,
      success: (result) => {
        //支付成功加载代发货
        this.setData({
          current: 1
        })

      },
      title: '是否确定支付',
    })
  },
  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function () {

  },
  // 提醒发货
  tixin() {
    wx.showToast({
      title: '已提醒卖家',
      icon: "success"
    })
    //显示待收货
    this.setData({
      current: 2
    })
  },
  // 查看物流
  chakan() {
    wx.showToast({
      title: '查看物物流',
      icon: "success"
    })
    //显示已完成
    this.setData({
      current: 3
    })
  },
  // 确定收获
  queding() {
    wx.showToast({
      title: '确定收货成功',
      icon: "success"
    })
    //显示已完成
    this.setData({
      current: 3
    })

  },
  del() {
    wx.showToast({
      title: '删除成功',
      icon: "success"
    })
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