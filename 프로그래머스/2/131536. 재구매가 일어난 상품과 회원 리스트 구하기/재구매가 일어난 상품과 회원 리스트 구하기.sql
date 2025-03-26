-- 코드를 입력하세요
SELECT USER_ID, PRODUCT_ID FROM (
    SELECT COUNT(*) AS cnt, USER_ID, PRODUCT_ID
    FROM online_sale
    GROUP BY user_id, product_id
) AS o
WHERE o.cnt >= 2
ORDER BY user_id ASC, product_id DESC;