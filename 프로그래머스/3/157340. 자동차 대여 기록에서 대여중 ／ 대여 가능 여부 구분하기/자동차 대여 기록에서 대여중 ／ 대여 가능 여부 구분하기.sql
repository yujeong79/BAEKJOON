-- 조회 : 자동차 ID, 대여 가능 여부 AS AVAILABILITY
-- 대여 가능 여부 : 2022년 10월 16일 대여 중 -> 대여중, ELSE -> 대여 가능
-- 정렬 : 자동차 ID 기준 내림차순
SELECT CAR_ID,
    CASE
        WHEN START_DATE <= '2022-10-16' AND END_DATE >= '2022-10-16' THEN '대여중'
        ELSE '대여 가능'
    END AS AVAILABILITY
FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
WHERE (CAR_ID, START_DATE) IN (SELECT CAR_ID, MAX(START_DATE)
                                    FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
                                    WHERE START_DATE <= '2022-10-16'
                                    GROUP BY CAR_ID
                                 )
ORDER BY CAR_ID DESC;




