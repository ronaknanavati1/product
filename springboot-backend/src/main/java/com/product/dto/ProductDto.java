package com.product.dto;

import com.product.model.Product;

public class ProductDto {
	private long productId;
	private String name;
	private String productType;
	private String category;
	private double basePrice;
	private double discount;
	private ProductCategoryDto charges;
	private double finalPrice;

	
	public ProductDto(Product product) {
		super();
		this.productId = product.getId();
		this.name = product.getProductName();
		this.productType = product.getProductType();
		this.category = product.getProductCategory().getCategory();
		this.basePrice = product.getProductPrice();
		this.discount = product.getProductPrice() * product.getProductCategory().getDiscount() / 100;
		this.charges = new ProductCategoryDto(product.getProductPrice() * product.getProductCategory().getGst() / 100, product.getProductCategory().getDeliveryCharge());
		this.finalPrice = product.getProductPrice();
	}
	public long getProductId() {
		return productId;
	}
	public void setProductId(long productId) {
		this.productId = productId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getProductType() {
		return productType;
	}
	public void setProductType(String productType) {
		this.productType = productType;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public double getBasePrice() {
		return basePrice;
	}
	public void setBasePrice(double basePrice) {
		this.basePrice = basePrice;
	}
	public double getDiscount() {
		return discount;
	}
	public void setDiscount(double discount) {
		this.discount = discount;
	}
	public ProductCategoryDto getCharges() {
		return charges;
	}
	public void setCharges(ProductCategoryDto charges) {
		this.charges = charges;
	}
	public double getFinalPrice() {
		return finalPrice;
	}
	public void setFinalPrice(double finalPrice) {
		this.finalPrice = finalPrice;
	}

	
}
