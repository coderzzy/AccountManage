package com.AccountManage.web;

import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import com.AccountManage.service.VipSev;
import com.AccountManage.model.Vip;
import com.AccountManage.util.AppException;

public class Vip_LoginAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//声明并初始化用户信息服务层实现类
	private VipSev vipSev = new VipSev();
		
	//获取form表单内容
	HttpServletRequest req = ServletActionContext.getRequest();
	String name = req.getParameter("name");
	String password = req.getParameter("password");
	
	/**
	 * vip用户登陆处理,返回vip用户对象
	 */
	@Override
	public String execute(){
		Vip vip = new Vip();
		try {
			//登录查询
			vip = vipSev.login(name, password);
			if(vip != null){
				//初始化一个session对象
				Map<String, Object> session = ActionContext.getContext().getSession();
				// 查询到匹配用户，保存至session中，跳转到用户中心页
				session.put("vip", vip);
				return "vip_welcome";
			}
			else{
				//登录失败，返回错误页面，提示错误信息
				return "error";
			}
		} catch (AppException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//异常返回404页面
			return "404";
		}
	}
}
