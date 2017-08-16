package com.AccountManage.service;

import com.AccountManage.db.UserDB;
import com.AccountManage.model.User;
import com.AccountManage.util.AppException;

/**
 * 用户信息服务类
 */
public class UserSev {
	//初始化用户数据库访问层实现类
	private UserDB userDB = new UserDB();
	
	/**
	 * 进行用户注册，注册成功则返回true，注册失败则返回false，
	 * 不区分是因为存在同名用户还是注册操作失败，统一为注册失败
	 * @param user 用户对象
	 * @return 注册成功返回true，失败则返回false
	 * @throws AppException
	 */
	public boolean register(User user) throws AppException{
		boolean flag = false;
		try {
			//1.验证不存在同名用户
			if(! userDB.isExist(user.getName())){
				//2.不存在同名用户则进行保存操作
				flag = userDB.save(user);
			}
		} catch (AppException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new AppException("com.AccountManage.service.UserSev.register");
		}
		
		return flag;
	}
	
	/**
	 * 进行用户登录，如果查询到相应用户则返回存有信息的用户实体，否则实体为null
	 * @param name 用户名
	 * @param password 用户密码
	 * @return 用户实体
	 * @throws AppException
	 */
	public User login(String name,String password) throws AppException{
		User user = null;
		int id = 0;
		try {
			id = userDB.login(name, password); //查询得到用户编号
			if(id > 0){
				//编号存在则返回用户实体
				user = new User();
				user = userDB.getUser(id);
			}
		} catch (AppException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new AppException("com.AccountManage.service.UserSev.login");
		}
		
		return user;
	}
}
