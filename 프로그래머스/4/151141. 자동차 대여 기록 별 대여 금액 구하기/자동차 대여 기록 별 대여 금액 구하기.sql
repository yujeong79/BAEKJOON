WITH history AS (
    SELECT
        *,
        DATEDIFF(end_date, start_date) + 1 AS duration,
        CASE
            WHEN DATEDIFF(end_date, start_date) + 1 >= 90 THEN '90일 이상'
            WHEN DATEDIFF(end_date, start_date) + 1 >= 30 THEN '30일 이상'
            WHEN DATEDIFF(end_date, start_date) + 1 >= 7 THEN '7일 이상'
            ELSE '7일 미만'
        END AS duration_type
    FROM car_rental_company_rental_history
)

SELECT
    history_id,
    ROUND(h.duration * c.daily_fee * (1 - IFNULL(discount_rate, 0) / 100), 0) AS fee 
FROM car_rental_company_car c
LEFT JOIN history h 
    USING(car_id)
LEFT JOIN car_rental_company_discount_plan p
    ON c.car_type = p.car_type AND h.duration_type = p.duration_type
WHERE c.car_type = '트럭'
GROUP BY h.history_id
ORDER BY fee DESC, history_id DESC