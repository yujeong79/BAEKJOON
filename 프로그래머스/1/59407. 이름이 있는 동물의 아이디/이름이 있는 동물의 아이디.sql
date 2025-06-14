-- 이름이 있는 동물 id를 조회
-- id를 기준으로 오름차순 정렬
SELECT 
    animal_id
FROM
    animal_ins
WHERE
    name IS NOT NULL
ORDER BY 
    animal_id;