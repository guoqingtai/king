 CREATE DATABASE `kingdom` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci; 
use kingdom;

drop table t_user;
drop table t_role;
drop table t_resource;
drop table r_user_role;
drop table r_role_resource;

CREATE TABLE `book` (
  `book_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '图书ID',
  `name` varchar(100) NOT NULL COMMENT '图书名称',
  `number` int(11) NOT NULL COMMENT '馆藏数量',
  PRIMARY KEY (`book_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8 COMMENT='图书表';

-- 初始化图书数据
INSERT INTO `book` (`book_id`, `name`, `number`)
VALUES
    (1000, 'Java程序设计', 10),
    (1001, '数据结构', 10),
    (1002, '设计模式', 10),
    (1003, '编译原理', 10);
    
create table t_user
(
user_id int not null primary key auto_increment, 
user_name varchar(128) unique not null,
password varchar(128),
create_time timestamp
);

insert into t_user (user_name,password) values ('admin','123');

create table t_role
(
role_id int not null auto_increment,
role_name varchar(128) unique not null,
primary key(role_id)
);

create table t_resource
(
res_id int not null auto_increment,
uri varchar(128) unique not null,
primary key (res_id)
);

create table r_user_role (
user_id int references t_user(user_id),
role_id int references t_role(role_id) 
);

create table r_role_resource (
role_id int references t_role(role_id),
res_id int references t_resource(res_id)
);
