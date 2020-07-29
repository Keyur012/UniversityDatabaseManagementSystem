create table studentPhoneNumbers(
	studentId varchar(10),
	studentPhoneNumber varchar(10)
);

alter table studentPhoneNumbers add constraint pkStudentPhoneNumbers primary key(studentId,studentPhoneNumber);
alter table studentPhoneNumbers add constraint fkStudentPhoneNumbersStudentId foreign key (studentId) references student(studentId) on delete cascade on update cascade;