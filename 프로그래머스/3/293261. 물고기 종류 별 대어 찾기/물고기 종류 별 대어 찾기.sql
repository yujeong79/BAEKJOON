-- 조회 : 종류별 가장 큰 물고기의 ID, 물고기 이름, 길이
-- 정렬 : 물고기 ID 기준
SELECT ID, FISH_NAME, LENGTH
FROM FISH_INFO I JOIN FISH_NAME_INFO N ON I.FISH_TYPE = N.FISH_TYPE
WHERE (I.FISH_TYPE, LENGTH) IN (SELECT FISH_TYPE, MAX(LENGTH)
                                FROM FISH_INFO
                                GROUP BY FISH_TYPE)
ORDER BY ID;