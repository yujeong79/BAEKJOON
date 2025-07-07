-- 조회 : 장바구니 아이디
-- 조건 : 우유와 요거트를 동시에 구입한 장바구니
-- 정렬 : 장바구니의 아이디순
SELECT CART_ID
FROM (SELECT CART_ID
        FROM CART_PRODUCTS
        GROUP BY CART_ID, NAME
        HAVING NAME IN ('Milk', 'Yogurt')) AS TEMP
GROUP BY CART_ID
HAVING COUNT(*) >= 2;
