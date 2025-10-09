-- 조회 : 잡은 수, 최대 길이, 물고기의 종류
-- 그룹 : 물고기 종류별
-- 해빙 : 평균 길이가 33cm 이상인 물고기들, LENGTH가 NULL인 경우 10cm로 취급
-- 정렬 : 물고기 종류 기준

WITH CTE AS (
    SELECT COUNT(*) AS FISH_COUNT,
        MAX(LENGTH) AS MAX_LENGTH,
        FISH_TYPE
    FROM FISH_INFO
    GROUP BY FISH_TYPE
    HAVING AVG(IFNULL(LENGTH, 10)) >= 33
)

SELECT FISH_COUNT, MAX_LENGTH, FISH_TYPE
FROM CTE
ORDER BY FISH_TYPE;