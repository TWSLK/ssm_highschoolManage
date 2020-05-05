package com.server.impl;

import java.util.List;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.YonggongbumenMapper;
import com.entity.Yonggongbumen;
import com.server.YonggongbumenServer;
@Service
public class YonggongbumenServerImpi implements YonggongbumenServer {
   @Resource
   private YonggongbumenMapper gdao;
	@Override
	public int add(Yonggongbumen po) {
		return gdao.insert(po);
	}

	@Override
	public int update(Yonggongbumen po) {
		return gdao.updateByPrimaryKeySelective(po);
	}

	
	
	@Override
	public int delete(int id) {
		return gdao.deleteByPrimaryKey(id);
	}

	@Override
	public List<Yonggongbumen> getAll(Map<String, Object> map) {
		return gdao.getAll(map);
	}
	
	public List<Yonggongbumen> getsyyonggongbumen1(Map<String, Object> map) {
		return gdao.getsyyonggongbumen1(map);
	}
	public List<Yonggongbumen> getsyyonggongbumen2(Map<String, Object> map) {
		return gdao.getsyyonggongbumen2(map);
	}
	public List<Yonggongbumen> getsyyonggongbumen3(Map<String, Object> map) {
		return gdao.getsyyonggongbumen3(map);
	}
	
	@Override
	public Yonggongbumen quchongYonggongbumen(Map<String, Object> account) {
		return gdao.quchongYonggongbumen(account);
	}

	@Override
	public List<Yonggongbumen> getByPage(Map<String, Object> map) {
		return gdao.getByPage(map);
	}

	@Override
	public int getCount(Map<String, Object> map) {
		return gdao.getCount(map);
	}

	@Override
	public List<Yonggongbumen> select(Map<String, Object> map) {
		return gdao.select(map);
	}

	@Override
	public Yonggongbumen getById(int id) {
		return gdao.selectByPrimaryKey(id);
	}

}

