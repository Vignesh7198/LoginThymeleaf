package com.example.demo.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Repo.UserRepo;
import com.example.demo.entity.Users;

@Service
public class UserRepoImpl {
	
	@Autowired
	UserRepo userRepo;

	public boolean save(Users user) {
		
		Users users = userRepo.findByUsernameAndPassword(user.getUsername(), user.getPassword());
		
		if(users!=null) {
			return true;
		}
		
		return false;
	}
	
}
