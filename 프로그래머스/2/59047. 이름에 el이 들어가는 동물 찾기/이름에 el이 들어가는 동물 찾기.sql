-- 조회 : 아이디, 이름
-- 조건 : 이름에 el이 포함, 개
-- 정렬 : 이름 기준
SELECT ANIMAL_ID, NAME
FROM ANIMAL_INS
WHERE NAME LIKE '%el%' AND ANIMAL_TYPE = 'Dog'
ORDER BY NAME;