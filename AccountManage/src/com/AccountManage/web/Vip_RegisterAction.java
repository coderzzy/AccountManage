package com.AccountManage.web;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionSupport;

import com.AccountManage.service.VipSev;
import com.AccountManage.model.Vip;
import com.AccountManage.util.AppException;

public class Vip_RegisterAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//声明并初始化vip用户信息服务层实现类
	private VipSev vipSev = new VipSev();
	
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
		//声明并初始化Vip对象，接受注册信息
		Vip vip = new Vip();
		vip.setName(name);
		vip.setPassword(password);
		vip.setMobile(mobile);
		vip.setEmail(email);
		
		try {
			//调用用户信息服务层处理注册请求，注册成功则跳转至登陆页
			if(vipSev.register(vip)){
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

