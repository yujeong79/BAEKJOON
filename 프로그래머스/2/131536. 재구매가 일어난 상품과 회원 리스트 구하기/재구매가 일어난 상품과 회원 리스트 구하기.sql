-- 조회 : 회원ID, 상품ID
-- 조건 : 동일한 회원이 동일한 상품을 재구매한 경우
-- 정렬 : 회원ID 기준, 상품ID 기준 내림차순

SELECT USER_ID, PRODUCT_ID
FROM ONLINE_SALE
GROUP BY USER_ID, PRODUCT_ID
HAVING COUNT(*) >= 2
ORDER BY USER_ID, PRODUCT_ID DESC;