-- 조회 : 잡은 수, 최대 길이, 물고기 종류
-- 조건 : 평균 길이가 33cm 이상인 물고기들
-- 그룹 : 물고기 종류
-- 정렬 : 물고기 종류
SELECT COUNT(*) AS FISH_COUNT, 
    MAX(LENGTH) AS MAX_LENGTH,
    FISH_TYPE
FROM FISH_INFO
GROUP BY FISH_TYPE
HAVING AVG(IFNULL(LENGTH, 10)) >= 33
ORDER BY FISH_TYPE;
