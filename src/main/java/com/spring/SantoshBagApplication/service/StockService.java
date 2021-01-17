package com.spring.SantoshBagApplication.service;

import java.util.List;

import com.spring.SantoshBagApplication.entity.Stock;

public interface StockService {
	
	public List<Stock> findAll();
	
	public Stock findById(int theId);
	
	public void save(Stock stock);
	
	public void deleteById(int theId);
}
