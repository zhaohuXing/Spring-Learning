xxx管理系统，司空见惯，寻找新大陆，抄某视频网站。
# 文档目录
- 开发环境及技术介绍
- 数据库设计
- 主页显示（利用Jsoup爬虫爬取信息）
- 视频播放
- 视频搜索
- 登录，注册
- 个人管理
-  视频管理
  - 私藏
  - 删除

# 开发环境及技术介绍
开发环境：
- Java 1.8+
- mysql
- redis
- nginx

会不会好奇，为什么没有服务器？你运行个毛线，错！SpringBoot内嵌Tomcat。
技术介绍：
- bootstrap (人丑，还不让美颜一下呀)
- SpringBoot (也是Java开源框架呀)
- MyBatis (没说非得用hibernate)


# 数据库设计
共三张表(user, category, category_item)
```
create table user(
	id int(11) not null auto_increment,
	email varchar(64) not null,
	password varchar(16) not null,
	nickname varchar(16) not null,
	primary key(id)
)engine = innodb default charset = utf8;

create table category(
	id bigint(20) not null auto_increment,
	user_id bigint(20) default null,
	name varchar(68) default null,
	logo varchar(68) default null,
	amount int(11) default 0,
	popularity bigint(20) default 0,
	md5 varchar(32) default null,
	primary key(id)
)engine=innodb default charset=utf8;

create table category_item (
  id bigint(20) not null auto_increment,
  user_id bigint(20) default null,
  category_id int(11) default null,
  type varchar(16) default null,
  name varchar(64) default null,
  image varchar(128) default null,
  url varchar(256) default null,
  primary key(id)
)engine = innodb default charset = utf8;
```
# 主页显示(利用Jsoup爬虫爬取信息)
前端利用bootstrap进行页面布局及美化,后台通过后台爬虫,主要爬取乐视视频信息，分析网页结构, 利用css选择器爬取视频名称，类型，图片，地址等信息，然后渲染到home页面上，并将爬取的信息暂存到redis库中。这里数据传输没有使用前后端分离，而是thymeleaf模板，使用ongl表达式，类似struts的。
![home显示.jpg](http://upload-images.jianshu.io/upload_images/2031765-b858a0ca74d57de8.jpg?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

代码：/src/main/java/site/aitudou/reids/task

# 视频播放
亮点：使用H5视频播放标签<video />,那么视频来源哪里？视频是由后台爬虫，抓取乐视网上的视频地址，解析到源地址，然后返回到video中的src属性.
页面的设计,共分为三部分：
- 视频播放部分
- 视频信息显示部分
- 剧情部分(集)

后台设计：利用Jsoup爬取地址，这里仍然用到了css选择器，分析网页div的标识，进一步寻找视频源地址。

![视频播放.jpg](http://upload-images.jianshu.io/upload_images/2031765-599f9ffff00a1b6d.jpg?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

代码:/src/main/java/site/aitudou/parse/  ,主要是ParseManager.java

# 视频搜索
猜猜这里是怎么实现的？自己使用like去搜索，错！，既然爬的是乐视视频上的，那么搜索，当然也是它的搜索栏，在它搜索网上上，分析出它的参数名，之后，之后在自己的页面上给参数赋予值，直接调用乐视的搜索接口。这样就轻而易举实现了视频的搜索，爬虫的威力还是很强大的。那么视频播放，就是上面的视频播放啦！
代码:/src/main/java/site/aitudou/parse/search/

# 登录，注册
#### 前端设计
- header.html设计
- login.html设计

header.html作为导航条，借用bootstap的样式，进行填写(logo, 首页，搜索，高级, 登录，个人中心), 如果用户登录了将显示个人中心．否则显示登录<br />
login.html作为登录注册一体的页面．除了样式外，重点应是：利用jquery,ajax,发post请求 <br />

```
// 通过jquery获取id = "username", id = "password"中的value
var username = $('#username').val() 
var password = $('#password').val()
var data = {
	username: 'username',
	password: 'password'
}
//利用jquery,ajax发送简单post请求，其中的一种
$.post('/url', data)

```

#### 后端设计
- security
- mail
- redis

采用spring-security进行安全设置(保护路径)，类似拦截器．总结[文章](http://www.jianshu.com/p/719ca436a5b6)<br />

注册除了进行数据库操作外，还通过邮箱进行验证,核心类：JavaMailSender(负责邮件的创建和发送), MimeMessage(纸), MimeMessageHelper(邮件各信息). 通过UUID和字符拼接生成token作为key, 将user的json作为value.存入到redis。用户需要在12小时内点击注册链接，完成注册。
登录通过spring-security框架进行安全设置。(让其访问指定的路径)，类型拦截器。
代码: /src/main/java/site/aitudou/config/

# 个人管理
个人管理，这里主要实现的是对个人信息的修改，个人信息就一个，那就是对昵称的修改，麻雀虽小，五脏俱全，前端修改使用模态框，进行修改。另还有退出的功能。
代码:/src/main/java/site/aitudou/controller/UserController, user.html

# 视频管理
  - 创建  
  -  私藏
  - 删除

前端通过模态框，创建新建分类，之后可以在里面存放自己喜欢的视频，可会记录观看的次数，咱讲究对称性，有创建有删除嘛，用户可以进入分类中删除视频，前提是先私藏后，不然，没有视频，你删除个鬼呀，可以直接删除分类。
user.html, CategoryX
