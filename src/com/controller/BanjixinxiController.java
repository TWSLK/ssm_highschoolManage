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

import com.entity.Banjixinxi;
import com.server.BanjixinxiServer;
import com.util.PageBean;
import net.sf.json.JSONObject;
import com.util.db;
import java.sql.SQLException;
import java.sql.*;
@Controller
public class BanjixinxiController {
	@Resource
	private BanjixinxiServer banjixinxiService;


   
	@RequestMapping("addBanjixinxi.do")
	public String addBanjixinxi(HttpServletRequest request,Banjixinxi banjixinxi,HttpSession session) throws SQLException{
		Timestamp time=new Timestamp(System.currentTimeMillis());
		
		banjixinxi.setAddtime(time.toString().substring(0, 19));
		banjixinxiService.add(banjixinxi);
		
		session.setAttribute("backxx", "添加成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		
		//session.setAttribute("backurl", "banjixinxiList.do");
		
		return "redirect:postback.jsp";
		//return "redirect:banjixinxiList.do";
		
		
		
	}
 
//	处理编辑
	@RequestMapping("doUpdateBanjixinxi.do")
	public String doUpdateBanjixinxi(int id,ModelMap map,Banjixinxi banjixinxi){
		banjixinxi=banjixinxiService.getById(id);
		map.put("banjixinxi", banjixinxi);
		return "banjixinxi_updt";
	}
	
	
	
	
	
//	后台详细
	@RequestMapping("banjixinxiDetail.do")
	public String banjixinxiDetail(int id,ModelMap map,Banjixinxi banjixinxi){
		banjixinxi=banjixinxiService.getById(id);
		map.put("banjixinxi", banjixinxi);
		return "banjixinxi_detail";
	}
//	前台详细
	@RequestMapping("bjxxDetail.do")
	public String bjxxDetail(int id,ModelMap map,Banjixinxi banjixinxi){
		banjixinxi=banjixinxiService.getById(id);
		map.put("banjixinxi", banjixinxi);
		return "banjixinxidetail";
	}
//	
	@RequestMapping("updateBanjixinxi.do")
	public String updateBanjixinxi(int id,ModelMap map,Banjixinxi banjixinxi,HttpServletRequest request,HttpSession session){
		banjixinxiService.update(banjixinxi);
		session.setAttribute("backxx", "修改成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		return "redirect:postback.jsp";
		//String url = request.getHeader("Referer");
		//return "redirect:"+url;
		//return "redirect:banjixinxiList.do";
	}

//	分页查询
	@RequestMapping("banjixinxiList.do")
	public String banjixinxiList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Banjixinxi banjixinxi, String banji){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(banji==null||banji.equals("")){pmap.put("banji", null);}else{pmap.put("banji", banji);}		
		int total=banjixinxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Banjixinxi> list=banjixinxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "banjixinxi_list";
	}
	
	@RequestMapping("banjixinxi_yanben1.do")
	public String banjixinxi_yanben1(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Banjixinxi banjixinxi, String banji){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(banji==null||banji.equals("")){pmap.put("banji", null);}else{pmap.put("banji", banji);}		
		int total=banjixinxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Banjixinxi> list=banjixinxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "banjixinxi_yanben1";
	}
	@RequestMapping("banjixinxi_yanben2.do")
	public String banjixinxi_yanben2(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Banjixinxi banjixinxi, String banji){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(banji==null||banji.equals("")){pmap.put("banji", null);}else{pmap.put("banji", banji);}		
		int total=banjixinxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Banjixinxi> list=banjixinxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "banjixinxi_yanben2";
	}
	@RequestMapping("banjixinxi_yanben3.do")
	public String banjixinxi_yanben3(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Banjixinxi banjixinxi, String banji){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(banji==null||banji.equals("")){pmap.put("banji", null);}else{pmap.put("banji", banji);}		
		int total=banjixinxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Banjixinxi> list=banjixinxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "banjixinxi_yanben3";
	}
	@RequestMapping("banjixinxi_yanben4.do")
	public String banjixinxi_yanben4(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Banjixinxi banjixinxi, String banji){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(banji==null||banji.equals("")){pmap.put("banji", null);}else{pmap.put("banji", banji);}		
		int total=banjixinxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Banjixinxi> list=banjixinxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "banjixinxi_yanben4";
	}
	@RequestMapping("banjixinxi_yanben5.do")
	public String banjixinxi_yanben5(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Banjixinxi banjixinxi, String banji){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(banji==null||banji.equals("")){pmap.put("banji", null);}else{pmap.put("banji", banji);}		
		int total=banjixinxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Banjixinxi> list=banjixinxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "banjixinxi_yanben5";
	}
	
	
	
	@RequestMapping("bjxxList.do")
	public String bjxxList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Banjixinxi banjixinxi, String banji){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(banji==null||banji.equals("")){pmap.put("banji", null);}else{pmap.put("banji", banji);}		
		int total=banjixinxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Banjixinxi> list=banjixinxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "banjixinxilist";
	}
	@RequestMapping("bjxxListtp.do")
	public String bjxxListtp(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Banjixinxi banjixinxi, String banji){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(banji==null||banji.equals("")){pmap.put("banji", null);}else{pmap.put("banji", banji);}		
		int total=banjixinxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Banjixinxi> list=banjixinxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "banjixinxilisttp";
	}
	
	@RequestMapping("deleteBanjixinxi.do")
	public String deleteBanjixinxi(int id,HttpServletRequest request){
		banjixinxiService.delete(id);
		String url = request.getHeader("Referer");
		return "redirect:"+url;
		//return "redirect:banjixinxiList.do";
	}
	
	@RequestMapping("quchongBanjixinxi.do")
	public void quchongBanjixinxi(Banjixinxi banjixinxi,HttpServletResponse response){
		   Map<String,Object> map=new HashMap<String,Object>();
		   map.put("banji", banjixinxi.getBanji());
		   System.out.println("banji==="+banjixinxi.getBanji());
		   System.out.println("banji222==="+banjixinxiService.quchongBanjixinxi(map));
		   JSONObject obj=new JSONObject();
		   if(banjixinxiService.quchongBanjixinxi(map)!=null){
				 obj.put("info", "ng");
			   }else{
				   obj.put("info", "班级可以用！");
				  
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
