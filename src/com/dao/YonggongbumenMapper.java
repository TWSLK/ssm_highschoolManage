package com.dao;

import java.util.List;
import java.util.Map;

import com.entity.Yonggongbumen;

public interface YonggongbumenMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Yonggongbumen record);

    int insertSelective(Yonggongbumen record);

    Yonggongbumen selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Yonggongbumen record);
	
    int updateByPrimaryKey(Yonggongbumen record);
	public Yonggongbumen quchongYonggongbumen(Map<String, Object> bumenzhanghao);
	public List<Yonggongbumen> getAll(Map<String, Object> map);
	public List<Yonggongbumen> getsyyonggongbumen1(Map<String, Object> map);
	public List<Yonggongbumen> getsyyonggongbumen3(Map<String, Object> map);
	public List<Yonggongbumen> getsyyonggongbumen2(Map<String, Object> map);
	public int getCount(Map<String, Object> po);
	public List<Yonggongbumen> getByPage(Map<String, Object> map);
	public List<Yonggongbumen> select(Map<String, Object> map);
//	所有List
}

