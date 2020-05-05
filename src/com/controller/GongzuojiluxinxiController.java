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

import com.entity.Gongzuojiluxinxi;
import com.server.GongzuojiluxinxiServer;
import com.util.PageBean;
import net.sf.json.JSONObject;
import com.util.db;
import java.sql.SQLException;
import java.sql.*;
@Controller
public class GongzuojiluxinxiController {
	@Resource
	private GongzuojiluxinxiServer gongzuojiluxinxiService;


   
	@RequestMapping("addGongzuojiluxinxi.do")
	public String addGongzuojiluxinxi(HttpServletRequest request,Gongzuojiluxinxi gongzuojiluxinxi,HttpSession session) throws SQLException{
		Timestamp time=new Timestamp(System.currentTimeMillis());
		
		gongzuojiluxinxi.setAddtime(time.toString().substring(0, 19));
		gongzuojiluxinxiService.add(gongzuojiluxinxi);
		
		session.setAttribute("backxx", "添加成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		
		//session.setAttribute("backurl", "gongzuojiluxinxiList.do");
		
		return "redirect:postback.jsp";
		//return "redirect:gongzuojiluxinxiList.do";
		
		
		
	}
 
//	处理编辑
	@RequestMapping("doUpdateGongzuojiluxinxi.do")
	public String doUpdateGongzuojiluxinxi(int id,ModelMap map,Gongzuojiluxinxi gongzuojiluxinxi){
		gongzuojiluxinxi=gongzuojiluxinxiService.getById(id);
		map.put("gongzuojiluxinxi", gongzuojiluxinxi);
		return "gongzuojiluxinxi_updt";
	}
	
	
	
	
	
//	后台详细
	@RequestMapping("gongzuojiluxinxiDetail.do")
	public String gongzuojiluxinxiDetail(int id,ModelMap map,Gongzuojiluxinxi gongzuojiluxinxi){
		gongzuojiluxinxi=gongzuojiluxinxiService.getById(id);
		map.put("gongzuojiluxinxi", gongzuojiluxinxi);
		return "gongzuojiluxinxi_detail";
	}
//	前台详细
	@RequestMapping("gzjlxxDetail.do")
	public String gzjlxxDetail(int id,ModelMap map,Gongzuojiluxinxi gongzuojiluxinxi){
		gongzuojiluxinxi=gongzuojiluxinxiService.getById(id);
		map.put("gongzuojiluxinxi", gongzuojiluxinxi);
		return "gongzuojiluxinxidetail";
	}
//	
	@RequestMapping("updateGongzuojiluxinxi.do")
	public String updateGongzuojiluxinxi(int id,ModelMap map,Gongzuojiluxinxi gongzuojiluxinxi,HttpServletRequest request,HttpSession session){
		gongzuojiluxinxiService.update(gongzuojiluxinxi);
		session.setAttribute("backxx", "修改成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		return "redirect:postback.jsp";
		//String url = request.getHeader("Referer");
		//return "redirect:"+url;
		//return "redirect:gongzuojiluxinxiList.do";
	}

//	分页查询
	@RequestMapping("gongzuojiluxinxiList.do")
	public String gongzuojiluxinxiList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Gongzuojiluxinxi gongzuojiluxinxi, String bumenzhanghao, String bumenmingcheng, String gangwei, String xuehao, String xingming, String xingbie, String gongzuojilu, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(bumenzhanghao==null||bumenzhanghao.equals("")){pmap.put("bumenzhanghao", null);}else{pmap.put("bumenzhanghao", bumenzhanghao);}		if(bumenmingcheng==null||bumenmingcheng.equals("")){pmap.put("bumenmingcheng", null);}else{pmap.put("bumenmingcheng", bumenmingcheng);}		if(gangwei==null||gangwei.equals("")){pmap.put("gangwei", null);}else{pmap.put("gangwei", gangwei);}		if(xuehao==null||xuehao.equals("")){pmap.put("xuehao", null);}else{pmap.put("xuehao", xuehao);}		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}		if(xingbie==null||xingbie.equals("")){pmap.put("xingbie", null);}else{pmap.put("xingbie", xingbie);}		if(gongzuojilu==null||gongzuojilu.equals("")){pmap.put("gongzuojilu", null);}else{pmap.put("gongzuojilu", gongzuojilu);}		
		int total=gongzuojiluxinxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Gongzuojiluxinxi> list=gongzuojiluxinxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "gongzuojiluxinxi_list";
	}
	
