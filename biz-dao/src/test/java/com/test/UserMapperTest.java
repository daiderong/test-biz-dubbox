package com.test;

import java.util.Random;

import javax.annotation.Resource;

import org.junit.Test;
import org.mybatis.spring.SqlSessionTemplate;

import com.daiderong.test.dao.mapper.UserMapper;
import com.daiderong.test.dubbo.model.User;

public class UserMapperTest extends JunitBaseTest {

	

	@Resource 
	private SqlSessionTemplate sqlSessionTemplate;

	
	String chars = "abcdefghijklmn";
	Random random = new Random();
	@Test
	public void testCreate() throws Exception {
		try {
			UserMapper mapper =  sqlSessionTemplate.getMapper(UserMapper.class);
			mapper.create(new User(randomChars(5),20));
			mapper.create(new User(randomChars(5),20));
			mapper.create(new User(randomChars(5),20));
			mapper.create(new User(randomChars(5),20));
			mapper.create(new User(randomChars(5),20));
			mapper.create(new User(randomChars(5),20));
			mapper.create(new User(randomChars(5),20));
			mapper.create(new User(randomChars(5),20));
			mapper.create(new User(randomChars(5),20));
			mapper.create(new User(randomChars(5),20));
			mapper.create(new User(randomChars(5),20));
			mapper.create(new User(randomChars(5),20));
			mapper.create(new User(randomChars(5),20));
			mapper.create(new User(randomChars(5),20));
			mapper.create(new User(randomChars(5),20));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	
	@Test
	public void testFindById() throws Exception {
		try {
			UserMapper mapper =  sqlSessionTemplate.getMapper(UserMapper.class);
			System.out.println(mapper.findById("daiderong"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	private String randomChars(int len){
		String str = "";
		for(int i=0;i<len;i++){
			str+=(chars.charAt(random.nextInt(chars.length()))+"");
		}
		return str;
		
	}
}
