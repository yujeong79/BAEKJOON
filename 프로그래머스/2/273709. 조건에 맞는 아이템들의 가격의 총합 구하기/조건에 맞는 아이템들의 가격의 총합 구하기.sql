-- 조회 : 가격의 총합 AS TOTAL_PRICE
-- 조건 : 희귀도가 LEGEND
select sum(price) as total_price
from item_info
where rarity = 'LEGEND';
