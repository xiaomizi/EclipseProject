package com.siecom.mybaits.mapper;

import java.util.List;

import com.siecom.mybaits.po.QueryVo;
import com.siecom.mybaits.po.User;

public interface UserMapper {
	User getUserById(int id);
	List<User> getUserByName(String username);
	void insertUser(User user);
	User getUserByQueryVo(QueryVo queryVo);
	int getNumOfRows();
	List<User> findUserList(User user);
	List<User> findUserByIds(QueryVo queryVo);
} 
