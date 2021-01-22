package com.capg.inventory.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
@Entity
@Table(name = "product_info")
public class ProductDto {

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
}
