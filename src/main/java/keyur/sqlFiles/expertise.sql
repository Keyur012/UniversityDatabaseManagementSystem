create table expertise(
	employeeId varchar(10),
	expertiseName varchar(20)
);

alter table expertise add constraint pkExpertise primary key (employeeId,expertiseName);
alter table expertise add constraint fkExpertiseEmployeeId foreign key (employeeId) references teacher(employeeId) on delete cascade on update cascade;