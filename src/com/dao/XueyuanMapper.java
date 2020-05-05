package com.dao;

import java.util.List;
import java.util.Map;

import com.entity.Xueyuan;

public interface XueyuanMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Xueyuan record);

    int insertSelective(Xueyuan record);

    Xueyuan selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Xueyuan record);
	
    int updateByPrimaryKey(Xueyuan record);
	public Xueyuan quchongXueyuan(Map<String, Object> zhanghao);
	public List<Xueyuan> getAll(Map<String, Object> map);
	public List<Xueyuan> getsyxueyuan1(Map<String, Object> map);
	public List<Xueyuan> getsyxueyuan3(Map<String, Object> map);
	public List<Xueyuan> getsyxueyuan2(Map<String, Object> map);
	public int getCount(Map<String, Object> po);
	public List<Xueyuan> getByPage(Map<String, Object> map);
	public List<Xueyuan> select(Map<String, Object> map);
//	所有List
}

