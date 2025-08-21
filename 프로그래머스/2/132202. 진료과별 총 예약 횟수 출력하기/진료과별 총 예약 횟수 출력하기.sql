-- 조회 : 진료과코드, 환자 수
-- 조건 : 2022년 5월 예약
-- 그룹 : 진료과코드
-- 정렬 : 환자 수 기준, 진료과 코드 기준
select mcdp_cd as '진료과코드', count(pt_no) as '5월예약건수'
from appointment
where date_format(apnt_ymd, '%Y%m') = '202205'
group by mcdp_cd
order by count(pt_no), mcdp_cd;

