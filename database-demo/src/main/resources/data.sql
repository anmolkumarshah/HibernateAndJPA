/*
create table Person(
	id integer not  null,
	name varchar(255) not null,
	location varchar(255),
	birthDate timestamp,
	primary key(id)
);
*/

insert into person(id,name,location,birth_date)
values
(10001,'Ranga','Hyderabad',current_timestamp()),
(10002,'Anmol','Nagpur',current_timestamp()),
(10003,'Saloni','Ballarpur',current_timestamp()),
(10004,'Rohit','Mumbai',current_timestamp()),
(10005,'Dhoni','Ranchi',current_timestamp());