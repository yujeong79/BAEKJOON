-- 조회 : 종류, ID, 식당 이름, 즐겨찾기수
-- 그룹 : 음식 종류
-- 조건 : 음식 종류별 즐겨찾기 수가 가장 많은 식당
-- 정렬 : 음식 종류 기준 내림차순
-- LIMIT : 1
SELECT FOOD_TYPE, REST_ID, REST_NAME, FAVORITES
FROM REST_INFO
WHERE (FOOD_TYPE, FAVORITES) IN (SELECT FOOD_TYPE, MAX(FAVORITES)
                                    FROM REST_INFO
                                    GROUP BY FOOD_TYPE
                                )
ORDER BY FOOD_TYPE DESC;