package com.AccountManage.web;


import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.AccountManage.model.User;
import com.AccountManage.service.User_AccountSev;
import com.AccountManage.util.AppException;

public class User_AccountReturnAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//声明并初始化user用户账号信息服务层实现类
	private User_AccountSev user_accountSev = new User_AccountSev();
	
	//获取form表单内容
	private HttpServletRequest req = ServletActionContext.getRequest();
	private int id= Integer.parseInt(req.getParameter("hidden"));
	private User user = (User) req.getSession().getAttribute("user");
	
	/**
	 * 注册处理
	 */
	@Override
	public String execute(){
		try {
			//调用用户信息服务层处理注册请求，注册成功则跳转至登陆页
			if(user_accountSev.reback(user,id)){
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