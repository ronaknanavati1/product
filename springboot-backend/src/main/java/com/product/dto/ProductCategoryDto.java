package com.product.dto;

public class ProductCategoryDto {
	private double gst;
	private double delivery;
	public double getGst() {
		return gst;
	}
	public void setGst(double gst) {
		this.gst = gst;
	}
	public double getDelivery() {
		return delivery;
	}
	public void setDelivery(double delivery) {
		this.delivery = delivery;
	}
	public ProductCategoryDto(double gst, double delivery) {
		super();
		this.gst = gst;
		this.delivery = delivery;
	}
}
