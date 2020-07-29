create table typesOfFee (
	feeType varchar(10),
	feeAmount float
);

alter table typesOfFee add constraint pkTypesOfFee primary key(feeType);