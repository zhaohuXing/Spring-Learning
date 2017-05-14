package com.sprint.bean.annotation;

import org.springframework.beans.factory.annotation.Autowired;
public class UserAnnotation {
	
	@Autowired
	private User user;

	public void printInfo() {
		System.out.println("user:" + user);
	}
}
