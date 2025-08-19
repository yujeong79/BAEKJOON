-- 조회 : 식품ID, 식품이름, 식품코드, 식품분류, 식품가격
-- 가격이 제일 비싼
select product_id, product_name, product_cd, category, price
from food_product
where price = (select max(price) from food_product);

