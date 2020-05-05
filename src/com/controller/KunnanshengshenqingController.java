package com.controller;

import java.io.File;
import java.io.IOException;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.entity.Kunnanshengshenqing;
import com.server.KunnanshengshenqingServer;
import com.util.PageBean;
import net.sf.json.JSONObject;
import com.util.db;
import java.sql.SQLException;
import java.sql.*;
@Controller
public class KunnanshengshenqingController {
	@Resource
	private KunnanshengshenqingServer kunnanshengshenqingService;


   
	@RequestMapping("addKunnanshengshenqing.do")
	public String addKunnanshengshenqing(HttpServletRequest request,Kunnanshengshenqing kunnanshengshenqing,HttpSession session) throws SQLException{
		Timestamp time=new Timestamp(System.currentTimeMillis());
		
		kunnanshengshenqing.setAddtime(time.toString().substring(0, 19));
		kunnanshengshenqingService.add(kunnanshengshenqing);
		
		session.setAttribute("backxx", "添加成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		
		//session.setAttribute("backurl", "kunnanshengshenqingList.do");
		
		return "redirect:postback.jsp";
		//return "redirect:kunnanshengshenqingList.do";
		
		
		
	}
 
//	处理编辑
	@RequestMapping("doUpdateKunnanshengshenqing.do")
	public String doUpdateKunnanshengshenqing(int id,ModelMap map,Kunnanshengshenqing kunnanshengshenqing){
		kunnanshengshenqing=kunnanshengshenqingService.getById(id);
		map.put("kunnanshengshenqing", kunnanshengshenqing);
		return "kunnanshengshenqing_updt";
	}
	
	
	
	@RequestMapping("doUpdateKunnanshengshenqinglb.do")
	public String doUpdateKunnanshengshenqinglb(int id,ModelMap map,Kunnanshengshenqing kunnanshengshenqing){
		kunnanshengshenqing=kunnanshengshenqingService.getById(id);
		map.put("kunnanshengshenqing", kunnanshengshenqing);
		return "kunnanshengshenqing_updtlb";
	}
	
	@RequestMapping("doUpdateKunnanshengshenqinglb2.do")
	public String doUpdateKunnanshengshenqinglb2(int id,ModelMap map,Kunnanshengshenqing kunnanshengshenqing){
		kunnanshengshenqing=kunnanshengshenqingService.getById(id);
		map.put("kunnanshengshenqing", kunnanshengshenqing);
		return "kunnanshengshenqing_updtlb2";
	}
	
	@RequestMapping("doUpdateKunnanshengshenqinglb3.do")
	public String doUpdateKunnanshengshenqinglb3(int id,ModelMap map,Kunnanshengshenqing kunnanshengshenqing){
		kunnanshengshenqing=kunnanshengshenqingService.getById(id);
		map.put("kunnanshengshenqing", kunnanshengshenqing);
		return "kunnanshengshenqing_updtlb3";
	}
	
@RequestMapping("updateKunnanshengshenqinglb.do")
	public String updateKunnanshengshenqinglb(int id,ModelMap map,Kunnanshengshenqing kunnanshengshenqing){
		kunnanshengshenqingService.updatelb(kunnanshengshenqing);
		return "redirect:kunnanshengshenqingList.do";
	}
	
//	后台详细
	@RequestMapping("kunnanshengshenqingDetail.do")
	public String kunnanshengshenqingDetail(int id,ModelMap map,Kunnanshengshenqing kunnanshengshenqing){
		kunnanshengshenqing=kunnanshengshenqingService.getById(id);
		map.put("kunnanshengshenqing", kunnanshengshenqing);
		return "kunnanshengshenqing_detail";
	}
//	前台详细
	@RequestMapping("knssqDetail.do")
	public String knssqDetail(int id,ModelMap map,Kunnanshengshenqing kunnanshengshenqing){
		kunnanshengshenqing=kunnanshengshenqingService.getById(id);
		map.put("kunnanshengshenqing", kunnanshengshenqing);
		return "kunnanshengshenqingdetail";
	}
//	
	@RequestMapping("updateKunnanshengshenqing.do")
	public String updateKunnanshengshenqing(int id,ModelMap map,Kunnanshengshenqing kunnanshengshenqing,HttpServletRequest request,HttpSession session){
		kunnanshengshenqingService.update(kunnanshengshenqing);
		session.setAttribute("backxx", "修改成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		return "redirect:postback.jsp";
		//String url = request.getHeader("Referer");
		//return "redirect:"+url;
		//return "redirect:kunnanshengshenqingList.do";
	}

//	分页查询
	@RequestMapping("kunnanshengshenqingList.do")
	public String kunnanshengshenqingList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Kunnanshengshenqing kunnanshengshenqing, String xuehao, String xingming, String xingbie, String banji, String shenqingliyou, String jiaoshishenhe, String xueyuanshenhe, String xuexiaoshenhe, String kunnanleibie, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(xuehao==null||xuehao.equals("")){pmap.put("xuehao", null);}else{pmap.put("xuehao", xuehao);}
		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}
		if(xingbie==null||xingbie.equals("")){pmap.put("xingbie", null);}else{pmap.put("xingbie", xingbie);}
		if(banji==null||banji.equals("")){pmap.put("banji", null);}else{pmap.put("banji", banji);}
		if(shenqingliyou==null||shenqingliyou.equals("")){pmap.put("shenqingliyou", null);}else{pmap.put("shenqingliyou", shenqingliyou);}
		if(jiaoshishenhe==null||jiaoshishenhe.equals("")){pmap.put("jiaoshishenhe", null);}else{pmap.put("jiaoshishenhe", jiaoshishenhe);}
		if(xueyuanshenhe==null||xueyuanshenhe.equals("")){pmap.put("xueyuanshenhe", null);}else{pmap.put("xueyuanshenhe", xueyuanshenhe);}
		if(xuexiaoshenhe==null||xuexiaoshenhe.equals("")){pmap.put("xuexiaoshenhe", null);}else{pmap.put("xuexiaoshenhe", xuexiaoshenhe);}
		if(kunnanleibie==null||kunnanleibie.equals("")){pmap.put("kunnanleibie", null);}else{pmap.put("kunnanleibie", kunnanleibie);}
		
		int total=kunnanshengshenqingService.getCount(pmap);
		pageBean.setTotal(total);
		List<Kunnanshengshenqing> list=kunnanshengshenqingService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "kunnanshengshenqing_list";
	}
	
