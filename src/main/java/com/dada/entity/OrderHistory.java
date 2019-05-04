package com.dada.entity;

import java.io.Serializable;
import java.util.Date;

public class OrderHistory implements Serializable{
    /**
     * 订单ID
     */
    private String id;

    /**
     * 车辆ID
     */
    private String carId;

    /**
     * 订单编号
     */
    private String orderId;

    /**
     * 中转站ID
     */
    private String stationId;

    /**
     * 订单进入时间
     */
    private Date inTime;

    /**
     * 订单发出时间
     */
    private Date outTime;

    /**
     * 订单状态:0-已接收、1-进行中、2-已发出
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
     * 订单ID
     * @return id 订单ID
     */
    public String getId() {
        return id;
    }

    /**
     * 订单ID
     * @param id 订单ID
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * 车辆ID
     * @return car_id 车辆ID
     */
    public String getCarId() {
        return carId;
    }

    /**
     * 车辆ID
     * @param carId 车辆ID
     */
    public void setCarId(String carId) {
        this.carId = carId == null ? null : carId.trim();
    }

    /**
     * 订单编号
     * @return order_id 订单编号
     */
    public String getOrderId() {
        return orderId;
    }

    /**
     * 订单编号
     * @param orderId 订单编号
     */
    public void setOrderId(String orderId) {
        this.orderId = orderId == null ? null : orderId.trim();
    }

    /**
     * 中转站ID
     * @return station_id 中转站ID
     */
    public String getStationId() {
        return stationId;
    }

    /**
     * 中转站ID
     * @param stationId 中转站ID
     */
    public void setStationId(String stationId) {
        this.stationId = stationId == null ? null : stationId.trim();
    }

    /**
     * 订单进入时间
     * @return in_time 订单进入时间
     */
    public Date getInTime() {
        return inTime;
    }

    /**
     * 订单进入时间
     * @param inTime 订单进入时间
     */
    public void setInTime(Date inTime) {
        this.inTime = inTime;
    }

    /**
     * 订单发出时间
     * @return out_time 订单发出时间
     */
    public Date getOutTime() {
        return outTime;
    }

    /**
     * 订单发出时间
     * @param outTime 订单发出时间
     */
    public void setOutTime(Date outTime) {
        this.outTime = outTime;
    }

    /**
     * 订单状态:0-已接收、1-进行中、2-已发出
     * @return status 订单状态:0-已接收、1-进行中、2-已发出
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 订单状态:0-已接收、1-进行中、2-已发出
     * @param status 订单状态:0-已接收、1-进行中、2-已发出
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