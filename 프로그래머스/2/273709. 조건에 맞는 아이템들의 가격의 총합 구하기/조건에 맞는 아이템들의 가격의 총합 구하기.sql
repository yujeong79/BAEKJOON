-- 조회 : 가격의 총합 AS TOTAL_PRICE
-- 조건 : 희귀도 = LEGEND
SELECT SUM(PRICE) AS TOTAL_PRICE
FROM ITEM_INFO
WHERE RARITY = 'LEGEND';