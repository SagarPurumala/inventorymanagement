package com.cg.merchantmanagementsystem.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.cg.merchantmanagementsystem.dto.MerchantDTO;

@Entity
@Table(name = "merchant_details")
public class Merchant {
	
		@Id
		@Column(name = "merchant_id")
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Integer merchantId;
		@Column(name = "merchant_name")
		private String merchantName;
		@Column(name = "organisation_name")
		private String OrganisationName;
		@Column(name = "address")
		private String address;
		@Column(name = "zipcode")
		private String zipcode;
		@Column(name = "city")
		private String city;
		@Column(name = "state")
		private String state;
		@Column(name = "phone_number")
		private String phoneNumber;
		@Column(name = "email")
		private String email;
		@Column(name= "status")
		private String status;
		@Column(name="image")
		private byte[] image;

		public Merchant() {
		}

		public Merchant(String merchantName, String organisationName, String address, String zipcode, String city,
				String state, String phoneNumber, String email, String status) {
			super();
			this.merchantName = merchantName;
			OrganisationName = organisationName;
			this.address = address;
			this.zipcode = zipcode;
			this.city = city;
			this.state = state;
			this.phoneNumber = phoneNumber;
			this.email = email;
			this.status = status;
		}


		public byte[] getImage() {
			return image;
		}

		public void setImage(byte[] image) {
			this.image = image;
		}

		public Integer getMerchantId() {
			return merchantId;
		}


		public void setMerchantId(Integer merchantId) {
			this.merchantId = merchantId;
		}


		public String getMerchantName() {
			return merchantName;
		}


		public void setMerchantName(String merchantName) {
			this.merchantName = merchantName;
		}


		public String getOrganisationName() {
			return OrganisationName;
		}


		public void setOrganisationName(String organisationName) {
			OrganisationName = organisationName;
		}


		public String getAddress() {
			return address;
		}


		public void setAddress(String address) {
			this.address = address;
		}


		public String getZipcode() {
			return zipcode;
		}


		public void setZipcode(String zipcode) {
			this.zipcode = zipcode;
		}


		public String getCity() {
			return city;
		}


		public void setCity(String city) {
			this.city = city;
		}


		public String getState() {
			return state;
		}


		public void setState(String state) {
			this.state = state;
		}


		public String getPhoneNumber() {
			return phoneNumber;
		}


		public void setPhoneNumber(String phoneNumber) {
			this.phoneNumber = phoneNumber;
		}


		public String getEmail() {
			return email;
		}


		public void setEmail(String email) {
			this.email = email;
		}


		public String getStatus() {
			return status;
		}


		public void setStatus(String status) {
			this.status = status;
		}


		public Merchant(MerchantDTO merchantdto) {
			this.merchantId = merchantdto.getMerchantId();
			this.merchantName = merchantdto.getMerchantName();
			this.OrganisationName=merchantdto.getOrganisationName();
			this.address = merchantdto.getAddress();
			this.zipcode = merchantdto.getZipcode();
			this.city = merchantdto.getCity();
			this.state = merchantdto.getState();
			this.phoneNumber = merchantdto.getPhoneNumber();
			this.email = merchantdto.getEmail();
			this.status=merchantdto.getStatus();
			this.image=merchantdto.getImage();
		}
}



