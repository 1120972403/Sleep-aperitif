package cn.jingyiban.service.impl;

import cn.jingyiban.mapper.BankMapper;
import cn.jingyiban.mapper.BankRecordMapper;
import cn.jingyiban.pojo.Bank;
import cn.jingyiban.pojo.BankRecord;
import cn.jingyiban.service.IBankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BankServiceImpl implements IBankService {

    @Autowired
    BankMapper bankMapper;
    @Autowired
    BankRecordMapper bankRecordMapper;

    Map<String, Object> map = new HashMap<>();
    /*获取题目*/
    @Override
    public Map<String, Object> getTypeBanKList(Integer type) {
        List<Bank> banLists = bankMapper.getTypeBanKList(type);
        map.put("data", banLists);
        return map;
    }

    @Override
    public int saveRecord(BankRecord bankRecord) {
        bankRecord.setCreateTime(new Date());
        int num = bankRecordMapper.insert(bankRecord);
        return num;
    }

    @Override
    public Map<String, Object> getMyBankRecord(Integer user_id) {
        List<Bank> banLists = bankRecordMapper.selectByUserID(user_id);
        map.put("data", banLists);
        return map;
    }
}
