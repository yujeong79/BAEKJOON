-- 조회 : 아이디, 이름
-- 조건 : 이름에 el이 들어감
-- 정렬 : 이름순
SELECT ANIMAL_ID, NAME
FROM ANIMAL_INS
WHERE NAME LIKE '%el%' && ANIMAL_TYPE = 'Dog'
ORDER BY NAME;