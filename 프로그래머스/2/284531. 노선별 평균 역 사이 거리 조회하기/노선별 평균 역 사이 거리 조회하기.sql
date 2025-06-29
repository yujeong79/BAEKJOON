-- 조회 : 노선, 노선별 총 누계 거리 AS TOTAL_DISTANCE, 평균 역 사이 거리 AS AVERAGE_DISTANCE
-- 총 누계 거리 : 소수 둘째 자리에서 반올림 + km
-- 평균 역 사이 거리 : 소수 셋째 자리에서 반올림 + km
-- 그룹 : 노선
-- 정렬 : 총 누계 거리 기준
SELECT ROUTE, 
    CONCAT(ROUND(SUM(D_BETWEEN_DIST), 1), 'km') AS TOTAL_DISTANCE, 
    CONCAT(ROUND(AVG(D_BETWEEN_DIST), 2), 'km') AS AVERAGE_DISTANCE
FROM SUBWAY_DISTANCE
GROUP BY ROUTE
ORDER BY SUM(D_BETWEEN_DIST) DESC;