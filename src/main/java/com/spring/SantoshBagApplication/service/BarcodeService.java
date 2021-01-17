package com.spring.SantoshBagApplication.service;

import java.io.FileNotFoundException;
import java.util.List;

import com.itextpdf.text.DocumentException;
import com.spring.SantoshBagApplication.entity.Barcode;

public interface BarcodeService {
	public List<Barcode> findAll();	
	public Barcode findById(int theId);
	public void save(Barcode barcode);
	public void deleteByAll();	
	public void generateBarcodeService() throws FileNotFoundException, DocumentException;

}
