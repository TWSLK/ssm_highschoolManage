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

import com.entity.Qingongzhuxue;
import com.server.QingongzhuxueServer;
import com.util.PageBean;
import net.sf.json.JSONObject;
import com.util.db;
import java.sql.SQLException;
import java.sql.*;
@Controller
public class QingongzhuxueController {
	@Resource
	private QingongzhuxueServer qingongzhuxueService;


   
	@RequestMapping("addQingongzhuxue.do")
	public String addQingongzhuxue(HttpServletRequest request,Qingongzhuxue qingongzhuxue,HttpSession session) throws SQLException{
		Timestamp time=new Timestamp(System.currentTimeMillis());
		
		qingongzhuxue.setAddtime(time.toString().substring(0, 19));
		qingongzhuxueService.add(qingongzhuxue);
		
		session.setAttribute("backxx", "添加成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		
		//session.setAttribute("backurl", "qingongzhuxueList.do");
		
		return "redirect:postback.jsp";
		//return "redirect:qingongzhuxueList.do";
		
		
		
	}
 
//	处理编辑
	@RequestMapping("doUpdateQingongzhuxue.do")
	public String doUpdateQingongzhuxue(int id,ModelMap map,Qingongzhuxue qingongzhuxue){
		qingongzhuxue=qingongzhuxueService.getById(id);
		map.put("qingongzhuxue", qingongzhuxue);
		return "qingongzhuxue_updt";
	}
	
	
	
	@RequestMapping("doUpdateQingongzhuxuelb.do")
	public String doUpdateQingongzhuxuelb(int id,ModelMap map,Qingongzhuxue qingongzhuxue){
		qingongzhuxue=qingongzhuxueService.getById(id);
		map.put("qingongzhuxue", qingongzhuxue);
		return "qingongzhuxue_updtlb";
	}
	
@RequestMapping("updateQingongzhuxuelb.do")
	public String updateQingongzhuxuelb(int id,ModelMap map,Qingongzhuxue qingongzhuxue){
		qingongzhuxueService.updatelb(qingongzhuxue);
		return "redirect:qingongzhuxueList.do";
	}
	
//	后台详细
	@RequestMapping("qingongzhuxueDetail.do")
	public String qingongzhuxueDetail(int id,ModelMap map,Qingongzhuxue qingongzhuxue){
		qingongzhuxue=qingongzhuxueService.getById(id);
		map.put("qingongzhuxue", qingongzhuxue);
		return "qingongzhuxue_detail";
	}
//	前台详细
	@RequestMapping("qgzxDetail.do")
	public String qgzxDetail(int id,ModelMap map,Qingongzhuxue qingongzhuxue){
		qingongzhuxue=qingongzhuxueService.getById(id);
		map.put("qingongzhuxue", qingongzhuxue);
		return "qingongzhuxuedetail";
	}
//	
	@RequestMapping("updateQingongzhuxue.do")
	public String updateQingongzhuxue(int id,ModelMap map,Qingongzhuxue qingongzhuxue,HttpServletRequest request,HttpSession session){
		qingongzhuxueService.update(qingongzhuxue);
		session.setAttribute("backxx", "修改成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		return "redirect:postback.jsp";
		//String url = request.getHeader("Referer");
		//return "redirect:"+url;
		//return "redirect:qingongzhuxueList.do";
	}

//	分页查询
	@RequestMapping("qingongzhuxueList.do")
	public String qingongzhuxueList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Qingongzhuxue qingongzhuxue, String bumenzhanghao, String bumenmingcheng, String lianxidianhua, String dizhi, String gangwei, String xuehao, String xingming, String xingbie, String banji, String jiaoshishenhe, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		pmap.put("jiaoshishenhe", '是');
		
		
		if(bumenzhanghao==null||bumenzhanghao.equals("")){pmap.put("bumenzhanghao", null);}else{pmap.put("bumenzhanghao", bumenzhanghao);}
		if(bumenmingcheng==null||bumenmingcheng.equals("")){pmap.put("bumenmingcheng", null);}else{pmap.put("bumenmingcheng", bumenmingcheng);}
		if(lianxidianhua==null||lianxidianhua.equals("")){pmap.put("lianxidianhua", null);}else{pmap.put("lianxidianhua", lianxidianhua);}
		if(dizhi==null||dizhi.equals("")){pmap.put("dizhi", null);}else{pmap.put("dizhi", dizhi);}
		if(gangwei==null||gangwei.equals("")){pmap.put("gangwei", null);}else{pmap.put("gangwei", gangwei);}
		if(xuehao==null||xuehao.equals("")){pmap.put("xuehao", null);}else{pmap.put("xuehao", xuehao);}
		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}
		if(xingbie==null||xingbie.equals("")){pmap.put("xingbie", null);}else{pmap.put("xingbie", xingbie);}
		if(banji==null||banji.equals("")){pmap.put("banji", null);}else{pmap.put("banji", banji);}
		if(jiaoshishenhe==null||jiaoshishenhe.equals("")){pmap.put("jiaoshishenhe", null);}else{pmap.put("jiaoshishenhe", jiaoshishenhe);}
		
		int total=qingongzhuxueService.getCount(pmap);
		pageBean.setTotal(total);
		List<Qingongzhuxue> list=qingongzhuxueService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "qingongzhuxue_list";
	}
	
