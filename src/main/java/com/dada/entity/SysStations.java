package com.dada.entity;

import java.util.Date;

public class SysStations {
	/**
	 * 站点ID
	 */
	private String id;

	/**
	 * 站点名称
	 */
	private String stationName;

	/**
	 * 站点名称
	 */
	private String address;

	/**
	 * 站点管理员
	 */
	private String memberId;

	/**
	 * 站点状态:0-正常、1-废弃
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
	 * 站点ID
	 * 
	 * @return id 站点ID
	 */
	public String getId() {
		return id;
	}

	/**
	 * 站点ID
	 * 
	 * @param id
	 *            站点ID
	 */
	public void setId(String id) {
		this.id = id == null ? null : id.trim();
	}

	/**
	 * 站点名称
	 * 
	 * @return station_name 站点名称
	 */
	public String getStationName() {
		return stationName;
	}

	/**
	 * 站点名称
	 * 
	 * @param stationName
	 *            站点名称
	 */
	public void setStationName(String stationName) {
		this.stationName = stationName == null ? null : stationName.trim();
	}

	/**
	 * 站点管理员
	 * 
	 * @return member_id 站点管理员
	 */
	public String getMemberId() {
		return memberId;
	}

	/**
	 * 站点管理员
	 * 
	 * @param memberId
	 *            站点管理员
	 */
	public void setMemberId(String memberId) {
		this.memberId = memberId == null ? null : memberId.trim();
	}

	/**
	 * 站点状态:0-正常、1-废弃
	 * 
	 * @return status 站点状态:0-正常、1-废弃
	 */
	public Integer getStatus() {
		return status;
	}

	/**
	 * 站点状态:0-正常、1-废弃
	 * 
	 * @param status
	 *            站点状态:0-正常、1-废弃
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
	 * <B>取得：</B>address<BR>
	 * 
	 * @return String
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * <B>设定：</B>address<BR>
	 * 
	 * @param address
	 */
	public void setAddress(String address) {
		this.address = address;
	}

}