package com.server;

import java.util.List;

import java.util.Map;

import com.entity.Zhuxuejin;

public interface ZhuxuejinServer {

  public int add(Zhuxuejin po);

  public int update(Zhuxuejin po);
  
  public int updatelb(Zhuxuejin po);
  
  public int delete(int id);

  public List<Zhuxuejin> getAll(Map<String,Object> map);
  public List<Zhuxuejin> getsyzhuxuejin1(Map<String,Object> map);
  public List<Zhuxuejin> getsyzhuxuejin2(Map<String,Object> map);
  public List<Zhuxuejin> getsyzhuxuejin3(Map<String,Object> map);
  public Zhuxuejin quchongZhuxuejin(Map<String, Object> acount);

  public Zhuxuejin getById( int id);

  public List<Zhuxuejin> getByPage(Map<String, Object> map);

  public int getCount(Map<String,Object> map);

  public List<Zhuxuejin> select(Map<String, Object> map);
}
//	所有List
