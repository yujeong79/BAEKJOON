-- 조회 : 연도, 평균 미세먼지 오염도 AS PM10, 평균 초미세먼지 오염도 PM2.5
-- PM10, PM2.5 : 소수 셋째 자리에서 반올림
-- 조건 : LOCATION2 = 수원
-- 그룹 : 연도
-- 결과 : 연도 기준

SELECT YEAR(YM) AS 'YEAR', 
    ROUND(AVG(PM_VAL1), 2) AS 'PM10', 
    ROUND(AVG(PM_VAL2), 2) AS 'PM2.5'
FROM AIR_POLLUTION
WHERE LOCATION2 = '수원'
GROUP BY YEAR
ORDER BY YEAR;
