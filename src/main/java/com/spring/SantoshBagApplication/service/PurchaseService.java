package com.spring.SantoshBagApplication.service;

import java.util.List;

import com.spring.SantoshBagApplication.entity.Purchase;

public interface PurchaseService {
	
	public List<Purchase> findAll();
	
	public Purchase findById(int theId);
	
	public void save(Purchase purchase);
	
	public void deleteById(int theId);
}
