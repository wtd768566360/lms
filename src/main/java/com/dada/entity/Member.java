package com.dada.entity;

import java.util.Date;

public class Member {
	/**
	 * 用户ID
	 */
	private String id;

	/**
	 * 工号
	 */
	private String memberNo;

	/**
	 * 真实姓名
	 */
	private String realname;

	/**
	 * 用户密码
	 */
	private String password;

	/**
	 * 用户头像链接
	 */
	private String headUrl;

	/**
	 * 身份证号码
	 */
	private String idCard;

	/**
	 * 用户手机
	 */
	private String phone;

	/**
	 * 用户邮箱
	 */
	private String email;

	/**
	 * 推送时使用
	 */
	private String token;

	/**
	 * 上次登录IP
	 */
	private String loginIp;

	/**
	 * 最后登录时间
	 */
	private Date lastTime;

	/**
	 * 用户状态:0-正常、1-冻结、2-离职
	 */
	private Integer status;

	/**
	 * 备注
	 */
	private String remark;

	/**
	 * 是否删除：1-已删除；0-未删除
	 */
	private Boolean isDeleted;

	/**
	 * 创建者ID
	 */
	private String creatorId;

	/**
	 * 修改者ID
	 */
	private String modifierId;

	/**
	 * 创建时间
	 */
	private Date createTime;

	/**
	 * 修改时间
	 */
	private Date modifyTime;

	/**
	 * 用户ID
	 * 
	 * @return id 用户ID
	 */
	public String getId() {
		return id;
	}

	/**
	 * 用户ID
	 * 
	 * @param id
	 *            用户ID
	 */
	public void setId(String id) {
		this.id = id == null ? null : id.trim();
	}

	/**
	 * 工号
	 * 
	 * @return member_no 工号
	 */
	public String getMemberNo() {
		return memberNo;
	}

	/**
	 * 工号
	 * 
	 * @param memberNo
	 *            工号
	 */
	public void setMemberNo(String memberNo) {
		this.memberNo = memberNo == null ? null : memberNo.trim();
	}

	/**
	 * 真实姓名
	 * 
	 * @return realname 真实姓名
	 */
	public String getRealname() {
		return realname;
	}

	/**
	 * 真实姓名
	 * 
	 * @param realname
	 *            真实姓名
	 */
	public void setRealname(String realname) {
		this.realname = realname == null ? null : realname.trim();
	}

	/**
	 * 用户密码
	 * 
	 * @return password 用户密码
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * 用户密码
	 * 
	 * @param password
	 *            用户密码
	 */
	public void setPassword(String password) {
		this.password = password == null ? null : password.trim();
	}

	/**
	 * 用户头像链接
	 * 
	 * @return head_url 用户头像链接
	 */
	public String getHeadUrl() {
		return headUrl;
	}

	/**
	 * 用户头像链接
	 * 
	 * @param headUrl
	 *            用户头像链接
	 */
	public void setHeadUrl(String headUrl) {
		this.headUrl = headUrl == null ? null : headUrl.trim();
	}

	/**
	 * 身份证号码
	 * 
	 * @return id_card 身份证号码
	 */
	public String getIdCard() {
		return idCard;
	}

	/**
	 * 身份证号码
	 * 
	 * @param idCard
	 *            身份证号码
	 */
	public void setIdCard(String idCard) {
		this.idCard = idCard == null ? null : idCard.trim();
	}

	/**
	 * 用户手机
	 * 
	 * @return phone 用户手机
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * 用户手机
	 * 
	 * @param phone
	 *            用户手机
	 */
	public void setPhone(String phone) {
		this.phone = phone == null ? null : phone.trim();
	}

	/**
	 * 推送时使用
	 * 
	 * @return token 推送时使用
	 */
	public String getToken() {
		return token;
	}

	/**
	 * 推送时使用
	 * 
	 * @param token
	 *            推送时使用
	 */
	public void setToken(String token) {
		this.token = token == null ? null : token.trim();
	}

	/**
	 * 上次登录IP
	 * 
	 * @return login_ip 上次登录IP
	 */
	public String getLoginIp() {
		return loginIp;
	}

