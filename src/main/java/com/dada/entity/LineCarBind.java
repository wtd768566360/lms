package com.dada.entity;

import java.util.Date;

public class LineCarBind {
    /**
     * ID
     */
    private String id;

    /**
     * 线路Id
     */
    private String lineId;

    /**
     * 车辆Id
     */
    private String carId;

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
     * ID
     * @return id ID
     */
    public String getId() {
        return id;
    }

    /**
     * ID
     * @param id ID
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * 线路Id
     * @return line_id 线路Id
     */
    public String getLineId() {
        return lineId;
    }

    /**
     * 线路Id
     * @param lineId 线路Id
     */
    public void setLineId(String lineId) {
        this.lineId = lineId == null ? null : lineId.trim();
    }

    /**
     * 车辆Id
     * @return car_id 车辆Id
     */
    public String getCarId() {
        return carId;
    }

    /**
     * 车辆Id
     * @param carId 车辆Id
     */
    public void setCarId(String carId) {
        this.carId = carId == null ? null : carId.trim();
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