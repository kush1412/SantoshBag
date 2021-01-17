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

import com.spring.SantoshBagApplication.entity.SalesOrder;
import com.spring.SantoshBagApplication.service.SalesOrderService;

@RestController
@RequestMapping("/api")
public class SalesOrderRestController {
	private SalesOrderService salesOrderService;

	@Autowired
	public SalesOrderRestController(SalesOrderService salesOrderService) {
		this.salesOrderService=salesOrderService;
	}
	

	@GetMapping("/salesorders")
	public List<SalesOrder> findAll() {
		System.out.println("get method is being called");
		return salesOrderService.findAll();
	}
	
	@GetMapping("/salesorders/{salesorderId}")
	public SalesOrder getSalesOrder(@PathVariable int salesorderId) {

		SalesOrder theSalesOrder = salesOrderService.findById(salesorderId);
		
		if (theSalesOrder == null) {
			throw new RuntimeException("SalesOrder id not found - " + salesorderId);
		}

		return theSalesOrder;
	}
	
	@PostMapping("/salesorder")
	public SalesOrder addSalesOrder(@RequestBody  SalesOrder theSalesOrder) {
		
		// also just in case they pass an id in JSON ... set id to 0
		// this is to force a save of new item ... instead of update
		
		theSalesOrder.setId(0);
		
		salesOrderService.save(theSalesOrder);
		
		return theSalesOrder;
	}
	
	@PutMapping("/salesorder")
	public SalesOrder updateSalesOrder(@RequestBody SalesOrder salesOrder) {
		
		salesOrderService.save(salesOrder);
		
		return salesOrder;
	}
	
	@DeleteMapping("/salesorders/{salesorderId}")
	public String deleteEmployee(@PathVariable int salesorderId) {
		
		SalesOrder tempSalesOrder = salesOrderService.findById(salesorderId);
		
		// throw exception if null
		
		if (tempSalesOrder == null) {
			throw new RuntimeException("Employee id not found - " + salesorderId);
		}
		
		salesOrderService.deleteById(salesorderId);
		
		return "Deleted salesorder id - " + salesorderId;
	}
	
}
