-- 조회 : ROUTE, SUM(D_BETWEEN_DIST) 총 누계 거리, AVG(D_BETWEEN_DIST) 평균 역 사이 거리
-- 총 누계 거리 : 소수 둘째자리에서 반올림 km, 평균 역 사이 거리는 소수 셋째자리에서 반올림 km
-- 그룹 : ROUTE
-- 결과 : 총 누계 거리 기준 내림차순

SELECT ROUTE, 
    CONCAT(ROUND(SUM(D_BETWEEN_DIST), 1), 'km') AS 'TOTAL_DISTANCE', 
    CONCAT(ROUND(AVG(D_BETWEEN_DIST), 2), 'km') AS 'AVERAGE_DISTANCE'
FROM SUBWAY_DISTANCE
GROUP BY ROUTE
ORDER BY SUM(D_BETWEEN_DIST) DESC;
