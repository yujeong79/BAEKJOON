-- 조회 : ID, 길이
-- 정렬 : 길이를 기준으로 내림차순, ID를 기준으로 오름차순
-- LIMIT : 10마리
SELECT ID, LENGTH
FROM FISH_INFO
ORDER BY LENGTH DESC, ID
LIMIT 10;