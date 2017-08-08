package com.daiderong.test.dubbo.service;

import java.util.List;

import com.daiderong.test.dubbo.model.User;
import com.github.pagehelper.PageInfo;

/** 
 * 对外用户service API
* @ClassName: UserService 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author daiderong
* @date 2017年8月7日 下午2:06:55 
*  
*/
public interface UserService {

	
	/**
	 * 注册一个用户
	* @param user 用户对象
	 */
	void  register(User user);
	
	/**
	 * 通过用户名来查找用户
	* @param name 用户名
	* @return
	 */
	User getByUsername(String name);
	
	
	/**
	 * 返回所有用户列表
	* @return
	 */
	List<User> loadAll();
	
	
	/**
	 * 分页查询列表
	* @param pageSize
	* @param pageNo
	* @param param
	* @return
	 */
	PageInfo<User> queryPage(int pageSize,int pageNo,User param);
	
	
}
