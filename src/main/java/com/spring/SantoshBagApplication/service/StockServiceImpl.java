package com.spring.SantoshBagApplication.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.SantoshBagApplication.dao.StockRepository;
import com.spring.SantoshBagApplication.entity.Stock;

@Service
public class StockServiceImpl implements StockService{
	
	private StockRepository stockRepository;
	
	@Autowired
	public StockServiceImpl(StockRepository stockRepository) {
		this.stockRepository=stockRepository;
	}
	
	@Override
	public List<Stock> findAll() {
		// TODO Auto-generated method stub
		return stockRepository.findAll();
	}

	@Override
	public Stock findById(int theId) {
		// TODO Auto-generated method stub
		Optional<Stock> result=stockRepository.findById(theId);
		Stock stock=null;
		if(result.isPresent()) {
			stock=result.get();
		}else {
			throw new RuntimeException("Did not find stock id - " + theId);
		}
		return stock;
	}

	@Override
	public void save(Stock stock) {
		// TODO Auto-generated method stub
		stockRepository.save(stock);
	}

	@Override
	public void deleteById(int theId) {
		// TODO Auto-generated method stub
		stockRepository.deleteById(theId);
	}

}
