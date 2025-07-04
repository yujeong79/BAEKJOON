-- 조회 : 물고기 종류별 가장 큰 물고기ID, 물고기 이름, 길이
-- 그룹 : 물고기 종류
-- 정렬 : 물고기ID 기준
SELECT ID, FISH_NAME, LENGTH
FROM FISH_INFO I LEFT JOIN FISH_NAME_INFO N ON I.FISH_TYPE = N.FISH_TYPE
WHERE (I.FISH_TYPE, LENGTH) IN (SELECT FISH_TYPE, MAX(LENGTH) AS LENGTH
                                FROM FISH_INFO
                                GROUP BY FISH_TYPE)
ORDER BY ID;