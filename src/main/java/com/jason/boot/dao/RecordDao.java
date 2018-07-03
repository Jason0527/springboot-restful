package com.jason.boot.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.jason.boot.entity.Record;

@Mapper
public interface RecordDao {
	@Select("select Max(total_money) from record")
	public Integer getTotalMoney();
	@Insert("insert into record(id,type,hero_name,skin_grade,money,create_date,total_money) values(#{id},#{type},#{heroName},#{skinGrade},#{money},#{createDate},#{totalMoney})")
	public int postRecord(Record record);
}
