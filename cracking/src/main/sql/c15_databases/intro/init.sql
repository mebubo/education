create table Courses(CourseID INT PRIMARY KEY, CourseName TEXT, TeacherID INT);
create table Teachers(TeacherID INT PRIMARY KEY, TeacherName TEXT);
create table Students(StudentID INT PRIMARY KEY, StudentName TEXT);
create table StudentCourses(CourseID INT, StudentID INT);

insert into Teachers values (1, "Irina");
insert into Teachers values (2, "Victor");
insert into Teachers values (3, "Tatiana");

insert into Students values (1, "Sergei");
insert into Students values (2, "Oleg");
insert into Students values (3, "Alexey");
insert into Students values (4, "Ruslan");

insert into Courses values (10, "Chemistry", 1);
insert into Courses values (20, "Physics", 2);
insert into Courses values (30, "Biology", 1);

insert into StudentCourses values (10, 1);
insert into StudentCourses values (10, 2);
insert into StudentCourses values (20, 1);
insert into StudentCourses values (30, 2);
insert into StudentCourses values (10, 4);
insert into StudentCourses values (20, 4);
insert into StudentCourses values (30, 4);

select TeacherID, TeacherName from Teachers;
