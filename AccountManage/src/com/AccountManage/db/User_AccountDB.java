package com.AccountManage.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.AccountManage.model.Account;
import com.AccountManage.model.Platform;
import com.AccountManage.model.User;
import com.AccountManage.model.Vip;
import com.AccountManage.util.AppException;
import com.AccountManage.util.DBUtil;

public class User_AccountDB {
	/**
	 * 根据账号id返回账号对象
	 * 
	 * @param id
	 * @return
	 * @throws AppException
	 */
	public Account getAccount(int id) throws AppException {
		Account account = null; // 声明账号对象
		// 声明数据库对象、预编译对象和结果集对象
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;

		try {
			// 创建数据库连接
			conn = DBUtil.getConnection();
			// 声明操作语句：根据用户编号查询用户对象，"?"为占位符
			String sql = "select * from account where id = ?";
			// 预编译sql
			psmt = conn.prepareStatement(sql);
			// 为占位符设置值
			psmt.setInt(1, id);
			// 执行此查询操作
			rs = psmt.executeQuery();
			// 查询到记录，用用户实体保存信息
			if (rs.next()) {
				account = new Account();
				account.setId(rs.getInt("id"));
				account.setName(rs.getString("name"));
				account.setPassword(rs.getString("password"));
				account.setLevel(rs.getInt("level"));
				account.setDel(rs.getInt("del"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new AppException("com.AccountManage.db.User_AccountDB.getAccount");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new AppException("com.AccountManage.db.User_AccountDB.getAccount");
		} finally {
			// 关闭数据库查询结果集
			DBUtil.closeResultSet(rs);

			// 关闭数据库查询指令
			DBUtil.closeStatement(psmt);

			// 关闭数据库连接
			DBUtil.closeConnection(conn);
		}
		return account;
	}

	/**
	 * 将用户和账号存到对应的关系表中
	 * 
	 * @param user
	 * @param id
	 * @return
	 * @throws AppException
	 */
	public boolean save(User user, int id) throws AppException {
		// 获得当前租赁时间作为租赁时间
		Timestamp time = new Timestamp(System.currentTimeMillis());

		boolean flag = false; // 标记位，成功为true，失败为false
		// 判断对象若为空，则不进行保存操作
		if (user == null || id == 0) {
			return flag;
		}
		// 声明数据库连接对象，预编译对象
		Connection conn = null;
		PreparedStatement psmt = null;
		String sql = null;
		int count = 0;

		// 存储帐号信息
		try {
			// 创建数据库连接
			conn = DBUtil.getConnection();
			// 声明操作语句：将vip帐号信息保存到数据库中，"?"为占位符
			sql = "insert into user_account (user_id,account_id,lend_time,return_time,money_hour,del)"
					+ " values(?,?,?,?,?,?)";
			System.out.print("账号租赁:" + sql);
			// 预编译sql
			psmt = conn.prepareStatement(sql);
			// 为占位符设置值
			psmt.setInt(1, user.getId());
			psmt.setInt(2, id);
			psmt.setTimestamp(3, time);
			psmt.setTimestamp(4, time); // 归还时间和借出时间相同视为未归还
			psmt.setFloat(5, (float) 0.25);
			psmt.setInt(6, 0);
			// 执行更新操作，返回受影响行数
			count = psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new AppException("com.AccountManage.db.User_AccountDB.save");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new AppException("com.AccountManage.db.User_AccountDB.save");
		} finally {
			// 关闭数据库查询指令
			DBUtil.closeStatement(psmt);
			// 关闭数据库连接
			DBUtil.closeConnection(conn);
		}

		// 如果受影响行数大于0，则操作成功
		if (count > 0) {
			flag = true;
		}

		return flag;
	}

	public boolean update(User user, int id) throws AppException {
		// 获得当前租赁时间作为归还时间
		Timestamp time = new Timestamp(System.currentTimeMillis());

		boolean flag = false; // 标记位，成功为true，失败为false
		// 判断对象若为空，则不进行操作
		if (user == null || id == 0) {
			return flag;
		}
		// 声明数据库连接对象，预编译对象
		Connection conn = null;
		PreparedStatement psmt = null;
		String sql = null;
		int count = 0;

		// 存储帐号信息
		try {
			// 创建数据库连接
			conn = DBUtil.getConnection();
			// 声明操作语句：将vip帐号信息保存到数据库中，"?"为占位符
			sql = "update user_account set return_time = ? where user_id = ? and account_id = ?";
			System.out.print("账号归还:" + sql);
			// 预编译sql
			psmt = conn.prepareStatement(sql);
			// 为占位符设置值
			psmt.setTimestamp(1, time);
			psmt.setInt(2, user.getId());
			psmt.setInt(3, id);
			// 执行更新操作，返回受影响行数
			count = psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new AppException("com.AccountManage.db.User_AccountDB.update");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new AppException("com.AccountManage.db.User_AccountDB.update");
		} finally {
			// 关闭数据库查询指令
			DBUtil.closeStatement(psmt);
			// 关闭数据库连接
			DBUtil.closeConnection(conn);
		}

		// 如果受影响行数大于0，则操作成功
		if (count > 0) {
			flag = true;
		}

		return flag;
	}
}
