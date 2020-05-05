package com.dao;

import java.util.List;
import java.util.Map;

import com.entity.Gangweixinxi;

public interface GangweixinxiMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Gangweixinxi record);

    int insertSelective(Gangweixinxi record);

    Gangweixinxi selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Gangweixinxi record);
	int updateByPrimaryKeySelectivelb(Gangweixinxi record);
    int updateByPrimaryKey(Gangweixinxi record);
	public Gangweixinxi quchongGangweixinxi(Map<String, Object> bumenzhanghao);
	public List<Gangweixinxi> getAll(Map<String, Object> map);
	public List<Gangweixinxi> getsygangweixinxi1(Map<String, Object> map);
	public List<Gangweixinxi> getsygangweixinxi3(Map<String, Object> map);
	public List<Gangweixinxi> getsygangweixinxi2(Map<String, Object> map);
	public int getCount(Map<String, Object> po);
	public List<Gangweixinxi> getByPage(Map<String, Object> map);
	public List<Gangweixinxi> select(Map<String, Object> map);
//	所有List
}

