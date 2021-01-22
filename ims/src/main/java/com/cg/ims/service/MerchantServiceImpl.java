package com.cg.ims.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.ims.dao.MerchantDao;
import com.cg.ims.entity.Product;
@Service
public class MerchantServiceImpl implements MerchantService{

	@Autowired
    private MerchantDao merchantDao; 
	
	@Override
	public Product getProduct(int productId) {
		// TODO Auto-generated method stub
		return merchantDao.getProduct(productId);
	}

}
