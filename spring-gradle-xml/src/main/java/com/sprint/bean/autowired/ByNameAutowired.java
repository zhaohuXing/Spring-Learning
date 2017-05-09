package com.sprint.bean.autowired;

public class ByNameAutowired {
	private String name;
	HelloApi helloApi;
	public void setHelloApi(HelloApi helloApi) {
		this.helloApi = helloApi;
	}

	public HelloApi getHelloApi() {
		return helloApi;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
}
