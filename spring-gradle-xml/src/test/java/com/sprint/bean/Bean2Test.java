package com.sprint.bean;


import com.sprint.helloword.HelloApi;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.junit.Test;
public class Bean2Test {
	
	ApplicationContext context = new ClassPathXmlApplicationContext("first.xml");
	@Test
	public void testConstrutor() {
		HelloApi bean1 = context.getBean("bean1", HelloApi.class);
		bean1.sayHello();
		HelloApi bean2 = context.getBean("bean2", HelloApi.class);
		bean2.sayHello();
	}

	@Test
	public void testFactory() {
		HelloApi bean3 = context.getBean("bean3", HelloApi.class);
		bean3.sayHello();
	}

	@Test 
	public void testDI() {
		HelloApi byIndex = context.getBean("byIndex", HelloApi.class);
		byIndex.sayHello();
		HelloApi byType = context.getBean("byType", HelloApi.class);
		byType.sayHello();
		HelloApi byName = context.getBean("byName", HelloApi.class);
		byName.sayHello();
		HelloApi sByIndex = context.getBean("StaticFactoryByIndex", HelloApi.class);
		sByIndex.sayHello();
		HelloApi sByName = context.getBean("StaticFactoryByName", HelloApi.class);
		sByName.sayHello();
		HelloApi sByType = context.getBean("StaticFactoryByType", HelloApi.class);
		sByType.sayHello();
		HelloApi iByIndex = context.getBean("InstanceByIndex", HelloApi.class);
		iByIndex.sayHello();
		HelloApi iByName = context.getBean("InstanceByName", HelloApi.class);
		iByName.sayHello();
		HelloApi iByType = context.getBean("InstanceByType", HelloApi.class);
		iByType.sayHello();
		HelloApi setterBean = context.getBean("setterBean", HelloApi.class);
		setterBean.sayHello();
		BooleanDemo bd = context.getBean("boolean1", BooleanDemo.class);
		System.out.println(bd.isSuccess());
	}
}
