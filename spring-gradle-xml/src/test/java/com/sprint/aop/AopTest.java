package com.sprint.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.junit.Test;
public class AopTest {
	
	ApplicationContext context = new ClassPathXmlApplicationContext("config/spring-aop.xml"); 
	@Test
	public void testHelloWorld() {
		IHelloWorldService helloWorldService = context.getBean("helloWorldService", IHelloWorldService.class);	
		helloWorldService.sayHello();
	}

}
