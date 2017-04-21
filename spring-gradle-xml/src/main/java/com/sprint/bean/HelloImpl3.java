package com.sprint.bean;

import com.sprint.helloword.HelloApi;
public class HelloImpl3 implements HelloApi {
	private int index;
	private String message;

	public HelloImpl3(int index, String message) {
		this.index = index;
		this.message = message;
	}

	@Override
	public void sayHello() {
		System.out.println("index:" + index + ", message:" + message);
	}
}
