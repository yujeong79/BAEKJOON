WITH temp AS (
    SELECT sales_date, product_id, user_id, sales_amount
    FROM online_sale
    WHERE sales_date BETWEEN '2022-03-01' AND '2022-03-31'
    
    UNION ALL
    
    SELECT sales_date, product_id, NULL AS user_id, sales_amount
    FROM offline_sale
    WHERE sales_date BETWEEN '2022-03-01' AND '2022-03-31'
)

SELECT DATE_FORMAT(sales_date, '%Y-%m-%d') AS sales_date, product_id, user_id, sales_amount
FROM temp
GROUP BY sales_date, user_id, product_id
ORDER BY sales_date ASC, product_id ASC, user_id ASC;