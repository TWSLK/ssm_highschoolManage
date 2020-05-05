package com.server.impl;

import java.util.List;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.BanjixinxiMapper;
import com.entity.Banjixinxi;
import com.server.BanjixinxiServer;
@Service
public class BanjixinxiServerImpi implements BanjixinxiServer {
   @Resource
   private BanjixinxiMapper gdao;
	@Override
	public int add(Banjixinxi po) {
		return gdao.insert(po);
	}

	@Override
	public int update(Banjixinxi po) {
		return gdao.updateByPrimaryKeySelective(po);
	}

	
	
	@Override
	public int delete(int id) {
		return gdao.deleteByPrimaryKey(id);
	}

	@Override
	public List<Banjixinxi> getAll(Map<String, Object> map) {
		return gdao.getAll(map);
	}
	
	public List<Banjixinxi> getsybanjixinxi1(Map<String, Object> map) {
		return gdao.getsybanjixinxi1(map);
	}
	public List<Banjixinxi> getsybanjixinxi2(Map<String, Object> map) {
		return gdao.getsybanjixinxi2(map);
	}
	public List<Banjixinxi> getsybanjixinxi3(Map<String, Object> map) {
		return gdao.getsybanjixinxi3(map);
	}
	
	@Override
	public Banjixinxi quchongBanjixinxi(Map<String, Object> account) {
		return gdao.quchongBanjixinxi(account);
	}

	@Override
	public List<Banjixinxi> getByPage(Map<String, Object> map) {
		return gdao.getByPage(map);
	}

	@Override
	public int getCount(Map<String, Object> map) {
		return gdao.getCount(map);
	}

	@Override
	public List<Banjixinxi> select(Map<String, Object> map) {
		return gdao.select(map);
	}

	@Override
	public Banjixinxi getById(int id) {
		return gdao.selectByPrimaryKey(id);
	}

}

