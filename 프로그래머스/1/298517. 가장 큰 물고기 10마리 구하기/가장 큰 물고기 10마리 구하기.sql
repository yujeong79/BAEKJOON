-- 조회 : ID, 길이
-- 정렬 : 길이를 기준으로 내림차순, ID를 기준으로 오름차순
-- LIMIT : 10마리
SELECT ID, LENGTH
FROM (
    SELECT ID,
        LENGTH,
        RANK() OVER (ORDER BY LENGTH DESC, ID) AS RNK
    FROM FISH_INFO
) AS TEMP
WHERE RNK <= 10
ORDER BY LENGTH DESC, ID;