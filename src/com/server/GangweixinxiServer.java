package com.server;

import java.util.List;

import java.util.Map;

import com.entity.Gangweixinxi;

public interface GangweixinxiServer {

  public int add(Gangweixinxi po);

  public int update(Gangweixinxi po);
  
  public int updatelb(Gangweixinxi po);
  
  public int delete(int id);

  public List<Gangweixinxi> getAll(Map<String,Object> map);
  public List<Gangweixinxi> getsygangweixinxi1(Map<String,Object> map);
  public List<Gangweixinxi> getsygangweixinxi2(Map<String,Object> map);
  public List<Gangweixinxi> getsygangweixinxi3(Map<String,Object> map);
  public Gangweixinxi quchongGangweixinxi(Map<String, Object> acount);

  public Gangweixinxi getById( int id);

  public List<Gangweixinxi> getByPage(Map<String, Object> map);

  public int getCount(Map<String,Object> map);

  public List<Gangweixinxi> select(Map<String, Object> map);
}
//	所有List
