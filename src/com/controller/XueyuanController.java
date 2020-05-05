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

import com.entity.Xueyuan;
import com.server.XueyuanServer;
import com.util.PageBean;
import net.sf.json.JSONObject;
import com.util.db;
import java.sql.SQLException;
import java.sql.*;
@Controller
public class XueyuanController {
	@Resource
	private XueyuanServer xueyuanService;


   
	@RequestMapping("addXueyuan.do")
	public String addXueyuan(HttpServletRequest request,Xueyuan xueyuan,HttpSession session) throws SQLException{
		Timestamp time=new Timestamp(System.currentTimeMillis());
		
		xueyuan.setAddtime(time.toString().substring(0, 19));
		xueyuanService.add(xueyuan);
		
		session.setAttribute("backxx", "添加成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		
		//session.setAttribute("backurl", "xueyuanList.do");
		
		return "redirect:postback.jsp";
		//return "redirect:xueyuanList.do";
		
		
		
	}
 
//	处理编辑
	@RequestMapping("doUpdateXueyuan.do")
	public String doUpdateXueyuan(int id,ModelMap map,Xueyuan xueyuan){
		xueyuan=xueyuanService.getById(id);
		map.put("xueyuan", xueyuan);
		return "xueyuan_updt";
	}
	
	@RequestMapping("doUpdateXueyuan2.do")
	public String doUpdateXueyuan2(ModelMap map,Xueyuan xueyuan,HttpServletRequest request){
		xueyuan=xueyuanService.getById(Integer.parseInt((String)request.getSession().getAttribute("uid")));
		map.put("xueyuan", xueyuan);
		return "xueyuan_updt2";
	}
	
@RequestMapping("updateXueyuan2.do")
	public String updateXueyuan2(int id,ModelMap map,Xueyuan xueyuan){
		xueyuanService.update(xueyuan);
		return "redirect:doUpdateXueyuan2.do";
	}
	
	
	
//	后台详细
	@RequestMapping("xueyuanDetail.do")
	public String xueyuanDetail(int id,ModelMap map,Xueyuan xueyuan){
		xueyuan=xueyuanService.getById(id);
		map.put("xueyuan", xueyuan);
		return "xueyuan_detail";
	}
//	前台详细
	@RequestMapping("xyDetail.do")
	public String xyDetail(int id,ModelMap map,Xueyuan xueyuan){
		xueyuan=xueyuanService.getById(id);
		map.put("xueyuan", xueyuan);
		return "xueyuandetail";
	}
//	
	@RequestMapping("updateXueyuan.do")
	public String updateXueyuan(int id,ModelMap map,Xueyuan xueyuan,HttpServletRequest request,HttpSession session){
		xueyuanService.update(xueyuan);
		session.setAttribute("backxx", "修改成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		return "redirect:postback.jsp";
		//String url = request.getHeader("Referer");
		//return "redirect:"+url;
		//return "redirect:xueyuanList.do";
	}

//	分页查询
	@RequestMapping("xueyuanList.do")
	public String xueyuanList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Xueyuan xueyuan, String zhanghao, String mima, String xingming, String xingbie, String lianxifangshi){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(zhanghao==null||zhanghao.equals("")){pmap.put("zhanghao", null);}else{pmap.put("zhanghao", zhanghao);}		if(mima==null||mima.equals("")){pmap.put("mima", null);}else{pmap.put("mima", mima);}		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}		if(xingbie==null||xingbie.equals("")){pmap.put("xingbie", null);}else{pmap.put("xingbie", xingbie);}		if(lianxifangshi==null||lianxifangshi.equals("")){pmap.put("lianxifangshi", null);}else{pmap.put("lianxifangshi", lianxifangshi);}		
		int total=xueyuanService.getCount(pmap);
		pageBean.setTotal(total);
		List<Xueyuan> list=xueyuanService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "xueyuan_list";
	}
	
