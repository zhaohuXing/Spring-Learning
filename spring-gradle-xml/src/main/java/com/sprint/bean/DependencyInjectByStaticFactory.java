package com.sprint.bean;

import com.sprint.helloword.HelloApi;
public class DependencyInjectByStaticFactory {
	public static HelloApi newInstance(int index, String message) {
		return new HelloImpl3(index, message);
	}
}
