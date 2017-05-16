#### 第一天：
IOC DI　概念

#### 第二天：Spring初涉(17-04-13)
元数据格式：　xml, annotation, java code<br />
ApplicationContext, AnnotationConfigApplicationContext, ClassPathXmlApplicationContext, naming beans<br />

## Spring-Bean之 Dependency Injection

两种注入方式:
- Constructor-based dependency injection
- Setter-based dependency injection

代码说明:
- src/main/java/com/sprint/bean/di/下所有文件
- src/main/resources/config/spring-bean-di.xml
- src/test/java/com/sprint/bean/di/

![DI方式.jpg](http://upload-images.jianshu.io/upload_images/2031765-148bf62b5c43be48.jpg?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

## Spring-Bean之Dependencies and configuration in detail(170421)
- src/main/java/com/sprint/bean/details/下所以文件
- src/main/resources/config/spring-bean-detail.xml
- src/test/java/com/sprint/bean/details/

![bean细节依赖.jpg](http://upload-images.jianshu.io/upload_images/2031765-b044d6aa74b37bed.jpg?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

## Spring-Bean之Depends-On(170508)
- src/main/java/com/sprint/bean/dependsOn/下所以文件
- src/main/resources/config/spring-bean-dependson.xml
- src/test/java/com/sprint/bean/dependsOn/

指定初始化,销毁顺序。depends-on值的bean要先初始化，早于被指定的Bean的,并且晚于被指定的Bean销毁.

## 省略知识点
- Spring-Bean之Lazy-initialized beans
- Spring-Bean之Autowiring collaborators
- Spring-Bean之Method injection

## Spring-Bean之Scope
- singleton　一般默认single, 保证Spring只有一个实例对象，不仅缓存对象而且还缓存Bean,将单例对象放入缓存池里。
- prototype 每次都会重新获取一个全新的Bean
- 等用到再说吧

## 资源的加载
- src/main/java/com/sprint/resource/
- 等用到再来深入学习吧

## spel语法(没用过)
- 框架这东西真的需要项目来驱动

## Aop
- 使用Schema-based AOP support 需要的依赖:spring-aop, cglib,aspectjweaver 
	- src/main/java/com/sprint/aop/
	- src/main/resources/config/spring-aop.xml用注释陈述了一些有关aop的概念,以及使用
	- src/test/java/com/sprint/aop/ 记录过程中出现的问题

- 使用@AspectJ注解，需要依赖:spring-aop, aspectjweaver.
	- src/main/java/com/sprint/aop/HelloWorldAspect2.java 里面配置aop及各种通知
	- src/main/resources/config/spring-aop-aspectj.xml
	- src/test/java/com/sprint/aop/ 

	


















