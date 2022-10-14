package com.product.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "product_category")
public class ProductCategory {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id; 
	@Column(name = "discount")
	private int discount;
	@Column(name = "gst")
	private int gst;
	@Column(name = "delivery_charge")
	private long deliveryCharge;
	@Column(name = "category")
	private String category;
	public ProductCategory(long id, int discount, int gst, long deliveryCharge, String category) {
		super();
		this.id = id;
		this.discount = discount;
		this.gst = gst;
		this.deliveryCharge = deliveryCharge;
		this.category = category;
	}
	public ProductCategory() {
	}
	public ProductCategory(long id, int discount, int gst, long deliveryCharge) {
		super();
		this.id = id;
		this.discount = discount;
		this.gst = gst;
		this.deliveryCharge = deliveryCharge;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public int getDiscount() {
		return discount;
	}
	public void setDiscount(int discount) {
		this.discount = discount;
	}
	public int getGst() {
		return gst;
	}
	public void setGst(int gst) {
		this.gst = gst;
	}
	public long getDeliveryCharge() {
		return deliveryCharge;
	}
	public void setDeliveryCharge(long deliveryCharge) {
		this.deliveryCharge = deliveryCharge;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
}
