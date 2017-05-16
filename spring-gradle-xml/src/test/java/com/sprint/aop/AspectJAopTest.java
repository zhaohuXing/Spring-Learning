package com.sprint.aop;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
public class AspectJAopTest {

	ApplicationContext context = new ClassPathXmlApplicationContext("config/spring-aop-aspectj.xml"); 
	@Test
	public void testAsepctJAop() {
		
		IHelloWorldService helloWorldService = context.getBean("helloWorldService", IHelloWorldService.class);
		helloWorldService.sayBefore("before---小土豆");
		System.out.println("===========testAspectJAop结束================");
	}
	
}
