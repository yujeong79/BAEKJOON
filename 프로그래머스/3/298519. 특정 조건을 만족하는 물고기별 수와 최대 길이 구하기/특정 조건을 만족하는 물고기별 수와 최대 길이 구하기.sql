-- 조회: 잡은 수, 최대 길이, 물고기의 종류
-- 그룹: 종류
-- 해빙: 평균 길이 >= 33
-- 정렬: 물고기 종류 기준

SELECT COUNT(*) AS FISH_COUNT, 
    MAX(LENGTH) AS MAX_LENGTH, 
    FISH_TYPE
FROM FISH_INFO
GROUP BY FISH_TYPE
HAVING AVG(IF(LENGTH <= 10, 10, LENGTH)) >= 33
ORDER BY FISH_TYPE
