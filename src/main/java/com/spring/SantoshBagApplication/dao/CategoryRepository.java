package com.spring.SantoshBagApplication.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.SantoshBagApplication.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer>{

}
