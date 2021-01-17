package com.spring.SantoshBagApplication.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.SantoshBagApplication.entity.SalesOrder;

public interface SalesOrderRespository extends JpaRepository<SalesOrder, Integer>{

}
