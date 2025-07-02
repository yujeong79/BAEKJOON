-- 조회 : 아이디, 이름
-- 조건 : 보호 시작일보다 입양일이 더 빠른 동물
-- 정렬 : 보호시작일 기준
select o.animal_id, o.name
from animal_outs o left join animal_ins i on o.animal_id = i.animal_id
where o.datetime < i.datetime
order by i.datetime;