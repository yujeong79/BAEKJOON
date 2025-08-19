-- 조회 : 아이디, 이름, 날짜
-- 날짜 : YY-mm-dd
-- 정렬 : 아이디순
select animal_id, name, date_format(datetime, '%Y-%m-%d') as '날짜'
from animal_ins
order by animal_id;