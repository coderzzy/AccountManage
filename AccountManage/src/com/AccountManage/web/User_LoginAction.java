package com.AccountManage.web;

import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import com.AccountManage.service.UserSev;
import com.AccountManage.model.User;
import com.AccountManage.util.AppException;

public class User_LoginAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//声明并初始化用户信息服务层实现类
	private UserSev userSev = new UserSev();
		
	//获取form表单内容
	HttpServletRequest req = ServletActionContext.getRequest();
	String name = req.getParameter("name");
	String password = req.getParameter("password");
	
	/**
	 * 用户登陆处理,返回用户对象
	 */
	@Override
	public String execute(){
		User user = new User();
		try {
			//登录查询
			user = userSev.login(name, password);
			if(user != null){
				//初始化一个session对象
				Map<String, Object> session = ActionContext.getContext().getSession();
				// 查询到匹配用户，保存至session中，跳转到用户中心页
				session.put("user", user);
				return "user_welcome";
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
