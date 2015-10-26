package com.proj1.model;

public class Order {

	private long orderId;
	private long itemCode;
	private long deliveryId;
	private long messageId;
	private long senderId;

	public long getOrderId() {
		return orderId;
	}

	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}

	public long getItemCode() {
		return itemCode;
	}

	public void setItemCode(long itemCode) {
		this.itemCode = itemCode;
	}

	public long getDeliveryId() {
		return deliveryId;
	}

	public void setDeliveryId(long deliveryId) {
		this.deliveryId = deliveryId;
	}

	public long getMessageId() {
		return messageId;
	}

	public void setMessageId(long messageId) {
		this.messageId = messageId;
	}

	public long getSenderId() {
		return senderId;
	}

	public void setSenderId(long senderId) {
		this.senderId = senderId;
	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", itemCode=" + itemCode + ", deliveryId=" + deliveryId + ", messageId="
				+ messageId + ", senderId=" + senderId + "]";
	}

}
