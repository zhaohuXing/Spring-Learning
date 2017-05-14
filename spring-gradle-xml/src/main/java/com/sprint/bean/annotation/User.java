package com.sprint.bean.annotation;

public class User {
	private String name;
	private int age;

	public User() {
		this.name = "小虎";
		this.age = 20;
	}
	
	@Override
	public String toString() {
		return "name: " + name + "age: " + age;
	}
}
