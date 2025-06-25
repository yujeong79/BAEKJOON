-- 조회 : 진료과코드 AS '진료과 코드', 환자 수 AS '5월예약건수'
-- 그룹 : 진료과코드
-- 조건 : 2022년 5월에 예약한 환자
-- 정렬 : 환자 수 기준 오름차순, 진료콰 코드 기준 오름차순
SELECT MCDP_CD AS '진료과코드', COUNT(*) AS '5월예약건수'
FROM APPOINTMENT
WHERE DATE_FORMAT(APNT_YMD, '%Y%m') = '202205'
GROUP BY MCDP_CD
ORDER BY COUNT(*), MCDP_CD;