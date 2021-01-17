package com.spring.SantoshBagApplication.service;

import java.util.List;

import com.spring.SantoshBagApplication.entity.Brand;

public interface BrandService {
	
	public List<Brand> findAll();
	
	public Brand findById(int theId);
	
	public void save(Brand brand);
	
	public void deleteById(int theId);
}
