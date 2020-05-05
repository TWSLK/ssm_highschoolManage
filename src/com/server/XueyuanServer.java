package com.server;

import java.util.List;

import java.util.Map;

import com.entity.Xueyuan;

public interface XueyuanServer {

  public int add(Xueyuan po);

  public int update(Xueyuan po);
  
  
  
  public int delete(int id);

  public List<Xueyuan> getAll(Map<String,Object> map);
  public List<Xueyuan> getsyxueyuan1(Map<String,Object> map);
  public List<Xueyuan> getsyxueyuan2(Map<String,Object> map);
  public List<Xueyuan> getsyxueyuan3(Map<String,Object> map);
  public Xueyuan quchongXueyuan(Map<String, Object> acount);

  public Xueyuan getById( int id);

  public List<Xueyuan> getByPage(Map<String, Object> map);

  public int getCount(Map<String,Object> map);

  public List<Xueyuan> select(Map<String, Object> map);
}
//	所有List
