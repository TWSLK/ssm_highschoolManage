package com.dao;

import java.util.List;
import java.util.Map;

import com.entity.Gongzuojiluxinxi;

public interface GongzuojiluxinxiMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Gongzuojiluxinxi record);

    int insertSelective(Gongzuojiluxinxi record);

    Gongzuojiluxinxi selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Gongzuojiluxinxi record);
	
    int updateByPrimaryKey(Gongzuojiluxinxi record);
	public Gongzuojiluxinxi quchongGongzuojiluxinxi(Map<String, Object> xuehao);
	public List<Gongzuojiluxinxi> getAll(Map<String, Object> map);
	public List<Gongzuojiluxinxi> getsygongzuojiluxinxi1(Map<String, Object> map);
	public List<Gongzuojiluxinxi> getsygongzuojiluxinxi3(Map<String, Object> map);
	public List<Gongzuojiluxinxi> getsygongzuojiluxinxi2(Map<String, Object> map);
	public int getCount(Map<String, Object> po);
	public List<Gongzuojiluxinxi> getByPage(Map<String, Object> map);
	public List<Gongzuojiluxinxi> select(Map<String, Object> map);
//	所有List
}

