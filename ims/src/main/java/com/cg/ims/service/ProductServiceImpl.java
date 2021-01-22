package com.cg.ims.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.ims.dao.MerchantDao;
import com.cg.ims.dao.ProductDao;
import com.cg.ims.dto.ProductDto;
import com.cg.ims.entity.Product;
import com.cg.ims.exception.ProductException;

@Transactional
@Service
public class ProductServiceImpl  implements ProductService {

	@Autowired
	private ProductDao productDao;
	
//	@Autowired
//	private MerchantDao merchantDao;
//	
	@Override
	public List<Product> showallproduct() {
		return this.productDao.findAll();
	}

	@Override
	public Product saveProduct(ProductDto productDto) throws ProductException {
		try {
			productDto.setProductId(null);
			int d=productDto.getDiscount();
			float p=productDto.getOriginalPrice();
			float discounted=(p-((d*p)/100));
			productDto.setDiscountprice(discounted);
			
			return productDao.save(new Product(productDto));
		} catch (IllegalArgumentException e) {
			throw new ProductException(e.getMessage());
		}
	}

	@Override
	public void deleteproduct(int productId) {
		productDao.deleteById(productId);
		
	}

	@Override
	public float getPriceOfProduct(int productId) {
		// TODO Auto-generated method stub
		return 0;
	}

//	@Override
//	public Product updateProduct(ProductDto productDto) {
//		Product existingProduct = productDao.findById(productDto.getProductId()).orElse(null);
//		if (existingProduct != null) {
//			existingProduct.setProductName(productDto.getProductName());
//			existingProduct.setProductTag(productDto.getProductTag());
//			existingProduct.setProductDescription(productDto.getProductDescription());
//			existingProduct.setOriginalPrice(productDto.getOriginalPrice());
//			existingProduct.setDiscount(productDto.getDiscount());
//			existingProduct.setQuantity(productDto.getQuantity());
//			return productDao.save(existingProduct);
//		} else {
//			throw new ProductException("product does not exist by id");
//		}
//	}

	@Override
	public ProductDto getProduct(int productId) {
//		return merchantDao.getProduct(productId);
		return null;
	}

	@Override
	public Product updateProduct(ProductDto productDto) {
		// TODO Auto-generated method stub
		return null;
	}

}
