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
    
select * from book;
create table t_user
(
user_id int not null primary key auto_increment, 
user_name varchar(128) unique not null,
password varchar(128),
create_time timestamp
);

create table t_department
(
depart_id int not null primary key auto_increment,
depart_name varchar(256) unique not null,
is_leaf boolean unique default false,
parent_id int,
create_time timestamp
)

create table t_role
(
role_id int not null auto_increment,
role_name varchar(128) unique not null,
primary key(role_id)
);

drop table t_resource;
create table t_resource
(
res_id int not null auto_increment,
uri varchar(128) unique not null,
num int,
parent int,
zh varchar(256),
en varchar(256),
img varchar(64),
show boolean default true, 
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


insert into t_user (user_name,password) values ('admin','8ee60a2e00c90d7e00d5069188dc115b');
select * from t_user;
select * from t_resource;
select * from r_role_resource;

insert into t_role (role_name) values('admin');
insert into r_user_role values (1,1);
insert into t_resource (uri,num,parent,zh,en) values ('index.htm',0,0,'AA','aa');
insert into t_resource (uri,num,parent,zh,en) values ('menu.htm',1,0,'BB','bb');
insert into t_resource (uri,num,parent,zh,en) values ('ajaxtest.htm',3,0,'CC','cc');
insert into r_role_resource (role_id,res_id) values (1,1);
insert into r_role_resource (role_id,res_id) values (1,2);
insert into r_role_resource (role_id,res_id) values (1,3);
# TEST
select * from t_role where role_id in (select role_id from r_user_role where user_id = 1);
select * from t_resource where res_id in (select res_id from r_role_resource where role_id = 1);



drop table b_survey;
create table b_survey
(
sv_id int not null auto_increment,
sv_class varchar(128) unique not null,
ques_num int not null,
ord int,
text varchar(512),
primary key (sv_id)
);

drop table b_question;
create table b_question
(
qs_id int not null auto_increment,
sv_id int not null,
ord int,
text varchar(512),
primary key (qs_id)
);
drop table b_option;
create table b_option
(
op_id int not null auto_increment,
ord int,
text varchar(256),
val decimal(12,2),
primary key(op_id)
);

drop table b_ans;
create table b_ans
(
ans_id int not null auto_increment,
ans_time timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
user_id int not null,
sv_id int not null,
is_complete boolean default false,
ans_val decimal(12,2) not null,
primary key(ans_id)
);

drop table b_ans_detail;
create table b_ans_detail
(
dt_id int not null auto_increment,
ans_id int not null,
dt_val decimal(12,2),
primary key(dt_id)
);



