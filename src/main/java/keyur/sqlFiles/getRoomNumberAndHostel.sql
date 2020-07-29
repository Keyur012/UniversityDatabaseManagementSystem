DROP PROCEDURE IF EXISTS finalp.getRoomNumberAndHostel;


Delimiter $$

CREATE PROCEDURE `getRoomNumberAndHostel`(in stuId varchar(10),out room int,out hname varchar(20))
BEGIN

	declare i int default 0;
    declare nn varchar(10) default "";
    DECLARE finished INTEGER DEFAULT 0;
	declare cursorstu cursor for select * from student;
    
    DECLARE CONTINUE HANDLER 
        FOR NOT FOUND SET finished = 1;
    
    open cursorstu ;
    
		gets : loop
			Fetch cursorstu into nn;
        
        if (finished = 1 ) then 
			leave gets;
		end if;
        
        set i = 1;
        end loop gets;
	close cursorstu;

	if (i = 1) then 
		Select  hostels.hostelName , studentHostel.studentRoomNumber into hName,room from ((student inner join studenthostel on student.studentId = studentHostel.studentId) inner join
		hostels on studenthostel.hostelId = hostels.hostelId) where student.studentId = stuId;
    else 
		set hName =  'Not Found';
		set room = -1;
    end if;    
END $$

Delimiter ;