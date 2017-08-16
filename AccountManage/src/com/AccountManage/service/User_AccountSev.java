package com.AccountManage.service;

import com.AccountManage.db.User_AccountDB;
import com.AccountManage.model.User;
import com.AccountManage.util.AppException;

public class User_AccountSev {
	// 初始化帐号数据库访问层实现类
		private User_AccountDB user_accountDB = new User_AccountDB();

		public boolean register(User user,int id) throws AppException {
			boolean flag = false;
			try {
					flag = user_accountDB.save(user,id);
			} catch (AppException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new AppException("com.AccountManage.service.User_AccountSev.register");
			}
			return flag;
		}

		public boolean reback(User user, int id) throws AppException {
			// TODO Auto-generated method stub
			boolean flag = false;
			try {
					flag = user_accountDB.update(user,id);
			} catch (AppException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new AppException("com.AccountManage.service.User_AccountSev.register");
			}
			return flag;
		}
}
