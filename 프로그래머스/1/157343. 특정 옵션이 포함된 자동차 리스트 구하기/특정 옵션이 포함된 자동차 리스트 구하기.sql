-- 조회 : 모두
-- 조건 : 네비게이션이 옵션에 포함
-- 정렬 : 자동차 ID 기준으로 내림차순
SELECT *
FROM CAR_RENTAL_COMPANY_CAR
WHERE OPTIONS LIKE '%네비게이션%'
ORDER BY CAR_ID DESC;