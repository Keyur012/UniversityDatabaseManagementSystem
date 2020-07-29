create table student (
	studentId varchar(10),
	studentName varchar(20) not null,
	studentEmail varchar(20) not null,
	studentDob date not null,
	studentPincode varchar(10) not null,
	studentCity varchar(10) not null,
	studentBranch varchar(20) not null,
	studentProgramme varchar(20) not null,
	studentClass varchar(2) not null check (studentClass = 'A' or studentClass = 'B'),
	studentPortalPassword varchar(20) not null
);

alter table student add constraint pkStudent primary key(studentId);

alter table student add column studentAge int generated always as (TIMESTAMPDIFF(year,studentDob,'2020-05-28'));