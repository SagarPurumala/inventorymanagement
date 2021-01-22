package com.cg.ims.dto;

import com.cg.ims.entity.Product;

import lombok.Data;

@Data
public class ProductDto {

	
	private Integer productId;
	private String productName;
    private String productTag;
    private String productDescription;
	private Integer discount;
	private float originalPrice;
	private float discountprice;
    private String size;
	private Integer quantity;
	private String category;
	private Integer merchantId;
	private byte[] image;
	

//	public ProductDto(Product product) {
//		this.productId=product.getProductId();
//		this.category=product.getCategory();
//	    this.productDescription=product.getProductDescription();
//		this.productName=product.getProductName();
//		this.merchantId=product.getMerchantId();
//		this.quantity=product.getQuantity();
//		this.image=product.getImage();
//		this.discount=product.getDiscount();
//		this.discountprice=product.getDiscountprice();
//		this.originalPrice=product.getOriginalPrice();
//		this.productTag=product.getProductTag();
//		this.size=product.getSize();
//	}
}
