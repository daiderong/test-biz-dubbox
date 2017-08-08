package com.daiderong.test.dubbo.provider.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.alibaba.dubbo.config.annotation.Service;
import com.daiderong.test.dao.invoke.UserMapperInvoke;
import com.daiderong.test.dubbo.model.User;
import com.daiderong.test.dubbo.service.UserService;
import com.github.pagehelper.PageInfo;

@Component
@Service
public class UserServiceImpl implements  UserService {

	
	@Resource
	private UserMapperInvoke userMapperInvoke;
	
	@Override
	public void register(User user) {
		userMapperInvoke.create(user);
	}

	@Override
	public User getByUsername(String name) {
		return userMapperInvoke.findById(name);
	}

	@Override
	public List<User> loadAll() {
		return userMapperInvoke.loadAll();
	}

	@Override
	public PageInfo<User> queryPage(int pageSize, int pageNo, User param) {
		return userMapperInvoke.queryPage(pageSize, pageNo, param);
	}

}
