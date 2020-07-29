create table admin (
	employeeId varchar(10),
	employeeOfficeNumber int,
	employeeOfficeName varchar(20),
	employeePost varchar(20)
);

alter table admin add constraint pkAdmin primary key (employeeId);
alter table admin add constraint fkAdminEmployeeId foreign key (employeeId) references employee(employeeId) on delete cascade on update cascade;
