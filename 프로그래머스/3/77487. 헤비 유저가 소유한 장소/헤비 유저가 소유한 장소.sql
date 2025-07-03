-- 조회 : ID, NAME, HOST_ID
-- 그룹 : HOST_ID
-- HAVING : 공간을 둘 이상 등록한 사용자
-- 정렬 : ID 기준
SELECT ID, NAME, HOST_ID
FROM PLACES
WHERE HOST_ID IN (SELECT HOST_ID 
                    FROM PLACES
                    GROUP BY HOST_ID
                    HAVING COUNT(*) >= 2
                 )
ORDER BY ID;