package com.spring.SantoshBagApplication.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.SantoshBagApplication.entity.Purchase;

public interface PurchaseRepository extends JpaRepository<Purchase, Integer> {

}
