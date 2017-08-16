package com.AccountManage.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.AccountManage.model.User;
import com.AccountManage.util.AppException;
import com.AccountManage.util.DBUtil;

/**
 * 用户数据访问类
 */
public class UserDB {

	/**
	 * 查询是否有同名用户存在
	 * 
	 * @param name
	 *            用户名
	 * @retrun 有同名用户返回true，否则返回false
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
			String sql = "select id from user where name = ?";
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
			throw new AppException("com.AccountManage.db.UserDB.isExist");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new AppException("com.AccountManage.db.UserDB.isExist");
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
	 * 将用户实体存放进数据库
	 * 
	 * @param user
	 *            用户实体
	 * @retrun 成功返回true，否则返回false
	 * @throws AppException
	 */
	public boolean save(User user) throws AppException {
		boolean flag = false; // 标记位，成功为true，失败为false
		// 判断用户对象若为空，则不进行保存操作
		if (user == null) {
			return flag;
		}
		// 声明数据库连接对象，预编译对象
		Connection conn = null;
		PreparedStatement psmt = null;

		try {
			// 创建数据库连接
			conn = DBUtil.getConnection();
			// 声明操作语句：将用户信息保存到数据库中，"?"为占位符
			String sql = "insert into user (name,password,mobile,email,honest_level,del)"
					+ " values(?,?,?,?,?,?)";
			System.out.print("用户注册:" + sql);
			// 预编译sql
			psmt = conn.prepareStatement(sql);
			// 为占位符设置值
			psmt.setString(1, user.getName());
			psmt.setString(2, user.getPassword());
			psmt.setString(3, user.getMobile());
			psmt.setString(4, user.getEmail());
			psmt.setInt(5, user.getHonest_level());
			psmt.setInt(6, user.getDel());
			// 执行更新操作，返回受影响行数
			int count = psmt.executeUpdate();
			// 如果受影响行数大于0，则操作成功
			if (count > 0) {
				flag = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new AppException("com.AccountManage.db.UserDB.save");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new AppException("com.AccountManage.db.UserDB.save");
		} finally {
			// 关闭数据库查询指令
			DBUtil.closeStatement(psmt);

			// 关闭数据库连接
			DBUtil.closeConnection(conn);
		}

		return flag;
	}

	/**
	 * 根据用户名、密码查询用户编号
	 * 
	 * @param name
	 *            用户名
	 * @param password
	 *            用户密码
	 * @return 用户编号
	 * @throws AppException
	 */
	public int login(String name, String password) throws AppException {
		int id = 0; // 用户编号
		// 声明数据库对象、预编译对象和结果集对象
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;

		try {
			// 创建数据库连接
			conn = DBUtil.getConnection();
			// 声明操作语句：根据用户名和密码查询用户编号，"?"为占位符
			String sql = "select id from user where name = ? and password = ?";
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
			throw new AppException("com.AccountManage.db.UserDB.login");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new AppException("com.AccountManage.db.UserDB.login");
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
	 * 根据用户编号查询用户对象
	 * 
	 * @param id
	 *            用户编号
	 * @return 用户对象
	 * @throws AppException
	 */
	public User getUser(int id) throws AppException {
		User user = null; // 声明用户对象
		// 声明数据库对象、预编译对象和结果集对象
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;

		try {
			// 创建数据库连接
			conn = DBUtil.getConnection();
			// 声明操作语句：根据用户编号查询用户对象，"?"为占位符
			String sql = "select * from user where id = ?";
			// 预编译sql
			psmt = conn.prepareStatement(sql);
			// 为占位符设置值
			psmt.setInt(1, id);
			// 执行此查询操作
			rs = psmt.executeQuery();
			// 查询到记录，用用户实体保存信息
			if (rs.next()) {
				user = new User();
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("name"));
				user.setPassword(rs.getString("password"));
				user.setEmail(rs.getString("email"));
				user.setMobile(rs.getString("mobile"));
				user.setHonest_level(rs.getInt("honest_level"));
				user.setDel(rs.getInt("del"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new AppException("com.AccountManage.db.UserDB.getUser");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new AppException("com.AccountManage.db.UserDB.getUser");
		} finally {
			// 关闭数据库查询结果集
			DBUtil.closeResultSet(rs);

			// 关闭数据库查询指令
			DBUtil.closeStatement(psmt);

			// 关闭数据库连接
			DBUtil.closeConnection(conn);
		}
		return user;
	}
}
