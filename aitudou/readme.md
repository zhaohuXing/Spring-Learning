
# 应用技术：
- thymeleaf
- springboot
- mybatis

# 域名替换
开发环境：ubuntu<br />
1. 修改hosts，`127.0.0.1 itudou.site` <br />
2. 利用nginx反向代理到http://localhost:3000<br />
3. 访问: `itudou.site`


# 注册登录

#### 数据库(user表设计)

```
create table user(
	id int(11) not null auto_increment,
	email varchar(64) not null,
	password varchar(16) not null,
	nickname varchar(16) not null,
	primary key(id)
)engine = innodb default charset = utf8;
```
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
使用javamail
使用redis

<br />
登录通过spring-security框架进行安全设置。(让其访问指定的路径)，类型拦截器。

# 视频 

#### category

```
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

```

# home页面及数据显示
前端利用bootstrap进行页面布局及美化,后台通过后台爬虫,将信息存入到redis.
![home显示.jpg](http://upload-images.jianshu.io/upload_images/2031765-b858a0ca74d57de8.jpg?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

- thymeleaf使用 : home.html及/home/下所以文件
- jsoup使用 : redis/task/下的文件
- redis存储与查询 : redis/下的文件

# 视频播放
利用开源的组件实现播放, 后台解析链接

![视频播放.jpg](http://upload-images.jianshu.io/upload_images/2031765-599f9ffff00a1b6d.jpg?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)