	/**
	 * 上次登录IP
	 * 
	 * @param loginIp
	 *            上次登录IP
	 */
	public void setLoginIp(String loginIp) {
		this.loginIp = loginIp == null ? null : loginIp.trim();
	}

	/**
	 * 最后登录时间
	 * 
	 * @return last_time 最后登录时间
	 */
	public Date getLastTime() {
		return lastTime;
	}

	/**
	 * 最后登录时间
	 * 
	 * @param lastTime
	 *            最后登录时间
	 */
	public void setLastTime(Date lastTime) {
		this.lastTime = lastTime;
	}

	/**
	 * 用户状态:0-正常、1-冻结、2-离职
	 * 
	 * @return status 用户状态:0-正常、1-冻结、2-离职
	 */
	public Integer getStatus() {
		return status;
	}

	/**
	 * 用户状态:0-正常、1-冻结、2-离职
	 * 
	 * @param status
	 *            用户状态:0-正常、1-冻结、2-离职
	 */
	public void setStatus(Integer status) {
		this.status = status;
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
	 * 是否删除：1-已删除；0-未删除
	 * 
	 * @return is_deleted 是否删除：1-已删除；0-未删除
	 */
	public Boolean getIsDeleted() {
		return isDeleted;
	}

	/**
	 * 是否删除：1-已删除；0-未删除
	 * 
	 * @param isDeleted
	 *            是否删除：1-已删除；0-未删除
	 */
	public void setIsDeleted(Boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	/**
	 * 创建者ID
	 * 
	 * @return creator_id 创建者ID
	 */
	public String getCreatorId() {
		return creatorId;
	}

	/**
	 * 创建者ID
	 * 
	 * @param creatorId
	 *            创建者ID
	 */
	public void setCreatorId(String creatorId) {
		this.creatorId = creatorId == null ? null : creatorId.trim();
	}

	/**
	 * 修改者ID
	 * 
	 * @return modifier_id 修改者ID
	 */
	public String getModifierId() {
		return modifierId;
	}

	/**
	 * 修改者ID
	 * 
	 * @param modifierId
	 *            修改者ID
	 */
	public void setModifierId(String modifierId) {
		this.modifierId = modifierId == null ? null : modifierId.trim();
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

	/**
	 * 修改时间
	 * 
	 * @return modify_time 修改时间
	 */
	public Date getModifyTime() {
		return modifyTime;
	}

	/**
	 * 修改时间
	 * 
	 * @param modifyTime
	 *            修改时间
	 */
	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}

	/**
	 * <B>设定：</B>email<BR>
	 * 
	 * @param email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * <B>取得：</B>email<BR>
	 * 
	 * @return String
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * <B>构造方法</B><BR>
	 * @param id
	 * @param memberNo
	 * @param realname
	 * @param password
	 * @param headUrl
	 * @param idCard
	 * @param phone
	 * @param email
	 * @param token
	 * @param loginIp
	 * @param lastTime
	 * @param status
	 * @param remark
	 * @param isDeleted
	 * @param creatorId
	 * @param modifierId
	 * @param createTime
	 * @param modifyTime
	 */
	public Member(String id, String memberNo, String realname, String password, String headUrl, String idCard,
			String phone, String email, String token, String loginIp, Date lastTime, Integer status, String remark,
			Boolean isDeleted, String creatorId, String modifierId, Date createTime, Date modifyTime) {
		super();
		this.id = id;
		this.memberNo = memberNo;
		this.realname = realname;
		this.password = password;
		this.headUrl = headUrl;
		this.idCard = idCard;
		this.phone = phone;
		this.email = email;
		this.token = token;
		this.loginIp = loginIp;
		this.lastTime = lastTime;
		this.status = status;
		this.remark = remark;
		this.isDeleted = isDeleted;
		this.creatorId = creatorId;
		this.modifierId = modifierId;
		this.createTime = createTime;
		this.modifyTime = modifyTime;
	}

	/**
	 * <B>构造方法</B><BR>
	 */
	public Member() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}