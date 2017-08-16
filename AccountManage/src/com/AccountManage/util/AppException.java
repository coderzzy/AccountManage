package com.AccountManage.util;

/**
 * 自定义异常类
 * @author zzy
 *
 */
public class AppException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int exceptionCode; //异常编号
	private String message; //异常消息
	
	/**
	 * 构造方法，设置异常消息
	 * 
	 * @param message 异常消息
	 */
	public AppException(String message){
		this.message = message;
	}
	
	/**
	 * 构造方法，设置异常消息和异常编号
	 * 
	 * @param message 异常消息
	 * @param exceptionCode 异常编号
	 */
	public AppException(String message,int exceptionCode){
		this.message = message;
		this.exceptionCode = exceptionCode;
	}
	
	/**
	 * 获取异常编号
	 * 
	 * @return 异常编号
	 */
	public int getExceptionCode(){
		return exceptionCode;
	}
	
	/**
	 * 获取详细的异常消息
	 * 
	 * @return detailMessage
	 */
	public String getMessage(){
		String detailMessage = "Detail message:"+exceptionCode+" "+message;
		return detailMessage;
	}
}