	@RequestMapping("qingongzhuxue_yanben1.do")
	public String qingongzhuxue_yanben1(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Qingongzhuxue qingongzhuxue, String bumenzhanghao, String bumenmingcheng, String lianxidianhua, String dizhi, String gangwei, String xuehao, String xingming, String xingbie, String banji, String jiaoshishenhe, String issh){
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
		if(xuehao==null||xuehao.equals("")){pmap.put("xuehao", null);}else{pmap.put("xuehao", xuehao);}
		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}
		if(xingbie==null||xingbie.equals("")){pmap.put("xingbie", null);}else{pmap.put("xingbie", xingbie);}
		if(banji==null||banji.equals("")){pmap.put("banji", null);}else{pmap.put("banji", banji);}
		if(jiaoshishenhe==null||jiaoshishenhe.equals("")){pmap.put("jiaoshishenhe", null);}else{pmap.put("jiaoshishenhe", jiaoshishenhe);}
		
		int total=qingongzhuxueService.getCount(pmap);
		pageBean.setTotal(total);
		List<Qingongzhuxue> list=qingongzhuxueService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "qingongzhuxue_yanben1";
	}
	@RequestMapping("qingongzhuxue_yanben2.do")
	public String qingongzhuxue_yanben2(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Qingongzhuxue qingongzhuxue, String bumenzhanghao, String bumenmingcheng, String lianxidianhua, String dizhi, String gangwei, String xuehao, String xingming, String xingbie, String banji, String jiaoshishenhe, String issh){
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
		if(xuehao==null||xuehao.equals("")){pmap.put("xuehao", null);}else{pmap.put("xuehao", xuehao);}
		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}
		if(xingbie==null||xingbie.equals("")){pmap.put("xingbie", null);}else{pmap.put("xingbie", xingbie);}
		if(banji==null||banji.equals("")){pmap.put("banji", null);}else{pmap.put("banji", banji);}
		if(jiaoshishenhe==null||jiaoshishenhe.equals("")){pmap.put("jiaoshishenhe", null);}else{pmap.put("jiaoshishenhe", jiaoshishenhe);}
		
		int total=qingongzhuxueService.getCount(pmap);
		pageBean.setTotal(total);
		List<Qingongzhuxue> list=qingongzhuxueService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "qingongzhuxue_yanben2";
	}
	@RequestMapping("qingongzhuxue_yanben3.do")
	public String qingongzhuxue_yanben3(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Qingongzhuxue qingongzhuxue, String bumenzhanghao, String bumenmingcheng, String lianxidianhua, String dizhi, String gangwei, String xuehao, String xingming, String xingbie, String banji, String jiaoshishenhe, String issh){
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
		if(xuehao==null||xuehao.equals("")){pmap.put("xuehao", null);}else{pmap.put("xuehao", xuehao);}
		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}
		if(xingbie==null||xingbie.equals("")){pmap.put("xingbie", null);}else{pmap.put("xingbie", xingbie);}
		if(banji==null||banji.equals("")){pmap.put("banji", null);}else{pmap.put("banji", banji);}
		if(jiaoshishenhe==null||jiaoshishenhe.equals("")){pmap.put("jiaoshishenhe", null);}else{pmap.put("jiaoshishenhe", jiaoshishenhe);}
		
		int total=qingongzhuxueService.getCount(pmap);
		pageBean.setTotal(total);
		List<Qingongzhuxue> list=qingongzhuxueService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "qingongzhuxue_yanben3";
	}
	@RequestMapping("qingongzhuxue_yanben4.do")
	public String qingongzhuxue_yanben4(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Qingongzhuxue qingongzhuxue, String bumenzhanghao, String bumenmingcheng, String lianxidianhua, String dizhi, String gangwei, String xuehao, String xingming, String xingbie, String banji, String jiaoshishenhe, String issh){
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
		if(xuehao==null||xuehao.equals("")){pmap.put("xuehao", null);}else{pmap.put("xuehao", xuehao);}
		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}
		if(xingbie==null||xingbie.equals("")){pmap.put("xingbie", null);}else{pmap.put("xingbie", xingbie);}
		if(banji==null||banji.equals("")){pmap.put("banji", null);}else{pmap.put("banji", banji);}
		if(jiaoshishenhe==null||jiaoshishenhe.equals("")){pmap.put("jiaoshishenhe", null);}else{pmap.put("jiaoshishenhe", jiaoshishenhe);}
		
		int total=qingongzhuxueService.getCount(pmap);
		pageBean.setTotal(total);
		List<Qingongzhuxue> list=qingongzhuxueService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "qingongzhuxue_yanben4";
	}
	@RequestMapping("qingongzhuxue_yanben5.do")
	public String qingongzhuxue_yanben5(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Qingongzhuxue qingongzhuxue, String bumenzhanghao, String bumenmingcheng, String lianxidianhua, String dizhi, String gangwei, String xuehao, String xingming, String xingbie, String banji, String jiaoshishenhe, String issh){
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
		if(xuehao==null||xuehao.equals("")){pmap.put("xuehao", null);}else{pmap.put("xuehao", xuehao);}
		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}
		if(xingbie==null||xingbie.equals("")){pmap.put("xingbie", null);}else{pmap.put("xingbie", xingbie);}
		if(banji==null||banji.equals("")){pmap.put("banji", null);}else{pmap.put("banji", banji);}
		if(jiaoshishenhe==null||jiaoshishenhe.equals("")){pmap.put("jiaoshishenhe", null);}else{pmap.put("jiaoshishenhe", jiaoshishenhe);}
		
		int total=qingongzhuxueService.getCount(pmap);
		pageBean.setTotal(total);
		List<Qingongzhuxue> list=qingongzhuxueService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "qingongzhuxue_yanben5";
	}
	
	@RequestMapping("qingongzhuxueList4.do")
	public String qingongzhuxueList4(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Qingongzhuxue qingongzhuxue, String bumenzhanghao, String bumenmingcheng, String lianxidianhua, String dizhi, String gangwei, String xuehao, String xingming, String xingbie, String banji, String jiaoshishenhe, String issh,HttpServletRequest request){
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
		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}
		if(xingbie==null||xingbie.equals("")){pmap.put("xingbie", null);}else{pmap.put("xingbie", xingbie);}
		if(jiaoshishenhe==null||jiaoshishenhe.equals("")){pmap.put("jiaoshishenhe", null);}else{pmap.put("jiaoshishenhe", jiaoshishenhe);}
		
		
		int total=qingongzhuxueService.getCount(pmap);
		pageBean.setTotal(total);
		List<Qingongzhuxue> list=qingongzhuxueService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "qingongzhuxue_list4";
	}
	@RequestMapping("qingongzhuxueList2.do")
	public String qingongzhuxueList2(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Qingongzhuxue qingongzhuxue, String bumenzhanghao, String bumenmingcheng, String lianxidianhua, String dizhi, String gangwei, String xuehao, String xingming, String xingbie, String banji, String jiaoshishenhe, String issh,HttpServletRequest request){
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
		if(bumenmingcheng==null||bumenmingcheng.equals("")){pmap.put("bumenmingcheng", null);}else{pmap.put("bumenmingcheng", bumenmingcheng);}
		if(lianxidianhua==null||lianxidianhua.equals("")){pmap.put("lianxidianhua", null);}else{pmap.put("lianxidianhua", lianxidianhua);}
		if(dizhi==null||dizhi.equals("")){pmap.put("dizhi", null);}else{pmap.put("dizhi", dizhi);}
		if(gangwei==null||gangwei.equals("")){pmap.put("gangwei", null);}else{pmap.put("gangwei", gangwei);}
		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}
		if(xingbie==null||xingbie.equals("")){pmap.put("xingbie", null);}else{pmap.put("xingbie", xingbie);}
		if(jiaoshishenhe==null||jiaoshishenhe.equals("")){pmap.put("jiaoshishenhe", null);}else{pmap.put("jiaoshishenhe", jiaoshishenhe);}
		
		
		int total=qingongzhuxueService.getCount(pmap);
		pageBean.setTotal(total);
		List<Qingongzhuxue> list=qingongzhuxueService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "qingongzhuxue_list2";
	}
	@RequestMapping("qingongzhuxueList3.do")
	public String qingongzhuxueList3(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Qingongzhuxue qingongzhuxue, String bumenzhanghao, String bumenmingcheng, String lianxidianhua, String dizhi, String gangwei, String xuehao, String xingming, String xingbie, String banji, String jiaoshishenhe, String issh,HttpServletRequest request){
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
		if(bumenmingcheng==null||bumenmingcheng.equals("")){pmap.put("bumenmingcheng", null);}else{pmap.put("bumenmingcheng", bumenmingcheng);}
		if(lianxidianhua==null||lianxidianhua.equals("")){pmap.put("lianxidianhua", null);}else{pmap.put("lianxidianhua", lianxidianhua);}
		if(dizhi==null||dizhi.equals("")){pmap.put("dizhi", null);}else{pmap.put("dizhi", dizhi);}
		if(gangwei==null||gangwei.equals("")){pmap.put("gangwei", null);}else{pmap.put("gangwei", gangwei);}
		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}
		if(xingbie==null||xingbie.equals("")){pmap.put("xingbie", null);}else{pmap.put("xingbie", xingbie);}
		if(jiaoshishenhe==null||jiaoshishenhe.equals("")){pmap.put("jiaoshishenhe", null);}else{pmap.put("jiaoshishenhe", jiaoshishenhe);}
		
		
		int total=qingongzhuxueService.getCount(pmap);
		pageBean.setTotal(total);
		List<Qingongzhuxue> list=qingongzhuxueService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "qingongzhuxue_list3";
	}
	
	
	@RequestMapping("qgzxList.do")
	public String qgzxList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Qingongzhuxue qingongzhuxue, String bumenzhanghao, String bumenmingcheng, String lianxidianhua, String dizhi, String gangwei, String xuehao, String xingming, String xingbie, String banji, String jiaoshishenhe, String issh){
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
		if(xuehao==null||xuehao.equals("")){pmap.put("xuehao", null);}else{pmap.put("xuehao", xuehao);}
		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}
		if(xingbie==null||xingbie.equals("")){pmap.put("xingbie", null);}else{pmap.put("xingbie", xingbie);}
		if(banji==null||banji.equals("")){pmap.put("banji", null);}else{pmap.put("banji", banji);}
		if(jiaoshishenhe==null||jiaoshishenhe.equals("")){pmap.put("jiaoshishenhe", null);}else{pmap.put("jiaoshishenhe", jiaoshishenhe);}
		
		int total=qingongzhuxueService.getCount(pmap);
		pageBean.setTotal(total);
		List<Qingongzhuxue> list=qingongzhuxueService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "qingongzhuxuelist";
	}
	@RequestMapping("qgzxListtp.do")
	public String qgzxListtp(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Qingongzhuxue qingongzhuxue, String bumenzhanghao, String bumenmingcheng, String lianxidianhua, String dizhi, String gangwei, String xuehao, String xingming, String xingbie, String banji, String jiaoshishenhe, String issh){
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
		if(xuehao==null||xuehao.equals("")){pmap.put("xuehao", null);}else{pmap.put("xuehao", xuehao);}
		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}
		if(xingbie==null||xingbie.equals("")){pmap.put("xingbie", null);}else{pmap.put("xingbie", xingbie);}
		if(banji==null||banji.equals("")){pmap.put("banji", null);}else{pmap.put("banji", banji);}
		if(jiaoshishenhe==null||jiaoshishenhe.equals("")){pmap.put("jiaoshishenhe", null);}else{pmap.put("jiaoshishenhe", jiaoshishenhe);}
		
		int total=qingongzhuxueService.getCount(pmap);
		pageBean.setTotal(total);
		List<Qingongzhuxue> list=qingongzhuxueService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "qingongzhuxuelisttp";
	}
	
	@RequestMapping("deleteQingongzhuxue.do")
	public String deleteQingongzhuxue(int id,HttpServletRequest request){
		qingongzhuxueService.delete(id);
		String url = request.getHeader("Referer");
		return "redirect:"+url;
		//return "redirect:qingongzhuxueList.do";
	}
	
	
}
