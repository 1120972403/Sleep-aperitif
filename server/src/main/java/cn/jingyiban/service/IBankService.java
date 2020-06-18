package cn.jingyiban.service;

import cn.jingyiban.pojo.Bank;
import cn.jingyiban.pojo.BankRecord;

import java.util.List;
import java.util.Map;

public interface IBankService {
    /*获取答题列表*/
    Map<String, Object> getTypeBanKList(Integer type);

    /*存储答题记录*/
    int saveRecord(BankRecord bankRecord);

    /*获取自己答题信息*/
    Map<String, Object> getMyBankRecord(Integer user_id);
}
