package com.siecom.mybaits.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.siecom.mybaits.po.User;

public class MyBatisTest {

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
		try {
			// 第一步:创建一个SQLSessionFactoryBuilder对象
			SqlSessionFactoryBuilder sessionFactoryBuilder = new SqlSessionFactoryBuilder();
			// 第二步:加载mybatis的配置文件
			InputStream resourceAsStream = Resources.getResourceAsStream("SqlMapConfig.xml");
			// 第三步:创建一个SQLSessionFactory对象
			SqlSessionFactory sessionFactory = sessionFactoryBuilder.build(resourceAsStream);
			// 第四步:创建一个SQLSession对象
			SqlSession sqlSession = sessionFactory.openSession();
			// 第五步:利用SQLSession进行SQL操作
			User user = sqlSession.selectOne("getUserById", 10);
			// 第六步:打印结果
			System.out.println(user);
			// 第七步:释放资源
			sqlSession.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testGetUserByName() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		// 第五步:利用SQLSession进行SQL操作
		List<User> list = sqlSession.selectList("getUserByName", "张");
		// 第六步:打印结果
		for(User user:list){
			System.out.println(user);
		}
		// 第七步:释放资源
		sqlSession.close();
	}
	
	@Test
	public void testAddUser() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		// 第五步:利用SQLSession进行SQL操作
		User user=new User();
		user.setUsername("桔梗");
		user.setBirthday(new Date());
		user.setSex("2");
		user.setAddress("犬夜叉古代东瀛");
		sqlSession.insert("addUser", user);
		System.out.println(user.getId());
		sqlSession.commit();
		// 第七步:释放资源
		sqlSession.close();
	}
	
	@Test
	public void testDeleteUserById() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		// 第五步:利用SQLSession进行SQL操作
		sqlSession.delete("deleteUserById", 30);
		sqlSession.commit();
		// 第七步:释放资源
		sqlSession.close();
	}
	
	@Test
	public void testUpdateUser() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		// 第五步:利用SQLSession进行SQL操作
		User user=new User();
		user.setId(33);
		user.setAddress("日本");
		sqlSession.update("updateUser", user);
		sqlSession.commit();
		// 第七步:释放资源
		sqlSession.close();
	}
}
