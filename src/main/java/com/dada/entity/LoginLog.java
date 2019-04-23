package com.dada.entity;

import java.util.Date;

public class LoginLog {
	/**
	 * ID
	 */
	private String id;

	/**
	 * 登录IP
	 */
	private String loginIp;

	/**
	 * 登录用户ID
	 */
	private String loginId;

	/**
	 * 登录名称
	 */
	private String loginName;

	/**
	 * 登录时间
	 */
	private Date loginTime;

	/**
	 * 访问资源
	 */
	private String accessUri;

	/**
	 * 操作请求
	 */
	private String operation;

	/**
	 * 登录类型:LOGIN_IN-登录、LOGIN_OUT-登出
	 */
	private String loginType;

	/**
	 * 登录状态:SUCCESS-登录成功、ERROR-登录失败
	 */
	private String status;

	/**
	 * 备注
	 */
	private String remark;

	/**
	 * <B>构造方法</B><BR>
	 * 
	 * @param id
	 * @param loginIp
	 * @param loginId
	 * @param loginName
	 * @param loginTime
	 * @param accessUri
	 * @param operation
	 * @param loginType
	 * @param status
	 * @param remark
	 */
	public LoginLog(String id, String loginIp, String loginId, String loginName, Date loginTime, String accessUri,
			String operation, String loginType, String status, String remark) {
		super();
		this.id = id;
		this.loginIp = loginIp;
		this.loginId = loginId;
		this.loginName = loginName;
		this.loginTime = loginTime;
		this.accessUri = accessUri;
		this.operation = operation;
		this.loginType = loginType;
		this.status = status;
		this.remark = remark;
	}

	/**
	 * ID
	 * 
	 * @return id ID
	 */
	public String getId() {
		return id;
	}

	/**
	 * ID
	 * 
	 * @param id
	 *            ID
	 */
	public void setId(String id) {
		this.id = id == null ? null : id.trim();
	}

	/**
	 * 登录IP
	 * 
	 * @return login_ip 登录IP
	 */
	public String getLoginIp() {
		return loginIp;
	}

	/**
	 * 登录IP
	 * 
	 * @param loginIp
	 *            登录IP
	 */
	public void setLoginIp(String loginIp) {
		this.loginIp = loginIp == null ? null : loginIp.trim();
	}

	/**
	 * 登录用户ID
	 * 
	 * @return login_id 登录用户ID
	 */
	public String getLoginId() {
		return loginId;
	}

	/**
	 * 登录用户ID
	 * 
	 * @param loginId
	 *            登录用户ID
	 */
	public void setLoginId(String loginId) {
		this.loginId = loginId == null ? null : loginId.trim();
	}

	/**
	 * 登录名称
	 * 
	 * @return login_name 登录名称
	 */
	public String getLoginName() {
		return loginName;
	}

	/**
	 * 登录名称
	 * 
	 * @param loginName
	 *            登录名称
	 */
	public void setLoginName(String loginName) {
		this.loginName = loginName == null ? null : loginName.trim();
	}

	/**
	 * 登录时间
	 * 
	 * @return login_time 登录时间
	 */
	public Date getLoginTime() {
		return loginTime;
	}

	/**
	 * 登录时间
	 * 
	 * @param loginTime
	 *            登录时间
	 */
	public void setLoginTime(Date loginTime) {
		this.loginTime = loginTime;
	}

	/**
	 * 访问资源
	 * 
	 * @return access_uri 访问资源
	 */
	public String getAccessUri() {
		return accessUri;
	}

	/**
	 * 访问资源
	 * 
	 * @param accessUri
	 *            访问资源
	 */
	public void setAccessUri(String accessUri) {
		this.accessUri = accessUri == null ? null : accessUri.trim();
	}

	/**
	 * 操作请求
	 * 
	 * @return operation 操作请求
	 */
	public String getOperation() {
		return operation;
	}

	/**
	 * 操作请求
	 * 
	 * @param operation
	 *            操作请求
	 */
	public void setOperation(String operation) {
		this.operation = operation == null ? null : operation.trim();
	}

	/**
	 * 登录类型:LOGIN_IN-登录、LOGIN_OUT-登出
	 * 
	 * @return login_type 登录类型:LOGIN_IN-登录、LOGIN_OUT-登出
	 */
	public String getLoginType() {
		return loginType;
	}

	/**
	 * 登录类型:LOGIN_IN-登录、LOGIN_OUT-登出
	 * 
	 * @param loginType
	 *            登录类型:LOGIN_IN-登录、LOGIN_OUT-登出
	 */
	public void setLoginType(String loginType) {
		this.loginType = loginType == null ? null : loginType.trim();
	}

	/**
	 * 登录状态:SUCCESS-登录成功、ERROR-登录失败
	 * 
	 * @return status 登录状态:SUCCESS-登录成功、ERROR-登录失败
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * 登录状态:SUCCESS-登录成功、ERROR-登录失败
	 * 
	 * @param status
	 *            登录状态:SUCCESS-登录成功、ERROR-登录失败
	 */
	public void setStatus(String status) {
		this.status = status == null ? null : status.trim();
	}

	/**
	 * 备注
	 * 
	 * @return remark 备注
	 */
	public String getRemark() {
		return remark;
	}

	/**
	 * 备注
	 * 
	 * @param remark
	 *            备注
	 */
	public void setRemark(String remark) {
		this.remark = remark == null ? null : remark.trim();
	}
}