select 
out2.animal_id,
out2.name
from animal_outs as out2
left join animal_ins as in2
on in2.animal_id = out2.animal_id
where in2.animal_id is null;