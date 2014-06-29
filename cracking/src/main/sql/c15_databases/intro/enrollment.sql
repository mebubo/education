select max(Students.StudentName), count(StudentCourses.CourseID)
    from Students
    left outer join StudentCourses on Students.StudentID = StudentCourses.StudentID
    group by Students.StudentID
    order by Students.StudentName;
