-- 조회 : CAR_ID
-- 조건 : 자동차 종류가 세단 AND 10월에 대여를 시작
-- 정렬 : 자동차ID 기준 DESC
select distinct(h.car_id)
from car_rental_company_rental_history h 
    left join car_rental_company_car c on h.car_id = c.car_id
where car_type = '세단' and month(start_date) = 10
order by h.car_id desc;