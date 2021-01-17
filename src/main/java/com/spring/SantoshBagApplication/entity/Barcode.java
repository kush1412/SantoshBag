package com.spring.SantoshBagApplication.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Barcode")
public class Barcode {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="brandname")
	private String brandName;
	
	@Column(name="modelnumber")
	private String modelNumber;
	
	@Column(name="color")
	private String color;
	
	@Column(name="size")
	private String size;
	
	@Column(name="number_of_barcode")
	private String numberOfBarcode;
	
	public Barcode() {
		
	}

	public Barcode(int id, String brandName, String modelNumber, String color, String size, String numberOfBarcode) {
		super();
		this.id = id;
		this.brandName = brandName;
		this.modelNumber = modelNumber;
		this.color = color;
		this.size = size;
		this.numberOfBarcode=numberOfBarcode;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBrandName() {
		return brandName;
	}
	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}
	public String getModelNumber() {
		return modelNumber;
	}
	public void setModelNumber(String modelNumber) {
		this.modelNumber = modelNumber;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}	

	public String getNumberOfBarcode() {
		return numberOfBarcode;
	}

	public void setNumberOfBarcode(String numberOfBarcode) {
		this.numberOfBarcode = numberOfBarcode;
	}

	@Override
	public String toString() {
		return "Barcode [id=" + id + ", brandName=" + brandName + ", modelNumber=" + modelNumber + ", color=" + color
				+ ", size=" + size + "numberOfBarcode="+numberOfBarcode+"]";
	}	
	
}
