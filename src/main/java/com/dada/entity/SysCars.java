package com.dada.entity;

import java.util.Date;

public class SysCars {
    /**
     * 车辆ID
     */
    private String id;

    /**
     * 司机
     */
    private String memberId;
    private String memberName;
    

    public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	/**
     * 车牌
     */
    private String licencePlate;

    /**
     * 车辆类型:0-小卡车、1-大卡车
     */
    private Integer carType;

    /**
     * 车辆状态:0-正常、1-报废
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
     * 车辆ID
     * @return id 车辆ID
     */
    public String getId() {
        return id;
    }

    /**
     * 车辆ID
     * @param id 车辆ID
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * 司机
     * @return member_id 司机
     */
    public String getMemberId() {
        return memberId;
    }

    /**
     * 司机
     * @param memberId 司机
     */
    public void setMemberId(String memberId) {
        this.memberId = memberId == null ? null : memberId.trim();
    }

    /**
     * 车牌
     * @return licence_plate 车牌
     */
    public String getLicencePlate() {
        return licencePlate;
    }

    /**
     * 车牌
     * @param licencePlate 车牌
     */
    public void setLicencePlate(String licencePlate) {
        this.licencePlate = licencePlate == null ? null : licencePlate.trim();
    }

    /**
     * 车辆类型:0-小卡车、1-大卡车
     * @return car_type 车辆类型:0-小卡车、1-大卡车
     */
    public Integer getCarType() {
        return carType;
    }

    /**
     * 车辆类型:0-小卡车、1-大卡车
     * @param carType 车辆类型:0-小卡车、1-大卡车
     */
    public void setCarType(Integer carType) {
        this.carType = carType;
    }

    /**
     * 车辆状态:0-正常、1-报废
     * @return status 车辆状态:0-正常、1-报废
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 车辆状态:0-正常、1-报废
     * @param status 车辆状态:0-正常、1-报废
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 备注
     * @return remark 备注
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 备注
     * @param remark 备注
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    /**
     * 是否删除：1-已删除；0-未删除
     * @return is_deleted 是否删除：1-已删除；0-未删除
     */
    public Boolean getIsDeleted() {
        return isDeleted;
    }

    /**
     * 是否删除：1-已删除；0-未删除
     * @param isDeleted 是否删除：1-已删除；0-未删除
     */
    public void setIsDeleted(Boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    /**
     * 创建者ID
     * @return creator_id 创建者ID
     */
    public String getCreatorId() {
        return creatorId;
    }

    /**
     * 创建者ID
     * @param creatorId 创建者ID
     */
    public void setCreatorId(String creatorId) {
        this.creatorId = creatorId == null ? null : creatorId.trim();
    }

    /**
     * 修改者ID
     * @return modifier_id 修改者ID
     */
    public String getModifierId() {
        return modifierId;
    }

    /**
     * 修改者ID
     * @param modifierId 修改者ID
     */
    public void setModifierId(String modifierId) {
        this.modifierId = modifierId == null ? null : modifierId.trim();
    }

    /**
     * 创建时间
     * @return create_time 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 创建时间
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 修改时间
     * @return modify_time 修改时间
     */
    public Date getModifyTime() {
        return modifyTime;
    }

    /**
     * 修改时间
     * @param modifyTime 修改时间
     */
    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }
}