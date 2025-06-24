-- 조회 : 생물 종, IFNULL(이름, 'No name'), 성별, 중성화 여부
-- 정렬 : 아이디 기준
SELECT ANIMAL_TYPE, IFNULL(NAME, 'No name') AS NAME, SEX_UPON_INTAKE
FROM ANIMAL_INS
ORDER BY ANIMAL_ID;