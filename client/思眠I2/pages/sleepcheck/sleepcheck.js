// pages/sleepcheck/sleepcheck.js
const $http = require('../../lib/config.js').apiUrl
const demo = [{
  title: "1.入睡时间（关灯后睡着的时间）",
  option: {
    answer_1: "15分钟",
    answer_2: "30分钟",
    answer_3: "1小时",
    answer_4: "2小时或者2小时以上"
  }

}, {
  title: "2.夜间苏醒",
  option: {
    answer_1: "1次",
    answer_2:  "3次",
    answer_3:  "5次",
    answer_4:  "8次"
  }

}, {
  title: "3.比期望的时间早醒",
  option: {
    answer_1: "1次",
    answer_2:  "3次",
    answer_3:  "7次",
    answer_4:  "11次或以上"
  }

}, {
  title: "4.总睡眠时间",
  option: {
    answer_1: "8小时",
    answer_2: "6小时",
    answer_3: "4小时",
    answer_4: "2小时或者2小时以下"
  }

}, {
  title: "5.总睡眠质量（无论睡多长）",
  option: {
    answer_1: "满意",
    answer_2: "一般",
    answer_3: "显著不满",
    answer_4: "严重不满或没有睡觉"
  }
}, {
  title: "6.白天情绪",
  option: {
    answer_1: "正常",
    answer_2: "轻微低落",
    answer_3: "显著低落",
    answer_4: "严重低落"
  }
}, {
  title: "7.白天身体状况（体力/精神，如记忆力，认知功能和注意力等）",
  option: {
    answer_1: "足够",
    answer_2: "轻微影响",
    answer_3: "显著影响",
    answer_4: "严重影响"
  }
}, {
  title: "8.白天思睡",
  option: {
    answer_1: "无思睡",
    answer_2: "轻微思睡",
    answer_3: "显著思睡",
    answer_4: "严重思睡"
  }
}]
Page({

  /**
   * 页面的初始数据
   */
  data: {
    list: {},
    num: 0,
    index: 0,
    score: 0
  },
  check(e) {
    let tabindex = e.currentTarget.dataset.index
    console.log(tabindex)
    this.setData({
      tabindex: tabindex
    })

    this.addScore(tabindex)

    this.setData({
      num: this.data.num + 1
  
    })
    setTimeout(()=>{
      this.setData({
        list: demo[this.data.num],
        tabindex:0
      })
    },500)

  
    if(this.data.num>=8){
      wx.showToast({
        title: '测试结束',
      })
      setTimeout(()=>{
        wx.redirectTo({
          url: '../sleepResult/sleepResult?score='+this.data.score,
        })
      },1000)
      return
    }
    console.log("num",this.data.num)

  },
  addScore(tabindex) {
    console.log("tabindex",tabindex)
    if (tabindex == "answer_2") {
      this.setData({
        score: this.data.score + 1
      })
    } else if (tabindex == "answer_3") {
      this.setData({
        score: this.data.score + 2
      })
    } else if (tabindex == "answer_4") {
      this.setData({
        score: this.data.score + 3
      })
    }
    console.log("score",this.data.score)
  },
  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    this.setData({
      list: demo[0]
    })
    if(options.type){
        this.setData({
          type:options.type
        })
    }
    
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