	@RequestMapping("gongzuojiluxinxi_yanben1.do")
	public String gongzuojiluxinxi_yanben1(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Gongzuojiluxinxi gongzuojiluxinxi, String bumenzhanghao, String bumenmingcheng, String gangwei, String xuehao, String xingming, String xingbie, String gongzuojilu, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(bumenzhanghao==null||bumenzhanghao.equals("")){pmap.put("bumenzhanghao", null);}else{pmap.put("bumenzhanghao", bumenzhanghao);}		if(bumenmingcheng==null||bumenmingcheng.equals("")){pmap.put("bumenmingcheng", null);}else{pmap.put("bumenmingcheng", bumenmingcheng);}		if(gangwei==null||gangwei.equals("")){pmap.put("gangwei", null);}else{pmap.put("gangwei", gangwei);}		if(xuehao==null||xuehao.equals("")){pmap.put("xuehao", null);}else{pmap.put("xuehao", xuehao);}		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}		if(xingbie==null||xingbie.equals("")){pmap.put("xingbie", null);}else{pmap.put("xingbie", xingbie);}		if(gongzuojilu==null||gongzuojilu.equals("")){pmap.put("gongzuojilu", null);}else{pmap.put("gongzuojilu", gongzuojilu);}		
		int total=gongzuojiluxinxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Gongzuojiluxinxi> list=gongzuojiluxinxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "gongzuojiluxinxi_yanben1";
	}
	@RequestMapping("gongzuojiluxinxi_yanben2.do")
	public String gongzuojiluxinxi_yanben2(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Gongzuojiluxinxi gongzuojiluxinxi, String bumenzhanghao, String bumenmingcheng, String gangwei, String xuehao, String xingming, String xingbie, String gongzuojilu, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(bumenzhanghao==null||bumenzhanghao.equals("")){pmap.put("bumenzhanghao", null);}else{pmap.put("bumenzhanghao", bumenzhanghao);}		if(bumenmingcheng==null||bumenmingcheng.equals("")){pmap.put("bumenmingcheng", null);}else{pmap.put("bumenmingcheng", bumenmingcheng);}		if(gangwei==null||gangwei.equals("")){pmap.put("gangwei", null);}else{pmap.put("gangwei", gangwei);}		if(xuehao==null||xuehao.equals("")){pmap.put("xuehao", null);}else{pmap.put("xuehao", xuehao);}		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}		if(xingbie==null||xingbie.equals("")){pmap.put("xingbie", null);}else{pmap.put("xingbie", xingbie);}		if(gongzuojilu==null||gongzuojilu.equals("")){pmap.put("gongzuojilu", null);}else{pmap.put("gongzuojilu", gongzuojilu);}		
		int total=gongzuojiluxinxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Gongzuojiluxinxi> list=gongzuojiluxinxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "gongzuojiluxinxi_yanben2";
	}
	@RequestMapping("gongzuojiluxinxi_yanben3.do")
	public String gongzuojiluxinxi_yanben3(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Gongzuojiluxinxi gongzuojiluxinxi, String bumenzhanghao, String bumenmingcheng, String gangwei, String xuehao, String xingming, String xingbie, String gongzuojilu, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(bumenzhanghao==null||bumenzhanghao.equals("")){pmap.put("bumenzhanghao", null);}else{pmap.put("bumenzhanghao", bumenzhanghao);}		if(bumenmingcheng==null||bumenmingcheng.equals("")){pmap.put("bumenmingcheng", null);}else{pmap.put("bumenmingcheng", bumenmingcheng);}		if(gangwei==null||gangwei.equals("")){pmap.put("gangwei", null);}else{pmap.put("gangwei", gangwei);}		if(xuehao==null||xuehao.equals("")){pmap.put("xuehao", null);}else{pmap.put("xuehao", xuehao);}		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}		if(xingbie==null||xingbie.equals("")){pmap.put("xingbie", null);}else{pmap.put("xingbie", xingbie);}		if(gongzuojilu==null||gongzuojilu.equals("")){pmap.put("gongzuojilu", null);}else{pmap.put("gongzuojilu", gongzuojilu);}		
		int total=gongzuojiluxinxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Gongzuojiluxinxi> list=gongzuojiluxinxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "gongzuojiluxinxi_yanben3";
	}
	@RequestMapping("gongzuojiluxinxi_yanben4.do")
	public String gongzuojiluxinxi_yanben4(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Gongzuojiluxinxi gongzuojiluxinxi, String bumenzhanghao, String bumenmingcheng, String gangwei, String xuehao, String xingming, String xingbie, String gongzuojilu, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(bumenzhanghao==null||bumenzhanghao.equals("")){pmap.put("bumenzhanghao", null);}else{pmap.put("bumenzhanghao", bumenzhanghao);}		if(bumenmingcheng==null||bumenmingcheng.equals("")){pmap.put("bumenmingcheng", null);}else{pmap.put("bumenmingcheng", bumenmingcheng);}		if(gangwei==null||gangwei.equals("")){pmap.put("gangwei", null);}else{pmap.put("gangwei", gangwei);}		if(xuehao==null||xuehao.equals("")){pmap.put("xuehao", null);}else{pmap.put("xuehao", xuehao);}		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}		if(xingbie==null||xingbie.equals("")){pmap.put("xingbie", null);}else{pmap.put("xingbie", xingbie);}		if(gongzuojilu==null||gongzuojilu.equals("")){pmap.put("gongzuojilu", null);}else{pmap.put("gongzuojilu", gongzuojilu);}		
		int total=gongzuojiluxinxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Gongzuojiluxinxi> list=gongzuojiluxinxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "gongzuojiluxinxi_yanben4";
	}
	@RequestMapping("gongzuojiluxinxi_yanben5.do")
	public String gongzuojiluxinxi_yanben5(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Gongzuojiluxinxi gongzuojiluxinxi, String bumenzhanghao, String bumenmingcheng, String gangwei, String xuehao, String xingming, String xingbie, String gongzuojilu, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(bumenzhanghao==null||bumenzhanghao.equals("")){pmap.put("bumenzhanghao", null);}else{pmap.put("bumenzhanghao", bumenzhanghao);}		if(bumenmingcheng==null||bumenmingcheng.equals("")){pmap.put("bumenmingcheng", null);}else{pmap.put("bumenmingcheng", bumenmingcheng);}		if(gangwei==null||gangwei.equals("")){pmap.put("gangwei", null);}else{pmap.put("gangwei", gangwei);}		if(xuehao==null||xuehao.equals("")){pmap.put("xuehao", null);}else{pmap.put("xuehao", xuehao);}		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}		if(xingbie==null||xingbie.equals("")){pmap.put("xingbie", null);}else{pmap.put("xingbie", xingbie);}		if(gongzuojilu==null||gongzuojilu.equals("")){pmap.put("gongzuojilu", null);}else{pmap.put("gongzuojilu", gongzuojilu);}		
		int total=gongzuojiluxinxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Gongzuojiluxinxi> list=gongzuojiluxinxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "gongzuojiluxinxi_yanben5";
	}
	
	@RequestMapping("gongzuojiluxinxiList3.do")
	public String gongzuojiluxinxiList3(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Gongzuojiluxinxi gongzuojiluxinxi, String bumenzhanghao, String bumenmingcheng, String gangwei, String xuehao, String xingming, String xingbie, String gongzuojilu, String issh,HttpServletRequest request){
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
		
		pmap.put("bumenzhanghao", (String)request.getSession().getAttribute("username"));
		if(bumenmingcheng==null||bumenmingcheng.equals("")){pmap.put("bumenmingcheng", null);}else{pmap.put("bumenmingcheng", bumenmingcheng);}		if(gangwei==null||gangwei.equals("")){pmap.put("gangwei", null);}else{pmap.put("gangwei", gangwei);}		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}		if(xingbie==null||xingbie.equals("")){pmap.put("xingbie", null);}else{pmap.put("xingbie", xingbie);}		if(gongzuojilu==null||gongzuojilu.equals("")){pmap.put("gongzuojilu", null);}else{pmap.put("gongzuojilu", gongzuojilu);}		
		
		int total=gongzuojiluxinxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Gongzuojiluxinxi> list=gongzuojiluxinxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "gongzuojiluxinxi_list3";
	}	@RequestMapping("gongzuojiluxinxiList2.do")
	public String gongzuojiluxinxiList2(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Gongzuojiluxinxi gongzuojiluxinxi, String bumenzhanghao, String bumenmingcheng, String gangwei, String xuehao, String xingming, String xingbie, String gongzuojilu, String issh,HttpServletRequest request){
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
		if(bumenmingcheng==null||bumenmingcheng.equals("")){pmap.put("bumenmingcheng", null);}else{pmap.put("bumenmingcheng", bumenmingcheng);}		if(gangwei==null||gangwei.equals("")){pmap.put("gangwei", null);}else{pmap.put("gangwei", gangwei);}		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}		if(xingbie==null||xingbie.equals("")){pmap.put("xingbie", null);}else{pmap.put("xingbie", xingbie);}		if(gongzuojilu==null||gongzuojilu.equals("")){pmap.put("gongzuojilu", null);}else{pmap.put("gongzuojilu", gongzuojilu);}		
		
		int total=gongzuojiluxinxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Gongzuojiluxinxi> list=gongzuojiluxinxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "gongzuojiluxinxi_list2";
	}	
	
	@RequestMapping("gzjlxxList.do")
	public String gzjlxxList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Gongzuojiluxinxi gongzuojiluxinxi, String bumenzhanghao, String bumenmingcheng, String gangwei, String xuehao, String xingming, String xingbie, String gongzuojilu, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(bumenzhanghao==null||bumenzhanghao.equals("")){pmap.put("bumenzhanghao", null);}else{pmap.put("bumenzhanghao", bumenzhanghao);}		if(bumenmingcheng==null||bumenmingcheng.equals("")){pmap.put("bumenmingcheng", null);}else{pmap.put("bumenmingcheng", bumenmingcheng);}		if(gangwei==null||gangwei.equals("")){pmap.put("gangwei", null);}else{pmap.put("gangwei", gangwei);}		if(xuehao==null||xuehao.equals("")){pmap.put("xuehao", null);}else{pmap.put("xuehao", xuehao);}		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}		if(xingbie==null||xingbie.equals("")){pmap.put("xingbie", null);}else{pmap.put("xingbie", xingbie);}		if(gongzuojilu==null||gongzuojilu.equals("")){pmap.put("gongzuojilu", null);}else{pmap.put("gongzuojilu", gongzuojilu);}		
		int total=gongzuojiluxinxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Gongzuojiluxinxi> list=gongzuojiluxinxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "gongzuojiluxinxilist";
	}
	@RequestMapping("gzjlxxListtp.do")
	public String gzjlxxListtp(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Gongzuojiluxinxi gongzuojiluxinxi, String bumenzhanghao, String bumenmingcheng, String gangwei, String xuehao, String xingming, String xingbie, String gongzuojilu, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(bumenzhanghao==null||bumenzhanghao.equals("")){pmap.put("bumenzhanghao", null);}else{pmap.put("bumenzhanghao", bumenzhanghao);}		if(bumenmingcheng==null||bumenmingcheng.equals("")){pmap.put("bumenmingcheng", null);}else{pmap.put("bumenmingcheng", bumenmingcheng);}		if(gangwei==null||gangwei.equals("")){pmap.put("gangwei", null);}else{pmap.put("gangwei", gangwei);}		if(xuehao==null||xuehao.equals("")){pmap.put("xuehao", null);}else{pmap.put("xuehao", xuehao);}		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}		if(xingbie==null||xingbie.equals("")){pmap.put("xingbie", null);}else{pmap.put("xingbie", xingbie);}		if(gongzuojilu==null||gongzuojilu.equals("")){pmap.put("gongzuojilu", null);}else{pmap.put("gongzuojilu", gongzuojilu);}		
		int total=gongzuojiluxinxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Gongzuojiluxinxi> list=gongzuojiluxinxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "gongzuojiluxinxilisttp";
	}
	
	@RequestMapping("deleteGongzuojiluxinxi.do")
	public String deleteGongzuojiluxinxi(int id,HttpServletRequest request){
		gongzuojiluxinxiService.delete(id);
		String url = request.getHeader("Referer");
		return "redirect:"+url;
		//return "redirect:gongzuojiluxinxiList.do";
	}
	
	
}
