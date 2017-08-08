package com.test;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;

import com.daiderong.test.dao.invoke.UserMapperInvoke;
import com.daiderong.test.dubbo.model.User;
import com.github.pagehelper.PageInfo;

public class UserMapperInvokeTest extends JunitBaseTest  {

	
	@Resource 
	private UserMapperInvoke userMapperInvoke;
	
	@Test
	public void testQueryPage() throws Exception {
		PageInfo<User> pageInfo =  userMapperInvoke.queryPage(10, 2, new User());
		System.out.println(pageInfo);
	}
	
	@Test
	public void testQueryListByPage() throws Exception {
		List<User> list =  userMapperInvoke.queryListByPage(10, 2, new User());
		System.out.println(list);
	}
	
	
	@Test
	public void testCreate() throws Exception {
		 userMapperInvoke.create(new User("zss11ss", 15));
	
	}
	
	@Test
	public void testExists() throws Exception {
	     User param =  new User();
		System.out.println( userMapperInvoke.existsBySelective(param));
	
	}
	
	
	@Test
	public void testGroupByAge() throws Exception {
		System.out.println( userMapperInvoke.getMapper().groupByAgeSeg());
	
	}
	
	
}
