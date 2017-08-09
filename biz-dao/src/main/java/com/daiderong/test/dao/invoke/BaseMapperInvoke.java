package com.daiderong.test.dao.invoke;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.log4j.Logger;
import org.mybatis.spring.SqlSessionTemplate;

import com.daiderong.test.dao.mapper.BaseMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * 
 * 基本mapper类
* @ClassName: BaseMapperInvoke 
* @author daiderong
* @date 2017年8月8日 下午11:07:12 
* 
* @param <Mapper> 定义的sqlMapper的类
* @param <T>   JavaBean
* @param <ID>  JavaBean的ID类型
 */
public class BaseMapperInvoke<Mapper extends BaseMapper,T,ID> {

	
	private static  Log logger = LogFactory.getLog("BaseMapperInvoke");
	
	
	@Resource
	private SqlSessionTemplate sqlSessionTemplate;
	
	//将会通过第一次反射泛型第一个参数得到
	protected Class<Mapper> mapperClass = null;
	
	
	public  Mapper getMapper (){
		
		if(mapperClass != null){
			return (Mapper) sqlSessionTemplate.getMapper(mapperClass);
		}
		else{
			Type genType = getClass().getGenericSuperclass();   
			if(genType!=null){
				Type[] params = ((ParameterizedType) genType).getActualTypeArguments(); 
				if(params.length == 0){
					throw new IllegalArgumentException("Mapper 泛型类必须定义");
				}
				mapperClass =   (Class<Mapper>) params[0];
				logger.debug("Mapper class :"+mapperClass);
				return (Mapper) sqlSessionTemplate.getMapper(mapperClass);
			}
			throw new IllegalArgumentException("Mapper 泛型类必须定义");
		}
	
	}
	
	
	
	public void create(T t){
		getMapper().create(t);
	}
	
	public int update(T t){
		 return  getMapper().update(t);
	}
	
	public int deleteById(ID id){
		return getMapper().deleteById(id);
	}
	
	
	public List<T> loadAll(){
		return getMapper().loadAll();
	}
	
	
	
	public T findById(ID id){
		return (T) getMapper().findById(id);
	}
	
	
	
	public List<T> findBySelective(T param){
		return getMapper().findBySelective(param);
	}
	
	
	
	public boolean existsBySelective(T param){
		return getMapper().existsBySelective(param);
	}
	
	
	/**
	 * 使用分页查询，使用了PageHelper工具分页
	* @param pageSize 每一页的大小
	* @param pageNo	页码
	* @param param 参数
	* @return  PageInfo<T> 分页对象
	 */
	public PageInfo<T> queryPage(int pageSize,int pageNo,Object param){
		PageHelper.startPage(pageNo,pageSize,true);
		List<T> pagelist = getMapper().findBySelective(param);
		PageInfo<T> pageInfo = new PageInfo<>(pagelist);
		return pageInfo;
	}
	
	
	/**
	 * 使用分页查询，使用了PageHelper工具分页，
	 * 不统计，只返回第{pageNo}页的数据列表
	* @param pageSize 每一页的大小
	* @param pageNo	页码
	* @param param 参数
	* @return  PageInfo<T> 分页对象
	 */
	public List<T> queryListByPage(int pageSize,int pageNo,Object param){
		PageHelper.startPage(pageNo,pageSize,false);
		List<T> pagelist = getMapper().findBySelective(param);
		return pagelist;
	}
	

	
	
	
	
	
}
