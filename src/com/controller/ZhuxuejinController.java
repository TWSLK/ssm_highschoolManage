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

import com.entity.Zhuxuejin;
import com.server.ZhuxuejinServer;
import com.util.PageBean;
import net.sf.json.JSONObject;
import com.util.db;
import java.sql.SQLException;
import java.sql.*;
@Controller
public class ZhuxuejinController {
	@Resource
	private ZhuxuejinServer zhuxuejinService;


   
	@RequestMapping("addZhuxuejin.do")
	public String addZhuxuejin(HttpServletRequest request,Zhuxuejin zhuxuejin,HttpSession session) throws SQLException{
		Timestamp time=new Timestamp(System.currentTimeMillis());
		
		zhuxuejin.setAddtime(time.toString().substring(0, 19));
		zhuxuejinService.add(zhuxuejin);
		
		session.setAttribute("backxx", "添加成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		
		//session.setAttribute("backurl", "zhuxuejinList.do");
		
		return "redirect:postback.jsp";
		//return "redirect:zhuxuejinList.do";
		
		
		
	}
 
//	处理编辑
	@RequestMapping("doUpdateZhuxuejin.do")
	public String doUpdateZhuxuejin(int id,ModelMap map,Zhuxuejin zhuxuejin){
		zhuxuejin=zhuxuejinService.getById(id);
		map.put("zhuxuejin", zhuxuejin);
		return "zhuxuejin_updt";
	}
	
	
	
	@RequestMapping("doUpdateZhuxuejinlb.do")
	public String doUpdateZhuxuejinlb(int id,ModelMap map,Zhuxuejin zhuxuejin){
		zhuxuejin=zhuxuejinService.getById(id);
		map.put("zhuxuejin", zhuxuejin);
		return "zhuxuejin_updtlb";
	}
	
	
	@RequestMapping("doUpdateZhuxuejinlb2.do")
	public String doUpdateZhuxuejinlb2(int id,ModelMap map,Zhuxuejin zhuxuejin){
		zhuxuejin=zhuxuejinService.getById(id);
		map.put("zhuxuejin", zhuxuejin);
		return "zhuxuejin_updtlb2";
	}
	
@RequestMapping("updateZhuxuejinlb.do")
	public String updateZhuxuejinlb(int id,ModelMap map,Zhuxuejin zhuxuejin){
		zhuxuejinService.updatelb(zhuxuejin);
		return "redirect:zhuxuejinList.do";
	}
	
//	后台详细
	@RequestMapping("zhuxuejinDetail.do")
	public String zhuxuejinDetail(int id,ModelMap map,Zhuxuejin zhuxuejin){
		zhuxuejin=zhuxuejinService.getById(id);
		map.put("zhuxuejin", zhuxuejin);
		return "zhuxuejin_detail";
	}
//	前台详细
	@RequestMapping("zxjDetail.do")
	public String zxjDetail(int id,ModelMap map,Zhuxuejin zhuxuejin){
		zhuxuejin=zhuxuejinService.getById(id);
		map.put("zhuxuejin", zhuxuejin);
		return "zhuxuejindetail";
	}
//	
	@RequestMapping("updateZhuxuejin.do")
	public String updateZhuxuejin(int id,ModelMap map,Zhuxuejin zhuxuejin,HttpServletRequest request,HttpSession session){
		zhuxuejinService.update(zhuxuejin);
		session.setAttribute("backxx", "修改成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		return "redirect:postback.jsp";
		//String url = request.getHeader("Referer");
		//return "redirect:"+url;
		//return "redirect:zhuxuejinList.do";
	}

//	分页查询
	@RequestMapping("zhuxuejinList.do")
	public String zhuxuejinList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Zhuxuejin zhuxuejin, String xuehao, String xingming, String xingbie, String kunnanleibie, String shenqingliyou, String xueyuanshenhe, String xuexiaoshenhe, String zhuxuejine){
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
		if(kunnanleibie==null||kunnanleibie.equals("")){pmap.put("kunnanleibie", null);}else{pmap.put("kunnanleibie", kunnanleibie);}
		if(shenqingliyou==null||shenqingliyou.equals("")){pmap.put("shenqingliyou", null);}else{pmap.put("shenqingliyou", shenqingliyou);}
		if(xueyuanshenhe==null||xueyuanshenhe.equals("")){pmap.put("xueyuanshenhe", null);}else{pmap.put("xueyuanshenhe", xueyuanshenhe);}
		if(xuexiaoshenhe==null||xuexiaoshenhe.equals("")){pmap.put("xuexiaoshenhe", null);}else{pmap.put("xuexiaoshenhe", xuexiaoshenhe);}
		if(zhuxuejine==null||zhuxuejine.equals("")){pmap.put("zhuxuejine", null);}else{pmap.put("zhuxuejine", zhuxuejine);}
		
		int total=zhuxuejinService.getCount(pmap);
		pageBean.setTotal(total);
		List<Zhuxuejin> list=zhuxuejinService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "zhuxuejin_list";
	}
	
	@RequestMapping("zhuxuejin_yanben1.do")
	public String zhuxuejin_yanben1(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Zhuxuejin zhuxuejin, String xuehao, String xingming, String xingbie, String kunnanleibie, String shenqingliyou, String xueyuanshenhe, String xuexiaoshenhe, String zhuxuejine){
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
		if(kunnanleibie==null||kunnanleibie.equals("")){pmap.put("kunnanleibie", null);}else{pmap.put("kunnanleibie", kunnanleibie);}
		if(shenqingliyou==null||shenqingliyou.equals("")){pmap.put("shenqingliyou", null);}else{pmap.put("shenqingliyou", shenqingliyou);}
		if(xueyuanshenhe==null||xueyuanshenhe.equals("")){pmap.put("xueyuanshenhe", null);}else{pmap.put("xueyuanshenhe", xueyuanshenhe);}
		if(xuexiaoshenhe==null||xuexiaoshenhe.equals("")){pmap.put("xuexiaoshenhe", null);}else{pmap.put("xuexiaoshenhe", xuexiaoshenhe);}
		if(zhuxuejine==null||zhuxuejine.equals("")){pmap.put("zhuxuejine", null);}else{pmap.put("zhuxuejine", zhuxuejine);}
		
		int total=zhuxuejinService.getCount(pmap);
		pageBean.setTotal(total);
		List<Zhuxuejin> list=zhuxuejinService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "zhuxuejin_yanben1";
	}
	@RequestMapping("zhuxuejin_yanben2.do")
	public String zhuxuejin_yanben2(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Zhuxuejin zhuxuejin, String xuehao, String xingming, String xingbie, String kunnanleibie, String shenqingliyou, String xueyuanshenhe, String xuexiaoshenhe, String zhuxuejine){
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
		if(kunnanleibie==null||kunnanleibie.equals("")){pmap.put("kunnanleibie", null);}else{pmap.put("kunnanleibie", kunnanleibie);}
		if(shenqingliyou==null||shenqingliyou.equals("")){pmap.put("shenqingliyou", null);}else{pmap.put("shenqingliyou", shenqingliyou);}
		if(xueyuanshenhe==null||xueyuanshenhe.equals("")){pmap.put("xueyuanshenhe", null);}else{pmap.put("xueyuanshenhe", xueyuanshenhe);}
		if(xuexiaoshenhe==null||xuexiaoshenhe.equals("")){pmap.put("xuexiaoshenhe", null);}else{pmap.put("xuexiaoshenhe", xuexiaoshenhe);}
		if(zhuxuejine==null||zhuxuejine.equals("")){pmap.put("zhuxuejine", null);}else{pmap.put("zhuxuejine", zhuxuejine);}
		
		int total=zhuxuejinService.getCount(pmap);
		pageBean.setTotal(total);
		List<Zhuxuejin> list=zhuxuejinService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "zhuxuejin_yanben2";
	}
	@RequestMapping("zhuxuejin_yanben3.do")
	public String zhuxuejin_yanben3(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Zhuxuejin zhuxuejin, String xuehao, String xingming, String xingbie, String kunnanleibie, String shenqingliyou, String xueyuanshenhe, String xuexiaoshenhe, String zhuxuejine){
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
		if(kunnanleibie==null||kunnanleibie.equals("")){pmap.put("kunnanleibie", null);}else{pmap.put("kunnanleibie", kunnanleibie);}
		if(shenqingliyou==null||shenqingliyou.equals("")){pmap.put("shenqingliyou", null);}else{pmap.put("shenqingliyou", shenqingliyou);}
		if(xueyuanshenhe==null||xueyuanshenhe.equals("")){pmap.put("xueyuanshenhe", null);}else{pmap.put("xueyuanshenhe", xueyuanshenhe);}
		if(xuexiaoshenhe==null||xuexiaoshenhe.equals("")){pmap.put("xuexiaoshenhe", null);}else{pmap.put("xuexiaoshenhe", xuexiaoshenhe);}
		if(zhuxuejine==null||zhuxuejine.equals("")){pmap.put("zhuxuejine", null);}else{pmap.put("zhuxuejine", zhuxuejine);}
		
		int total=zhuxuejinService.getCount(pmap);
		pageBean.setTotal(total);
		List<Zhuxuejin> list=zhuxuejinService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "zhuxuejin_yanben3";
	}
	@RequestMapping("zhuxuejin_yanben4.do")
	public String zhuxuejin_yanben4(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Zhuxuejin zhuxuejin, String xuehao, String xingming, String xingbie, String kunnanleibie, String shenqingliyou, String xueyuanshenhe, String xuexiaoshenhe, String zhuxuejine){
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
		if(kunnanleibie==null||kunnanleibie.equals("")){pmap.put("kunnanleibie", null);}else{pmap.put("kunnanleibie", kunnanleibie);}
		if(shenqingliyou==null||shenqingliyou.equals("")){pmap.put("shenqingliyou", null);}else{pmap.put("shenqingliyou", shenqingliyou);}
		if(xueyuanshenhe==null||xueyuanshenhe.equals("")){pmap.put("xueyuanshenhe", null);}else{pmap.put("xueyuanshenhe", xueyuanshenhe);}
		if(xuexiaoshenhe==null||xuexiaoshenhe.equals("")){pmap.put("xuexiaoshenhe", null);}else{pmap.put("xuexiaoshenhe", xuexiaoshenhe);}
		if(zhuxuejine==null||zhuxuejine.equals("")){pmap.put("zhuxuejine", null);}else{pmap.put("zhuxuejine", zhuxuejine);}
		
		int total=zhuxuejinService.getCount(pmap);
		pageBean.setTotal(total);
		List<Zhuxuejin> list=zhuxuejinService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "zhuxuejin_yanben4";
	}
	@RequestMapping("zhuxuejin_yanben5.do")
	public String zhuxuejin_yanben5(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Zhuxuejin zhuxuejin, String xuehao, String xingming, String xingbie, String kunnanleibie, String shenqingliyou, String xueyuanshenhe, String xuexiaoshenhe, String zhuxuejine){
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
		if(kunnanleibie==null||kunnanleibie.equals("")){pmap.put("kunnanleibie", null);}else{pmap.put("kunnanleibie", kunnanleibie);}
		if(shenqingliyou==null||shenqingliyou.equals("")){pmap.put("shenqingliyou", null);}else{pmap.put("shenqingliyou", shenqingliyou);}
		if(xueyuanshenhe==null||xueyuanshenhe.equals("")){pmap.put("xueyuanshenhe", null);}else{pmap.put("xueyuanshenhe", xueyuanshenhe);}
		if(xuexiaoshenhe==null||xuexiaoshenhe.equals("")){pmap.put("xuexiaoshenhe", null);}else{pmap.put("xuexiaoshenhe", xuexiaoshenhe);}
		if(zhuxuejine==null||zhuxuejine.equals("")){pmap.put("zhuxuejine", null);}else{pmap.put("zhuxuejine", zhuxuejine);}
		
		int total=zhuxuejinService.getCount(pmap);
		pageBean.setTotal(total);
		List<Zhuxuejin> list=zhuxuejinService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "zhuxuejin_yanben5";
	}
	
	@RequestMapping("zhuxuejinList2.do")
	public String zhuxuejinList2(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Zhuxuejin zhuxuejin, String xuehao, String xingming, String xingbie, String kunnanleibie, String shenqingliyou, String xueyuanshenhe, String xuexiaoshenhe, String zhuxuejine,HttpServletRequest request){
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
		if(kunnanleibie==null||kunnanleibie.equals("")){pmap.put("kunnanleibie", null);}else{pmap.put("kunnanleibie", kunnanleibie);}
		if(shenqingliyou==null||shenqingliyou.equals("")){pmap.put("shenqingliyou", null);}else{pmap.put("shenqingliyou", shenqingliyou);}
		if(xuexiaoshenhe==null||xuexiaoshenhe.equals("")){pmap.put("xuexiaoshenhe", null);}else{pmap.put("xuexiaoshenhe", xuexiaoshenhe);}
		if(zhuxuejine==null||zhuxuejine.equals("")){pmap.put("zhuxuejine", null);}else{pmap.put("zhuxuejine", zhuxuejine);}
		
		
		int total=zhuxuejinService.getCount(pmap);
		pageBean.setTotal(total);
		List<Zhuxuejin> list=zhuxuejinService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "zhuxuejin_list2";
	}
	@RequestMapping("zhuxuejinList3.do")
	public String zhuxuejinList3(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Zhuxuejin zhuxuejin, String xuehao, String xingming, String xingbie, String kunnanleibie, String shenqingliyou, String xueyuanshenhe, String xuexiaoshenhe, String zhuxuejine,HttpServletRequest request){
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
		
		//pmap.put("xueyuanshenhe", (String)request.getSession().getAttribute("username"));
		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}
		if(xingbie==null||xingbie.equals("")){pmap.put("xingbie", null);}else{pmap.put("xingbie", xingbie);}
		if(kunnanleibie==null||kunnanleibie.equals("")){pmap.put("kunnanleibie", null);}else{pmap.put("kunnanleibie", kunnanleibie);}
		if(shenqingliyou==null||shenqingliyou.equals("")){pmap.put("shenqingliyou", null);}else{pmap.put("shenqingliyou", shenqingliyou);}
		if(xuexiaoshenhe==null||xuexiaoshenhe.equals("")){pmap.put("xuexiaoshenhe", null);}else{pmap.put("xuexiaoshenhe", xuexiaoshenhe);}
		if(zhuxuejine==null||zhuxuejine.equals("")){pmap.put("zhuxuejine", null);}else{pmap.put("zhuxuejine", zhuxuejine);}
		
		
		int total=zhuxuejinService.getCount(pmap);
		pageBean.setTotal(total);
		List<Zhuxuejin> list=zhuxuejinService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "zhuxuejin_list3";
	}
	
	
	@RequestMapping("zxjList.do")
	public String zxjList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Zhuxuejin zhuxuejin, String xuehao, String xingming, String xingbie, String kunnanleibie, String shenqingliyou, String xueyuanshenhe, String xuexiaoshenhe, String zhuxuejine){
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
		if(kunnanleibie==null||kunnanleibie.equals("")){pmap.put("kunnanleibie", null);}else{pmap.put("kunnanleibie", kunnanleibie);}
		if(shenqingliyou==null||shenqingliyou.equals("")){pmap.put("shenqingliyou", null);}else{pmap.put("shenqingliyou", shenqingliyou);}
		if(xueyuanshenhe==null||xueyuanshenhe.equals("")){pmap.put("xueyuanshenhe", null);}else{pmap.put("xueyuanshenhe", xueyuanshenhe);}
		if(xuexiaoshenhe==null||xuexiaoshenhe.equals("")){pmap.put("xuexiaoshenhe", null);}else{pmap.put("xuexiaoshenhe", xuexiaoshenhe);}
		if(zhuxuejine==null||zhuxuejine.equals("")){pmap.put("zhuxuejine", null);}else{pmap.put("zhuxuejine", zhuxuejine);}
		
		int total=zhuxuejinService.getCount(pmap);
		pageBean.setTotal(total);
		List<Zhuxuejin> list=zhuxuejinService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "zhuxuejinlist";
	}
	@RequestMapping("zxjListtp.do")
	public String zxjListtp(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Zhuxuejin zhuxuejin, String xuehao, String xingming, String xingbie, String kunnanleibie, String shenqingliyou, String xueyuanshenhe, String xuexiaoshenhe, String zhuxuejine){
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
		if(kunnanleibie==null||kunnanleibie.equals("")){pmap.put("kunnanleibie", null);}else{pmap.put("kunnanleibie", kunnanleibie);}
		if(shenqingliyou==null||shenqingliyou.equals("")){pmap.put("shenqingliyou", null);}else{pmap.put("shenqingliyou", shenqingliyou);}
		if(xueyuanshenhe==null||xueyuanshenhe.equals("")){pmap.put("xueyuanshenhe", null);}else{pmap.put("xueyuanshenhe", xueyuanshenhe);}
		if(xuexiaoshenhe==null||xuexiaoshenhe.equals("")){pmap.put("xuexiaoshenhe", null);}else{pmap.put("xuexiaoshenhe", xuexiaoshenhe);}
		if(zhuxuejine==null||zhuxuejine.equals("")){pmap.put("zhuxuejine", null);}else{pmap.put("zhuxuejine", zhuxuejine);}
		
		int total=zhuxuejinService.getCount(pmap);
		pageBean.setTotal(total);
		List<Zhuxuejin> list=zhuxuejinService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "zhuxuejinlisttp";
	}
	
	@RequestMapping("deleteZhuxuejin.do")
	public String deleteZhuxuejin(int id,HttpServletRequest request){
		zhuxuejinService.delete(id);
		String url = request.getHeader("Referer");
		return "redirect:"+url;
		//return "redirect:zhuxuejinList.do";
	}
	
	
}
