--create database schemaparser;
--Use schemaparser;
create schema post;
create table post(
id primary key ,
name varchar (20),
textv text,
link varchar (30),
 create data
);
-- link ссылка будет уникальной
--избавление от дубликатов в названии
select name from post
group by name;
