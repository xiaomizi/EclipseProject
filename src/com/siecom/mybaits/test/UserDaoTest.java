package com.siecom.mybaits.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.siecom.mybaits.dao.UserDao;
import com.siecom.mybaits.dao.impl.UserDaoImpl;
import com.siecom.mybaits.po.User;

public class UserDaoTest {

	// 会话工厂
	private SqlSessionFactory sqlSessionFactory;
	
	@Before
	public void createSqlSessionFactory() throws IOException {
		// 配置文件
		String resource = "SqlMapConfig.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);

		// 使用SqlSessionFactoryBuilder从xml配置文件中创建SqlSessionFactory
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

	}

	@Test
	public void testGetUserById() {
		UserDao userDao=new UserDaoImpl(sqlSessionFactory);
		User user = userDao.getUserById(33);
		System.out.println(user);
	}

	@Test
	public void testGetUserByName() {
		UserDao userDao=new UserDaoImpl(sqlSessionFactory);
		List<User> list = userDao.getUserByName("张");
		for(User user:list){
			System.out.println(user);
		}
	}

	@Test
	public void testInsertUser() {
		System.out.println("hot_fix");
		UserDao userDao=new UserDaoImpl(sqlSessionFactory);
		User user=new User();
		user.setUsername("桔梗");
		user.setBirthday(new Date());
		user.setSex("2");
		user.setAddress("犬夜叉古代东瀛");
		userDao.insertUser(user);
	}
}
