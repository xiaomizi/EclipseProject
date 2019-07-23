package com.siecom.mybaits.dao;

import java.util.List;

import com.siecom.mybaits.po.User;

public interface UserDao {
	User getUserById(int id);
	List<User> getUserByName(String username);
	void insertUser(User user);
} 
