package com.spring.SantoshBagApplication.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.SantoshBagApplication.dao.CategoryRepository;
import com.spring.SantoshBagApplication.entity.Category;

@Service
public class CategoryServiceImpl implements CategoryService {

	private CategoryRepository categoryRepository;
	
	@Autowired
	public CategoryServiceImpl(CategoryRepository categoryRepository) {
		this.categoryRepository=categoryRepository;
	}
	
	@Override
	public List<Category> findAll() {
		// TODO Auto-generated method stub
		return categoryRepository.findAll();
	}

	@Override
	public Category findById(int theId) {
		// TODO Auto-generated method stub
		Optional<Category> result=categoryRepository.findById(theId);
		Category category=null;
		if(result.isPresent()) {
			category=result.get();
		}else {
			throw new RuntimeException("Did not find category id - " + theId);
		}
		return category;
	}

	@Override
	public void save(Category category) {
		// TODO Auto-generated method stub
		categoryRepository.save(category);		
	}

	@Override
	public void deleteById(int theId) {
		// TODO Auto-generated method stub
		categoryRepository.deleteById(theId);
	}

}
