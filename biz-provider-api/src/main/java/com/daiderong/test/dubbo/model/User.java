package com.daiderong.test.dubbo.model;

import java.io.Serializable;

/**
 * 用户对象
* @ClassName: User 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author daiderong
* @date 2017年8月7日 下午2:06:26 
*
 */
public class User implements Serializable {

	private String username;
	
	private Integer age;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}
	
	public User() {
		super();
	}

	public User(String username, Integer age) {
		super();
		this.username = username;
		this.age = age;
	}

	
	@Override
	public String toString() {
		return String.format("{user:%s,age:%s}", username,age);
	}

	
	
	
	
	
	
	
	
}
