create table studentEnroll(
	studentId varchar(10),
	courseId varchar(10),
	passingYear int,
	marks int check (marks > -1 and marks < 101)
);

alter table studentEnroll add constraint fkStudentEnrollStudentId foreign key (studentId) references student(studentId) on delete cascade on update cascade;
alter table studentEnroll add constraint fkStudentEnrollCourseId foreign key (courseId) references courses(courseId) on delete cascade on update cascade;
alter table studentEnroll add constraint pkStudentEnroll primary key (studentId,courseId);