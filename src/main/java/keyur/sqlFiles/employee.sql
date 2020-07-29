create table employee(
	employeeId varchar(10),
	employeeName varchar(20) not null,
	employeeEmail varchar(20) not null,
	employeeJoiningDate date not null,
	employeeHighestDegree varchar(30) not null,
	employeePincode varchar(10) not null,
	employeeCity varchar(10) not null,
	employeePortalPassword varchar(20) not null,
	isTeacher int check (isTeacher =1 or isTeacher =2 or isTeacher =0)
);

alter table employee add constraint pkEmployee primary key (employeeId);

alter table employee add column employeeExperience int generated always as (TIMESTAMPDIFF(year,employeeJoiningDate,'2020-05-28'));