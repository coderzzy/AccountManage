package com.AccountManage.web;

import java.sql.Timestamp;
import java.util.Map;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import com.AccountManage.service.Vip_AccountSev;
import com.AccountManage.model.Account;
import com.AccountManage.model.Platform;
import com.AccountManage.model.Vip;
import com.AccountManage.util.AppException;

public class Vip_AccountRegisterAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//声明并初始化vip用户信息服务层实现类
	private Vip_AccountSev vip_accountSev = new Vip_AccountSev();
	
	//获取form表单内容
	private HttpServletRequest req = ServletActionContext.getRequest();
	private String name = req.getParameter("name");
	private String password = req.getParameter("password");
	private String level = req.getParameter("level");
	private String platform_name = req.getParameter("platform");
	private String overtime = req.getParameter("overtime");
	private Vip vip = (Vip) req.getSession().getAttribute("vip");
	
	/**
	 * 注册处理
	 */
	@Override
	public String execute(){
		//声明并初始化对象，接受注册信息
		Account account = new Account();
		Platform platform = new Platform();
		account.setName(name);
		account.setPassword(password);
		account.setLevel(Integer.parseInt(level));
		account.setTime(Timestamp.valueOf(overtime));
		platform.setName(platform_name);
		
		try {
			//调用用户信息服务层处理注册请求，注册成功则跳转至登陆页
			if(vip_accountSev.register(vip,account,platform)){
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

