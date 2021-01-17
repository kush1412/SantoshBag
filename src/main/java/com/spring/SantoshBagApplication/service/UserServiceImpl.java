package com.spring.SantoshBagApplication.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.SantoshBagApplication.dao.UserRepository;
import com.spring.SantoshBagApplication.entity.User;

@Service
public class UserServiceImpl implements UserService{
	
	private UserRepository userRepository;
	
	@Autowired
	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository=userRepository;
	}
	
	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return (List<User>) userRepository.findAll();
	}

	@Override
	public User findById(int theId) {
		// TODO Auto-generated method stub
		Optional<User> result=userRepository.findById(theId);
		User user=null;
		if(result.isPresent()) {
			user=result.get();
		}else {
			throw new RuntimeException("Did not find user id - " + theId);
		}
		return user;
	}
	
/*	@Override
	public User findByEmail(String email) {
		User user=userRepository.findByEmailId(email);
		if(user.getEmailId() !=null) {
			return user;
		}else {
			throw new RuntimeException("Did not find user email - " + email);
		}
	}*/

	@Override
	public void save(User user) {
		// TODO Auto-generated method stub
		userRepository.save(user);		
	}

	@Override
	public void deleteById(int theId) {
		// TODO Auto-generated method stub
		userRepository.deleteById(theId);
	}

	

}
