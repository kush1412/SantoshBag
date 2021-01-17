package com.spring.SantoshBagApplication.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Salesorder")
public class SalesOrder {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="category")
	private String category;
	
	@Column(name="model_number")
	private String modelNumber;
	
	@Column(name="color")
	private String color;
	
	@Column(name="size")
	private String size;
	
	@Column(name="brand")
	private String brand;
	
	@Column(name="quantity")
	private String quantity;
	
	@Column(name="soldprice")
	private String soldprice;
	
	@Column(name="customer_name")
	private String customerName;	
	
	public SalesOrder() {
		
	}

	public SalesOrder(int id, String category, String modelNumber, String color, String size, String brand,
			String quantity, String soldprice, String customerName) {
		super();
		this.id = id;
		this.category = category;
		this.modelNumber = modelNumber;
		this.color = color;
		this.size = size;
		this.brand = brand;
		this.quantity = quantity;
		this.soldprice = soldprice;
		this.customerName = customerName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
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

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public String getSoldprice() {
		return soldprice;
	}

	public void setSoldprice(String soldprice) {
		this.soldprice = soldprice;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	@Override
	public String toString() {
		return "SalesOrder [id=" + id + ", category=" + category + ", modelNumber=" + modelNumber + ", color=" + color
				+ ", size=" + size + ", brand=" + brand + ", quantity=" + quantity + ", soldprice=" + soldprice
				+ ", customerName=" + customerName + "]";
	}	
	
}
