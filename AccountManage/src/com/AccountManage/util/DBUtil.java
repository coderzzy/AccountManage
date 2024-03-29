package com.AccountManage.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 数据库连接工具类
 * @author zzy
 *
 */
public class DBUtil {
	
	private static String user="root"; //数据库用户名
	private static String password="zzyyzz"; //密码   
	private static String dbName="account_manage"; //数据库名  
	private static String url="jdbc:mysql://localhost/"+dbName+"?useUnicode=true&amp;"+"characterEncoding=UTF-8"; //数据库连接字符串,编码为utf-8
	
	//类加载时，执行此静态代码段
	static{
		//加载驱动
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.print("驱动加载失败!");
		}
	}
	
	/**
	 * 创建数据库连接
	 * @return 创建连接成功，返回数据库连接对象；否则返回null
	 */
	public static Connection getConnection(){
		Connection conn = null;  //连接类
		try {
			conn = DriverManager.getConnection(url,user,password);
			System.out.print("connect success!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
	
	/**
	 * 关闭数据库连接
	 * @param Connection 数据库连接对象
	 */
	public static void closeConnection(Connection conn){
		try {
			if((conn != null)&&(! conn.isClosed())){
				conn.close();
				conn = null;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 关闭数据库查询指令
	 * @param PreparedStatement 数据库查询指令
	 */
	public static void closeStatement(PreparedStatement pst){
		try {
			if ((pst != null) && (!pst.isClosed())) {
				pst.close();
				pst = null;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 关闭数据库查询结果集
	 * @param ResultSet 数据库查询结果集
	 */
	public static void closeResultSet(ResultSet rs){
		try {
			if ((rs != null) && (!rs.isClosed())) {
				rs.close();
				rs = null;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
