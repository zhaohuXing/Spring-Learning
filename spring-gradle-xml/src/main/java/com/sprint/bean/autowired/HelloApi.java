package com.sprint.bean.autowired;

public class HelloApi {
	String apiName;

	public void setApiName(String apiName) {
		this.apiName = apiName;
	}

	@Override
	public String toString() {
		return "Hello Autowired";
	}
}
