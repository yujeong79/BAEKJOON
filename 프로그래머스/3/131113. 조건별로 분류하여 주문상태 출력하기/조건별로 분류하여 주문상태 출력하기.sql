-- 조회 : 주문ID, 제품ID, 출고일자, 출고여부
-- 출고여부 : 202205 이전 -> 출고완료, 이후 -> 출고 대기, 미정 -> 출고미정
-- 정렬 : 주문ID

SELECT ORDER_ID,
    PRODUCT_ID,
    DATE_FORMAT(OUT_DATE, '%Y-%m-%d') AS OUT_DATE,
    CASE 
        WHEN OUT_DATE IS NULL THEN '출고미정'
        WHEN DATE_FORMAT(OUT_DATE, '%Y%m%d') <= '20220501' THEN '출고완료'
        ELSE '출고대기'
    END AS '출고여부'
FROM FOOD_ORDER
ORDER BY ORDER_ID;
