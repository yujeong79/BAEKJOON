-- 조회 : 월, 자동차 ID, 총 대여 횟수
-- 조건 : 2022년 8월부터 2022년 10월까지 총 대여 횟수가 5회 이상인 자동차들
-- 정렬 : 월 기준, 자동차ID 기준 내림차순
SELECT MONTH(start_date) AS month, car_id, COUNT(*) AS records
FROM car_rental_company_rental_history
WHERE car_id IN (SELECT car_id
                FROM car_rental_company_rental_history
                WHERE DATE_FORMAT(start_date, '%Y-%m') BETWEEN '2022-08' AND '2022-10'
                GROUP BY car_id
                HAVING COUNT(*) >= 5
                )
GROUP BY car_id, month
HAVING records > 0 AND month BETWEEN 8 AND 10
ORDER BY month, car_id DESC;

