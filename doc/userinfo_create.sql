# 1 用户表 包括 卖家 买家（普通用户） 客服人员 等
use qdDemo;
create table userinfo(
id 			integer		 not null	 auto_increment 	comment 'id',
userName 	varchar(255) not null 						comment '用户名',
password 	varchar(255) not null 						comment '密码',
trueName 	varchar(255)  								comment '真实姓名',
sex 		integer 	 not null 						comment '性别 0：男 1：女',
address 	varchar(255) 								comment '地址',
phoneNo		varchar(255) 								comment '电话号码',
email 		varchar(255) 								comment '邮箱',
usertype  	integer 	not null 	default 0 			comment '用户类型：0：普通用户 1：卖家店主 2：卖家客服',
primary key(id)
);


# 2 商铺表
use qdDemo;
create table shop(
id 			integer		 not null	 auto_increment 	comment '店铺id',
shopName 	varchar(255) not null 						comment '店铺名',
address 	varchar(255) 								comment '地址',
phoneNo		varchar(255) 								comment '电话号码',
email 		varchar(255) 								comment '邮箱',
score       float		not null 	default 5.0			comment '评分',
userid 		integer 	not null						comment'店铺卖家用户id',
primary key(id)
);


# 3 商品的简介信息表
use qddemo;
create table goodsBrief(
id integer auto_increment primary key comment '商品id',
goodName varchar(255) not null comment '商品名称',
pictures integer comment '商品图片',
shopid integer not null comment '店铺id'
);


# 4 商品的详细信息表
create table goodsDetail(
id integer auto_increment primary key comment 'id',
goodBriefId integer  not null comment 'goodBrief id 属于某个商品',
goodColor varchar(255) not null comment '商品颜色',
goodSize varchar(255) not null comment '商品尺寸',
goodPrice float not null comment '商品价格',
goodRemainCount integer not null comment '商品剩余数量',
pictures integer comment '商品图片'
);

# 5  商品的购买记录表
use qddemo;
create table purchaseRecord(
id integer auto_increment primary key comment '购买流水id',
goodid integer not null comment '商品id',
userid integer not null comment '用户id',
goodsPrice float not null comment '购买的商品金额',
discount float comment '折扣钱数'
);

# 6 商品的图片
use qddemo;
create table goodPicture(
id integer auto_increment primary key comment '图片id',
goodName varchar(255) not null comment '商品名称',
goodColor varchar(255) not null comment '商品颜色',
goodPicture varchar(255) not null comment '商品图片'
);


# 开始扩展用户功能
 
# 7 用户的收获地址表

use qddemo;
create table receiverAddress(
id integer auto_increment primary key comment '收获地址id',
userId integer not null  comment '用户的id',
receiverName varchar(255) not null comment '收货人名字',
receiverAddress varchar(255) not null comment '收货人地址',
receiverPhone numeric not null comment '收货人电话',
isDefault bool default 0 comment '是否是默认的收获地址， defaulet==0 ，默认不是默认的收获地址'
)
