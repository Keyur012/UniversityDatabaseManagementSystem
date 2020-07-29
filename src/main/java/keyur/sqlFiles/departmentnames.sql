create table departmentNames (
	departmentId varchar(3),
	departmentName varchar(20)
);

alter table departmentNames add constraint pkDepartmentNames primary key (departmentId);
