-- 조회 : 아이디, 생물 종, 이름
-- 조건 : 보호소에 들어올 당시엔 중성화되지 않았지만(%Intact%) 보호소를 나갈 당시엔 중성화(Neutred/Spayed)된 동물
-- 정렬 : 아이디 기준
SELECT o.animal_id, o.animal_type, o.name
FROM ANIMAL_OUTS o LEFT JOIN ANIMAL_INS i ON o.animal_id = i.animal_id
WHERE (o.sex_upon_outcome LIKE '%Neutered%' OR o.sex_upon_outcome LIKE '%Spayed%')
    AND i.sex_upon_intake LIKE '%Intact%'
ORDER BY o.animal_id;