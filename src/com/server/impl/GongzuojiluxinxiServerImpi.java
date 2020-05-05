package com.server.impl;

import java.util.List;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.GongzuojiluxinxiMapper;
import com.entity.Gongzuojiluxinxi;
import com.server.GongzuojiluxinxiServer;
@Service
public class GongzuojiluxinxiServerImpi implements GongzuojiluxinxiServer {
   @Resource
   private GongzuojiluxinxiMapper gdao;
	@Override
	public int add(Gongzuojiluxinxi po) {
		return gdao.insert(po);
	}

	@Override
	public int update(Gongzuojiluxinxi po) {
		return gdao.updateByPrimaryKeySelective(po);
	}

	
	
	@Override
	public int delete(int id) {
		return gdao.deleteByPrimaryKey(id);
	}

	@Override
	public List<Gongzuojiluxinxi> getAll(Map<String, Object> map) {
		return gdao.getAll(map);
	}
	
	public List<Gongzuojiluxinxi> getsygongzuojiluxinxi1(Map<String, Object> map) {
		return gdao.getsygongzuojiluxinxi1(map);
	}
	public List<Gongzuojiluxinxi> getsygongzuojiluxinxi2(Map<String, Object> map) {
		return gdao.getsygongzuojiluxinxi2(map);
	}
	public List<Gongzuojiluxinxi> getsygongzuojiluxinxi3(Map<String, Object> map) {
		return gdao.getsygongzuojiluxinxi3(map);
	}
	
	@Override
	public Gongzuojiluxinxi quchongGongzuojiluxinxi(Map<String, Object> account) {
		return gdao.quchongGongzuojiluxinxi(account);
	}

	@Override
	public List<Gongzuojiluxinxi> getByPage(Map<String, Object> map) {
		return gdao.getByPage(map);
	}

	@Override
	public int getCount(Map<String, Object> map) {
		return gdao.getCount(map);
	}

	@Override
	public List<Gongzuojiluxinxi> select(Map<String, Object> map) {
		return gdao.select(map);
	}

	@Override
	public Gongzuojiluxinxi getById(int id) {
		return gdao.selectByPrimaryKey(id);
	}

}

