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

import com.spring.SantoshBagApplication.entity.Brand;
import com.spring.SantoshBagApplication.service.BrandService;

@RestController
@RequestMapping("/api")
public class BrandRestController {
	
	private BrandService brandService;

	@Autowired
	public BrandRestController(BrandService brandService) {
		this.brandService=brandService;
	}
	
	@GetMapping("/brands")
	public List<Brand> findAll() {
		System.out.println("get method is being called");
		return brandService.findAll();
	}
	
	@GetMapping("/brands/{brandId}")
	public Brand getBrand(@PathVariable int brandId) {
		
		Brand theBrand = brandService.findById(brandId);
		
		if (theBrand == null) {
			throw new RuntimeException("Brand id not found - " + brandId);
		}
		
		return theBrand;
	}
	
	@PostMapping("/brand")
	public Brand addBrands(@RequestBody  Brand theBrand) {
		
		// also just in case they pass an id in JSON ... set id to 0
		// this is to force a save of new item ... instead of update
		
		theBrand.setId(0);
		
		brandService.save(theBrand);
		
		return theBrand;
	}
	
	@PutMapping("/brand")
	public Brand updateBrand(@RequestBody Brand brand) {
		
		brandService.save(brand);
		
		return brand;
	}
	
	@DeleteMapping("/brand/{brandId}")
	public String deleteBrand(@PathVariable int brandId) {
		
		Brand tempBrand = brandService.findById(brandId);
		
		// throw exception if null
		
		if (tempBrand == null) {
			throw new RuntimeException("Category id not found - " + brandId);
		}
		
		brandService.deleteById(brandId);
		
		return "Deleted brand id - " + brandId;
	}
	
}
