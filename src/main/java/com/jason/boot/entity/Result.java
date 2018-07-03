package com.jason.boot.entity;
/**
 * 返回结果实体类
 * @author jason
 *
 * @param <T>
 */
public class Result<T> {
	public static final int SUCCESS_CODE=200;//请求成功,符合预期结果
	public static final int ERROR_CODE=250;//系统异常
	public static final int OTHER_CODE=211;//请求成功，但与预期不符（请求未得到数据）
	public static final String SUCCESS_MSG="SUCCESS";
	public static final String ERROR_MSG="ERROR";
	private int code;
	private String msg;
	private T data;
	public Result(){
		
	}
	public Result(int code,String msg){
		this.setCode(code);
		this.setMsg(msg);
	}
	public Result(int code,String msg,T data){
		this(code,msg);
		if(data != null){
			this.setData(data);
		}else{
			this.setCode(OTHER_CODE);
		}
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public String toString(){
		return "【code="+code+"  msg="+msg+"】";
	}
}
