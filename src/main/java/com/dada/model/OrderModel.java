/**
 * Copyright 2019 TPRI. All Rights Reserved.
 */
package com.dada.model;

import java.util.Date;

/**
 * <B>概要说明：订单枚举</B><BR>
 * 
 * @author（WuTengda） @since 2019年5月4日
 */
public class OrderModel {
	/**
	 * 车辆ID
	 */
	private String carId;

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
	private Integer orderStatus;

	/**
	 * 备注
	 */
	private String orderRemark;

	/**
	 * 订单ID
	 */
	private String orderHisturyID;

	/**
	 * 订单编号
	 */
	private String orderId;

	/**
	 * 备注
	 */
	private String orderHisturyRemark;

	/**
	 * <B>取得：</B>carId<BR>
	 * @return String
	 */
	public String getCarId() {
		return carId;
	}

	/**
	 * <B>设定：</B>carId<BR>
	 * @param carId
	 */
	public void setCarId(String carId) {
		this.carId = carId;
	}

	/**
	 * <B>取得：</B>orderNo<BR>
	 * @return String
	 */
	public String getOrderNo() {
		return orderNo;
	}

	/**
	 * <B>设定：</B>orderNo<BR>
	 * @param orderNo
	 */
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	/**
	 * <B>取得：</B>startSite<BR>
	 * @return String
	 */
	public String getStartSite() {
		return startSite;
	}

	/**
	 * <B>设定：</B>startSite<BR>
	 * @param startSite
	 */
	public void setStartSite(String startSite) {
		this.startSite = startSite;
	}

	/**
	 * <B>取得：</B>endSite<BR>
	 * @return String
	 */
	public String getEndSite() {
		return endSite;
	}

	/**
	 * <B>设定：</B>endSite<BR>
	 * @param endSite
	 */
	public void setEndSite(String endSite) {
		this.endSite = endSite;
	}

	/**
	 * <B>取得：</B>addresserName<BR>
	 * @return String
	 */
	public String getAddresserName() {
		return addresserName;
	}

	/**
	 * <B>设定：</B>addresserName<BR>
	 * @param addresserName
	 */
	public void setAddresserName(String addresserName) {
		this.addresserName = addresserName;
	}

	/**
	 * <B>取得：</B>addresserPhone<BR>
	 * @return String
	 */
	public String getAddresserPhone() {
		return addresserPhone;
	}

	/**
	 * <B>设定：</B>addresserPhone<BR>
	 * @param addresserPhone
	 */
	public void setAddresserPhone(String addresserPhone) {
		this.addresserPhone = addresserPhone;
	}

	/**
	 * <B>取得：</B>addresserCard<BR>
	 * @return String
	 */
	public String getAddresserCard() {
		return addresserCard;
	}

	/**
	 * <B>设定：</B>addresserCard<BR>
	 * @param addresserCard
	 */
	public void setAddresserCard(String addresserCard) {
		this.addresserCard = addresserCard;
	}

	/**
	 * <B>取得：</B>recipientsName<BR>
	 * @return String
	 */
	public String getRecipientsName() {
		return recipientsName;
	}

	/**
	 * <B>设定：</B>recipientsName<BR>
	 * @param recipientsName
	 */
	public void setRecipientsName(String recipientsName) {
		this.recipientsName = recipientsName;
	}

	/**
	 * <B>取得：</B>recipientsPhone<BR>
	 * @return String
	 */
	public String getRecipientsPhone() {
		return recipientsPhone;
	}

	/**
	 * <B>设定：</B>recipientsPhone<BR>
	 * @param recipientsPhone
	 */
	public void setRecipientsPhone(String recipientsPhone) {
		this.recipientsPhone = recipientsPhone;
	}

	/**
	 * <B>取得：</B>deliveryTime<BR>
	 * @return Date
	 */
	public Date getDeliveryTime() {
		return deliveryTime;
	}

	/**
	 * <B>设定：</B>deliveryTime<BR>
	 * @param deliveryTime
	 */
	public void setDeliveryTime(Date deliveryTime) {
		this.deliveryTime = deliveryTime;
	}

	/**
	 * <B>取得：</B>receiptTime<BR>
	 * @return Date
	 */
	public Date getReceiptTime() {
		return receiptTime;
	}

	/**
	 * <B>设定：</B>receiptTime<BR>
	 * @param receiptTime
	 */
	public void setReceiptTime(Date receiptTime) {
		this.receiptTime = receiptTime;
	}

	/**
	 * <B>取得：</B>orderStatus<BR>
	 * @return Integer
	 */
	public Integer getOrderStatus() {
		return orderStatus;
	}

	/**
	 * <B>设定：</B>orderStatus<BR>
	 * @param orderStatus
	 */
	public void setOrderStatus(Integer orderStatus) {
		this.orderStatus = orderStatus;
	}

	/**
	 * <B>取得：</B>orderRemark<BR>
	 * @return String
	 */
	public String getOrderRemark() {
		return orderRemark;
	}

	/**
	 * <B>设定：</B>orderRemark<BR>
	 * @param orderRemark
	 */
	public void setOrderRemark(String orderRemark) {
		this.orderRemark = orderRemark;
	}

	/**
	 * <B>取得：</B>orderHisturyID<BR>
	 * @return String
	 */
	public String getOrderHisturyID() {
		return orderHisturyID;
	}

	/**
	 * <B>设定：</B>orderHisturyID<BR>
	 * @param orderHisturyID
	 */
	public void setOrderHisturyID(String orderHisturyID) {
		this.orderHisturyID = orderHisturyID;
	}

	/**
	 * <B>取得：</B>orderId<BR>
	 * @return String
	 */
	public String getOrderId() {
		return orderId;
	}

	/**
	 * <B>设定：</B>orderId<BR>
	 * @param orderId
	 */
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	/**
	 * <B>取得：</B>orderHisturyRemark<BR>
	 * @return String
	 */
	public String getOrderHisturyRemark() {
		return orderHisturyRemark;
	}

	/**
	 * <B>设定：</B>orderHisturyRemark<BR>
	 * @param orderHisturyRemark
	 */
	public void setOrderHisturyRemark(String orderHisturyRemark) {
		this.orderHisturyRemark = orderHisturyRemark;
	}
	
	
}
