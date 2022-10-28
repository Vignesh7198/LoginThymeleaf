package com.example.demo.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entity.Users;

public interface UserRepo extends JpaRepository<Users, Integer> {

	@Query(nativeQuery = true, value = "select * from users where username =:username and password=:password")
	Users findByUsernameAndPassword(@Param("username") String username, @Param("password") String password);
	
	

}
