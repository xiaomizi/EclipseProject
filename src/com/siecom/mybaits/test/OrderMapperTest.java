package com.siecom.mybaits.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.siecom.mybaits.mapper.OrderMapper;
import com.siecom.mybaits.po.OrderUser;
import com.siecom.mybaits.po.Orders;
import com.siecom.mybaits.po.User;

public class OrderMapperTest {

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
	public void testGetOrderList() {
		SqlSession openSession = sqlSessionFactory.openSession();
		OrderMapper orderMapper = openSession.getMapper(OrderMapper.class);
		List<Orders> orders = orderMapper.getOrderList();
		for(Orders o:orders){
			System.out.println(o);
		}
		
		openSession.close();
	}

	@Test
	public void testGetOrderListResultMap() {
		SqlSession openSession = sqlSessionFactory.openSession();
		OrderMapper orderMapper = openSession.getMapper(OrderMapper.class);
		List<Orders> orders = orderMapper.getOrderListResultMap();
		for(Orders o:orders){
			System.out.println(o);
		}
		
		openSession.close();
	}
	
	@Test
	public void testGetOrderUserListResultType() {
		SqlSession openSession = sqlSessionFactory.openSession();
		OrderMapper orderMapper = openSession.getMapper(OrderMapper.class);
		List<OrderUser> orders = orderMapper.getOrderUserListResultType();
		for(OrderUser o:orders){
			System.out.println(o);
		}
		
		openSession.close();
	}
	
	@Test
	public void testGetOrderUserListResultMap() {
		SqlSession openSession = sqlSessionFactory.openSession();
		OrderMapper orderMapper = openSession.getMapper(OrderMapper.class);
		List<Orders> orders = orderMapper.getOrderUserListResultMap();
		for(Orders o:orders){
			System.out.println(o);
		}
		
		openSession.close();
	}
	
	@Test
	public void testGetUserOrdersResultMap() {
		SqlSession openSession = sqlSessionFactory.openSession();
		OrderMapper orderMapper = openSession.getMapper(OrderMapper.class);
		List<User> users = orderMapper.getUserOrdersResultMap();
		for(User u:users){
			System.out.println(u);
		}
		
		openSession.close();
	}
}
