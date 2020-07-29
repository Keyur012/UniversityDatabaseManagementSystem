create table teacher (
	employeeId varchar(10),
	departmentId varchar(3),
	employeePost varchar(20)
);

alter table teacher add constraint pkTeacher primary key (employeeId);
alter table teacher add constraint fkTeacherEmployeeId foreign key (employeeId) references employee(employeeId) on delete cascade on update cascade;
alter table teacher add constraint fkTeacherDepartmentId foreign key (departmentId) references departmentNames(departmentId) on delete cascade on update cascade;
