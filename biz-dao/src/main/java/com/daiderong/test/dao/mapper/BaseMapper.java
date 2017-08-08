package com.daiderong.test.dao.mapper;

import java.util.List;

public  interface BaseMapper<T,ID> {

	
	/**
	 * 保存对象 调用id = create 
	* @param t 表对应的javabean
	 */
	void create(T t);
	/**
	 * 更新 调用id = update 
	* @param t
	* @return
	 */
	int update(T t);
	/**
	 * 通过ID删除
	* @param id
	* @return
	 */
	int deleteById(ID id);
	
	/**
	 * 加载全部数据
	* @return List<T>
	 */
	List<T> loadAll();
	
	
	/**
	 * 通过ID来查找对象
	* @param id
	* @return
	 */
	T findById(ID id);
	
	
	/**
	 * 通过给定对象的值来查找列表
	* @param param 给定对象的值
	* @return List<T>
	 */
	List<T> findBySelective(T param);
	
	
	/**
	 * 判断对象是否存在
	* @param param
	* @return boolean
	 */
	boolean existsBySelective(T param);
	
	
	
	
	
	
}
