package com.daiderong.test.dao.mapper;

import com.daiderong.test.dubbo.model.User;
import com.daiderong.test.dubbo.vo.UserAgeSeg;

/**
 * user sqlMap类
* @ClassName: UserMapper 
* @author daiderong
* @date 2017年8月8日 下午11:13:17 
*
 */
public interface UserMapper extends BaseMapper<User, String>    {

	
	//如果有特殊方法，可以定义在此接中，注意需要在对应的xml中实现(user-mapper.xml)
	
	
	/**
	 * 按年龄段统计用户人数
	 */
	UserAgeSeg groupByAgeSeg();
	
}

