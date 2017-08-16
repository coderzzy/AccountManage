package com.AccountManage.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.AccountManage.model.Vip;
import com.AccountManage.util.AppException;
import com.AccountManage.util.DBUtil;

/**
 * vip用户数据访问类
 */
public class VipDB {

	/**
	 * 查询是否有同名vip用户存在
	 * 
	 * @param name
	 *            vip用户名
	 * @retrun 有同名vip用户返回true，否则返回false
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
			String sql = "select id from vip where name = ?";
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
			throw new AppException("com.AccountManage.db.VipDB.isExist");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new AppException("com.AccountManage.db.VipDB.isExist");
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
	 * 将vip用户实体存放进数据库
	 * 
	 * @param vip
	 *            vip用户实体
	 * @retrun 成功返回true，否则返回false
	 * @throws AppException
	 */
	public boolean save(Vip vip) throws AppException {
		boolean flag = false; // 标记位，成功为true，失败为false
		// 判断vip用户对象若为空，则不进行保存操作
		if (vip == null) {
			return flag;
		}
		// 声明数据库连接对象，预编译对象
		Connection conn = null;
		PreparedStatement psmt = null;

		try {
			// 创建数据库连接
			conn = DBUtil.getConnection();
			// 声明操作语句：将vip用户信息保存到数据库中，"?"为占位符
			String sql = "insert into vip (name,password,mobile,email,del)"
					+ " values(?,?,?,?,?)";
			System.out.print("用户注册:" + sql);
			// 预编译sql
			psmt = conn.prepareStatement(sql);
			// 为占位符设置值
			psmt.setString(1, vip.getName());
			psmt.setString(2, vip.getPassword());
			psmt.setString(3, vip.getMobile());
			psmt.setString(4, vip.getEmail());
			psmt.setInt(5, vip.getDel());
			// 执行更新操作，返回受影响行数
			int count = psmt.executeUpdate();
			// 如果受影响行数大于0，则操作成功
			if (count > 0) {
				flag = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new AppException("com.AccountManage.db.VipDB.save");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new AppException("com.AccountManage.db.VipDB.save");
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
	 *            vip用户名
	 * @param password
	 *            vip用户密码
	 * @return vip用户编号
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
			String sql = "select id from vip where name = ? and password = ?";
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
	 * 根据用户编号查询用户对象
	 * 
	 * @param id
	 *            vip用户编号
	 * @return vip用户对象
	 * @throws AppException
	 */
	public Vip getVip(int id) throws AppException {
		Vip vip = null; // 声明用户对象
		// 声明数据库对象、预编译对象和结果集对象
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;

		try {
			// 创建数据库连接
			conn = DBUtil.getConnection();
			// 声明操作语句：根据用户编号查询用户对象，"?"为占位符
			String sql = "select * from vip where id = ?";
			// 预编译sql
			psmt = conn.prepareStatement(sql);
			// 为占位符设置值
			psmt.setInt(1, id);
			// 执行此查询操作
			rs = psmt.executeQuery();
			// 查询到记录，用用户实体保存信息
			if (rs.next()) {
				vip = new Vip();
				vip.setId(rs.getInt("id"));
				vip.setName(rs.getString("name"));
				vip.setPassword(rs.getString("password"));
				vip.setEmail(rs.getString("email"));
				vip.setMobile(rs.getString("mobile"));
				vip.setDel(rs.getInt("del"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new AppException("com.AccountManage.db.VipDB.getVip");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new AppException("com.AccountManage.db.VipDB.getVip");
		} finally {
			// 关闭数据库查询结果集
			DBUtil.closeResultSet(rs);

			// 关闭数据库查询指令
			DBUtil.closeStatement(psmt);

			// 关闭数据库连接
			DBUtil.closeConnection(conn);
		}
		return vip;
	}
}
