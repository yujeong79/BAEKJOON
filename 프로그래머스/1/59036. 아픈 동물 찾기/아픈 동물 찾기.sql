-- 아픈 동물의 아이디와 이름을 조회
-- 아이디를 기준으로 정렬
SELECT
    animal_id,
    name
FROM
    animal_ins
WHERE
    intake_condition = 'Sick'
ORDER BY
    animal_id;