package com.spring.SantoshBagApplication.service;

import java.util.List;

import com.spring.SantoshBagApplication.entity.Category;


public interface CategoryService {
	
	public List<Category> findAll();
	
	public Category findById(int theId);
	
	public void save(Category category);
	
	public void deleteById(int theId);
}
