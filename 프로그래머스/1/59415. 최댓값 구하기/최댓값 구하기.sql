-- 조회 : 가장 최근에 들어온 동물
SELECT MAX(DATETIME) AS '시간'
FROM ANIMAL_INS;