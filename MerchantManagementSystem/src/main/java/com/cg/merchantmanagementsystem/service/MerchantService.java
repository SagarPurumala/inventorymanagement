package com.cg.merchantmanagementsystem.service;

import java.util.List;

import com.cg.merchantmanagementsystem.dto.MerchantDTO;
import com.cg.merchantmanagementsystem.entity.Merchant;

public interface MerchantService {
	
	MerchantDTO addMerchant(MerchantDTO merchantDto);
	
	boolean disableAccount(Integer merchantId);
	
	boolean blockAccount(Integer merchantId);
	
	boolean unblockAccount(Integer merchantId);
	
	MerchantDTO updateMerchant(MerchantDTO merchantDto);
	
	List<MerchantDTO> viewMerchants();
	
	MerchantDTO getMerchant(Integer merchantId);
	
	boolean merchantExist(Integer merchantId);

	boolean checkMerchant(Integer merchantId);

	void deleteMerchant(Merchant merchant);

	boolean deleteAccount(Integer merchantId);
}
