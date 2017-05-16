package com.sprint.aop;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
@Aspect
public class HelloWorldAspect2 {

	@Pointcut(value="execution(* com.sprint..*.sayBefore(..)) && args(param)", argNames="param")
	public void beforePointcut(String param) {}

	@Before(value="beforePointcut(param)", argNames="param")
	public void beforeAdvice(String param) {
		System.out.println("===========before advice param:" + param);	
	}	

	@AfterReturning(value="execution(* com.sprint..*.sayBefore(..))",
					pointcut="execution(* com.sprint..*.sayAfterReturning(..))",
					argNames="retVal", returning="retVal")
	public void afterReturningAdvice(Object retVal) {
		System.out.println("============after returning advice retVal：" + retVal);
	}	
	//剩下的通知如上,
	//@AfterThrowing
	//@After
	//@After

	//测试代码与schema一致，这里不在重复.
	//
	//xml 也好，annotation也好，只是一种元数据。既是框架也是个半成品，最终目标应放到产品上。

}
