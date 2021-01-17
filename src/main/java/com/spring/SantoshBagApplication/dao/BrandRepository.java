package com.spring.SantoshBagApplication.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.SantoshBagApplication.entity.Brand;

public interface BrandRepository extends JpaRepository<Brand, Integer> {

}
