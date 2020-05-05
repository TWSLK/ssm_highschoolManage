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

import com.entity.Yonggongbumen;
import com.server.YonggongbumenServer;
import com.util.PageBean;
import net.sf.json.JSONObject;
import com.util.db;
import java.sql.SQLException;
import java.sql.*;
@Controller
public class YonggongbumenController {
	@Resource
	private YonggongbumenServer yonggongbumenService;


   
	@RequestMapping("addYonggongbumen.do")
	public String addYonggongbumen(HttpServletRequest request,Yonggongbumen yonggongbumen,HttpSession session) throws SQLException{
		Timestamp time=new Timestamp(System.currentTimeMillis());
		
		yonggongbumen.setAddtime(time.toString().substring(0, 19));
		yonggongbumenService.add(yonggongbumen);
		
		session.setAttribute("backxx", "添加成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		
		//session.setAttribute("backurl", "yonggongbumenList.do");
		
		return "redirect:postback.jsp";
		//return "redirect:yonggongbumenList.do";
		
		
		
	}
 
//	处理编辑
	@RequestMapping("doUpdateYonggongbumen.do")
	public String doUpdateYonggongbumen(int id,ModelMap map,Yonggongbumen yonggongbumen){
		yonggongbumen=yonggongbumenService.getById(id);
		map.put("yonggongbumen", yonggongbumen);
		return "yonggongbumen_updt";
	}
	
	@RequestMapping("doUpdateYonggongbumen2.do")
	public String doUpdateYonggongbumen2(ModelMap map,Yonggongbumen yonggongbumen,HttpServletRequest request){
		yonggongbumen=yonggongbumenService.getById(Integer.parseInt((String)request.getSession().getAttribute("uid")));
		map.put("yonggongbumen", yonggongbumen);
		return "yonggongbumen_updt2";
	}
	
@RequestMapping("updateYonggongbumen2.do")
	public String updateYonggongbumen2(int id,ModelMap map,Yonggongbumen yonggongbumen){
		yonggongbumenService.update(yonggongbumen);
		return "redirect:doUpdateYonggongbumen2.do";
	}
	
	
	
//	后台详细
	@RequestMapping("yonggongbumenDetail.do")
	public String yonggongbumenDetail(int id,ModelMap map,Yonggongbumen yonggongbumen){
		yonggongbumen=yonggongbumenService.getById(id);
		map.put("yonggongbumen", yonggongbumen);
		return "yonggongbumen_detail";
	}
//	前台详细
	@RequestMapping("ygbmDetail.do")
	public String ygbmDetail(int id,ModelMap map,Yonggongbumen yonggongbumen){
		yonggongbumen=yonggongbumenService.getById(id);
		map.put("yonggongbumen", yonggongbumen);
		return "yonggongbumendetail";
	}
//	
	@RequestMapping("updateYonggongbumen.do")
	public String updateYonggongbumen(int id,ModelMap map,Yonggongbumen yonggongbumen,HttpServletRequest request,HttpSession session){
		yonggongbumenService.update(yonggongbumen);
		session.setAttribute("backxx", "修改成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		return "redirect:postback.jsp";
		//String url = request.getHeader("Referer");
		//return "redirect:"+url;
		//return "redirect:yonggongbumenList.do";
	}

//	分页查询
	@RequestMapping("yonggongbumenList.do")
	public String yonggongbumenList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Yonggongbumen yonggongbumen, String bumenzhanghao, String mima, String bumenmingcheng, String fuzeren, String lianxidianhua, String dizhi){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(bumenzhanghao==null||bumenzhanghao.equals("")){pmap.put("bumenzhanghao", null);}else{pmap.put("bumenzhanghao", bumenzhanghao);}		if(mima==null||mima.equals("")){pmap.put("mima", null);}else{pmap.put("mima", mima);}		if(bumenmingcheng==null||bumenmingcheng.equals("")){pmap.put("bumenmingcheng", null);}else{pmap.put("bumenmingcheng", bumenmingcheng);}		if(fuzeren==null||fuzeren.equals("")){pmap.put("fuzeren", null);}else{pmap.put("fuzeren", fuzeren);}		if(lianxidianhua==null||lianxidianhua.equals("")){pmap.put("lianxidianhua", null);}else{pmap.put("lianxidianhua", lianxidianhua);}		if(dizhi==null||dizhi.equals("")){pmap.put("dizhi", null);}else{pmap.put("dizhi", dizhi);}		
		int total=yonggongbumenService.getCount(pmap);
		pageBean.setTotal(total);
		List<Yonggongbumen> list=yonggongbumenService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "yonggongbumen_list";
	}
	
	@RequestMapping("yonggongbumen_yanben1.do")
	public String yonggongbumen_yanben1(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Yonggongbumen yonggongbumen, String bumenzhanghao, String mima, String bumenmingcheng, String fuzeren, String lianxidianhua, String dizhi){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(bumenzhanghao==null||bumenzhanghao.equals("")){pmap.put("bumenzhanghao", null);}else{pmap.put("bumenzhanghao", bumenzhanghao);}		if(mima==null||mima.equals("")){pmap.put("mima", null);}else{pmap.put("mima", mima);}		if(bumenmingcheng==null||bumenmingcheng.equals("")){pmap.put("bumenmingcheng", null);}else{pmap.put("bumenmingcheng", bumenmingcheng);}		if(fuzeren==null||fuzeren.equals("")){pmap.put("fuzeren", null);}else{pmap.put("fuzeren", fuzeren);}		if(lianxidianhua==null||lianxidianhua.equals("")){pmap.put("lianxidianhua", null);}else{pmap.put("lianxidianhua", lianxidianhua);}		if(dizhi==null||dizhi.equals("")){pmap.put("dizhi", null);}else{pmap.put("dizhi", dizhi);}		
		int total=yonggongbumenService.getCount(pmap);
		pageBean.setTotal(total);
		List<Yonggongbumen> list=yonggongbumenService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "yonggongbumen_yanben1";
	}
	@RequestMapping("yonggongbumen_yanben2.do")
	public String yonggongbumen_yanben2(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Yonggongbumen yonggongbumen, String bumenzhanghao, String mima, String bumenmingcheng, String fuzeren, String lianxidianhua, String dizhi){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(bumenzhanghao==null||bumenzhanghao.equals("")){pmap.put("bumenzhanghao", null);}else{pmap.put("bumenzhanghao", bumenzhanghao);}		if(mima==null||mima.equals("")){pmap.put("mima", null);}else{pmap.put("mima", mima);}		if(bumenmingcheng==null||bumenmingcheng.equals("")){pmap.put("bumenmingcheng", null);}else{pmap.put("bumenmingcheng", bumenmingcheng);}		if(fuzeren==null||fuzeren.equals("")){pmap.put("fuzeren", null);}else{pmap.put("fuzeren", fuzeren);}		if(lianxidianhua==null||lianxidianhua.equals("")){pmap.put("lianxidianhua", null);}else{pmap.put("lianxidianhua", lianxidianhua);}		if(dizhi==null||dizhi.equals("")){pmap.put("dizhi", null);}else{pmap.put("dizhi", dizhi);}		
		int total=yonggongbumenService.getCount(pmap);
		pageBean.setTotal(total);
		List<Yonggongbumen> list=yonggongbumenService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "yonggongbumen_yanben2";
	}
	@RequestMapping("yonggongbumen_yanben3.do")
	public String yonggongbumen_yanben3(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Yonggongbumen yonggongbumen, String bumenzhanghao, String mima, String bumenmingcheng, String fuzeren, String lianxidianhua, String dizhi){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(bumenzhanghao==null||bumenzhanghao.equals("")){pmap.put("bumenzhanghao", null);}else{pmap.put("bumenzhanghao", bumenzhanghao);}		if(mima==null||mima.equals("")){pmap.put("mima", null);}else{pmap.put("mima", mima);}		if(bumenmingcheng==null||bumenmingcheng.equals("")){pmap.put("bumenmingcheng", null);}else{pmap.put("bumenmingcheng", bumenmingcheng);}		if(fuzeren==null||fuzeren.equals("")){pmap.put("fuzeren", null);}else{pmap.put("fuzeren", fuzeren);}		if(lianxidianhua==null||lianxidianhua.equals("")){pmap.put("lianxidianhua", null);}else{pmap.put("lianxidianhua", lianxidianhua);}		if(dizhi==null||dizhi.equals("")){pmap.put("dizhi", null);}else{pmap.put("dizhi", dizhi);}		
		int total=yonggongbumenService.getCount(pmap);
		pageBean.setTotal(total);
		List<Yonggongbumen> list=yonggongbumenService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "yonggongbumen_yanben3";
	}
	@RequestMapping("yonggongbumen_yanben4.do")
	public String yonggongbumen_yanben4(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Yonggongbumen yonggongbumen, String bumenzhanghao, String mima, String bumenmingcheng, String fuzeren, String lianxidianhua, String dizhi){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(bumenzhanghao==null||bumenzhanghao.equals("")){pmap.put("bumenzhanghao", null);}else{pmap.put("bumenzhanghao", bumenzhanghao);}		if(mima==null||mima.equals("")){pmap.put("mima", null);}else{pmap.put("mima", mima);}		if(bumenmingcheng==null||bumenmingcheng.equals("")){pmap.put("bumenmingcheng", null);}else{pmap.put("bumenmingcheng", bumenmingcheng);}		if(fuzeren==null||fuzeren.equals("")){pmap.put("fuzeren", null);}else{pmap.put("fuzeren", fuzeren);}		if(lianxidianhua==null||lianxidianhua.equals("")){pmap.put("lianxidianhua", null);}else{pmap.put("lianxidianhua", lianxidianhua);}		if(dizhi==null||dizhi.equals("")){pmap.put("dizhi", null);}else{pmap.put("dizhi", dizhi);}		
		int total=yonggongbumenService.getCount(pmap);
		pageBean.setTotal(total);
		List<Yonggongbumen> list=yonggongbumenService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "yonggongbumen_yanben4";
	}
	@RequestMapping("yonggongbumen_yanben5.do")
	public String yonggongbumen_yanben5(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Yonggongbumen yonggongbumen, String bumenzhanghao, String mima, String bumenmingcheng, String fuzeren, String lianxidianhua, String dizhi){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(bumenzhanghao==null||bumenzhanghao.equals("")){pmap.put("bumenzhanghao", null);}else{pmap.put("bumenzhanghao", bumenzhanghao);}		if(mima==null||mima.equals("")){pmap.put("mima", null);}else{pmap.put("mima", mima);}		if(bumenmingcheng==null||bumenmingcheng.equals("")){pmap.put("bumenmingcheng", null);}else{pmap.put("bumenmingcheng", bumenmingcheng);}		if(fuzeren==null||fuzeren.equals("")){pmap.put("fuzeren", null);}else{pmap.put("fuzeren", fuzeren);}		if(lianxidianhua==null||lianxidianhua.equals("")){pmap.put("lianxidianhua", null);}else{pmap.put("lianxidianhua", lianxidianhua);}		if(dizhi==null||dizhi.equals("")){pmap.put("dizhi", null);}else{pmap.put("dizhi", dizhi);}		
		int total=yonggongbumenService.getCount(pmap);
		pageBean.setTotal(total);
		List<Yonggongbumen> list=yonggongbumenService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "yonggongbumen_yanben5";
	}
	
	
	
	@RequestMapping("ygbmList.do")
	public String ygbmList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Yonggongbumen yonggongbumen, String bumenzhanghao, String mima, String bumenmingcheng, String fuzeren, String lianxidianhua, String dizhi){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(bumenzhanghao==null||bumenzhanghao.equals("")){pmap.put("bumenzhanghao", null);}else{pmap.put("bumenzhanghao", bumenzhanghao);}		if(mima==null||mima.equals("")){pmap.put("mima", null);}else{pmap.put("mima", mima);}		if(bumenmingcheng==null||bumenmingcheng.equals("")){pmap.put("bumenmingcheng", null);}else{pmap.put("bumenmingcheng", bumenmingcheng);}		if(fuzeren==null||fuzeren.equals("")){pmap.put("fuzeren", null);}else{pmap.put("fuzeren", fuzeren);}		if(lianxidianhua==null||lianxidianhua.equals("")){pmap.put("lianxidianhua", null);}else{pmap.put("lianxidianhua", lianxidianhua);}		if(dizhi==null||dizhi.equals("")){pmap.put("dizhi", null);}else{pmap.put("dizhi", dizhi);}		
		int total=yonggongbumenService.getCount(pmap);
		pageBean.setTotal(total);
		List<Yonggongbumen> list=yonggongbumenService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "yonggongbumenlist";
	}
	@RequestMapping("ygbmListtp.do")
	public String ygbmListtp(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Yonggongbumen yonggongbumen, String bumenzhanghao, String mima, String bumenmingcheng, String fuzeren, String lianxidianhua, String dizhi){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(bumenzhanghao==null||bumenzhanghao.equals("")){pmap.put("bumenzhanghao", null);}else{pmap.put("bumenzhanghao", bumenzhanghao);}		if(mima==null||mima.equals("")){pmap.put("mima", null);}else{pmap.put("mima", mima);}		if(bumenmingcheng==null||bumenmingcheng.equals("")){pmap.put("bumenmingcheng", null);}else{pmap.put("bumenmingcheng", bumenmingcheng);}		if(fuzeren==null||fuzeren.equals("")){pmap.put("fuzeren", null);}else{pmap.put("fuzeren", fuzeren);}		if(lianxidianhua==null||lianxidianhua.equals("")){pmap.put("lianxidianhua", null);}else{pmap.put("lianxidianhua", lianxidianhua);}		if(dizhi==null||dizhi.equals("")){pmap.put("dizhi", null);}else{pmap.put("dizhi", dizhi);}		
		int total=yonggongbumenService.getCount(pmap);
		pageBean.setTotal(total);
		List<Yonggongbumen> list=yonggongbumenService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "yonggongbumenlisttp";
	}
	
	@RequestMapping("deleteYonggongbumen.do")
	public String deleteYonggongbumen(int id,HttpServletRequest request){
		yonggongbumenService.delete(id);
		String url = request.getHeader("Referer");
		return "redirect:"+url;
		//return "redirect:yonggongbumenList.do";
	}
	
	@RequestMapping("quchongYonggongbumen.do")
	public void quchongYonggongbumen(Yonggongbumen yonggongbumen,HttpServletResponse response){
		   Map<String,Object> map=new HashMap<String,Object>();
		   map.put("bumenzhanghao", yonggongbumen.getBumenzhanghao());
		   System.out.println("bumenzhanghao==="+yonggongbumen.getBumenzhanghao());
		   System.out.println("bumenzhanghao222==="+yonggongbumenService.quchongYonggongbumen(map));
		   JSONObject obj=new JSONObject();
		   if(yonggongbumenService.quchongYonggongbumen(map)!=null){
				 obj.put("info", "ng");
			   }else{
				   obj.put("info", "部门帐号可以用！");
				  
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
