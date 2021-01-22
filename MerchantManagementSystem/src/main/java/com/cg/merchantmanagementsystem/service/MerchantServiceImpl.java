package com.cg.merchantmanagementsystem.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.merchantmanagementsystem.dao.MerchantDAO;
import com.cg.merchantmanagementsystem.dto.MerchantDTO;
import com.cg.merchantmanagementsystem.entity.Merchant;
import com.cg.merchantmanagementsystem.exception.MerchantException;

@Service
public class MerchantServiceImpl implements MerchantService {

	@Autowired
	MerchantDAO merchantDao;
	
	String idNotPresent="Merchant Id is null";
	String disabled="DISABLED";

	@Override
	public MerchantDTO addMerchant(MerchantDTO merchantDto) {
		merchantDto.setMerchantId(null);
		if (!merchantDao.existsByPhoneNumber(merchantDto.getPhoneNumber())) {

			try {
				Merchant merchant = merchantDao.save(new Merchant(merchantDto));
				return new MerchantDTO(merchant);
			} catch (IllegalArgumentException e) {
				throw new MerchantException(e.getMessage());
			}
		} else {
			throw new MerchantException("Merchant already exist with same phone number!");
		}
	}

	@Override
	public boolean disableAccount(Integer merchantId) {
		if (merchantId == null) {
			throw new MerchantException(idNotPresent);
		}
		if (merchantDao.existsById(merchantId)) {
			Optional<Merchant> merchant = merchantDao.findById(merchantId);
			if (merchant.isPresent())
				merchant.get().setStatus(disabled);
			try {
				if (merchant.isPresent())
					merchantDao.save(merchant.get());
				return true;
			} catch (IllegalArgumentException e) {
				throw new MerchantException(e.getMessage());
			}

		} else {
			throw new MerchantException("Merchant doesn't exists!");
		}
	}

	@Override
	public boolean blockAccount(Integer merchantId) {
		if (merchantId == null) {
			throw new MerchantException(idNotPresent);
		}
		if (merchantDao.existsById(merchantId)) {
			Optional<Merchant> merchant = merchantDao.findById(merchantId);
			if (merchant.isPresent()) {
				if (merchant.get().getStatus().equals(disabled)) {
					throw new MerchantException("Merchant account is already disabled!");
				}
				merchant.get().setStatus("BLOCKED");
			}
			try {
				if (merchant.isPresent())
					merchantDao.save(merchant.get());
				return true;
			} catch (IllegalArgumentException e) {
				throw new MerchantException(e.getMessage());
			}
		} else {
			throw new MerchantException("Merchant doesn't exists!");
		}
	}

	@Override
	public MerchantDTO updateMerchant(MerchantDTO merchantDto) {

		if (merchantDao.existsById(merchantDto.getMerchantId())) {
			try {
				Merchant merchant = merchantDao.save(new Merchant(merchantDto));
				return new MerchantDTO(merchant);
			} catch (IllegalArgumentException e) {
				throw new MerchantException(e.getMessage());
			}
		} else {
			throw new MerchantException("Merchant doesn't exists!");
		}
	}

	@Override
	public List<MerchantDTO> viewMerchants() {

		List<Merchant> list = (List<Merchant>) merchantDao.findAll();
		if (list.size()!=0) {
			
			return StreamSupport.stream(list.spliterator(), false).map(merchant -> new MerchantDTO(merchant))
					.collect(Collectors.toList());
		}
		else {
			throw new MerchantException("No merchant present in the system");
		}
		
	}

	@Override
	public MerchantDTO getMerchant(Integer merchantId) {
		if (merchantId == null) {
			throw new MerchantException(idNotPresent);
		}
		if (merchantDao.existsById(merchantId)) {
			Optional<Merchant> merchant = merchantDao.findById(merchantId);
			if (merchant.isPresent()) {
				return new MerchantDTO(merchant.get());
			} else {
				throw new MerchantException("merchant does not exist with this id");
			}

		} else {
			throw new MerchantException("Merchant doesn't exists!");
		}
	}

	@Override
	public boolean unblockAccount(Integer merchantId) {
		if (merchantId == null) {
			throw new MerchantException(idNotPresent);
		}
		if (merchantDao.existsById(merchantId)) {
			Optional<Merchant> merchant = merchantDao.findById(merchantId);
			if (merchant.isPresent()) {
				if (merchant.get().getStatus().equals(disabled)) {
					throw new MerchantException("Merchant account is already disabled!");
				}
				if (merchant.get().getStatus().equals("ACTIVE")) {
					throw new MerchantException("Merchant account is already Active!");
				}
				merchant.get().setStatus("ACTIVE");
				merchantDao.save(merchant.get());
				return true;
			} else {
				throw new MerchantException("merchant does not exist");
			}
		} else {
			throw new MerchantException("Merchant doesn't exists!");
		}
	}

	@Override
	public boolean merchantExist(Integer merchantId) {

		return merchantDao.existsById(merchantId);
	}

	@Override
	public boolean checkMerchant(Integer merchantId) {
		return merchantDao.existsById(merchantId);
	}

	@Override
	public void deleteMerchant(Merchant merchant) {
		merchantDao.delete(merchant);
	}

	@Override
	public boolean deleteAccount(Integer merchantId) {
		 merchantDao.deleteById(merchantId);
		 return true;
	}

}
