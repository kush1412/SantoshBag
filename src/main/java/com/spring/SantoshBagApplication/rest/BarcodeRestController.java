package com.spring.SantoshBagApplication.rest;

import java.io.FileNotFoundException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itextpdf.text.DocumentException;
import com.spring.SantoshBagApplication.entity.Barcode;
import com.spring.SantoshBagApplication.service.BarcodeServiceImpl;

@RestController
@RequestMapping("/api")
public class BarcodeRestController {
	private BarcodeServiceImpl barcodeService;
	
	@Autowired
	public BarcodeRestController(BarcodeServiceImpl barcodeService) {
		this.barcodeService=barcodeService;
	}
	
	@GetMapping("/bracodes")
	public List<Barcode> getBarcodes(){
		return barcodeService.findAll();
	}
	
	@GetMapping("/bracode/{barcodeId}")
	public Barcode getBarcode(@PathVariable int barcodeId) {
		Barcode barcode = barcodeService.findById(barcodeId);
		if(barcode==null) {
			throw new RuntimeException("barcode id not found - " + barcodeId);
		}
		return barcode;
	}
	
	@PostMapping("/barcode")
	public Barcode addBarcode(@RequestBody Barcode barcode) {
		if(barcode !=null) {
			barcode.setId(0);
			barcodeService.save(barcode);
			return barcode;
		}else {
			throw new RuntimeException("barcode request body are null - "+barcode);
		}
		
	}
	
	@PutMapping("/barcode")
	public Barcode updateBarcode(@RequestBody Barcode barcode) {
		if (barcode != null) {
			barcodeService.save(barcode);
			return barcode;
		} else {
			throw new RuntimeException("barcode request body are null - " + barcode);
		}
	}
	
	@GetMapping("/printBarcodes")
	public void generateBarcode() {
		try {
			barcodeService.generateBarcodeService();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
