package com.cg.merchantmanagementsystem.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cg.merchantmanagementsystem.entity.Merchant;

@Repository
public interface MerchantDAO extends CrudRepository<Merchant, Integer> {
	
	public boolean existsByPhoneNumber(String phoneNumber);
	
}
