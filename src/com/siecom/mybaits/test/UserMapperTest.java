package com.siecom.mybaits.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.siecom.mybaits.mapper.UserMapper;
import com.siecom.mybaits.po.QueryVo;
import com.siecom.mybaits.po.User;

public class UserMapperTest {

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
		SqlSession openSession = sqlSessionFactory.openSession();
		UserMapper userMapper = openSession.getMapper(UserMapper.class);
		User user = userMapper.getUserById(34);
		System.out.println(user);
		openSession.close();
	}

	@Test
	public void testGetUserByName() {
		SqlSession openSession = sqlSessionFactory.openSession();
		UserMapper userMapper = openSession.getMapper(UserMapper.class);
		List<User> list = userMapper.getUserByName("张");
		for(User user:list){
			System.out.println(user);
		}
		openSession.close();
	}

	@Test
	public void testInsertUser() {
		SqlSession openSession = sqlSessionFactory.openSession();
		UserMapper userMapper = openSession.getMapper(UserMapper.class);
		
		User user=new User();
		user.setUsername("桔梗");
		user.setBirthday(new Date());
		user.setSex("2");
		user.setAddress("犬夜叉古代东瀛");
		
		userMapper.insertUser(user);
		openSession.commit();
		openSession.close();
	}

	@Test
	public void testGetUserByQueryVo() {
		SqlSession openSession = sqlSessionFactory.openSession();
		UserMapper userMapper = openSession.getMapper(UserMapper.class);
		QueryVo queryVo=new QueryVo();
		User user=new User();
		user.setId(34);
		queryVo.setUser(user);
		User user1 = userMapper.getUserByQueryVo(queryVo);
		System.out.println(user1);
		openSession.close();
	}
	
	@Test
	public void testGetNumOfRows() {
		SqlSession openSession = sqlSessionFactory.openSession();
		UserMapper userMapper = openSession.getMapper(UserMapper.class);
		int numOfRows = userMapper.getNumOfRows();
		System.out.println(numOfRows);
		openSession.close();
	}
	
	@Test
	public void testFindUserList() {
		SqlSession openSession = sqlSessionFactory.openSession();
		UserMapper userMapper = openSession.getMapper(UserMapper.class);
		User user=new User();
		user.setId(27);
		user.setUsername("桔");
		List<User> list = userMapper.findUserList(user);
		for(User u:list){
			System.out.println(u);
		}
		openSession.close();
	}
	
	
	@Test
	public void testFindUserByIds() {
		SqlSession openSession = sqlSessionFactory.openSession();
		UserMapper userMapper = openSession.getMapper(UserMapper.class);
		QueryVo queryVo=new QueryVo();
		List<Integer> list_ids=new ArrayList<>();
		list_ids.add(1);
		list_ids.add(16);
		list_ids.add(26);
		list_ids.add(27);
		queryVo.setIds(list_ids);
		List<User> list = userMapper.findUserByIds(queryVo);
		for(User u:list){
			System.out.println(u);
		}
		openSession.close();
	}
}
