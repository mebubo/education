select students.sid, avg(course_enrollment.grade)
from students
inner join course_enrollment on students.sid = course_enrollment.sid
group by students.sid;