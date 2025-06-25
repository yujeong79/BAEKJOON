-- 조회 : 종류 AS CARS, 수
-- 조건 : 통풍시트, 열선시트, 가죽시트 중 하나 이상의 옵션을 가진 자동차
-- 그룹 : 종류
-- 정렬 : 종류
SELECT CAR_TYPE, COUNT(CAR_ID) AS CARS
FROM CAR_RENTAL_COMPANY_CAR
WHERE OPTIONS LIKE '%통풍시트%' 
    OR OPTIONS LIKE '%열선시트%' 
    OR OPTIONS LIKE '%가죽시트%'
GROUP BY CAR_TYPE
ORDER BY CAR_TYPE;
