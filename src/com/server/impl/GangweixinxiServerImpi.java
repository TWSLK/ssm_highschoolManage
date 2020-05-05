package com.server.impl;

import java.util.List;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.GangweixinxiMapper;
import com.entity.Gangweixinxi;
import com.server.GangweixinxiServer;
@Service
public class GangweixinxiServerImpi implements GangweixinxiServer {
   @Resource
   private GangweixinxiMapper gdao;
	@Override
	public int add(Gangweixinxi po) {
		return gdao.insert(po);
	}

	@Override
	public int update(Gangweixinxi po) {
		return gdao.updateByPrimaryKeySelective(po);
	}

	@Override
	public int updatelb(Gangweixinxi po) {
		return gdao.updateByPrimaryKeySelectivelb(po);
	}
	
	@Override
	public int delete(int id) {
		return gdao.deleteByPrimaryKey(id);
	}

	@Override
	public List<Gangweixinxi> getAll(Map<String, Object> map) {
		return gdao.getAll(map);
	}
	
	public List<Gangweixinxi> getsygangweixinxi1(Map<String, Object> map) {
		return gdao.getsygangweixinxi1(map);
	}
	public List<Gangweixinxi> getsygangweixinxi2(Map<String, Object> map) {
		return gdao.getsygangweixinxi2(map);
	}
	public List<Gangweixinxi> getsygangweixinxi3(Map<String, Object> map) {
		return gdao.getsygangweixinxi3(map);
	}
	
	@Override
	public Gangweixinxi quchongGangweixinxi(Map<String, Object> account) {
		return gdao.quchongGangweixinxi(account);
	}

	@Override
	public List<Gangweixinxi> getByPage(Map<String, Object> map) {
		return gdao.getByPage(map);
	}

	@Override
	public int getCount(Map<String, Object> map) {
		return gdao.getCount(map);
	}

	@Override
	public List<Gangweixinxi> select(Map<String, Object> map) {
		return gdao.select(map);
	}

	@Override
	public Gangweixinxi getById(int id) {
		return gdao.selectByPrimaryKey(id);
	}

}

