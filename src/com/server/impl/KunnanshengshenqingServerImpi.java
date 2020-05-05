package com.server.impl;

import java.util.List;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.KunnanshengshenqingMapper;
import com.entity.Kunnanshengshenqing;
import com.server.KunnanshengshenqingServer;
@Service
public class KunnanshengshenqingServerImpi implements KunnanshengshenqingServer {
   @Resource
   private KunnanshengshenqingMapper gdao;
	@Override
	public int add(Kunnanshengshenqing po) {
		return gdao.insert(po);
	}

	@Override
	public int update(Kunnanshengshenqing po) {
		return gdao.updateByPrimaryKeySelective(po);
	}

	@Override
	public int updatelb(Kunnanshengshenqing po) {
		return gdao.updateByPrimaryKeySelectivelb(po);
	}
	
	@Override
	public int delete(int id) {
		return gdao.deleteByPrimaryKey(id);
	}

	@Override
	public List<Kunnanshengshenqing> getAll(Map<String, Object> map) {
		return gdao.getAll(map);
	}
	
	public List<Kunnanshengshenqing> getsykunnanshengshenqing1(Map<String, Object> map) {
		return gdao.getsykunnanshengshenqing1(map);
	}
	public List<Kunnanshengshenqing> getsykunnanshengshenqing2(Map<String, Object> map) {
		return gdao.getsykunnanshengshenqing2(map);
	}
	public List<Kunnanshengshenqing> getsykunnanshengshenqing3(Map<String, Object> map) {
		return gdao.getsykunnanshengshenqing3(map);
	}
	
	@Override
	public Kunnanshengshenqing quchongKunnanshengshenqing(Map<String, Object> account) {
		return gdao.quchongKunnanshengshenqing(account);
	}

	@Override
	public List<Kunnanshengshenqing> getByPage(Map<String, Object> map) {
		return gdao.getByPage(map);
	}

	@Override
	public int getCount(Map<String, Object> map) {
		return gdao.getCount(map);
	}

	@Override
	public List<Kunnanshengshenqing> select(Map<String, Object> map) {
		return gdao.select(map);
	}

	@Override
	public Kunnanshengshenqing getById(int id) {
		return gdao.selectByPrimaryKey(id);
	}

}

