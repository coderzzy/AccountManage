package com.AccountManage.model;

/**
 * 用户实体类
 */
public class User {
	private int id; //用户编号
	private String name; // 用户昵称
	private String password; // 用户密码
	private String mobile; // 手机
	private String email; // 邮箱
	private int honest_level; //用户诚信等级初始值为0
	private int del; //删除标记，0未删除，1为删除

	/**
	 * 无参构造函数，赋初值
	 */
	public User() {
		this.name = "";
		this.password = "";
		this.mobile = "";
		this.email = "";
		this.honest_level = 0;
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

	public String getMobile() {
		return mobile;
	}

	public String getEmail() {
		return email;
	}
	
	public int getHonest_level(){
		return honest_level;
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

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setHonest_level(int honest_level){
		this.honest_level = honest_level;
	}
	
	public void setDel(int del){
		this.del = del;
	}
}
