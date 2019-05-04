package com.dada.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Orders implements Serializable{
    /**
     * 订单ID
     */
    private String id;

    /**
     * 车辆ID
     */
    private String carId="0";

    /**
     * 订单编号
     */
    private String orderNo;

    /**
     * 发货地点
     */
    private String startSite;

    /**
     * 收货地点
     */
    private String endSite;

    /**
     * 发件人
     */
    private String addresserName;

    /**
     * 发件人手机号
     */
    private String addresserPhone;

    /**
     * 发件人身份证
     */
    private String addresserCard;

    /**
     * 收件人
     */
    private String recipientsName;

    /**
     * 收件人手机号
     */
    private String recipientsPhone;

    /**
     * 收件人身份证
     */
    private String recipientsCard;

    /**
     * 发货时间
     */
    private Date deliveryTime;

    /**
     * 收货时间
     */
    private Date receiptTime;

    /**
     * 订单状态:0-待发货、1-已发货、2-已完成
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

    
    public  List<OrderHistory> orderhistorys;
    
    
    
    
    public List<OrderHistory> getOrderhistorys() {
		return orderhistorys;
	}

	public void setOrderhistorys(List<OrderHistory> orderhistorys) {
		this.orderhistorys = orderhistorys;
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
     * @return order_no 订单编号
     */
    public String getOrderNo() {
        return orderNo;
    }

    /**
     * 订单编号
     * @param orderNo 订单编号
     */
    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo == null ? null : orderNo.trim();
    }

    /**
     * 发货地点
     * @return start_site 发货地点
     */
    public String getStartSite() {
        return startSite;
    }

    /**
     * 发货地点
     * @param startSite 发货地点
     */
    public void setStartSite(String startSite) {
        this.startSite = startSite == null ? null : startSite.trim();
    }

    /**
     * 收货地点
     * @return end_site 收货地点
     */
    public String getEndSite() {
        return endSite;
    }

    /**
     * 收货地点
     * @param endSite 收货地点
     */
    public void setEndSite(String endSite) {
        this.endSite = endSite == null ? null : endSite.trim();
    }

    /**
     * 发件人
     * @return addresser_name 发件人
     */
    public String getAddresserName() {
        return addresserName;
    }

    /**
     * 发件人
     * @param addresserName 发件人
     */
    public void setAddresserName(String addresserName) {
        this.addresserName = addresserName == null ? null : addresserName.trim();
    }

    /**
     * 发件人手机号
     * @return addresser_phone 发件人手机号
     */
    public String getAddresserPhone() {
        return addresserPhone;
    }

    /**
     * 发件人手机号
     * @param addresserPhone 发件人手机号
     */
    public void setAddresserPhone(String addresserPhone) {
        this.addresserPhone = addresserPhone == null ? null : addresserPhone.trim();
    }

    /**
     * 发件人身份证
     * @return addresser_card 发件人身份证
     */
    public String getAddresserCard() {
        return addresserCard;
    }

    /**
     * 发件人身份证
     * @param addresserCard 发件人身份证
     */
    public void setAddresserCard(String addresserCard) {
        this.addresserCard = addresserCard == null ? null : addresserCard.trim();
    }

    /**
     * 收件人
     * @return recipients_name 收件人
     */
    public String getRecipientsName() {
        return recipientsName;
    }

    /**
     * 收件人
     * @param recipientsName 收件人
     */
    public void setRecipientsName(String recipientsName) {
        this.recipientsName = recipientsName == null ? null : recipientsName.trim();
    }

    /**
     * 收件人手机号
     * @return recipients__phone 收件人手机号
     */
    public String getRecipientsPhone() {
        return recipientsPhone;
    }

    /**
     * 收件人手机号
     * @param recipientsPhone 收件人手机号
     */
    public void setRecipientsPhone(String recipientsPhone) {
        this.recipientsPhone = recipientsPhone == null ? null : recipientsPhone.trim();
    }

    /**
     * 收件人身份证
     * @return recipients__card 收件人身份证
     */
    public String getRecipientsCard() {
        return recipientsCard;
    }

    /**
     * 收件人身份证
     * @param recipientsCard 收件人身份证
     */
    public void setRecipientsCard(String recipientsCard) {
        this.recipientsCard = recipientsCard == null ? null : recipientsCard.trim();
    }

    /**
     * 发货时间
     * @return delivery_time 发货时间
     */
    public Date getDeliveryTime() {
        return deliveryTime;
    }

    /**
     * 发货时间
     * @param deliveryTime 发货时间
     */
    public void setDeliveryTime(Date deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    /**
     * 收货时间
     * @return receipt_time 收货时间
     */
    public Date getReceiptTime() {
        return receiptTime;
    }

    /**
     * 收货时间
     * @param receiptTime 收货时间
     */
    public void setReceiptTime(Date receiptTime) {
        this.receiptTime = receiptTime;
    }

    /**
     * 订单状态:0-待发货、1-已发货、2-已完成
     * @return status 订单状态:0-待发货、1-已发货、2-已完成
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 订单状态:0-待发货、1-已发货、2-已完成
     * @param status 订单状态:0-待发货、1-已发货、2-已完成
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