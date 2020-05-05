package com.server;

import java.util.List;

import java.util.Map;

import com.entity.Yonggongbumen;

public interface YonggongbumenServer {

  public int add(Yonggongbumen po);

  public int update(Yonggongbumen po);
  
  
  
  public int delete(int id);

  public List<Yonggongbumen> getAll(Map<String,Object> map);
  public List<Yonggongbumen> getsyyonggongbumen1(Map<String,Object> map);
  public List<Yonggongbumen> getsyyonggongbumen2(Map<String,Object> map);
  public List<Yonggongbumen> getsyyonggongbumen3(Map<String,Object> map);
  public Yonggongbumen quchongYonggongbumen(Map<String, Object> acount);

  public Yonggongbumen getById( int id);

  public List<Yonggongbumen> getByPage(Map<String, Object> map);

  public int getCount(Map<String,Object> map);

  public List<Yonggongbumen> select(Map<String, Object> map);
}
//	所有List
