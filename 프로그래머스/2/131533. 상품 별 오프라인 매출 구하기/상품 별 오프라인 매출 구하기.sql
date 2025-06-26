-- 조회 : 상품코드, 상품코드 별 매출액 합계
-- 조인 : offline_sale + PRODUCT product_id 기준
-- 정렬 : 매출액 기준 내림차순, 상품코드 기준
SELECT p.PRODUCT_CODE, SUM(PRICE*SALES_AMOUNT) AS SALES
FROM OFFLINE_SALE s LEFT JOIN PRODUCT p ON s.PRODUCT_ID = p.PRODUCT_ID
GROUP BY p.PRODUCT_CODE 
ORDER BY SALES DESC, p.PRODUCT_CODE; 