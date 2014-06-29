select Teachers.TeacherName, count(StudentCourses.StudentID)
    from Teachers
    left outer join Courses on Teachers.TeacherID = Courses.TeacherID
    left outer join StudentCourses on Courses.CourseID = StudentCourses.CourseID
    group by Teachers.TeacherID;