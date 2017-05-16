package com.sprint.aop;

public interface IHelloWorldService {
	public void sayHello();
	public void sayBefore(String param);
	public boolean sayAfterReturning();
	public void sayAfterThrowing();
	public void sayAround(String param);
	public void sayAdvisorBefore(String param);
}
