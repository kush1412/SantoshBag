package com.spring.SantoshBagApplication.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.SantoshBagApplication.dao.BrandRepository;
import com.spring.SantoshBagApplication.entity.Brand;

@Service
public class BrandServiceImpl implements BrandService {	
	
	private BrandRepository brandRepository;
	
	@Autowired
	public BrandServiceImpl(BrandRepository brandRepository) {
		this.brandRepository = brandRepository;
	}

	@Override
	public List<Brand> findAll() {
		// TODO Auto-generated method stub
		return brandRepository.findAll();
	}

	@Override
	public Brand findById(int theId) {
		// TODO Auto-generated method stub	
		Optional<Brand> result=brandRepository.findById(theId);
		Brand brand=null;
		if (result.isPresent()) {
			brand = result.get();
		}
		else {
			// we didn't find the employee
			throw new RuntimeException("Did not find brand id - " + theId);
		}
		
		return brand;
	}

	@Override
	public void save(Brand brand) {
		// TODO Auto-generated method stub
		brandRepository.save(brand);
		
	}

	@Override
	public void deleteById(int theId) {
		// TODO Auto-generated method stub
		brandRepository.deleteById(theId);
	}	

}
