-- 조회 : 회원 ID, 닉네임, 총거래금액
-- 조건 : status가 done
-- 그룹 : 회원 ID
-- 정렬 : 총거래금액 기준
select user_id, nickname, sum(price) as total_sales
from used_goods_board b left join used_goods_user u on b.writer_id = u.user_id
where status = 'DONE'
group by writer_id
having total_sales >= 700000
order by total_sales;