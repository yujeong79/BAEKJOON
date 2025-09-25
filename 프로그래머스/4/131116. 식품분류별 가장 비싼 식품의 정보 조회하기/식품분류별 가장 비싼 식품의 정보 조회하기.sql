-- 조회 : 분류, 가격, 이름
-- 그룹 : 식품 분류별
-- 조건 : 식품 분류별 가격이 제일 비싼 식품 & 과자, 국, 김치, 식용유
-- 정렬 : 식품 가격 기준 내림차순

SELECT CATEGORY, PRICE, PRODUCT_NAME
FROM FOOD_PRODUCT
WHERE (CATEGORY, PRICE) IN (SELECT CATEGORY, MAX(PRICE)
                            FROM FOOD_PRODUCT
                            GROUP BY CATEGORY
                            HAVING CATEGORY IN ('과자', '국', '김치', '식용유'))
ORDER BY PRICE DESC;
