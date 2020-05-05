package com.dao;

import java.util.List;
import java.util.Map;

import com.entity.Banjixinxi;

public interface BanjixinxiMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Banjixinxi record);

    int insertSelective(Banjixinxi record);

    Banjixinxi selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Banjixinxi record);
	
    int updateByPrimaryKey(Banjixinxi record);
	public Banjixinxi quchongBanjixinxi(Map<String, Object> banji);
	public List<Banjixinxi> getAll(Map<String, Object> map);
	public List<Banjixinxi> getsybanjixinxi1(Map<String, Object> map);
	public List<Banjixinxi> getsybanjixinxi3(Map<String, Object> map);
	public List<Banjixinxi> getsybanjixinxi2(Map<String, Object> map);
	public int getCount(Map<String, Object> po);
	public List<Banjixinxi> getByPage(Map<String, Object> map);
	public List<Banjixinxi> select(Map<String, Object> map);
//	所有List
}

