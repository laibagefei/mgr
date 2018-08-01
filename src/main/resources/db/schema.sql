drop table if exists operator;

create table operator (id int primary key auto_increment, name varchar, pwd varchar, create_time TIMESTAMP default current_timestamp);