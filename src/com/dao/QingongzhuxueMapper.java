package com.dao;

import java.util.List;
import java.util.Map;

import com.entity.Qingongzhuxue;

public interface QingongzhuxueMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Qingongzhuxue record);

    int insertSelective(Qingongzhuxue record);

    Qingongzhuxue selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Qingongzhuxue record);
	int updateByPrimaryKeySelectivelb(Qingongzhuxue record);
    int updateByPrimaryKey(Qingongzhuxue record);
	public Qingongzhuxue quchongQingongzhuxue(Map<String, Object> xuehao);
	public List<Qingongzhuxue> getAll(Map<String, Object> map);
	public List<Qingongzhuxue> getsyqingongzhuxue1(Map<String, Object> map);
	public List<Qingongzhuxue> getsyqingongzhuxue3(Map<String, Object> map);
	public List<Qingongzhuxue> getsyqingongzhuxue2(Map<String, Object> map);
	public int getCount(Map<String, Object> po);
	public List<Qingongzhuxue> getByPage(Map<String, Object> map);
	public List<Qingongzhuxue> select(Map<String, Object> map);
//	所有List
}

