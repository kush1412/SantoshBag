package com.spring.SantoshBagApplication.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.spring.SantoshBagApplication.dao.PurchaseRepository;
import com.spring.SantoshBagApplication.entity.Purchase;

@Service
public class PurchaseServiceImpl implements PurchaseService {
	private PurchaseRepository purchaseRepository;
	
	public PurchaseServiceImpl(PurchaseRepository purchaseRepository) {
		this.purchaseRepository = purchaseRepository;
	}
	@Override
	public List<Purchase> findAll() {
		// TODO Auto-generated method stub
		return purchaseRepository.findAll();
	}

	@Override
	public Purchase findById(int theId) {
		// TODO Auto-generated method stub
		Optional<Purchase> result=purchaseRepository.findById(theId);
		Purchase purchase=null;
		if(result.isPresent()) {
			purchase=result.get();
		}else {
			throw new RuntimeException("Did not find purchase id - " + theId);
		}		
		return purchase;
	}

	@Override
	public void save(Purchase purchase) {
		// TODO Auto-generated method stub
		purchaseRepository.save(purchase);
	}

	@Override
	public void deleteById(int theId) {
		// TODO Auto-generated method stub
		purchaseRepository.deleteById(theId);
	}

}
