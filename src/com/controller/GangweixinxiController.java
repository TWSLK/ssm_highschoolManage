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

import com.entity.Gangweixinxi;
import com.server.GangweixinxiServer;
import com.util.PageBean;
import net.sf.json.JSONObject;
import com.util.db;
import java.sql.SQLException;
import java.sql.*;
@Controller
public class GangweixinxiController {
	@Resource
	private GangweixinxiServer gangweixinxiService;


   
	@RequestMapping("addGangweixinxi.do")
	public String addGangweixinxi(HttpServletRequest request,Gangweixinxi gangweixinxi,HttpSession session) throws SQLException{
		Timestamp time=new Timestamp(System.currentTimeMillis());
		
		gangweixinxi.setAddtime(time.toString().substring(0, 19));
		gangweixinxiService.add(gangweixinxi);
		
		session.setAttribute("backxx", "添加成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		
		//session.setAttribute("backurl", "gangweixinxiList.do");
		
		return "redirect:postback.jsp";
		//return "redirect:gangweixinxiList.do";
		
		
		
	}
 
//	处理编辑
	@RequestMapping("doUpdateGangweixinxi.do")
	public String doUpdateGangweixinxi(int id,ModelMap map,Gangweixinxi gangweixinxi){
		gangweixinxi=gangweixinxiService.getById(id);
		map.put("gangweixinxi", gangweixinxi);
		return "gangweixinxi_updt";
	}
	
	
	
	@RequestMapping("doUpdateGangweixinxilb.do")
	public String doUpdateGangweixinxilb(int id,ModelMap map,Gangweixinxi gangweixinxi){
		gangweixinxi=gangweixinxiService.getById(id);
		map.put("gangweixinxi", gangweixinxi);
		return "gangweixinxi_updtlb";
	}
	
@RequestMapping("updateGangweixinxilb.do")
	public String updateGangweixinxilb(int id,ModelMap map,Gangweixinxi gangweixinxi){
		gangweixinxiService.updatelb(gangweixinxi);
		return "redirect:gangweixinxiList.do";
	}
	
//	后台详细
	@RequestMapping("gangweixinxiDetail.do")
	public String gangweixinxiDetail(int id,ModelMap map,Gangweixinxi gangweixinxi){
		gangweixinxi=gangweixinxiService.getById(id);
		map.put("gangweixinxi", gangweixinxi);
		return "gangweixinxi_detail";
	}
//	前台详细
	@RequestMapping("gwxxDetail.do")
	public String gwxxDetail(int id,ModelMap map,Gangweixinxi gangweixinxi){
		gangweixinxi=gangweixinxiService.getById(id);
		map.put("gangweixinxi", gangweixinxi);
		return "gangweixinxidetail";
	}
//	
	@RequestMapping("updateGangweixinxi.do")
	public String updateGangweixinxi(int id,ModelMap map,Gangweixinxi gangweixinxi,HttpServletRequest request,HttpSession session){
		gangweixinxiService.update(gangweixinxi);
		session.setAttribute("backxx", "修改成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		return "redirect:postback.jsp";
		//String url = request.getHeader("Referer");
		//return "redirect:"+url;
		//return "redirect:gangweixinxiList.do";
	}

//	分页查询
	@RequestMapping("gangweixinxiList.do")
	public String gangweixinxiList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Gangweixinxi gangweixinxi, String bumenzhanghao, String bumenmingcheng, String lianxidianhua, String dizhi, String gangwei, String xiangxi, String xueyuanshenhe, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(bumenzhanghao==null||bumenzhanghao.equals("")){pmap.put("bumenzhanghao", null);}else{pmap.put("bumenzhanghao", bumenzhanghao);}
		if(bumenmingcheng==null||bumenmingcheng.equals("")){pmap.put("bumenmingcheng", null);}else{pmap.put("bumenmingcheng", bumenmingcheng);}
		if(lianxidianhua==null||lianxidianhua.equals("")){pmap.put("lianxidianhua", null);}else{pmap.put("lianxidianhua", lianxidianhua);}
		if(dizhi==null||dizhi.equals("")){pmap.put("dizhi", null);}else{pmap.put("dizhi", dizhi);}
		if(gangwei==null||gangwei.equals("")){pmap.put("gangwei", null);}else{pmap.put("gangwei", gangwei);}
		if(xiangxi==null||xiangxi.equals("")){pmap.put("xiangxi", null);}else{pmap.put("xiangxi", xiangxi);}
		if(xueyuanshenhe==null||xueyuanshenhe.equals("")){pmap.put("xueyuanshenhe", null);}else{pmap.put("xueyuanshenhe", xueyuanshenhe);}
		
		int total=gangweixinxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Gangweixinxi> list=gangweixinxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "gangweixinxi_list";
	}
	
	@RequestMapping("gangweixinxi_yanben1.do")
	public String gangweixinxi_yanben1(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Gangweixinxi gangweixinxi, String bumenzhanghao, String bumenmingcheng, String lianxidianhua, String dizhi, String gangwei, String xiangxi, String xueyuanshenhe, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		pmap.put("issh", '是');
		
		
		if(bumenzhanghao==null||bumenzhanghao.equals("")){pmap.put("bumenzhanghao", null);}else{pmap.put("bumenzhanghao", bumenzhanghao);}
		if(bumenmingcheng==null||bumenmingcheng.equals("")){pmap.put("bumenmingcheng", null);}else{pmap.put("bumenmingcheng", bumenmingcheng);}
		if(lianxidianhua==null||lianxidianhua.equals("")){pmap.put("lianxidianhua", null);}else{pmap.put("lianxidianhua", lianxidianhua);}
		if(dizhi==null||dizhi.equals("")){pmap.put("dizhi", null);}else{pmap.put("dizhi", dizhi);}
		if(gangwei==null||gangwei.equals("")){pmap.put("gangwei", null);}else{pmap.put("gangwei", gangwei);}
		if(xiangxi==null||xiangxi.equals("")){pmap.put("xiangxi", null);}else{pmap.put("xiangxi", xiangxi);}
		if(xueyuanshenhe==null||xueyuanshenhe.equals("")){pmap.put("xueyuanshenhe", null);}else{pmap.put("xueyuanshenhe", xueyuanshenhe);}
		
		int total=gangweixinxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Gangweixinxi> list=gangweixinxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "gangweixinxi_yanben1";
	}
	@RequestMapping("gangweixinxi_yanben2.do")
	public String gangweixinxi_yanben2(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Gangweixinxi gangweixinxi, String bumenzhanghao, String bumenmingcheng, String lianxidianhua, String dizhi, String gangwei, String xiangxi, String xueyuanshenhe, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(bumenzhanghao==null||bumenzhanghao.equals("")){pmap.put("bumenzhanghao", null);}else{pmap.put("bumenzhanghao", bumenzhanghao);}
		if(bumenmingcheng==null||bumenmingcheng.equals("")){pmap.put("bumenmingcheng", null);}else{pmap.put("bumenmingcheng", bumenmingcheng);}
		if(lianxidianhua==null||lianxidianhua.equals("")){pmap.put("lianxidianhua", null);}else{pmap.put("lianxidianhua", lianxidianhua);}
		if(dizhi==null||dizhi.equals("")){pmap.put("dizhi", null);}else{pmap.put("dizhi", dizhi);}
		if(gangwei==null||gangwei.equals("")){pmap.put("gangwei", null);}else{pmap.put("gangwei", gangwei);}
		if(xiangxi==null||xiangxi.equals("")){pmap.put("xiangxi", null);}else{pmap.put("xiangxi", xiangxi);}
		if(xueyuanshenhe==null||xueyuanshenhe.equals("")){pmap.put("xueyuanshenhe", null);}else{pmap.put("xueyuanshenhe", xueyuanshenhe);}
		
		int total=gangweixinxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Gangweixinxi> list=gangweixinxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "gangweixinxi_yanben2";
	}
	@RequestMapping("gangweixinxi_yanben3.do")
	public String gangweixinxi_yanben3(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Gangweixinxi gangweixinxi, String bumenzhanghao, String bumenmingcheng, String lianxidianhua, String dizhi, String gangwei, String xiangxi, String xueyuanshenhe, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(bumenzhanghao==null||bumenzhanghao.equals("")){pmap.put("bumenzhanghao", null);}else{pmap.put("bumenzhanghao", bumenzhanghao);}
		if(bumenmingcheng==null||bumenmingcheng.equals("")){pmap.put("bumenmingcheng", null);}else{pmap.put("bumenmingcheng", bumenmingcheng);}
		if(lianxidianhua==null||lianxidianhua.equals("")){pmap.put("lianxidianhua", null);}else{pmap.put("lianxidianhua", lianxidianhua);}
		if(dizhi==null||dizhi.equals("")){pmap.put("dizhi", null);}else{pmap.put("dizhi", dizhi);}
		if(gangwei==null||gangwei.equals("")){pmap.put("gangwei", null);}else{pmap.put("gangwei", gangwei);}
		if(xiangxi==null||xiangxi.equals("")){pmap.put("xiangxi", null);}else{pmap.put("xiangxi", xiangxi);}
		if(xueyuanshenhe==null||xueyuanshenhe.equals("")){pmap.put("xueyuanshenhe", null);}else{pmap.put("xueyuanshenhe", xueyuanshenhe);}
		
		int total=gangweixinxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Gangweixinxi> list=gangweixinxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "gangweixinxi_yanben3";
	}
	@RequestMapping("gangweixinxi_yanben4.do")
	public String gangweixinxi_yanben4(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Gangweixinxi gangweixinxi, String bumenzhanghao, String bumenmingcheng, String lianxidianhua, String dizhi, String gangwei, String xiangxi, String xueyuanshenhe, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(bumenzhanghao==null||bumenzhanghao.equals("")){pmap.put("bumenzhanghao", null);}else{pmap.put("bumenzhanghao", bumenzhanghao);}
		if(bumenmingcheng==null||bumenmingcheng.equals("")){pmap.put("bumenmingcheng", null);}else{pmap.put("bumenmingcheng", bumenmingcheng);}
		if(lianxidianhua==null||lianxidianhua.equals("")){pmap.put("lianxidianhua", null);}else{pmap.put("lianxidianhua", lianxidianhua);}
		if(dizhi==null||dizhi.equals("")){pmap.put("dizhi", null);}else{pmap.put("dizhi", dizhi);}
		if(gangwei==null||gangwei.equals("")){pmap.put("gangwei", null);}else{pmap.put("gangwei", gangwei);}
		if(xiangxi==null||xiangxi.equals("")){pmap.put("xiangxi", null);}else{pmap.put("xiangxi", xiangxi);}
		if(xueyuanshenhe==null||xueyuanshenhe.equals("")){pmap.put("xueyuanshenhe", null);}else{pmap.put("xueyuanshenhe", xueyuanshenhe);}
		
		int total=gangweixinxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Gangweixinxi> list=gangweixinxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "gangweixinxi_yanben4";
	}
	@RequestMapping("gangweixinxi_yanben5.do")
	public String gangweixinxi_yanben5(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Gangweixinxi gangweixinxi, String bumenzhanghao, String bumenmingcheng, String lianxidianhua, String dizhi, String gangwei, String xiangxi, String xueyuanshenhe, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(bumenzhanghao==null||bumenzhanghao.equals("")){pmap.put("bumenzhanghao", null);}else{pmap.put("bumenzhanghao", bumenzhanghao);}
		if(bumenmingcheng==null||bumenmingcheng.equals("")){pmap.put("bumenmingcheng", null);}else{pmap.put("bumenmingcheng", bumenmingcheng);}
		if(lianxidianhua==null||lianxidianhua.equals("")){pmap.put("lianxidianhua", null);}else{pmap.put("lianxidianhua", lianxidianhua);}
		if(dizhi==null||dizhi.equals("")){pmap.put("dizhi", null);}else{pmap.put("dizhi", dizhi);}
		if(gangwei==null||gangwei.equals("")){pmap.put("gangwei", null);}else{pmap.put("gangwei", gangwei);}
		if(xiangxi==null||xiangxi.equals("")){pmap.put("xiangxi", null);}else{pmap.put("xiangxi", xiangxi);}
		if(xueyuanshenhe==null||xueyuanshenhe.equals("")){pmap.put("xueyuanshenhe", null);}else{pmap.put("xueyuanshenhe", xueyuanshenhe);}
		
		int total=gangweixinxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Gangweixinxi> list=gangweixinxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "gangweixinxi_yanben5";
	}
	
	@RequestMapping("gangweixinxiList2.do")
	public String gangweixinxiList2(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Gangweixinxi gangweixinxi, String bumenzhanghao, String bumenmingcheng, String lianxidianhua, String dizhi, String gangwei, String xiangxi, String xueyuanshenhe, String issh,HttpServletRequest request){
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
		if(bumenmingcheng==null||bumenmingcheng.equals("")){pmap.put("bumenmingcheng", null);}else{pmap.put("bumenmingcheng", bumenmingcheng);}
		if(lianxidianhua==null||lianxidianhua.equals("")){pmap.put("lianxidianhua", null);}else{pmap.put("lianxidianhua", lianxidianhua);}
		if(dizhi==null||dizhi.equals("")){pmap.put("dizhi", null);}else{pmap.put("dizhi", dizhi);}
		if(gangwei==null||gangwei.equals("")){pmap.put("gangwei", null);}else{pmap.put("gangwei", gangwei);}
		if(xiangxi==null||xiangxi.equals("")){pmap.put("xiangxi", null);}else{pmap.put("xiangxi", xiangxi);}
		
		
		int total=gangweixinxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Gangweixinxi> list=gangweixinxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "gangweixinxi_list2";
	}
	@RequestMapping("gangweixinxiList3.do")
	public String gangweixinxiList3(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Gangweixinxi gangweixinxi, String bumenzhanghao, String bumenmingcheng, String lianxidianhua, String dizhi, String gangwei, String xiangxi, String xueyuanshenhe, String issh,HttpServletRequest request){
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
		if(bumenmingcheng==null||bumenmingcheng.equals("")){pmap.put("bumenmingcheng", null);}else{pmap.put("bumenmingcheng", bumenmingcheng);}
		if(lianxidianhua==null||lianxidianhua.equals("")){pmap.put("lianxidianhua", null);}else{pmap.put("lianxidianhua", lianxidianhua);}
		if(dizhi==null||dizhi.equals("")){pmap.put("dizhi", null);}else{pmap.put("dizhi", dizhi);}
		if(gangwei==null||gangwei.equals("")){pmap.put("gangwei", null);}else{pmap.put("gangwei", gangwei);}
		if(xiangxi==null||xiangxi.equals("")){pmap.put("xiangxi", null);}else{pmap.put("xiangxi", xiangxi);}
		
		
		int total=gangweixinxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Gangweixinxi> list=gangweixinxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "gangweixinxi_list3";
	}
	
	
	@RequestMapping("gwxxList.do")
	public String gwxxList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Gangweixinxi gangweixinxi, String bumenzhanghao, String bumenmingcheng, String lianxidianhua, String dizhi, String gangwei, String xiangxi, String xueyuanshenhe, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(bumenzhanghao==null||bumenzhanghao.equals("")){pmap.put("bumenzhanghao", null);}else{pmap.put("bumenzhanghao", bumenzhanghao);}
		if(bumenmingcheng==null||bumenmingcheng.equals("")){pmap.put("bumenmingcheng", null);}else{pmap.put("bumenmingcheng", bumenmingcheng);}
		if(lianxidianhua==null||lianxidianhua.equals("")){pmap.put("lianxidianhua", null);}else{pmap.put("lianxidianhua", lianxidianhua);}
		if(dizhi==null||dizhi.equals("")){pmap.put("dizhi", null);}else{pmap.put("dizhi", dizhi);}
		if(gangwei==null||gangwei.equals("")){pmap.put("gangwei", null);}else{pmap.put("gangwei", gangwei);}
		if(xiangxi==null||xiangxi.equals("")){pmap.put("xiangxi", null);}else{pmap.put("xiangxi", xiangxi);}
		if(xueyuanshenhe==null||xueyuanshenhe.equals("")){pmap.put("xueyuanshenhe", null);}else{pmap.put("xueyuanshenhe", xueyuanshenhe);}
		
		int total=gangweixinxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Gangweixinxi> list=gangweixinxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "gangweixinxilist";
	}
	@RequestMapping("gwxxListtp.do")
	public String gwxxListtp(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Gangweixinxi gangweixinxi, String bumenzhanghao, String bumenmingcheng, String lianxidianhua, String dizhi, String gangwei, String xiangxi, String xueyuanshenhe, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(bumenzhanghao==null||bumenzhanghao.equals("")){pmap.put("bumenzhanghao", null);}else{pmap.put("bumenzhanghao", bumenzhanghao);}
		if(bumenmingcheng==null||bumenmingcheng.equals("")){pmap.put("bumenmingcheng", null);}else{pmap.put("bumenmingcheng", bumenmingcheng);}
		if(lianxidianhua==null||lianxidianhua.equals("")){pmap.put("lianxidianhua", null);}else{pmap.put("lianxidianhua", lianxidianhua);}
		if(dizhi==null||dizhi.equals("")){pmap.put("dizhi", null);}else{pmap.put("dizhi", dizhi);}
		if(gangwei==null||gangwei.equals("")){pmap.put("gangwei", null);}else{pmap.put("gangwei", gangwei);}
		if(xiangxi==null||xiangxi.equals("")){pmap.put("xiangxi", null);}else{pmap.put("xiangxi", xiangxi);}
		if(xueyuanshenhe==null||xueyuanshenhe.equals("")){pmap.put("xueyuanshenhe", null);}else{pmap.put("xueyuanshenhe", xueyuanshenhe);}
		
		int total=gangweixinxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Gangweixinxi> list=gangweixinxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "gangweixinxilisttp";
	}
	
	@RequestMapping("deleteGangweixinxi.do")
	public String deleteGangweixinxi(int id,HttpServletRequest request){
		gangweixinxiService.delete(id);
		String url = request.getHeader("Referer");
		return "redirect:"+url;
		//return "redirect:gangweixinxiList.do";
	}
	
	
}
