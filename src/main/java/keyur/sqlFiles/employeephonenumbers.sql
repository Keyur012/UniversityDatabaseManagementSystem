create table employeePhoneNumbers (
	employeeId varchar(10),
	employeePhoneNumber varchar(10)
);

alter table employeePhoneNumbers add constraint pkEmployeePhoneNumbers primary key (employeePhoneNumber);
alter table employeePhoneNumbers add constraint fkEmployeePhoneNumbersEmployeeId foreign key (employeeId) references employee(employeeId) on delete cascade on update cascade;