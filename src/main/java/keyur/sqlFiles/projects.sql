create table projects(
	employeeId varchar(10),
	projectName varchar(20)
);

alter table projects add constraint pkProjects primary key (employeeId,projectName);
alter table projects add constraint fkProjectsEmployeeId foreign key (employeeId) references teacher(employeeId) on delete cascade on update cascade;