-- 조회 : category, 개수
-- 그룹 : 카테고리 코드 앞 2자리
-- 정렬 : 카테고리 코드 기준
select left(product_code, 2) as category, count(*) as products
from product
group by category
order by category;