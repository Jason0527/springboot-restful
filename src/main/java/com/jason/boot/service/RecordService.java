package com.jason.boot.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jason.boot.dao.RecordDao;
import com.jason.boot.entity.Record;
import com.jason.boot.utils.StringUtil;
@Service
public class RecordService {
	@Autowired
	RecordDao dao;
	public int postRecord(Record record){
		record.setCreateDate(new Date());
		record.setId(StringUtil.createUUID());
		record.setTotalMoney(record.getMoney()+getTotalMoney());
		return dao.postRecord(record);
	}
	public Integer getTotalMoney(){
		if(dao.getTotalMoney() == null){
			return 0;
		}
		return dao.getTotalMoney();
	}
}
