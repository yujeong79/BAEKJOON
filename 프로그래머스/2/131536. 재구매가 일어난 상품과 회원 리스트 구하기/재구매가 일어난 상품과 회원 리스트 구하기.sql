-- 조회 : 회원 ID, 상품 ID
-- 그룹 : 회원 ID + 상품 ID
-- 조건 : 재구매
-- 정렬 : 회원 ID 기준, 상품 ID 기준 내림차순
SELECT USER_ID, PRODUCT_ID
FROM ONLINE_SALE
GROUP BY USER_ID, PRODUCT_ID
HAVING COUNT(*) > 1
ORDER BY USER_ID, PRODUCT_ID DESC;