-- 조회 : 생물 종, 이름, 성별, 중성화 여부
-- 이름 : 이름이 NULL이면 No name
-- 정렬 : 아이디순
select animal_type, ifnull(name, 'No name') as name, sex_upon_intake
from animal_ins
order by animal_id;