package com.sprint.bean.annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.junit.Test;
public class UserAnnotationTest {

	ApplicationContext context = new ClassPathXmlApplicationContext("config/spring-bean-annotation.xml"); 

	@Test
	public void testPrintInfo() {
					
	}

}
