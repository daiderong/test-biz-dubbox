package com.daiderong.test.dao.invoke;

import org.springframework.stereotype.Repository;

import com.daiderong.test.dao.mapper.UserMapper;
import com.daiderong.test.dubbo.model.User;

/**
 * user的sqlMap类
* @ClassName: UserMapperInvoke 
* @author daiderong
* @date 2017年8月8日 下午11:12:12 
*
 */
@Repository
public class UserMapperInvoke extends BaseMapperInvoke<UserMapper,User,String> {
	
	
	
}
