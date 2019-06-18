首页的JS调用了外网的JS文件，存在连接生效的风险
1文件重命名及JS与CSS归类

阿司匹林诱发哮喘=aspirinInducedAsthma
登录=login
疾病=disease
利肺片=liFeiPian
评分=score
首页=index
药品=drugs
注册=register
肺活检、检查详情=checkDetails
检查=checks


创建数据库
create database mynewdb character set utf8;
use mynewdb;
导入疾病百科数据表
source /root/usr/database.sql; 

创建用户表 user
id username password tel  indate
create table user(id int primary key auto_increment comment '主键约束', username varchar(50) unique comment '用户名也是社保卡号不重复',password varchar(50), tel varchar(50) comment '电话',indate date comment '入院日期') engine=innodb charset=utf8;

创建药品百科数据库 表名为drugs 12个属性
属性有自增ID  药品名字：name   主要成分：basis   适应症：Indication  用法用量：dosage  不良反应：reaction  注意事项：attentions   禁忌：taboo   剂型：dosage_forms 性状：yao_character 贮藏： store  有效期：effective
create table drugs(id int primary key auto_increment comment '主键约束',name varchar(50) comment '药名',basis text comment '主要成分', Indication text comment '适应症',dosage text comment '用法用量',reaction text comment '不良反应', attentions text comment '注意事项',taboo text comment '禁忌',dosage_forms text comment '剂型',yao_character text comment '性状',store text comment '贮藏',effective int comment '有效期:按月计')engine=innodb charset=utf8;

创建疾病检查数据表 表名为checks 3个属性
属性有自增ID  检查名字：name  不适宜人群：unsuitable
create table checks(id int primary key auto_increment comment '主键约束',name varchar(50) comment '检查名字',unsuitable text comment '不适宜人群')engine=innodb charset=utf8;

