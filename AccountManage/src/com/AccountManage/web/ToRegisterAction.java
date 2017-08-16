package com.AccountManage.web;

import com.opensymphony.xwork2.ActionSupport;

public class ToRegisterAction extends ActionSupport{
	/**
	 * 处理页面跳转
	 */
	private static final long serialVersionUID = 1L;
	@Override
	public String execute(){
		return "register";
	}

}
