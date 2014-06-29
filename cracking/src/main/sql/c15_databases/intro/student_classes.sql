select Students.StudentName, group_concat(Courses.CourseName)
    from Students
    left outer join StudentCourses on Students.StudentID = StudentCourses.StudentID
    left outer join Courses on StudentCourses.CourseID = Courses.CourseID
    group by Students.StudentID
    order by Students.StudentName;
