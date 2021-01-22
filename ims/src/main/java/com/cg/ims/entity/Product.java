package com.cg.ims.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.cg.ims.dto.ProductDto;

import lombok.Data;
@Data
@Entity
@Table(name = "product_info")
public class Product {
	
	@Id
	@Column(name = "product_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer productId;
	@Column(name = "product_name")
	private String productName;
	@Column(name = "product_tag")
    private String productTag;
	@Column(name = "product_description")
    private String productDescription;
	@Column(name="discount")
	private Integer discount;
	@Column(name = "product_originalprice")
	private float originalPrice;
	@Column(name = "product_discountprice")
	private float discountprice;
	@Column(name = "product_size")
    private String size;
	@Column(name = "product_quantity")
	private Integer quantity;
	@Column(name = "product_category")
	private String category;
	@Column(name = "merchant_id")
	private Integer merchantId;
	@Column(name = "product_image", length = 1000)
	private byte[] image;
	
	public Product(ProductDto product) {
		this.productId=product.getProductId();
		this.category=product.getCategory();
	    this.productDescription=product.getProductDescription();
		this.productName=product.getProductName();
		this.merchantId=product.getMerchantId();
		this.quantity=product.getQuantity();
		this.image=product.getImage();
		this.discount=product.getDiscount();
		this.discountprice=product.getDiscountprice();
		this.originalPrice=product.getOriginalPrice();
		this.productTag=product.getProductTag();
		this.size=product.getSize();
	}
	public Product() {
	}

}
