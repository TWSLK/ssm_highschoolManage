package com.server.impl;

import java.util.List;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.QingongzhuxueMapper;
import com.entity.Qingongzhuxue;
import com.server.QingongzhuxueServer;
@Service
public class QingongzhuxueServerImpi implements QingongzhuxueServer {
   @Resource
   private QingongzhuxueMapper gdao;
	@Override
	public int add(Qingongzhuxue po) {
		return gdao.insert(po);
	}

	@Override
	public int update(Qingongzhuxue po) {
		return gdao.updateByPrimaryKeySelective(po);
	}

	@Override
	public int updatelb(Qingongzhuxue po) {
		return gdao.updateByPrimaryKeySelectivelb(po);
	}
	
	@Override
	public int delete(int id) {
		return gdao.deleteByPrimaryKey(id);
	}

	@Override
	public List<Qingongzhuxue> getAll(Map<String, Object> map) {
		return gdao.getAll(map);
	}
	
	public List<Qingongzhuxue> getsyqingongzhuxue1(Map<String, Object> map) {
		return gdao.getsyqingongzhuxue1(map);
	}
	public List<Qingongzhuxue> getsyqingongzhuxue2(Map<String, Object> map) {
		return gdao.getsyqingongzhuxue2(map);
	}
	public List<Qingongzhuxue> getsyqingongzhuxue3(Map<String, Object> map) {
		return gdao.getsyqingongzhuxue3(map);
	}
	
	@Override
	public Qingongzhuxue quchongQingongzhuxue(Map<String, Object> account) {
		return gdao.quchongQingongzhuxue(account);
	}

	@Override
	public List<Qingongzhuxue> getByPage(Map<String, Object> map) {
		return gdao.getByPage(map);
	}

	@Override
	public int getCount(Map<String, Object> map) {
		return gdao.getCount(map);
	}

	@Override
	public List<Qingongzhuxue> select(Map<String, Object> map) {
		return gdao.select(map);
	}

	@Override
	public Qingongzhuxue getById(int id) {
		return gdao.selectByPrimaryKey(id);
	}

}