	@RequestMapping("kunnanshengshenqing_yanben1.do")
	public String kunnanshengshenqing_yanben1(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Kunnanshengshenqing kunnanshengshenqing, String xuehao, String xingming, String xingbie, String banji, String shenqingliyou, String jiaoshishenhe, String xueyuanshenhe, String xuexiaoshenhe, String kunnanleibie, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(xuehao==null||xuehao.equals("")){pmap.put("xuehao", null);}else{pmap.put("xuehao", xuehao);}
		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}
		if(xingbie==null||xingbie.equals("")){pmap.put("xingbie", null);}else{pmap.put("xingbie", xingbie);}
		if(banji==null||banji.equals("")){pmap.put("banji", null);}else{pmap.put("banji", banji);}
		if(shenqingliyou==null||shenqingliyou.equals("")){pmap.put("shenqingliyou", null);}else{pmap.put("shenqingliyou", shenqingliyou);}
		if(jiaoshishenhe==null||jiaoshishenhe.equals("")){pmap.put("jiaoshishenhe", null);}else{pmap.put("jiaoshishenhe", jiaoshishenhe);}
		if(xueyuanshenhe==null||xueyuanshenhe.equals("")){pmap.put("xueyuanshenhe", null);}else{pmap.put("xueyuanshenhe", xueyuanshenhe);}
		if(xuexiaoshenhe==null||xuexiaoshenhe.equals("")){pmap.put("xuexiaoshenhe", null);}else{pmap.put("xuexiaoshenhe", xuexiaoshenhe);}
		if(kunnanleibie==null||kunnanleibie.equals("")){pmap.put("kunnanleibie", null);}else{pmap.put("kunnanleibie", kunnanleibie);}
		
