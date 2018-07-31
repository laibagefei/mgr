drop table if exists city;
drop table if exists user;

create table city (id int primary key auto_increment, name varchar, code varchar);
create table user (id int primary key auto_increment, username varchar, name varchar, age smallint, slogan varchar);