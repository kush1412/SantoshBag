package com.spring.SantoshBagApplication.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.SantoshBagApplication.entity.Category;
import com.spring.SantoshBagApplication.service.CategoryService;

@RestController
@RequestMapping("/api")
public class CategoryRestController {

	private CategoryService categoryService;
	
	@Autowired
	public CategoryRestController(CategoryService categoryService) {
		this.categoryService=categoryService;
	}
	
	@GetMapping("/categories")
	public List<Category> findAll() {
		System.out.println("get method is being called");
		return categoryService.findAll();
	}
	
	@GetMapping("/categories/{categoryId}")
	public Category getEmployee(@PathVariable int categoryId) {
		
		Category theCategory = categoryService.findById(categoryId);
		
		if (theCategory == null) {
			throw new RuntimeException("Employee id not found - " + categoryId);
		}
		
		return theCategory;
	}
	
	@PostMapping("/categories")
	public Category addCategories(@RequestBody  Category theCategory) {
		
		// also just in case they pass an id in JSON ... set id to 0
		// this is to force a save of new item ... instead of update
		
		theCategory.setId(0);
		
		categoryService.save(theCategory);
		
		return theCategory;
	}
	
	@PutMapping("/categories")
	public Category updateCategory(@RequestBody Category category) {
		
		categoryService.save(category);
		
		return category;
	}
	
	@DeleteMapping("/categories/{categoryId}")
	public String deleteCategory(@PathVariable int categoryId) {
		
		Category tempCategory = categoryService.findById(categoryId);
		
		// throw exception if null
		
		if (tempCategory == null) {
			throw new RuntimeException("Category id not found - " + categoryId);
		}
		
		categoryService.deleteById(categoryId);
		
		return "Deleted salesorder id - " + categoryId;
	}
}
