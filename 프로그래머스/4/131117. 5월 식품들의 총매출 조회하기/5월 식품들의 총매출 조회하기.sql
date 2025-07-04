-- 조회 : 식품 ID, 식품 이름, 총매줄
-- 조건 : 생산일자(PRODUCE_DATE)가 2022년 5월인 식품
-- 정렬 : 총매출 기준 내림차순, 식품 ID 기준
SELECT p.product_id, p.product_name, SUM(amount)*price AS total_sales
FROM food_order o LEFT JOIN food_product p ON o.product_id = p.product_id
WHERE DATE_FORMAT(o.produce_date, '%Y-%m') = '2022-05'
GROUP BY p.product_id
ORDER BY total_sales DESC, p.product_id;
