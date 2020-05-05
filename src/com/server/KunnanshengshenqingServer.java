package com.server;

import java.util.List;

import java.util.Map;

import com.entity.Kunnanshengshenqing;

public interface KunnanshengshenqingServer {

  public int add(Kunnanshengshenqing po);

  public int update(Kunnanshengshenqing po);
  
  public int updatelb(Kunnanshengshenqing po);
  
  public int delete(int id);

  public List<Kunnanshengshenqing> getAll(Map<String,Object> map);
  public List<Kunnanshengshenqing> getsykunnanshengshenqing1(Map<String,Object> map);
  public List<Kunnanshengshenqing> getsykunnanshengshenqing2(Map<String,Object> map);
  public List<Kunnanshengshenqing> getsykunnanshengshenqing3(Map<String,Object> map);
  public Kunnanshengshenqing quchongKunnanshengshenqing(Map<String, Object> acount);

  public Kunnanshengshenqing getById( int id);

  public List<Kunnanshengshenqing> getByPage(Map<String, Object> map);

  public int getCount(Map<String,Object> map);

  public List<Kunnanshengshenqing> select(Map<String, Object> map);
}
//	所有List
