-- 조회 : 아이디, 이름
-- 정렬 : 보호 기간 기준 내림차순
-- LIMIT : 2
select o.animal_id, o.name
from animal_outs o left join animal_ins i on o.animal_id = i.animal_id
order by datediff(o.datetime, i.datetime) desc
limit 2;