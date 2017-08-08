package com.daiderong.test.junit;

import org.junit.Test;

import com.alibaba.dubbo.config.annotation.Reference;
import com.daiderong.test.dubbo.model.User;
import com.daiderong.test.dubbo.service.UserService;

public class UserServiceTest extends JunitBaseTest {

	/**
	 * 
	 */
	@Reference
	private UserService userService;
	
	
	@Test
	public void testRegister() throws Exception {
		
		userService.register(new User("xxxx2",16));
		
		userService.register(new User("xxxx3",16));
		userService.register(new User("xxxx5",16));
	}
	
	
	
	
	
}
