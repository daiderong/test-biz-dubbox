package com.daiderong.test.dubbo.web.filter;

import java.io.IOException;
import java.util.StringTokenizer;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


public class WebInitFilter implements Filter {

	
	
	private Log log = LogFactory.getLog(this.getClass());

	private String encoding = "UTF-8";
	
	
	
	
	public String getEncoding() {
		return encoding;
	}

	public void setEncoding(String encoding) {
		this.encoding = encoding;
	}

	@Override
	public void destroy() {

	}

	@Override
	public void doFilter(ServletRequest servletRequest,
			ServletResponse servletResponse, FilterChain filterChain)
			throws IOException, ServletException {
		
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		servletRequest.setCharacterEncoding(encoding);
		servletResponse.setCharacterEncoding(encoding);
		long timeBegin = System.currentTimeMillis();
		String  reqUrl = request.getRequestURL()+(request.getQueryString()==null?"":("?"+request.getQueryString()));
		String  reqIp =  getIp(request);
		log.info("ip:"+reqIp+",访问url:"+reqUrl+",提交方式:"+request.getMethod());
		//初始化session
	
		filterChain.doFilter(servletRequest, servletResponse);
		log.info("ip:"+reqIp+",访问url:"+reqUrl+",提交方式:"+request.getMethod()+",use time:"+(System.currentTimeMillis()-timeBegin)+" ms");

		return;

	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		String encoding = arg0.getInitParameter("encoding");
		if(encoding!=null){
			this.encoding = encoding;
		}
	}
	
	/**
	 * 获得客户端Ip，
	 * 非request.getRemoteAddr()这么简单的取ip
	 * 若request历经nginx，F5等转发以后一般ip不能直接取getRemoteAddr().
	 * @param request
	 * @return
	 */
	public static String getIp(final HttpServletRequest request) {
		String ip = request.getHeader("x-forwarded-for");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("x-client-ip");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		
		// 多级反向代理
		if (null != ip && !"".equals(ip.trim())) {
			StringTokenizer st = new StringTokenizer(ip, ",");
			if (st.countTokens() > 1) {
				return st.nextToken();
			}
		}
		return ip;
	}
}
