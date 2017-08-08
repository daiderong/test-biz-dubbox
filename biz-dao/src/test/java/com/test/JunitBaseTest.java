package com.test;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * junit 测试父类，继承此类可以扫描加载配置文件
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath*:test/**/*.xml","classpath*:context/**/*.xml"})
public class JunitBaseTest {
	
	
	
	
	

}