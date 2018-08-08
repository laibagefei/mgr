drop table if exists operator;
drop table if exists domain;
drop table if exists article;
drop table if exists topic;
//drop table if exists user;
drop table if exists reading_note;

create table operator (id int primary key auto_increment, name varchar, pwd varchar, create_time TIMESTAMP default current_timestamp);
create table domain (id int primary key auto_increment, name varchar, code varchar, parent_code varchar, tags varchar, des varchar, create_time timestamp default current_timestamp);
create table article (id int primary key auto_increment, title varchar, author varchar, content varchar, tags varchar,
  create_time TIMESTAMP default current_timestamp);
create table topic (id int primary key auto_increment, name varchar, create_time timestamp default current_timestamp);
//create table user (id bigint primary key auto_increment, email varchar, mobile varchar, pwd varchar, username varchar, avatar varchar,
//gender tinyint, age smallint, slogan varchar, region varchar, city varchar, create_time timestamp default current_timestamp);
create table reading_note (id int primary key auto_increment,title varchar,content varchar,book_id int,book_name varchar,user_id int,
create_time timestamp default current_timestamp);