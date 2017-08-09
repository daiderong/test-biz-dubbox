# test-biz-dubbox

### 项目说明
	当前项目是一个dubbox的服务化项目，本项目使用dubbox,zookeeper,spring,mybatis,pagehelper等开源框架，主要是帮助初学者快速上手dubbox并集成其它的框架

### 项目特点

	+ 多数使用注解方式，大大减少配置文件
	+ 使用了mybatis的mapper方式，并针对常用方法进行了封装，并集成了pagehelper分页，具体可以在biz-dao代码中查看
	+ 项目中集成了单元测试和WEB端测试，稍加改造可以直接是一个能使用的生产的项目
	

### 项目中的使用的测试表

```SQL

	CREATE TABLE `user` (
  		`username` varchar(20) NOT NULL,
  		`age` int(3) NOT NULL,
	  	PRIMARY KEY (`username`)
	) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4

```

### 项目中的使用到一些工具及版本号

+ JDK 1.8
+ Zookeeper 3.4
+ Tomcat 8.5
+ Mysql 5.6




### 提示

+ 不想自己打dubbox的包可以使用项目目录下jar目录下的dubbo-2.8.4.jar包，源代码也有
+ 也可以前往 https://github.com/dangdangdotcom/dubbox 下载下来自己打包





		


