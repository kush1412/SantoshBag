package com.spring.SantoshBagApplication.rest;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.SantoshBagApplication.entity.Purchase;
import com.spring.SantoshBagApplication.service.PurchaseService;

@RestController
@RequestMapping("/api")
public class PurchaseRestController {
	
	private PurchaseService purchaseService;
	
	public PurchaseRestController(PurchaseService purchaseService) {
		this.purchaseService=purchaseService;
	}
	
	@GetMapping("/purchases")
	public List<Purchase> findAll() {
		System.out.println("get method is being called");
		return purchaseService.findAll();
	}
	
	@GetMapping("/purchases/{purchaseId}")
	public Purchase getEmployee(@PathVariable int purchaseId) {
		
		Purchase thePurchase = purchaseService.findById(purchaseId);
		
		if (thePurchase == null) {
			throw new RuntimeException("Employee id not found - " + purchaseId);
		}
		
		return thePurchase;
	}
	
	@PostMapping("/purchases")
	public Purchase addPurchase(@RequestBody  Purchase thePurchase) {
		
		// also just in case they pass an id in JSON ... set id to 0
		// this is to force a save of new item ... instead of update
		
		thePurchase.setId(0);
		
		purchaseService.save(thePurchase);
		
		return thePurchase;
	}
	
	@PutMapping("/purchases")
	public Purchase updatePurchase(@RequestBody Purchase thePurchase) {
		
		purchaseService.save(thePurchase);
		
		return thePurchase;
	}
	
	@DeleteMapping("/purchases/{purchaseId}")
	public String deletePurchase(@PathVariable int purchaseId) {
		
		Purchase tempPurchase = purchaseService.findById(purchaseId);
		
		// throw exception if null
		
		if (tempPurchase == null) {
			throw new RuntimeException("Employee id not found - " + purchaseId);
		}
		
		purchaseService.deleteById(purchaseId);
		
		return "Deleted employee id - " + purchaseId;
	}
}
