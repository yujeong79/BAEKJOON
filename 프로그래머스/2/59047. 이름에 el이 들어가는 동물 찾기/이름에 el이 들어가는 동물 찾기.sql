select animal_id, name
from animal_ins
where animal_type regexp 'Dog+'
    and name regexp 'el+'
order by name;