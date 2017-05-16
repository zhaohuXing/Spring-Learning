package com.sprint.aop;

public class HelloWorldService implements IHelloWorldService {
	
	@Override
	public void sayHello() {
		System.out.println("=====================Hello World");	
	}

	@Override
	public void sayBefore(String params) {
		System.out.println("===================before:params-" + params);
	}

	@Override
	public boolean sayAfterReturning() {
		System.out.println("==========after returning");	
		return true;
	}

	@Override
	public void sayAfterThrowing() {
		System.out.println("===============before throwing");
		throw new RuntimeException();
	}

	@Override
	public void sayAround(String param) {
		System.out.println("===========around param:" + param);
	}

	@Override
	public void sayAdvisorBefore(String param) {
		System.out.println("=========advisor param: " + param);
	}
}
