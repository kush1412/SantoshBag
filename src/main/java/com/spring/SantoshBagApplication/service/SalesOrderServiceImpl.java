package com.spring.SantoshBagApplication.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.SantoshBagApplication.dao.SalesOrderRespository;
import com.spring.SantoshBagApplication.entity.SalesOrder;

@Service
public class SalesOrderServiceImpl implements SalesOrderService {

	private SalesOrderRespository salesOrderRepository;
	
	@Autowired
	public SalesOrderServiceImpl(SalesOrderRespository salesOrderRepository) {
		this.salesOrderRepository=salesOrderRepository;
	}
	
	@Override
	public List<SalesOrder> findAll() {
		// TODO Auto-generated method stub
		return salesOrderRepository.findAll();
	}

	@Override
	public SalesOrder findById(int theId) {
		// TODO Auto-generated method stub
		Optional<SalesOrder> result=salesOrderRepository.findById(theId);
		SalesOrder salesOrder=null;
		if(result.isPresent()) {
			salesOrder=result.get();
		}else {
			throw new RuntimeException("Did not find salesOrder id - " + theId);
		}
		
		return salesOrder;
	}

	@Override
	public void save(SalesOrder salesorder) {
		// TODO Auto-generated method stub
		salesOrderRepository.save(salesorder);
	}

	@Override
	public void deleteById(int theId) {
		// TODO Auto-generated method stub
		salesOrderRepository.deleteById(theId);
		
	}

}
