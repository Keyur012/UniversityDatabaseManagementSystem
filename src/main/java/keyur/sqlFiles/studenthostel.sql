create table studentHostel (
	studentId varchar(10),
	studentHostelId varchar(10),
	hostelId int,
	studentRoomNumber int
);

alter table studentHostel add constraint pkStudentHostel primary key (studentHostelId);
alter table studentHostel add constraint fkStudentHostelStudentId foreign key (studentId) references student(studentId) on delete cascade on update cascade;
alter table studentHostel add constraint fkStudentHostelHostelId foreign key (hostelId) references hostels(hostelId) on delete cascade on update cascade;