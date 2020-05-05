package com.server.impl;

import java.util.List;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.ZhuxuejinMapper;
import com.entity.Zhuxuejin;
import com.server.ZhuxuejinServer;
@Service
public class ZhuxuejinServerImpi implements ZhuxuejinServer {
   @Resource
   private ZhuxuejinMapper gdao;
	@Override
	public int add(Zhuxuejin po) {
		return gdao.insert(po);
	}

	@Override
	public int update(Zhuxuejin po) {
		return gdao.updateByPrimaryKeySelective(po);
	}

	@Override
	public int updatelb(Zhuxuejin po) {
		return gdao.updateByPrimaryKeySelectivelb(po);
	}
	
	@Override
	public int delete(int id) {
		return gdao.deleteByPrimaryKey(id);
	}

	@Override
	public List<Zhuxuejin> getAll(Map<String, Object> map) {
		return gdao.getAll(map);
	}
	
	public List<Zhuxuejin> getsyzhuxuejin1(Map<String, Object> map) {
		return gdao.getsyzhuxuejin1(map);
	}
	public List<Zhuxuejin> getsyzhuxuejin2(Map<String, Object> map) {
		return gdao.getsyzhuxuejin2(map);
	}
	public List<Zhuxuejin> getsyzhuxuejin3(Map<String, Object> map) {
		return gdao.getsyzhuxuejin3(map);
	}
	
	@Override
	public Zhuxuejin quchongZhuxuejin(Map<String, Object> account) {
		return gdao.quchongZhuxuejin(account);
	}

	@Override
	public List<Zhuxuejin> getByPage(Map<String, Object> map) {
		return gdao.getByPage(map);
	}

	@Override
	public int getCount(Map<String, Object> map) {
		return gdao.getCount(map);
	}

	@Override
	public List<Zhuxuejin> select(Map<String, Object> map) {
		return gdao.select(map);
	}

	@Override
	public Zhuxuejin getById(int id) {
		return gdao.selectByPrimaryKey(id);
	}

}

