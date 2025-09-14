-- 조회 : 개체ID, 분류
-- 분류 : 100 이하 -> LOW, 1000 이하 -> MEDIUM, 1000 초과 -> HIGH
-- 정렬 : 개체ID 기준

SELECT ID,
    CASE 
        WHEN SIZE_OF_COLONY <= 100 THEN 'LOW'
        WHEN SIZE_OF_COLONY <= 1000 THEN 'MEDIUM'
        ELSE 'HIGH'
    END AS SIZE
FROM ECOLI_DATA
ORDER BY ID;