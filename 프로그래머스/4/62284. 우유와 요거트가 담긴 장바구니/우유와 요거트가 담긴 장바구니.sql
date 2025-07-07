-- 조회 : 장바구니 아이디
-- 조건 : 우유와 요거트를 동시에 구입한 장바구니
-- 정렬 : 장바구니의 아이디순
SELECT DISTINCT(CART_ID)
FROM CART_PRODUCTS
WHERE CART_ID IN (SELECT CART_ID
                  FROM CART_PRODUCTS
                  WHERE NAME = 'Milk')
  AND CART_ID IN (SELECT CART_ID
                  FROM CART_PRODUCTS
                  WHERE NAME = 'Yogurt');