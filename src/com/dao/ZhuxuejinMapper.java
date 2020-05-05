package com.dao;

import java.util.List;
import java.util.Map;

import com.entity.Zhuxuejin;

public interface ZhuxuejinMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Zhuxuejin record);

    int insertSelective(Zhuxuejin record);

    Zhuxuejin selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Zhuxuejin record);
	int updateByPrimaryKeySelectivelb(Zhuxuejin record);
    int updateByPrimaryKey(Zhuxuejin record);
	public Zhuxuejin quchongZhuxuejin(Map<String, Object> xuehao);
	public List<Zhuxuejin> getAll(Map<String, Object> map);
	public List<Zhuxuejin> getsyzhuxuejin1(Map<String, Object> map);
	public List<Zhuxuejin> getsyzhuxuejin3(Map<String, Object> map);
	public List<Zhuxuejin> getsyzhuxuejin2(Map<String, Object> map);
	public int getCount(Map<String, Object> po);
	public List<Zhuxuejin> getByPage(Map<String, Object> map);
	public List<Zhuxuejin> select(Map<String, Object> map);
//	所有List
}

