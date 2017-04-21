package com.sprint.bean;

import com.sprint.helloword.*;
public class HelloApiInstanceFactory {
	public HelloApi newInstance(String message) {
		return new HelloImpl2(message);
	}
}
