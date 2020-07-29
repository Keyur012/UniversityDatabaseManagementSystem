create table taugthBy (
	courseId varchar(10),
	teacherId varchar(10)
);

alter table taugthBy add constraint fkTaugthByCourseId foreign key (courseId) references courses(courseId) on delete cascade on update cascade;
alter table taugthBy add constraint fkTaugthByTeacherId foreign key (teacherId) references teacher(employeeId) on delete cascade on update cascade;
alter table taugthBy add constraint pkTaugthBy primary key (courseId,teacherId);