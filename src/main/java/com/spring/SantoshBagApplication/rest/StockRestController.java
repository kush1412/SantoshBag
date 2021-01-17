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

import com.spring.SantoshBagApplication.entity.Stock;
import com.spring.SantoshBagApplication.service.StockService;

@RestController
@RequestMapping("/api")
public class StockRestController {

	private StockService stockService;
	
	@Autowired
	public StockRestController(StockService stockService) {
		this.stockService=stockService;
	}
	
	@GetMapping("/stocks")
	public List<Stock> findAll() {
		System.out.println("get method is being called");
		return stockService.findAll();
	}
	
	@GetMapping("/stocks/{stockId}")
	public Stock getStock(@PathVariable int stockId) {
		
		Stock stock = stockService.findById(stockId);
		
		if (stock == null) {
			throw new RuntimeException("stock id not found - " + stockId);
		}
		
		return stock;
	}
	
	@PostMapping("/stock")
	public Stock addStock(@RequestBody  Stock thestock) {
		
		// also just in case they pass an id in JSON ... set id to 0
		// this is to force a save of new item ... instead of update
		
		thestock.setId(0);
		
		stockService.save(thestock);
		
		return thestock;
	}
	
	@PutMapping("/stock")
	public Stock updateUser(@RequestBody Stock thestock) {
		
		stockService.save(thestock);
		
		return thestock;
	}
	
	@DeleteMapping("/stocks/{stockId}")
	public String deleteEmployee(@PathVariable int stockId) {
		
		Stock tempStock = stockService.findById(stockId);
		
		// throw exception if null
		
		if (tempStock == null) {
			throw new RuntimeException("StockId id not found - " + stockId);
		}
		
		stockService.deleteById(stockId);
		
		return "Deleted employee id - " + stockId;
	}
}
