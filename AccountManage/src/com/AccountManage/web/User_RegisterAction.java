package com.AccountManage.web;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionSupport;

import com.AccountManage.service.UserSev;
import com.AccountManage.model.User;
import com.AccountManage.util.AppException;

public class User_RegisterAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//声明并初始化用户信息服务层实现类
	private UserSev userSev = new UserSev();
	
	//获取form表单内容
	private HttpServletRequest req = ServletActionContext.getRequest();
	private String name = req.getParameter("name");
	private String password = req.getParameter("password");
	private String mobile = req.getParameter("mobile");
	private String email = req.getParameter("email");
	
	/**
	 * 注册处理
	 */
	@Override
	public String execute(){
		//声明并初始化User对象，接受注册信息
		User user = new User();
		user.setName(name);
		user.setPassword(password);
		user.setMobile(mobile);
		user.setEmail(email);
		
		try {
			//调用用户信息服务层处理注册请求，注册成功则跳转至登陆页
			if(userSev.register(user)){
				return "login";
			} else{//注册失败，则返回注册页面
				return "register";
			}
		} catch (AppException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//系统异常，则跳转到404报错页面
			return "404";
		}
	}
}

