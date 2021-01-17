package com.spring.SantoshBagApplication.excel;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.spring.SantoshBagApplication.dao.PurchaseRepository;
import com.spring.SantoshBagApplication.entity.Purchase;

@Service
public class PurchaseExcelService {

	@Autowired
	PurchaseRepository repository;

	public void save(MultipartFile file) {
		try {
			System.out.println("ExcelService==> save"); 
			List<Purchase> purchaseList = PurchaseExcelHelper.excelToTutorials(file.getInputStream());
			repository.saveAll(purchaseList);
		} catch (IOException e) {
			throw new RuntimeException("fail to store excel data: " + e.getMessage());
		}
	}

}
