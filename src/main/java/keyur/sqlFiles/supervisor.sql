create table supervisor (
	supervisorId varchar(10),
	teacherId varchar(10)
);

alter table supervisor add constraint pkSupervisor primary key (supervisorId,teacherId);
alter table supervisor add constraint fkSupervisorSupervisorId foreign key (supervisorId) references teacher(employeeId) on delete cascade on update cascade;
alter table supervisor add constraint fkSupervisorTeacherId foreign key (teacherId) references teacher(employeeId) on delete cascade on update cascade;