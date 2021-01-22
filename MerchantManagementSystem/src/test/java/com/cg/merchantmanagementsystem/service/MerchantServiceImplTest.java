package com.cg.merchantmanagementsystem.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Random;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.merchantmanagementsystem.dto.MerchantDTO;
import com.cg.merchantmanagementsystem.entity.Merchant;
import com.cg.merchantmanagementsystem.exception.MerchantException;

@SpringBootTest
 class MerchantServiceImplTest {


	@Autowired
	MerchantService merchantService;

	@Test
	void getMerchantListPass() {
		assertThat(merchantService.viewMerchants()).isNotEmpty();
	}

	@Test
	void addMerchantPass() {
		Random num = new Random();
	      int  num2, num3, num4, num5, num6, num7, num8, num9, num10, num11;
	   
	      num2 = 9;
	      num3 = num.nextInt(9) + 10;
	      num4 = num.nextInt(10);
	      num5 = num.nextInt(5) + 11;
	      num6 = num.nextInt(10);
	      num7 = num.nextInt(3);
	      num8 = num.nextInt(5);
	      num9 = num.nextInt(10);
	      String number=""+num2+num3+num4+num5+num6+num7+num8+num9;
		
		MerchantDTO merchant = new MerchantDTO("Pooja Rozara","Magic Builders","121, near ashok plaza", "133486", "Mohali", "Punjab",number, "pooja@gmail.com","ACTIVE");
		assertThat(merchantService.addMerchant(merchant).equals(merchant));
		merchantService.deleteMerchant(new Merchant(merchant));
	}

	@Test
	void addMerchantException() {
		MerchantDTO merchant = new MerchantDTO("Pooja Rozara","Magic Builders","121, near ashok plaza", "133486", "Mohali", "Punjab","8958684455", "pooja@gmail.com","ACTIVE");
		assertThrows( MerchantException.class, () -> {merchantService.addMerchant(merchant);});
	}

	@Test
	void updateMerchant() {
		MerchantDTO merchant = new MerchantDTO(1,"Pooja R.","Sudhanshu Sports","121, near ashok plaza", "133486", "Mohali", "Punjab","7526868370", "pooja@gmail.com","ACTIVE");
		assertThat(merchantService.updateMerchant(merchant).equals(merchant));
	}

	@Test
	void updateException() {
		MerchantDTO merchant = new MerchantDTO(987645,"Pooja ","Sudhanshu Sports","121, near ashok plaza", "133486", "Mohali", "Punjab","7526840370", "pooja@gmail.com","ACTIVE");
		assertThrows(MerchantException.class, () -> {
			merchantService.updateMerchant(merchant);
		});
	}

	@Test
	void getMerchantPass() {
		assertThat(merchantService.getMerchant(1)).isNotNull();
	}

	@Test
	void getMerchantException() {
		assertThrows(MerchantException.class, () -> {
			merchantService.getMerchant(null);
		});
	}
	
	@Test
	void getMerchantExceptionWhenNoMerchantExists() {
		assertThrows(MerchantException.class, () -> {
			merchantService.getMerchant(1234567890);
		});
	}

	
}
