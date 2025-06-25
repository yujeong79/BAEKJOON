-- 조회 : 종류, 수
-- 그룹 : 종류
-- 정렬 : type 
SELECT ANIMAL_TYPE, COUNT(ANIMAL_ID) AS 'count'
FROM ANIMAL_INS
GROUP BY ANIMAL_TYPE
HAVING ANIMAL_TYPE IN ('Cat', 'Dog')
ORDER BY 
    CASE ANIMAL_TYPE
        WHEN 'Cat' THEN 1
        WHEN 'Dog' THEN 2
    END;