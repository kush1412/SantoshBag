package com.spring.SantoshBagApplication.excel;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.spring.SantoshBagApplication.dao.BrandRepository;
import com.spring.SantoshBagApplication.entity.Brand;

@Service
public class ExcelService {

	@Autowired
	BrandRepository repository;

	public void save(MultipartFile file) {
		try {
			  System.out.println("ExcelService==> save"); 
			List<Brand> brandList = ExcelHelper.excelToTutorials(file.getInputStream());
			for(Brand br:brandList) {
				System.out.println("brandName==>"+br.getBrandName());
			}
			
			repository.saveAll(brandList);
		} catch (IOException e) {
			throw new RuntimeException("fail to store excel data: " + e.getMessage());
		}
	}

	public List<Brand> getAllTutorials() {
		return repository.findAll();
	}
}
