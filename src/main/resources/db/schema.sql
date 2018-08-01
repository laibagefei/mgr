drop table if exists operator;
drop table if exists article;

create table operator (id int primary key auto_increment, name varchar, pwd varchar, create_time TIMESTAMP default current_timestamp);
create table article (id int primary key auto_increment, title varchar, author varchar, content varchar, tags varchar,
  create_time TIMESTAMP default current_timestamp);