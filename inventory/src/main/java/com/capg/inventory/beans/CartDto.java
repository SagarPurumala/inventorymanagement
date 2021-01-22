package com.capg.inventory.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import lombok.Data;

@Data
@Entity
@Table(name="cart_info")
public class CartDto {
	
	@Id
	@Column(name="cart_id")
	//@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="cartIdGenerator")
	//@SequenceGenerator(name="cartIdGenerator", initialValue=1000)
	private int cartId;
	
	@Column(name="customer_id")
	private int customerId;
	
	@Column(name="quantity")
	private int quantity;
	
	@Column(name="status")
	private String status;
	
	@OneToOne
	@JoinColumn(name="product_id", referencedColumnName = "product_id")
	private ProductDto product=new ProductDto();

	@Column(name="subTotal")
	private float subTotal;
	
	

}
