package com.spring.SantoshBagApplication.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.SantoshBagApplication.entity.Stock;

public interface StockRepository extends JpaRepository<Stock, Integer> {

}
