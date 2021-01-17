package com.spring.SantoshBagApplication.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.SantoshBagApplication.entity.User;


public interface UserRepository extends JpaRepository<User, Integer> {
	
}
