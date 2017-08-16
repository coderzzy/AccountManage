package com.AccountManage.model;

/**
 * 平台实体类
 * @author zzy
 *
 */
public class Platform {
	private int id;
	private String name;
	private String other;
	private int del;
	
	public Platform(){
		this.id = 0;
		this.name = "";
		this.other = "";
		this.del = 0;
	}
	
	public int getId(){
		return id;
	}
	
	public String getName(){
		return name;
	}
	
	public String getOther(){
		return other;
	}
	
	public int getDel(){
		return del;
	}
	
	public void setId(int id){
		this.id = id;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public void setOther(String other){
		this.other = other;
	}
	
	public void setDel(int del){
		this.del = del;
	}
}
