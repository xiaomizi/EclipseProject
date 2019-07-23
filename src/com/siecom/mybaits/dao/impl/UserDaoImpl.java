package com.siecom.mybaits.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.siecom.mybaits.dao.UserDao;
import com.siecom.mybaits.po.User;

public class UserDaoImpl implements UserDao {

	private SqlSessionFactory sqlSessionFactory;
	
	public UserDaoImpl(SqlSessionFactory sqlSessionFactory){
		this.sqlSessionFactory=sqlSessionFactory;
	}
	
	@Override
	public User getUserById(int id) {
		SqlSession openSession = sqlSessionFactory.openSession();
		User user = openSession.selectOne("getUserById", id);
		openSession.close();
		return user;
	}

	@Override
	public List<User> getUserByName(String username) {
		SqlSession openSession = sqlSessionFactory.openSession();
		List<User> list= openSession.selectList("getUserByName", username);
		openSession.close();
		return list;
	}

	@Override
	public void insertUser(User user) {
		SqlSession openSession = sqlSessionFactory.openSession();
		openSession.insert("addUser", user);
		openSession.commit();
		openSession.close();
	}

}
