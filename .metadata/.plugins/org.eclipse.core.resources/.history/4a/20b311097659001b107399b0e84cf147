package com.capg.inventory.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.inventory.beans.ProductDto;
import com.capg.inventory.dao.MerchantDAO;
@Service
public class MerchantServiceImpl implements MerchantService{
	@Autowired
    private MerchantDAO merchantDao;
	
	@Override
	public ProductDto getProduct(Integer productId) {
		// TODO Auto-generated method stub
		return merchantDao.getProduct(productId);
	}

	@Override
	public boolean addProduct(ProductDto productInformation) {
		// TODO Auto-generated method stub
		return merchantDao.addProduct(productInformation);
	}

	@Override
	public boolean updateProduct(ProductDto productInformation) {
		// TODO Auto-generated method stub
		return merchantDao.updateProduct(productInformation);
	}

	@Override
	public boolean deleteProduct(Integer productId) {
		// TODO Auto-generated method stub
		return merchantDao.deleteProduct(productId);
	}

	@Override
	public List<ProductDto> viewProducts() {
		// TODO Auto-generated method stub
		return merchantDao.viewProducts();
	}

}
