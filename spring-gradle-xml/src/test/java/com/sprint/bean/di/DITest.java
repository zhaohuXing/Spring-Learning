package com.sprint.bean.di;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
public class DITest {
	
	ApplicationContext context = new ClassPathXmlApplicationContext("/config/spring-bean-di.xml");

	@Test 
	public void testConstructorDI() {
		ConstructorDI di = context.getBean("constructor-index", ConstructorDI.class);
		Assert.assertEquals("years:750000,ultimateAnswer:42", di.toString());		
		di = context.getBean("constructor-type", ConstructorDI.class);
		Assert.assertEquals("years:750000,ultimateAnswer:42", di.toString());		
		System.out.println(di.toString());
		di = context.getBean("constructor-name", ConstructorDI.class);
		Assert.assertEquals("years:750000,ultimateAnswer:42", di.toString());		
		System.out.println(di.toString());
	}

	@Test
	public void testSetterDI() {
		SetterDI di = context.getBean("setter", SetterDI.class);
		Assert.assertEquals("years:750000,ultimateAnswer:42", di.toString());		
	}
}
