package com.dada.entity;

import java.util.Date;

public class OperationLog {
	/**
	 * ID
	 */
	private String id;

	/**
	 * 登录用户ID
	 */
	private String memberId;

	/**
	 * 登录名称
	 */
	private String memberName;

	/**
	 * 登录IP
	 */
	private String accessIp;

	/**
	 * 访问资源
	 */
	private String accessUri;

	/**
	 * 操作请求
	 */
	private String operation;

	/**
	 * 操作类型(日志信息)
	 */
	private String operationType;

	/**
	 * 备注
	 */
	private String remark;

	/**
	 * 创建时间
	 */
	private Date createTime;

	/**
	 * <B>构造方法</B><BR>
	 * 
	 * @param id
	 * @param memberId
	 * @param memberName
	 * @param accessIp
	 * @param accessUri
	 * @param operation
	 * @param operationType
	 * @param remark
	 * @param createTime
	 */
	public OperationLog(String id, String memberId, String memberName, String accessIp, String accessUri,
			String operation, String operationType, String remark, Date createTime) {
		super();
		this.id = id;
		this.memberId = memberId;
		this.memberName = memberName;
		this.accessIp = accessIp;
		this.accessUri = accessUri;
		this.operation = operation;
		this.operationType = operationType;
		this.remark = remark;
		this.createTime = createTime;
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
	 * 登录用户ID
	 * 
	 * @return member_id 登录用户ID
	 */
	public String getMemberId() {
		return memberId;
	}

	/**
	 * 登录用户ID
	 * 
	 * @param memberId
	 *            登录用户ID
	 */
	public void setMemberId(String memberId) {
		this.memberId = memberId == null ? null : memberId.trim();
	}

	/**
	 * 登录名称
	 * 
	 * @return member_name 登录名称
	 */
	public String getMemberName() {
		return memberName;
	}

	/**
	 * 登录名称
	 * 
	 * @param memberName
	 *            登录名称
	 */
	public void setMemberName(String memberName) {
		this.memberName = memberName == null ? null : memberName.trim();
	}

	/**
	 * 登录IP
	 * 
	 * @return access_ip 登录IP
	 */
	public String getAccessIp() {
		return accessIp;
	}

	/**
	 * 登录IP
	 * 
	 * @param accessIp
	 *            登录IP
	 */
	public void setAccessIp(String accessIp) {
		this.accessIp = accessIp == null ? null : accessIp.trim();
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
	 * 操作类型(日志信息)
	 * 
	 * @return operation_type 操作类型(日志信息)
	 */
	public String getOperationType() {
		return operationType;
	}

	/**
	 * 操作类型(日志信息)
	 * 
	 * @param operationType
	 *            操作类型(日志信息)
	 */
	public void setOperationType(String operationType) {
		this.operationType = operationType == null ? null : operationType.trim();
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

	/**
	 * 创建时间
	 * 
	 * @return create_time 创建时间
	 */
	public Date getCreateTime() {
		return createTime;
	}

	/**
	 * 创建时间
	 * 
	 * @param createTime
	 *            创建时间
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
}