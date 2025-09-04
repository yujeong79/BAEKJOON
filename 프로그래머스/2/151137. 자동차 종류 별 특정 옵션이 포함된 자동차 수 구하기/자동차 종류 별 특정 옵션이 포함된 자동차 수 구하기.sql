-- 조회 : car_type, count as cars
-- 조건 : option like '가죽시트', '열선시트', '통풍시트'
-- 그룹 : car_type
-- 정렬 : car_type

SELECT CAR_TYPE, COUNT(*) AS 'CARS'
FROM CAR_RENTAL_COMPANY_CAR
WHERE OPTIONS LIKE '%통풍시트%' OR OPTIONS LIKE '%가죽시트%' OR OPTIONS LIKE '%열선시트%'
GROUP BY CAR_TYPE
ORDER BY CAR_TYPE
