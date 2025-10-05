-- 조회 : 주문ID, 제품ID, 출고일자, 출고여부
-- 출고여부 : 2022년 5월 1일까지 -> 출고완료, 이후 -> 출고대기, 미정 -> 출고미정
-- 정렬 : 주문ID 기준

WITH TEMP AS (
    SELECT ORDER_ID, 
        PRODUCT_ID, 
        DATE_FORMAT(OUT_DATE, '%Y-%m-%d') AS OUT_DATE,
        CASE
            WHEN OUT_DATE IS NULL THEN '출고미정'
            WHEN OUT_DATE <= '2022-05-01' THEN '출고완료'
            ELSE '출고대기'
        END AS '출고여부'
    FROM FOOD_ORDER
)

SELECT ORDER_ID, PRODUCT_ID, OUT_DATE, 출고여부
FROM TEMP
ORDER BY ORDER_ID;