-- 数据库初始化脚本

-- 创建数据库
create database seckill;

-- 使用数据库
use seckill;

--　创建秒杀库存表
create table seckill (
	seckill_id bigint not null auto_increment comment '商品库存id',
	name varchar(120) not null comment '商品名称',
	number int not null comment '商品库存',
	start_time  timestamp not null default current_timestamp comment '秒杀开始时间',
	end_time  timestamp not null default current_timestamp comment '秒杀开始时间',
	create_time timestamp not null default current_timestamp comment '创建时间',
	primary key(seckill_id),
	key idx_start_time(start_time),
	key idx_end_time(end_time),
	key idx_create_time(create_time)
)engine=innodb auto_increment=1000 default charset=utf8 comment="秒杀库存表"; 

-- 初始化数据
insert into 
	seckill (name, number, start_time, end_time)
values
	('1000元秒杀MacPro', 300, '2017-05-10 00:00:00', '2017-05-11 00:00:00'),
	('300元秒杀Iphone7', 200, '2017-05-10 00:00:00', '2017-05-11 00:00:00'),
	('200元秒杀小米6', 100, '2017-05-10 00:00:00', '2017-05-11 00:00:00'),
	('100元秒杀OPPO R9 Plus', 50, '2017-05-10 00:00:00', '2017-05-11 00:00:00');

-- 秒杀成功明细表
-- 用户登录认证和相关信息

create table success_seckill (
	seckill_id bigint not null auto_increment comment '商品库存id',
	user_phone bigint not null comment '用户手机号',
	state tinyint not null default -1 comment '状态标识,'
	create_time timestamp not null comment '创建时间',
	primary key(seckill_id, user_phone),
	key idx_create_time(create_time)
)engine=innodb default charset=utf8 comment="秒杀成功明细表"; 
