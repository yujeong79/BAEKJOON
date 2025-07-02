-- 조회 : 주문 ID, 제품 ID, 출고일자, 출고여부
-- 출고여부 : out_date가 2022년 5월 1일 이내면 출고 완료, 이후면 출고 대기, 미정이면 출고미정
-- 정렬 : 주문 ID 기준
SELECT ORDER_ID, 
    PRODUCT_ID, 
    DATE_FORMAT(OUT_DATE, '%Y-%m-%d') AS OUT_DATE,
    CASE 
        WHEN OUT_DATE <= '2022-05-01' THEN '출고완료'
        WHEN OUT_DATE > '2022-05-01' THEN '출고대기'
        ELSE '출고미정'
    END AS '출고여부'
FROM FOOD_ORDER
ORDER BY ORDER_ID;