package com.daiderong.test.dubbo.vo;

public class UserAgeSeg {

	private Integer lt6 = 0;//< 60 
	private Integer a6x = 0; //[60,70)
	private Integer a7x = 0 ;//[70,80)
	private Integer a8x = 0 ;//[80,90)
	private Integer gte9 = 0;//>= 90,
	
	
	public Integer getLt6() {
		return lt6;
	}
	public void setLt6(Integer lt6) {
		this.lt6 = lt6;
	}
	public Integer getA6x() {
		return a6x;
	}
	public void setA6x(Integer a6x) {
		this.a6x = a6x;
	}
	public Integer getA7x() {
		return a7x;
	}
	public void setA7x(Integer a7x) {
		this.a7x = a7x;
	}
	public Integer getA8x() {
		return a8x;
	}
	public void setA8x(Integer a8x) {
		this.a8x = a8x;
	}
	public Integer getGte9() {
		return gte9;
	}
	public void setGte90(Integer gte9) {
		this.gte9 = gte9;
	}
	
	@Override
	public String toString() {
		return String.format("lt6:%d,a6x:%d,a7x:%d,a8x:%d,gte9:%d", lt6,a6x,a7x,a8x,gte9);
	}
}
