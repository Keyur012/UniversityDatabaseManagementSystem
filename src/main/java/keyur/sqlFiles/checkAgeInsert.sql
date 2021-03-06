DROP TRIGGER IF EXISTS checkAgeInsert;

Delimiter $$

create trigger checkAgeInsert
	before insert
on student for each row 
	begin
		declare agge int default 0;
        set agge = TIMESTAMPDIFF(year,new.studentDob,'2020-05-28');
        
        if (agge > 25) then
			CALL `'Cannot add or update row: Age is greter than 25!!!'`;
        end if;
	end $$
    
Delimiter ;
