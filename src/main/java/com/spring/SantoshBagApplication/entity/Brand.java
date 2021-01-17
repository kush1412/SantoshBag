package com.spring.SantoshBagApplication.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Brand")
public class Brand {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="brand_name")
	private String brandName;	
	
	public Brand() {
		
	}
	
	public Brand(int id, String brandName) {
		super();
		this.id = id;
		this.brandName = brandName;
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

	@Override
	public String toString() {
		return "Brand [id=" + id + ", brandName=" + brandName + "]";
	}	
}
