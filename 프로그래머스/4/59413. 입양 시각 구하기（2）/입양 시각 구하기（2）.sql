-- 조회 : 시간, 입양건수
-- 정렬 : 시간 기준

with recursive hours as (
    select 0 as hour
    union
    select hour+1 as hour from hours
    where hour <= 22
)

select h.hour, ifnull(cnt, 0) as count
from hours h 
    left join (select hour(datetime) as hour, count(*) as cnt
                from animal_outs
                group by hour) as temp
    on h.hour = temp.hour
group by h.hour
order by h.hour;