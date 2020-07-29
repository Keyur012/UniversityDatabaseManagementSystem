create table studentHasFeeType (
	studentId varchar(10),
	feeType varchar(10)
);

alter table studentHasFeeType add constraint pkStudentHasFeeType primary key(studentId);
alter table studentHasFeeType add constraint fkStudentHasFeeTypeStudentId foreign key (studentId) references student(studentId) on delete cascade on update cascade;
alter table studentHasFeeType add constraint fkStudentHasFeeTypeFeeType foreign key (feeType) references typesOfFee(feeType) on delete cascade on update cascade;