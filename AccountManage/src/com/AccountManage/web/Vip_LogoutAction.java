package com.AccountManage.web;

import java.util.Map;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * vip用户登出Action
 * @author zzy
 *
 */
public class Vip_LogoutAction extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 注销vip用户，移除session中的用户信息，跳转到首页
	 */
	@ Override
	public String execute(){
		//初始化一个session对象
		Map<String, Object> session = ActionContext.getContext().getSession();
		//移除session中的用户信息
		session.remove("vip");
		//跳转到首页
		return "index";
	}
}