	@RequestMapping("xueyuan_yanben1.do")
	public String xueyuan_yanben1(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Xueyuan xueyuan, String zhanghao, String mima, String xingming, String xingbie, String lianxifangshi){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(zhanghao==null||zhanghao.equals("")){pmap.put("zhanghao", null);}else{pmap.put("zhanghao", zhanghao);}		if(mima==null||mima.equals("")){pmap.put("mima", null);}else{pmap.put("mima", mima);}		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}		if(xingbie==null||xingbie.equals("")){pmap.put("xingbie", null);}else{pmap.put("xingbie", xingbie);}		if(lianxifangshi==null||lianxifangshi.equals("")){pmap.put("lianxifangshi", null);}else{pmap.put("lianxifangshi", lianxifangshi);}		
		int total=xueyuanService.getCount(pmap);
		pageBean.setTotal(total);
		List<Xueyuan> list=xueyuanService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "xueyuan_yanben1";
	}
	@RequestMapping("xueyuan_yanben2.do")
	public String xueyuan_yanben2(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Xueyuan xueyuan, String zhanghao, String mima, String xingming, String xingbie, String lianxifangshi){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(zhanghao==null||zhanghao.equals("")){pmap.put("zhanghao", null);}else{pmap.put("zhanghao", zhanghao);}		if(mima==null||mima.equals("")){pmap.put("mima", null);}else{pmap.put("mima", mima);}		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}		if(xingbie==null||xingbie.equals("")){pmap.put("xingbie", null);}else{pmap.put("xingbie", xingbie);}		if(lianxifangshi==null||lianxifangshi.equals("")){pmap.put("lianxifangshi", null);}else{pmap.put("lianxifangshi", lianxifangshi);}		
		int total=xueyuanService.getCount(pmap);
		pageBean.setTotal(total);
		List<Xueyuan> list=xueyuanService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "xueyuan_yanben2";
	}
	@RequestMapping("xueyuan_yanben3.do")
	public String xueyuan_yanben3(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Xueyuan xueyuan, String zhanghao, String mima, String xingming, String xingbie, String lianxifangshi){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(zhanghao==null||zhanghao.equals("")){pmap.put("zhanghao", null);}else{pmap.put("zhanghao", zhanghao);}		if(mima==null||mima.equals("")){pmap.put("mima", null);}else{pmap.put("mima", mima);}		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}		if(xingbie==null||xingbie.equals("")){pmap.put("xingbie", null);}else{pmap.put("xingbie", xingbie);}		if(lianxifangshi==null||lianxifangshi.equals("")){pmap.put("lianxifangshi", null);}else{pmap.put("lianxifangshi", lianxifangshi);}		
		int total=xueyuanService.getCount(pmap);
		pageBean.setTotal(total);
		List<Xueyuan> list=xueyuanService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "xueyuan_yanben3";
	}
	@RequestMapping("xueyuan_yanben4.do")
	public String xueyuan_yanben4(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Xueyuan xueyuan, String zhanghao, String mima, String xingming, String xingbie, String lianxifangshi){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(zhanghao==null||zhanghao.equals("")){pmap.put("zhanghao", null);}else{pmap.put("zhanghao", zhanghao);}		if(mima==null||mima.equals("")){pmap.put("mima", null);}else{pmap.put("mima", mima);}		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}		if(xingbie==null||xingbie.equals("")){pmap.put("xingbie", null);}else{pmap.put("xingbie", xingbie);}		if(lianxifangshi==null||lianxifangshi.equals("")){pmap.put("lianxifangshi", null);}else{pmap.put("lianxifangshi", lianxifangshi);}		
		int total=xueyuanService.getCount(pmap);
		pageBean.setTotal(total);
		List<Xueyuan> list=xueyuanService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "xueyuan_yanben4";
	}
	@RequestMapping("xueyuan_yanben5.do")
	public String xueyuan_yanben5(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Xueyuan xueyuan, String zhanghao, String mima, String xingming, String xingbie, String lianxifangshi){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(zhanghao==null||zhanghao.equals("")){pmap.put("zhanghao", null);}else{pmap.put("zhanghao", zhanghao);}		if(mima==null||mima.equals("")){pmap.put("mima", null);}else{pmap.put("mima", mima);}		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}		if(xingbie==null||xingbie.equals("")){pmap.put("xingbie", null);}else{pmap.put("xingbie", xingbie);}		if(lianxifangshi==null||lianxifangshi.equals("")){pmap.put("lianxifangshi", null);}else{pmap.put("lianxifangshi", lianxifangshi);}		
		int total=xueyuanService.getCount(pmap);
		pageBean.setTotal(total);
		List<Xueyuan> list=xueyuanService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "xueyuan_yanben5";
	}
	
	
	
	@RequestMapping("xyList.do")
	public String xyList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Xueyuan xueyuan, String zhanghao, String mima, String xingming, String xingbie, String lianxifangshi){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(zhanghao==null||zhanghao.equals("")){pmap.put("zhanghao", null);}else{pmap.put("zhanghao", zhanghao);}		if(mima==null||mima.equals("")){pmap.put("mima", null);}else{pmap.put("mima", mima);}		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}		if(xingbie==null||xingbie.equals("")){pmap.put("xingbie", null);}else{pmap.put("xingbie", xingbie);}		if(lianxifangshi==null||lianxifangshi.equals("")){pmap.put("lianxifangshi", null);}else{pmap.put("lianxifangshi", lianxifangshi);}		
		int total=xueyuanService.getCount(pmap);
		pageBean.setTotal(total);
		List<Xueyuan> list=xueyuanService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "xueyuanlist";
	}
	@RequestMapping("xyListtp.do")
	public String xyListtp(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Xueyuan xueyuan, String zhanghao, String mima, String xingming, String xingbie, String lianxifangshi){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(zhanghao==null||zhanghao.equals("")){pmap.put("zhanghao", null);}else{pmap.put("zhanghao", zhanghao);}		if(mima==null||mima.equals("")){pmap.put("mima", null);}else{pmap.put("mima", mima);}		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}		if(xingbie==null||xingbie.equals("")){pmap.put("xingbie", null);}else{pmap.put("xingbie", xingbie);}		if(lianxifangshi==null||lianxifangshi.equals("")){pmap.put("lianxifangshi", null);}else{pmap.put("lianxifangshi", lianxifangshi);}		
		int total=xueyuanService.getCount(pmap);
		pageBean.setTotal(total);
		List<Xueyuan> list=xueyuanService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "xueyuanlisttp";
	}
	
	@RequestMapping("deleteXueyuan.do")
	public String deleteXueyuan(int id,HttpServletRequest request){
		xueyuanService.delete(id);
		String url = request.getHeader("Referer");
		return "redirect:"+url;
		//return "redirect:xueyuanList.do";
	}
	
	@RequestMapping("quchongXueyuan.do")
	public void quchongXueyuan(Xueyuan xueyuan,HttpServletResponse response){
		   Map<String,Object> map=new HashMap<String,Object>();
		   map.put("zhanghao", xueyuan.getZhanghao());
		   System.out.println("zhanghao==="+xueyuan.getZhanghao());
		   System.out.println("zhanghao222==="+xueyuanService.quchongXueyuan(map));
		   JSONObject obj=new JSONObject();
		   if(xueyuanService.quchongXueyuan(map)!=null){
				 obj.put("info", "ng");
			   }else{
				   obj.put("info", "账号可以用！");
				  
			   }
		   response.setContentType("text/html;charset=utf-8");
		   PrintWriter out=null;
		   try {
			out=response.getWriter();
			out.print(obj);
			out.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			out.close();
		}
	}
}
