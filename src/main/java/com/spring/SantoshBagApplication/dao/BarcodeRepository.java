package com.spring.SantoshBagApplication.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.SantoshBagApplication.entity.Barcode;

public interface BarcodeRepository extends JpaRepository<Barcode, Integer>{

}
