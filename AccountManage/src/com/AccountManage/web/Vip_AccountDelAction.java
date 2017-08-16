package com.AccountManage.web;


import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.AccountManage.model.Vip;
import com.AccountManage.service.Vip_AccountSev;
import com.AccountManage.util.AppException;

public class Vip_AccountDelAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//声明并初始化user用户账号信息服务层实现类
	private Vip_AccountSev vip_accountSev = new Vip_AccountSev();
	
	//获取form表单内容
	private HttpServletRequest req = ServletActionContext.getRequest();
	private int id= Integer.parseInt(req.getParameter("hidden"));
	private Vip vip = (Vip) req.getSession().getAttribute("vip");
	
	/**
	 * 注册处理
	 */
	@Override
	public String execute(){
		try {
			//调用用户信息服务层处理注册请求，注册成功则跳转至登陆页
			if(vip_accountSev.del(vip,id)){
				return "success";
			} else{//注册失败，则返回404页面
				return "404";
			}
		} catch (AppException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//系统异常，则跳转到404报错页面
			return "404";
		}
	}
}
