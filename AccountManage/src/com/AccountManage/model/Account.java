package com.AccountManage.model;

import java.sql.Timestamp;

/**
 * 账号实体类
 * @author zzy
 *
 */
public class Account {
	private int id; //账号编号
	private String name; // 账号名称
	private String password; // 账号密码
	private int level; // 账号等级
	private Timestamp dt; //过期时间
	private int del; //删除标记，0未删除，1为删除

	/**
	 * 无参构造函数，赋初值
	 */
	public Account() {
		this.name = "";
		this.password = "";
		this.level = 0;
		this.dt = null;
		this.del = 0;
	}

	/**
	 * get和set方法
	 */
	public int getId(){
		return id;
	}
	
	public String getName() {
		return name;
	}

	public String getPassword() {
		return password;
	}

	public int getLevel(){
		return level;
	}
	
	public Timestamp getTime() {
		return dt;
	}

	public int getDel(){
		return del;
	}
	
	public void setId(int id){
		this.id = id;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setLevel(int level){
		this.level = level;
	}
	
	public void setTime(Timestamp dt) {
		this.dt = dt;
	}
	
	public void setDel(int del){
		this.del = del;
	}
}
