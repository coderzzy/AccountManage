package com.AccountManage.model;

/**
 * vip用户实体类
 */
public class Vip {
	private int id; //vip用户编号
	private String name; // vip用户昵称
	private String password; // vip用户密码
	private String mobile; // 手机
	private String email; // 邮箱
	private int del; //删除标记，0未删除，1为删除

	/**
	 * 无参构造函数，赋初值
	 */
	public Vip() {
		this.name = "";
		this.password = "";
		this.mobile = "";
		this.email = "";
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
	
	public void setDel(int del){
		this.del = del;
	}
}
