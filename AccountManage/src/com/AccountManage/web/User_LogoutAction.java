package com.AccountManage.web;

import java.util.Map;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 用户登出Action
 * @author zzy
 *
 */
public class User_LogoutAction extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 注销用户，移除session中的用户信息，跳转到首页
	 */
	@ Override
	public String execute(){
		//初始化一个session对象
		Map<String, Object> session = ActionContext.getContext().getSession();
		//移除session中的用户信息
		session.remove("user");
		//跳转到首页
		return "index";
	}
}
