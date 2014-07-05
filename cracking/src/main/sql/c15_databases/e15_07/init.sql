create table students (sid int, sname varchar(100), address varchar(500));
create table courses (cid int, cname varchar(100));
create table course_enrollment (cid int, sid int, grade float);

insert into students values (1, 'Adam', NULL);
insert into students values (2, 'Betty', NULL);
insert into students values (3, 'Carol', NULL);
insert into students values (4, 'Denis', NULL);
insert into students values (5, 'Emil', NULL);
insert into students values (6, 'Florence', NULL);

insert into courses values (100, 'chemistry');
insert into courses values (101, 'physics');
insert into courses values (102, 'literature');
insert into courses values (103, 'sports');

insert into course_enrollment values (100, 1, 20);
insert into course_enrollment values (100, 2, 20);
insert into course_enrollment values (100, 3, 20);
insert into course_enrollment values (100, 4, 20);
insert into course_enrollment values (100, 5, 20);
insert into course_enrollment values (100, 6, 20);

insert into course_enrollment values (101, 1, 20);
insert into course_enrollment values (101, 3, 30);
insert into course_enrollment values (101, 4, 20);
insert into course_enrollment values (101, 5, 100);
insert into course_enrollment values (101, 6, 10);

insert into course_enrollment values (102, 1, 40);
insert into course_enrollment values (102, 2, 20);
insert into course_enrollment values (102, 3, 20);
insert into course_enrollment values (102, 4, 20);
insert into course_enrollment values (102, 5, 90);
insert into course_enrollment values (102, 6, 20);

insert into course_enrollment values (103, 1, 60);
insert into course_enrollment values (103, 2, 20);
insert into course_enrollment values (103, 4, 20);
insert into course_enrollment values (103, 5, 20);
insert into course_enrollment values (103, 6, 20);