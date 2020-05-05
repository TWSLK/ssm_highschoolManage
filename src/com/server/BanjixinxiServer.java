package com.server;

import java.util.List;

import java.util.Map;

import com.entity.Banjixinxi;

public interface BanjixinxiServer {

  public int add(Banjixinxi po);

  public int update(Banjixinxi po);
  
  
  
  public int delete(int id);

  public List<Banjixinxi> getAll(Map<String,Object> map);
  public List<Banjixinxi> getsybanjixinxi1(Map<String,Object> map);
  public List<Banjixinxi> getsybanjixinxi2(Map<String,Object> map);
  public List<Banjixinxi> getsybanjixinxi3(Map<String,Object> map);
  public Banjixinxi quchongBanjixinxi(Map<String, Object> acount);

  public Banjixinxi getById( int id);

  public List<Banjixinxi> getByPage(Map<String, Object> map);

  public int getCount(Map<String,Object> map);

  public List<Banjixinxi> select(Map<String, Object> map);
}
//	所有List
