package com.AccountManage.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.AccountManage.model.Account;
import com.AccountManage.model.Platform;
import com.AccountManage.model.Vip;
import com.AccountManage.util.AppException;
import com.AccountManage.util.DBUtil;

/**
 * vip账号数据读取类
 * 
 * @author zzy
 *
 */
public class Vip_AccountDB {

	/**
	 * 查询是否有相同平台名字
	 * 
	 * @param name
	 * @return
	 * @throws AppException
	 */
	public boolean isExist(String name) throws AppException {
		boolean flag = false; // 操作标志
		// 声明数据库对象、预编译对象和结果集对象
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;

		try {
			// 创建数据库连接
			conn = DBUtil.getConnection();
			// 声明操作语句：根据用户名查询用户编号，"?"为占位符
			String sql = "select id from platform where name = ?";
			// 预编译sql
			psmt = conn.prepareStatement(sql);
			// 为占位符设置值
			psmt.setString(1, name);
			// 执行此查询操作
			rs = psmt.executeQuery();
			// 查询到记录，则该账户名的用户存在，flag为true
			if (rs.next()) {
				flag = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new AppException("com.AccountManage.db.Vip_AccountDB.isExist");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new AppException("com.AccountManage.db.Vip_AccountDB.isExist");
		} finally {
			// 关闭数据库查询结果集
			DBUtil.closeResultSet(rs);

			// 关闭数据库查询指令
			DBUtil.closeStatement(psmt);

			// 关闭数据库连接
			DBUtil.closeConnection(conn);
		}
		return flag;
	}

	/**
	 * 根据帐号名称和密码查询id
	 * 
	 * @param name
	 * @param password
	 * @return
	 * @throws AppException
	 */
	public int getAccountId(String name, String password) throws AppException {
		int id = 0; // 用户编号
		// 声明数据库对象、预编译对象和结果集对象
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;

		try {
			// 创建数据库连接
			conn = DBUtil.getConnection();
			// 声明操作语句：根据用户名和密码查询用户编号，"?"为占位符
			String sql = "select id from account where name = ? and password = ?";
			// 预编译sql
			psmt = conn.prepareStatement(sql);
			// 为占位符设置值
			psmt.setString(1, name);
			psmt.setString(2, password);
			// 执行此查询操作
			rs = psmt.executeQuery();
			// 查询到记录，提取用户编号
			if (rs.next()) {
				id = rs.getInt("id");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new AppException("com.AccountManage.db.VipDB.login");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new AppException("com.AccountManage.db.VipDB.login");
		} finally {
			// 关闭数据库查询结果集
			DBUtil.closeResultSet(rs);

			// 关闭数据库查询指令
			DBUtil.closeStatement(psmt);

			// 关闭数据库连接
			DBUtil.closeConnection(conn);
		}
		return id;
	}

	/**
	 * 根据平台名称查询id
	 * 
	 * @param name
	 * @return
	 * @throws AppException
	 */
	public int getPlatId(String name) throws AppException {
		int id = 0; // 用户编号
		// 声明数据库对象、预编译对象和结果集对象
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;

		try {
			// 创建数据库连接
			conn = DBUtil.getConnection();
			// 声明操作语句：根据用户名和密码查询用户编号，"?"为占位符
			String sql = "select id from platform where name = ?";
			// 预编译sql
			psmt = conn.prepareStatement(sql);
			// 为占位符设置值
			psmt.setString(1, name);
			// 执行此查询操作
			rs = psmt.executeQuery();
			// 查询到记录，提取用户编号
			if (rs.next()) {
				id = rs.getInt("id");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new AppException("com.AccountManage.db.VipDB.login");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new AppException("com.AccountManage.db.VipDB.login");
		} finally {
			// 关闭数据库查询结果集
			DBUtil.closeResultSet(rs);

			// 关闭数据库查询指令
			DBUtil.closeStatement(psmt);

			// 关闭数据库连接
			DBUtil.closeConnection(conn);
		}
		return id;
	}

	/**
	 * 将会员账号和平台号存储到对应的表中，并且完成两者的关系表
	 * 
	 * @param account
	 * @param platform
	 * @return
	 * @throws AppException
	 */
	public boolean save(Vip vip,Account account, Platform platform) throws AppException {
		boolean flag = false; // 标记位，成功为true，失败为false
		// 判断对象若为空，则不进行保存操作
		if (account == null || platform == null) {
			return flag;
		}
		// 声明数据库连接对象，预编译对象
		Connection conn = null;
		PreparedStatement psmt = null;
		String sql = null;
		int count1 = 0;
		int count2 = 0;
		int count3 = 0;

		// 存储帐号信息
		try {
			// 创建数据库连接
			conn = DBUtil.getConnection();
			// 声明操作语句：将vip帐号信息保存到数据库中，"?"为占位符
			sql = "insert into account (name,password,level,over_time,del)" + " values(?,?,?,?,?)";
			System.out.print("账号注册:" + sql);
			// 预编译sql
			psmt = conn.prepareStatement(sql);
			// 为占位符设置值
			psmt.setString(1, account.getName());
			psmt.setString(2, account.getPassword());
			psmt.setInt(3, account.getLevel());
			psmt.setTimestamp(4, account.getTime());
			psmt.setInt(5, account.getDel());
			// 执行更新操作，返回受影响行数
			count1 = psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new AppException("com.AccountManage.db.Vip_AccountDB.save");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new AppException("com.AccountManage.db.Vip_AccountDB.save");
		} finally {
			// 关闭数据库查询指令
			DBUtil.closeStatement(psmt);
			// 关闭数据库连接
			DBUtil.closeConnection(conn);
		}

		// 存储平台信息
		if (!isExist(platform.getName())) {
			try {
				// 创建数据库连接
				conn = DBUtil.getConnection();

				sql = "insert into platform (name,other,del)" + " values(?,?,?)";
				System.out.print("平台注册:" + sql);
				psmt = conn.prepareStatement(sql);
				psmt.setString(1, platform.getName());
				psmt.setString(2, platform.getOther());
				psmt.setInt(3, platform.getDel());
				psmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
				throw new AppException("com.AccountManage.db.Vip_AccountDB.save");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new AppException("com.AccountManage.db.Vip_AccountDB.save");
			} finally {
				// 关闭数据库查询指令
				DBUtil.closeStatement(psmt);
				// 关闭数据库连接
				DBUtil.closeConnection(conn);
			}
		}

		try {
			// 创建数据库连接
			conn = DBUtil.getConnection();
			
			sql = "insert into platform_account (plat_id,account_id,other,del)" + " values(?,?,?,?)";
			System.out.print("平台帐号关系表注册:" + sql);
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, getPlatId(platform.getName()));
			psmt.setInt(2, getAccountId(account.getName(),account.getPassword()));
			psmt.setString(3,"");
			psmt.setInt(4,0);
			count2 = psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new AppException("com.AccountManage.db.Vip_AccountDB.save");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new AppException("com.AccountManage.db.Vip_AccountDB.save");
		} finally {
			// 关闭数据库查询指令
			DBUtil.closeStatement(psmt);
			// 关闭数据库连接
			DBUtil.closeConnection(conn);
		}
		
		try {
			VipDB vipDB = new VipDB();
			// 创建数据库连接
			conn = DBUtil.getConnection();
			
			sql = "insert into vip_account (vip_id,account_id,money_hour,del)" + " values(?,?,?,?)";
			System.out.print("平台帐号关系表注册:" + sql);
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, vipDB.login(vip.getName(), vip.getPassword()));
			psmt.setInt(2, getAccountId(account.getName(),account.getPassword()));
			psmt.setFloat(3,(float) 0.25);
			psmt.setInt(4,0);
			count3 = psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new AppException("com.AccountManage.db.Vip_AccountDB.save");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new AppException("com.AccountManage.db.Vip_AccountDB.save");
		} finally {
			// 关闭数据库查询指令
			DBUtil.closeStatement(psmt);
			// 关闭数据库连接
			DBUtil.closeConnection(conn);
		}
		
		// 如果受影响行数大于0，则操作成功
		if (count1 > 0 && count2>0 && count3 > 0) {
			flag = true;
		}

		return flag;
	}

	
	public boolean del(Vip vip, int id) throws AppException{
		boolean flag = false; // 标记位，成功为true，失败为false
		// 判断对象若为空，则不进行删除操作
		if (vip == null || id == 0) {
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
			sql = "delete from account where id = ?";
			System.out.print("账号删除:" + sql);
			// 预编译sql
			psmt = conn.prepareStatement(sql);
			// 为占位符设置值
			psmt.setInt(1,id);
			// 执行更新操作，返回受影响行数
			count = psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new AppException("com.AccountManage.db.Vip_AccountDB.del");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new AppException("com.AccountManage.db.Vip_AccountDB.del");
		} finally {
			// 关闭数据库查询指令
			DBUtil.closeStatement(psmt);
			// 关闭数据库连接
			DBUtil.closeConnection(conn);
		}
		
		if(count > 0){
			flag = true;
		}
		return flag;
	}
}
