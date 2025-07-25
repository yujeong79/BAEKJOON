-- 조회 : 맛
-- 정렬 : 7월 아이스크림 총 주문량과 상반기 아이르스크림 총 주문량을 더한 값 기준 내림차순
-- LIMIT : 3
SELECT H.FLAVOR
FROM (SELECT FLAVOR, SUM(TOTAL_ORDER) AS HALF_TOTAL FROM FIRST_HALF GROUP BY FLAVOR) AS H
    JOIN (SELECT FLAVOR, SUM(TOTAL_ORDER) AS JULY_TOTAL FROM JULY GROUP BY FLAVOR) AS J
    ON H.FLAVOR = J.FLAVOR
ORDER BY H.HALF_TOTAL + J.JULY_TOTAL DESC
LIMIT 3;