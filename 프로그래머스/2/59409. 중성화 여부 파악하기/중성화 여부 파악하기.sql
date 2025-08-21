-- 조회 : 아이디, 이름, 중성화 여부
-- 중성화 여부 : 중성화 -> O, 아니면 X
-- 정렬 : 아이디 기준
select animal_id,
    name,
    if(sex_upon_intake like '%Neutered%' or sex_upon_intake like '%Spayed%', 'O', 'X') as '중성화'
from animal_ins
order by animal_id;