insert into course(id,name) values(10001,'JPA In Depth');
insert into course(id,name) values(10002,'Java In Depth');
insert into course(id,name) values(10003,'Python In Depth');

insert into passport(id,number) values
(30001,'IND21312'),
(30002,'AUS234234'),
(30003,'PAK234234');

insert into student(id,name,passport_id) values
(20001,'Anmol',30001),
(20002,'Saloni',30002),
(20003,'Naman',30003);

insert into review(id,rating,description,course_id) values
(40001,5,'good',10001),
(40002,4,'good overall',10001),
(40003,1,'wrost',10003);

insert into STUDENT_COURSE_TABLE(COURSE_ID,	STUDENT_ID) values
(10001,20001),
(10001,20002),
(10001,20003),
(10002,20001),
(10003,20001),
(10003,20003);


