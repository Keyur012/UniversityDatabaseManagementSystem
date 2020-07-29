create table courses(
	courseId varchar(10),
	courseCoordinatorId varchar(10),
	courseName varchar(20),
	courseYear int
);

alter table courses add constraint fkCoursesCoordinatorId foreign key (courseCoordinatorId) references teacher(employeeId) on delete cascade on update cascade;
alter table courses add constraint pkCourses primary key (courseId,courseCoordinatorId);