package com.server;

import java.util.List;

import java.util.Map;

import com.entity.Gongzuojiluxinxi;

public interface GongzuojiluxinxiServer {

  public int add(Gongzuojiluxinxi po);

  public int update(Gongzuojiluxinxi po);
  
  
  
  public int delete(int id);

  public List<Gongzuojiluxinxi> getAll(Map<String,Object> map);
  public List<Gongzuojiluxinxi> getsygongzuojiluxinxi1(Map<String,Object> map);
  public List<Gongzuojiluxinxi> getsygongzuojiluxinxi2(Map<String,Object> map);
  public List<Gongzuojiluxinxi> getsygongzuojiluxinxi3(Map<String,Object> map);
  public Gongzuojiluxinxi quchongGongzuojiluxinxi(Map<String, Object> acount);

  public Gongzuojiluxinxi getById( int id);

  public List<Gongzuojiluxinxi> getByPage(Map<String, Object> map);

  public int getCount(Map<String,Object> map);

  public List<Gongzuojiluxinxi> select(Map<String, Object> map);
}
//	所有List
