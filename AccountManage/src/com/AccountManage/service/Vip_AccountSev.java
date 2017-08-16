package com.AccountManage.service;

import com.AccountManage.db.Vip_AccountDB;
import com.AccountManage.model.Account;
import com.AccountManage.model.Platform;
import com.AccountManage.model.Vip;
import com.AccountManage.util.AppException;

public class Vip_AccountSev {
	// 初始化帐号数据库访问层实现类
	private Vip_AccountDB vip_accountDB = new Vip_AccountDB();

	
	public boolean register(Vip vip,Account account,Platform platform) throws AppException {
		boolean flag = false;
		try {
				flag = vip_accountDB.save(vip,account,platform);
		} catch (AppException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new AppException("com.AccountManage.service.Vip_AccountSev.register");
		}
		return flag;
	}


	public boolean del(Vip vip, int id) throws AppException{
		boolean flag = false;
		try {
				flag = vip_accountDB.del(vip,id);
		} catch (AppException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new AppException("com.AccountManage.service.Vip_AccountSev.del");
		}
		return flag;
	}
}
