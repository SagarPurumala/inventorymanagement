package com.cg.merchantmanagementsystem.dto;

import com.cg.merchantmanagementsystem.entity.Merchant;

public class MerchantDTO {

	private Integer merchantId;
	private String merchantName;
	private String organisationName;
	private String address;
	private String zipcode;
	private String city;
	private String state;
	private String phoneNumber;
	private String email;
	private String status;
	private byte[] image;

	public MerchantDTO() {
	}

	public MerchantDTO(Integer merchantId, String merchantName, String organisationName, String address, String zipcode,
			String city, String state, String phoneNumber, String email, String status) {
		super();
		this.merchantId = merchantId;
		this.merchantName = merchantName;
		this.organisationName = organisationName;
		this.address = address;
		this.zipcode = zipcode;
		this.city = city;
		this.state = state;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.status = status;
	}

	public MerchantDTO(String merchantName, String organisationName, String address, String zipcode, String city,
			String state, String phoneNumber, String email, String status) {
		super();
		this.merchantName = merchantName;
		this.organisationName = organisationName;
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
		return organisationName;
	}

	public void setOrganisationName(String organisationName) {
		this.organisationName = organisationName;
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

	public MerchantDTO(Merchant merchant) {
		this.merchantId = merchant.getMerchantId();
		this.merchantName = merchant.getMerchantName();
		this.organisationName = merchant.getOrganisationName();
		this.address = merchant.getAddress();
		this.zipcode = merchant.getZipcode();
		this.city = merchant.getCity();
		this.state = merchant.getState();
		this.phoneNumber = merchant.getPhoneNumber();
		this.email = merchant.getEmail();
		this.status = merchant.getStatus();
		this.image = merchant.getImage();
	}

	@Override
	public boolean equals(Object obj) {

		if (obj != null && obj.getClass() == this.getClass()) {
			MerchantDTO merchant = (MerchantDTO) obj;
			if (merchant.getPhoneNumber().equals(this.getPhoneNumber())) {
				return true;
			}
		}
		return false;
	}

	@Override
	public int hashCode() {
		return super.hashCode();
	}

}
