// pages/emr/emr.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    sx: "",
    sd: "",
    mx: "",
    zs: ""
  },
  photo(e) {
    var type = e.currentTarget.dataset.type
    this.chooseImage(type)
  },
  chooseImage(type) {
    wx.chooseImage({
      count: 1,
      sizeType: ['original', 'compressed'], //可以指定是原图还是压缩图，默认二者都有
      sourceType: ['album'], //从相册选择
      success: (res) => {
        if (type == 'sx') {
          this.setData({
            sx: res.tempFilePaths
          })
        } else if (type == 'sd') {
          this.setData({
            sd: res.tempFilePaths
          })
        } else if (type == 'mx') {
          this.setData({
            mx: res.tempFilePaths
          })
        }

      }
    });
  },
  // 自述内容
  content(e) {
    this.data.zs = e.detail.value
  },
  // 提交信息
  wirte() {
    if (this.data.sx == '') {
      wx.showToast({
        title: '未上传舌像',
        icon: "none"
      })
    } else if (this.data.sd == '') {
      wx.showToast({
        title: '未上传舌底',
        icon: "none"
      })
    } else if (this.data.mx == '') {
      wx.showToast({
        title: '未上传面像',
        icon: "none"
      })
    } else if (this.data.zs == '') {
      wx.showToast({
        title: '自述不能为空',
        icon: "none"
      })
    }
    else{
      wx.showLoading({
        title: '上传中',
      })
      setTimeout(()=>{
        wx.hideLoading()
        
      },2000)
    }
  },
  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {

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