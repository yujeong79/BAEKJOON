-- 조회 : animal_type, count
-- 그룹 : animal_type
-- 정렬 : 고양이 -> 개

SELECT animal_type, count(animal_id) AS count
FROM animal_ins
GROUP BY animal_type
ORDER BY CASE animal_type 
            WHEN 'Cat' THEN 1
            ELSE 2
        END;
