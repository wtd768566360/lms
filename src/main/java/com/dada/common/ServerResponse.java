package com.dada.common;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import java.io.Serializable;

@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class ServerResponse<T> implements Serializable {
	private int code;

	private String msg;

	private T data;

	private String count;

	private ServerResponse(int code) {
		this.code = code;
	}

	private ServerResponse(int code, T data) {
		this.code = code;
		this.data = data;
	}

	private ServerResponse(int code, String msg, T data) {
		this.code = code;
		this.msg = msg;
		this.data = data;
	}

	private ServerResponse(int code, String msg, String count, T data) {
		this.code = code;
		this.msg = msg;
		this.data = data;
		this.count = count;
	}

	private ServerResponse(int code, String msg) {
		this.code = code;
		this.msg = msg;
	}

	@JsonIgnore
	// 使之不在json序列化结果当中
	public boolean isSuccess() {
		return this.code == ResponseCode.SUCCESS.getCode();
	}

	public int getCode() {
		return code;
	}

	public T getData() {
		return data;
	}

	public String getMsg() {
		return msg;
	}

	public String getCount() {
		return count;
	}
	
	public static <T> ServerResponse<T> createBySuccess() {
		return new ServerResponse<T>(ResponseCode.SUCCESS.getCode());
	}

	public static <T> ServerResponse<T> createBySuccessMessage(String msg) {
		return new ServerResponse<T>(ResponseCode.SUCCESS.getCode(), msg);
	}

	public static <T> ServerResponse<T> createBySuccess(T data) {
		return new ServerResponse<T>(ResponseCode.SUCCESS.getCode(), data);
	}

	public static <T> ServerResponse<T> createBySuccess(String msg, T data) {
		return new ServerResponse<T>(ResponseCode.SUCCESS.getCode(), msg, data);
	}

	/**
	 * 
	 * <B>概要说明：分页</B><BR>
	 * @param msg:消息
	 * @param count:查询数据总条数
	 * @param data:结果集
	 * @return
	 */
	public static <T> ServerResponse<T> createByPageSuccess(String msg, String count, T data) {
		return new ServerResponse<T>(ResponseCode.SUCCESS.getCode(), msg, count, data);
	}

	public static <T> ServerResponse<T> createByError() {
		return new ServerResponse<T>(ResponseCode.ERROR.getCode(), ResponseCode.ERROR.getDesc());
	}

	public static <T> ServerResponse<T> createByErrorMessage(String errorMessage) {
		return new ServerResponse<T>(ResponseCode.ERROR.getCode(), errorMessage);
	}

	public static <T> ServerResponse<T> createByErrorCodeMessage(int errorCode, String errorMessage) {
		return new ServerResponse<T>(errorCode, errorMessage);
	}
}
