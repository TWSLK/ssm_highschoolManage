package com.dao;

import java.util.List;
import java.util.Map;

import com.entity.Kunnanshengshenqing;

public interface KunnanshengshenqingMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Kunnanshengshenqing record);

    int insertSelective(Kunnanshengshenqing record);

    Kunnanshengshenqing selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Kunnanshengshenqing record);
	int updateByPrimaryKeySelectivelb(Kunnanshengshenqing record);
    int updateByPrimaryKey(Kunnanshengshenqing record);
	public Kunnanshengshenqing quchongKunnanshengshenqing(Map<String, Object> xuehao);
	public List<Kunnanshengshenqing> getAll(Map<String, Object> map);
	public List<Kunnanshengshenqing> getsykunnanshengshenqing1(Map<String, Object> map);
	public List<Kunnanshengshenqing> getsykunnanshengshenqing3(Map<String, Object> map);
	public List<Kunnanshengshenqing> getsykunnanshengshenqing2(Map<String, Object> map);
	public int getCount(Map<String, Object> po);
	public List<Kunnanshengshenqing> getByPage(Map<String, Object> map);
	public List<Kunnanshengshenqing> select(Map<String, Object> map);
//	所有List
}

