package com.server;

import java.util.List;

import java.util.Map;

import com.entity.Qingongzhuxue;

public interface QingongzhuxueServer {

  public int add(Qingongzhuxue po);

  public int update(Qingongzhuxue po);
  
  public int updatelb(Qingongzhuxue po);
  
  public int delete(int id);

  public List<Qingongzhuxue> getAll(Map<String,Object> map);
  public List<Qingongzhuxue> getsyqingongzhuxue1(Map<String,Object> map);
  public List<Qingongzhuxue> getsyqingongzhuxue2(Map<String,Object> map);
  public List<Qingongzhuxue> getsyqingongzhuxue3(Map<String,Object> map);
  public Qingongzhuxue quchongQingongzhuxue(Map<String, Object> acount);

  public Qingongzhuxue getById( int id);

  public List<Qingongzhuxue> getByPage(Map<String, Object> map);

  public int getCount(Map<String,Object> map);

  public List<Qingongzhuxue> select(Map<String, Object> map);
}
//	所有List
