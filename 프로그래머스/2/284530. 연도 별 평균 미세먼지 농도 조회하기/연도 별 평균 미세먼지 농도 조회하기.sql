-- 조회 : 연도별 평균 미세먼지 오염도 AS PM10, 평균 초미세먼지 오염도 AS PM2.5
--          => 둘 다 셋째 자리에서 반올림
-- 그룹 : 연도
-- 조건 : LOCATION2 = 수원
-- 정렬 : 연도 기준
SELECT YEAR(YM) AS YEAR, ROUND(AVG(PM_VAL1), 2) AS 'PM10', ROUND(AVG(PM_VAL2), 2) AS 'PM2.5'
FROM AIR_POLLUTION
WHERE LOCATION2 = '수원'
GROUP BY YEAR(YM)
ORDER BY YEAR(YM);