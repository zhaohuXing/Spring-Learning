package com.sprint.bean.autowired;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.junit.Test;
public class ByNameAutowiredTest {
	
	ApplicationContext context = new ClassPathXmlApplicationContext("config/spring-bean-autowired.xml"); 

	@Test
	public void test() {
		ByNameAutowired bean = context.getBean("byName1", ByNameAutowired.class);
		System.out.println(bean.helloApi);
	}
}