		int total=kunnanshengshenqingService.getCount(pmap);
		pageBean.setTotal(total);
		List<Kunnanshengshenqing> list=kunnanshengshenqingService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "kunnanshengshenqing_yanben1";
	}
	@RequestMapping("kunnanshengshenqing_yanben2.do")
	public String kunnanshengshenqing_yanben2(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Kunnanshengshenqing kunnanshengshenqing, String xuehao, String xingming, String xingbie, String banji, String shenqingliyou, String jiaoshishenhe, String xueyuanshenhe, String xuexiaoshenhe, String kunnanleibie, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(xuehao==null||xuehao.equals("")){pmap.put("xuehao", null);}else{pmap.put("xuehao", xuehao);}
		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}
		if(xingbie==null||xingbie.equals("")){pmap.put("xingbie", null);}else{pmap.put("xingbie", xingbie);}
		if(banji==null||banji.equals("")){pmap.put("banji", null);}else{pmap.put("banji", banji);}
		if(shenqingliyou==null||shenqingliyou.equals("")){pmap.put("shenqingliyou", null);}else{pmap.put("shenqingliyou", shenqingliyou);}
		if(jiaoshishenhe==null||jiaoshishenhe.equals("")){pmap.put("jiaoshishenhe", null);}else{pmap.put("jiaoshishenhe", jiaoshishenhe);}
		if(xueyuanshenhe==null||xueyuanshenhe.equals("")){pmap.put("xueyuanshenhe", null);}else{pmap.put("xueyuanshenhe", xueyuanshenhe);}
		if(xuexiaoshenhe==null||xuexiaoshenhe.equals("")){pmap.put("xuexiaoshenhe", null);}else{pmap.put("xuexiaoshenhe", xuexiaoshenhe);}
		if(kunnanleibie==null||kunnanleibie.equals("")){pmap.put("kunnanleibie", null);}else{pmap.put("kunnanleibie", kunnanleibie);}
		
		int total=kunnanshengshenqingService.getCount(pmap);
		pageBean.setTotal(total);
		List<Kunnanshengshenqing> list=kunnanshengshenqingService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "kunnanshengshenqing_yanben2";
	}
	@RequestMapping("kunnanshengshenqing_yanben3.do")
	public String kunnanshengshenqing_yanben3(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Kunnanshengshenqing kunnanshengshenqing, String xuehao, String xingming, String xingbie, String banji, String shenqingliyou, String jiaoshishenhe, String xueyuanshenhe, String xuexiaoshenhe, String kunnanleibie, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(xuehao==null||xuehao.equals("")){pmap.put("xuehao", null);}else{pmap.put("xuehao", xuehao);}
		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}
		if(xingbie==null||xingbie.equals("")){pmap.put("xingbie", null);}else{pmap.put("xingbie", xingbie);}
		if(banji==null||banji.equals("")){pmap.put("banji", null);}else{pmap.put("banji", banji);}
		if(shenqingliyou==null||shenqingliyou.equals("")){pmap.put("shenqingliyou", null);}else{pmap.put("shenqingliyou", shenqingliyou);}
		if(jiaoshishenhe==null||jiaoshishenhe.equals("")){pmap.put("jiaoshishenhe", null);}else{pmap.put("jiaoshishenhe", jiaoshishenhe);}
		if(xueyuanshenhe==null||xueyuanshenhe.equals("")){pmap.put("xueyuanshenhe", null);}else{pmap.put("xueyuanshenhe", xueyuanshenhe);}
		if(xuexiaoshenhe==null||xuexiaoshenhe.equals("")){pmap.put("xuexiaoshenhe", null);}else{pmap.put("xuexiaoshenhe", xuexiaoshenhe);}
		if(kunnanleibie==null||kunnanleibie.equals("")){pmap.put("kunnanleibie", null);}else{pmap.put("kunnanleibie", kunnanleibie);}
		
		int total=kunnanshengshenqingService.getCount(pmap);
		pageBean.setTotal(total);
		List<Kunnanshengshenqing> list=kunnanshengshenqingService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "kunnanshengshenqing_yanben3";
	}
	@RequestMapping("kunnanshengshenqing_yanben4.do")
	public String kunnanshengshenqing_yanben4(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Kunnanshengshenqing kunnanshengshenqing, String xuehao, String xingming, String xingbie, String banji, String shenqingliyou, String jiaoshishenhe, String xueyuanshenhe, String xuexiaoshenhe, String kunnanleibie, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(xuehao==null||xuehao.equals("")){pmap.put("xuehao", null);}else{pmap.put("xuehao", xuehao);}
		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}
		if(xingbie==null||xingbie.equals("")){pmap.put("xingbie", null);}else{pmap.put("xingbie", xingbie);}
		if(banji==null||banji.equals("")){pmap.put("banji", null);}else{pmap.put("banji", banji);}
		if(shenqingliyou==null||shenqingliyou.equals("")){pmap.put("shenqingliyou", null);}else{pmap.put("shenqingliyou", shenqingliyou);}
		if(jiaoshishenhe==null||jiaoshishenhe.equals("")){pmap.put("jiaoshishenhe", null);}else{pmap.put("jiaoshishenhe", jiaoshishenhe);}
		if(xueyuanshenhe==null||xueyuanshenhe.equals("")){pmap.put("xueyuanshenhe", null);}else{pmap.put("xueyuanshenhe", xueyuanshenhe);}
		if(xuexiaoshenhe==null||xuexiaoshenhe.equals("")){pmap.put("xuexiaoshenhe", null);}else{pmap.put("xuexiaoshenhe", xuexiaoshenhe);}
		if(kunnanleibie==null||kunnanleibie.equals("")){pmap.put("kunnanleibie", null);}else{pmap.put("kunnanleibie", kunnanleibie);}
		
		int total=kunnanshengshenqingService.getCount(pmap);
		pageBean.setTotal(total);
		List<Kunnanshengshenqing> list=kunnanshengshenqingService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "kunnanshengshenqing_yanben4";
	}
	@RequestMapping("kunnanshengshenqing_yanben5.do")
	public String kunnanshengshenqing_yanben5(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Kunnanshengshenqing kunnanshengshenqing, String xuehao, String xingming, String xingbie, String banji, String shenqingliyou, String jiaoshishenhe, String xueyuanshenhe, String xuexiaoshenhe, String kunnanleibie, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(xuehao==null||xuehao.equals("")){pmap.put("xuehao", null);}else{pmap.put("xuehao", xuehao);}
		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}
		if(xingbie==null||xingbie.equals("")){pmap.put("xingbie", null);}else{pmap.put("xingbie", xingbie);}
		if(banji==null||banji.equals("")){pmap.put("banji", null);}else{pmap.put("banji", banji);}
		if(shenqingliyou==null||shenqingliyou.equals("")){pmap.put("shenqingliyou", null);}else{pmap.put("shenqingliyou", shenqingliyou);}
		if(jiaoshishenhe==null||jiaoshishenhe.equals("")){pmap.put("jiaoshishenhe", null);}else{pmap.put("jiaoshishenhe", jiaoshishenhe);}
		if(xueyuanshenhe==null||xueyuanshenhe.equals("")){pmap.put("xueyuanshenhe", null);}else{pmap.put("xueyuanshenhe", xueyuanshenhe);}
		if(xuexiaoshenhe==null||xuexiaoshenhe.equals("")){pmap.put("xuexiaoshenhe", null);}else{pmap.put("xuexiaoshenhe", xuexiaoshenhe);}
		if(kunnanleibie==null||kunnanleibie.equals("")){pmap.put("kunnanleibie", null);}else{pmap.put("kunnanleibie", kunnanleibie);}
		
		int total=kunnanshengshenqingService.getCount(pmap);
		pageBean.setTotal(total);
		List<Kunnanshengshenqing> list=kunnanshengshenqingService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "kunnanshengshenqing_yanben5";
	}
	
	@RequestMapping("kunnanshengshenqingList2.do")
	public String kunnanshengshenqingList2(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Kunnanshengshenqing kunnanshengshenqing, String xuehao, String xingming, String xingbie, String banji, String shenqingliyou, String jiaoshishenhe, String xueyuanshenhe, String xuexiaoshenhe, String kunnanleibie, String issh,HttpServletRequest request){
		/*if(session.getAttribute("user")==null){
			return "login";
		}*/
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		pmap.put("xuehao", (String)request.getSession().getAttribute("username"));
		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}
		if(xingbie==null||xingbie.equals("")){pmap.put("xingbie", null);}else{pmap.put("xingbie", xingbie);}
		if(shenqingliyou==null||shenqingliyou.equals("")){pmap.put("shenqingliyou", null);}else{pmap.put("shenqingliyou", shenqingliyou);}
		if(jiaoshishenhe==null||jiaoshishenhe.equals("")){pmap.put("jiaoshishenhe", null);}else{pmap.put("jiaoshishenhe", jiaoshishenhe);}
		if(xuexiaoshenhe==null||xuexiaoshenhe.equals("")){pmap.put("xuexiaoshenhe", null);}else{pmap.put("xuexiaoshenhe", xuexiaoshenhe);}
		if(kunnanleibie==null||kunnanleibie.equals("")){pmap.put("kunnanleibie", null);}else{pmap.put("kunnanleibie", kunnanleibie);}
		
		
		int total=kunnanshengshenqingService.getCount(pmap);
		pageBean.setTotal(total);
		List<Kunnanshengshenqing> list=kunnanshengshenqingService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "kunnanshengshenqing_list2";
	}
	@RequestMapping("kunnanshengshenqingList3.do")
	public String kunnanshengshenqingList3(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Kunnanshengshenqing kunnanshengshenqing, String xuehao, String xingming, String xingbie, String banji, String shenqingliyou, String jiaoshishenhe, String xueyuanshenhe, String xuexiaoshenhe, String kunnanleibie, String issh,HttpServletRequest request){
		/*if(session.getAttribute("user")==null){
			return "login";
		}*/
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		pmap.put("banji", (String)request.getSession().getAttribute("banji"));
		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}
		if(xingbie==null||xingbie.equals("")){pmap.put("xingbie", null);}else{pmap.put("xingbie", xingbie);}
		if(shenqingliyou==null||shenqingliyou.equals("")){pmap.put("shenqingliyou", null);}else{pmap.put("shenqingliyou", shenqingliyou);}
		if(jiaoshishenhe==null||jiaoshishenhe.equals("")){pmap.put("jiaoshishenhe", null);}else{pmap.put("jiaoshishenhe", jiaoshishenhe);}
		if(xuexiaoshenhe==null||xuexiaoshenhe.equals("")){pmap.put("xuexiaoshenhe", null);}else{pmap.put("xuexiaoshenhe", xuexiaoshenhe);}
		if(kunnanleibie==null||kunnanleibie.equals("")){pmap.put("kunnanleibie", null);}else{pmap.put("kunnanleibie", kunnanleibie);}
		
		
		int total=kunnanshengshenqingService.getCount(pmap);
		pageBean.setTotal(total);
		List<Kunnanshengshenqing> list=kunnanshengshenqingService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "kunnanshengshenqing_list3";
	}
	
	@RequestMapping("kunnanshengshenqingList4.do")
	public String kunnanshengshenqingList4(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Kunnanshengshenqing kunnanshengshenqing, String xuehao, String xingming, String xingbie, String banji, String shenqingliyou, String jiaoshishenhe, String xueyuanshenhe, String xuexiaoshenhe, String kunnanleibie, String issh,HttpServletRequest request){
		/*if(session.getAttribute("user")==null){
			return "login";
		}*/
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		//pmap.put(jiaoshishenhe, "审核通过");
		//if(yuan.equals("是"))
		
		//pmap.put("jiaoshishenhe", (String)request.getAttribute("审核通过"));
		//pmap.put(issh='否');
		//pmap.put("审核通过", jiaoshishenhe);
		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}
		if(xingbie==null||xingbie.equals("")){pmap.put("xingbie", null);}else{pmap.put("xingbie", xingbie);}
		if(shenqingliyou==null||shenqingliyou.equals("")){pmap.put("shenqingliyou", null);}else{pmap.put("shenqingliyou", shenqingliyou);}
		if(jiaoshishenhe==null||jiaoshishenhe.equals("")){pmap.put("jiaoshishenhe", null);}else{pmap.put("jiaoshishenhe", jiaoshishenhe);}
		if(xuexiaoshenhe==null||xuexiaoshenhe.equals("")){pmap.put("xuexiaoshenhe", null);}else{pmap.put("xuexiaoshenhe", xuexiaoshenhe);}
		if(kunnanleibie==null||kunnanleibie.equals("")){pmap.put("kunnanleibie", null);}else{pmap.put("kunnanleibie", kunnanleibie);}
		
		
		int total=kunnanshengshenqingService.getCount(pmap);
		pageBean.setTotal(total);
		List<Kunnanshengshenqing> list=kunnanshengshenqingService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "kunnanshengshenqing_list4";
	}
	
	
	@RequestMapping("knssqList.do")
	public String knssqList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Kunnanshengshenqing kunnanshengshenqing, String xuehao, String xingming, String xingbie, String banji, String shenqingliyou, String jiaoshishenhe, String xueyuanshenhe, String xuexiaoshenhe, String kunnanleibie, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(xuehao==null||xuehao.equals("")){pmap.put("xuehao", null);}else{pmap.put("xuehao", xuehao);}
		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}
		if(xingbie==null||xingbie.equals("")){pmap.put("xingbie", null);}else{pmap.put("xingbie", xingbie);}
		if(banji==null||banji.equals("")){pmap.put("banji", null);}else{pmap.put("banji", banji);}
		if(shenqingliyou==null||shenqingliyou.equals("")){pmap.put("shenqingliyou", null);}else{pmap.put("shenqingliyou", shenqingliyou);}
		if(jiaoshishenhe==null||jiaoshishenhe.equals("")){pmap.put("jiaoshishenhe", null);}else{pmap.put("jiaoshishenhe", jiaoshishenhe);}
		if(xueyuanshenhe==null||xueyuanshenhe.equals("")){pmap.put("xueyuanshenhe", null);}else{pmap.put("xueyuanshenhe", xueyuanshenhe);}
		if(xuexiaoshenhe==null||xuexiaoshenhe.equals("")){pmap.put("xuexiaoshenhe", null);}else{pmap.put("xuexiaoshenhe", xuexiaoshenhe);}
		if(kunnanleibie==null||kunnanleibie.equals("")){pmap.put("kunnanleibie", null);}else{pmap.put("kunnanleibie", kunnanleibie);}
		
		int total=kunnanshengshenqingService.getCount(pmap);
		pageBean.setTotal(total);
		List<Kunnanshengshenqing> list=kunnanshengshenqingService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "kunnanshengshenqinglist";
	}
	@RequestMapping("knssqListtp.do")
	public String knssqListtp(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Kunnanshengshenqing kunnanshengshenqing, String xuehao, String xingming, String xingbie, String banji, String shenqingliyou, String jiaoshishenhe, String xueyuanshenhe, String xuexiaoshenhe, String kunnanleibie, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(xuehao==null||xuehao.equals("")){pmap.put("xuehao", null);}else{pmap.put("xuehao", xuehao);}
		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}
		if(xingbie==null||xingbie.equals("")){pmap.put("xingbie", null);}else{pmap.put("xingbie", xingbie);}
		if(banji==null||banji.equals("")){pmap.put("banji", null);}else{pmap.put("banji", banji);}
		if(shenqingliyou==null||shenqingliyou.equals("")){pmap.put("shenqingliyou", null);}else{pmap.put("shenqingliyou", shenqingliyou);}
		if(jiaoshishenhe==null||jiaoshishenhe.equals("")){pmap.put("jiaoshishenhe", null);}else{pmap.put("jiaoshishenhe", jiaoshishenhe);}
		if(xueyuanshenhe==null||xueyuanshenhe.equals("")){pmap.put("xueyuanshenhe", null);}else{pmap.put("xueyuanshenhe", xueyuanshenhe);}
		if(xuexiaoshenhe==null||xuexiaoshenhe.equals("")){pmap.put("xuexiaoshenhe", null);}else{pmap.put("xuexiaoshenhe", xuexiaoshenhe);}
		if(kunnanleibie==null||kunnanleibie.equals("")){pmap.put("kunnanleibie", null);}else{pmap.put("kunnanleibie", kunnanleibie);}
		
		int total=kunnanshengshenqingService.getCount(pmap);
		pageBean.setTotal(total);
		List<Kunnanshengshenqing> list=kunnanshengshenqingService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "kunnanshengshenqinglisttp";
	}
	
	@RequestMapping("deleteKunnanshengshenqing.do")
	public String deleteKunnanshengshenqing(int id,HttpServletRequest request){
		kunnanshengshenqingService.delete(id);
		String url = request.getHeader("Referer");
		return "redirect:"+url;
		//return "redirect:kunnanshengshenqingList.do";
	}
	
	
}
