package com.server.impl;

import java.util.List;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.XueyuanMapper;
import com.entity.Xueyuan;
import com.server.XueyuanServer;
@Service
public class XueyuanServerImpi implements XueyuanServer {
   @Resource
   private XueyuanMapper gdao;
	@Override
	public int add(Xueyuan po) {
		return gdao.insert(po);
	}

	@Override
	public int update(Xueyuan po) {
		return gdao.updateByPrimaryKeySelective(po);
	}

	
	
	@Override
	public int delete(int id) {
		return gdao.deleteByPrimaryKey(id);
	}

	@Override
	public List<Xueyuan> getAll(Map<String, Object> map) {
		return gdao.getAll(map);
	}
	
	public List<Xueyuan> getsyxueyuan1(Map<String, Object> map) {
		return gdao.getsyxueyuan1(map);
	}
	public List<Xueyuan> getsyxueyuan2(Map<String, Object> map) {
		return gdao.getsyxueyuan2(map);
	}
	public List<Xueyuan> getsyxueyuan3(Map<String, Object> map) {
		return gdao.getsyxueyuan3(map);
	}
	
	@Override
	public Xueyuan quchongXueyuan(Map<String, Object> account) {
		return gdao.quchongXueyuan(account);
	}

	@Override
	public List<Xueyuan> getByPage(Map<String, Object> map) {
		return gdao.getByPage(map);
	}

	@Override
	public int getCount(Map<String, Object> map) {
		return gdao.getCount(map);
	}

	@Override
	public List<Xueyuan> select(Map<String, Object> map) {
		return gdao.select(map);
	}

	@Override
	public Xueyuan getById(int id) {
		return gdao.selectByPrimaryKey(id);
	}

}

