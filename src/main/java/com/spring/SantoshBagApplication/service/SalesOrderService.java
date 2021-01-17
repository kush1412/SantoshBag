package com.spring.SantoshBagApplication.service;

import java.util.List;

import com.spring.SantoshBagApplication.entity.SalesOrder;

public interface SalesOrderService {
	
	public List<SalesOrder> findAll();
	
	public SalesOrder findById(int theId);
	
	public void save(SalesOrder salesorder);
	
	public void deleteById(int theId);
}
