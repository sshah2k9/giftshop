package com.proj1.model;

public class Item {

	private long itemCode;
	private String itemName;
	private String itemDesc;
	private float price;
	private int categoryId;
	private String fileName;

	public long getItemCode() {
		return itemCode;
	}

	@Override
	public String toString() {
		return "Item [itemCode=" + itemCode + ", itemName=" + itemName + ", itemDesc=" + itemDesc + ", price=" + price
				+ ", categoryId=" + categoryId + ", fileName=" + fileName + "]";
	}

	public void setItemCode(long l) {
		this.itemCode = l;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getItemDesc() {
		return itemDesc;
	}

	public void setItemDesc(String itemDesc) {
		this.itemDesc = itemDesc;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

}
