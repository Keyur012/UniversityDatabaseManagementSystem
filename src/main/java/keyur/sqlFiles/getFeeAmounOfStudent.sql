DROP PROCEDURE IF EXISTS finalp.getFeeAmounOfStudent;

Delimiter $$


CREATE PROCEDURE `getFeeAmounOfStudent` (In stu varchar(10),out amount int)
BEGIN
	select typesoffee.feeAmount into amount from ((student inner join studenthasfeetype on student.studentId = studenthasfeetype.studentId) inner join typesoffee on studenthasfeetype.feeType =  typesoffee.feeType) where student.studentId = stu;
END $$

Delimiter ;