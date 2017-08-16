package com.AccountManage.service;

import com.AccountManage.db.VipDB;
import com.AccountManage.model.Vip;
import com.AccountManage.util.AppException;

/**
 * vip用户信息服务类
 */
public class VipSev {
	//初始化用户数据库访问层实现类
	private VipDB vipDB = new VipDB();
	
	/**
	 * 进行vip用户注册，注册成功则返回true，注册失败则返回false，
	 * 不区分是因为存在同名用户还是注册操作失败，统一为注册失败
	 * @param user 用户对象
	 * @return 注册成功返回true，失败则返回false
	 * @throws AppException
	 */
	public boolean register(Vip vip) throws AppException{
		boolean flag = false;
		try {
			//1.验证不存在同名用户
			if(! vipDB.isExist(vip.getName())){
				//2.不存在同名用户则进行保存操作
				flag = vipDB.save(vip);
			}
		} catch (AppException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new AppException("com.AccountManage.service.VipSev.register");
		}
		
		return flag;
	}
	
	/**
	 * 进行vip用户登录，如果查询到相应用户则返回存有信息的用户实体，否则实体为null
	 * @param name 用户名
	 * @param password 用户密码
	 * @return vip用户实体
	 * @throws AppException
	 */
	public Vip login(String name,String password) throws AppException{
		Vip vip = null;
		int id = 0;
		try {
			id = vipDB.login(name, password); //查询得到用户编号
			if(id > 0){
				//编号存在则返回用户实体
				vip = new Vip();
				vip = vipDB.getVip(id);
			}
		} catch (AppException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new AppException("com.AccountManage.service.VipSev.login");
		}
		
		return vip;
	}
}
