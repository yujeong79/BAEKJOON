-- 조회 : 동물 이름의 갯수(NULL인 경우 제외, 중복되는 이름은 하나로)
SELECT COUNT(DISTINCT(NAME)) AS COUNT
FROM ANIMAL_INS;