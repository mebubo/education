select Teachers.TeacherName, group_concat(Students.StudentName)
    from Teachers
    left outer join Courses on Teachers.TeacherID = Courses.TeacherID
    left outer join StudentCourses on Courses.CourseID = StudentCourses.CourseID
    left outer join Students on StudentCourses.StudentID = Students.StudentID
    group by Teachers.TeacherID;