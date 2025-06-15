-- 아이디, 이름, 보호 시작일 조회
-- 이름 오름차순, 보호 시작일 내림차순으로 정렬
SELECT ANIMAL_ID, NAME, DATETIME
FROM ANIMAL_INS
ORDER BY NAME, DATETIME DESC;