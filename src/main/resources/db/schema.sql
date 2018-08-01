drop table if exists operator;
drop table if exists article;
drop table if exists topic;
drop table if exists user;

create table operator (id int primary key auto_increment, name varchar, pwd varchar, create_time TIMESTAMP default current_timestamp);
create table article (id int primary key auto_increment, title varchar, author varchar, content varchar, tags varchar,
  create_time TIMESTAMP default current_timestamp);
create table topic (id int primary key auto_increment, name varchar, create_time timestamp default current_timestamp);
create table user (id bigint primary key auto_increment, email varchar, mobile varchar, pwd varchar, username varchar, avatar varchar,
gender tinyint, age smallint, slogan varchar, create_time timestamp default current_timestamp);