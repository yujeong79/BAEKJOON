-- 동물의 이름과 보호 시작일 조회
-- animal_id를 기준으로 내림차순 정렬
SELECT NAME, DATETIME
FROM ANIMAL_INS
ORDER BY ANIMAL_ID DESC;