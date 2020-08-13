DROP PROCEDURE IF EXISTS finalp.getMarksCnameConame;


Delimiter $$

CREATE PROCEDURE `getMarksCnameConame`(In stu varchar(10),in cou varchar(10),out marks int,out cname varchar(20),out coname varchar(10))
BEGIN
	select studentenroll.marks,courses.courseName,employee.employeename  into marks,cname,coname from (((student inner join studentenroll on student.studentId = studentenroll.studentId ) inner join courses on studentenroll.courseId = courses.courseId ) inner join employee on courses.courseCoordinatorId = employee.employeeId) where student.studentId = stu and courses.sourseId = cou;
END $$

Delimiter ;
