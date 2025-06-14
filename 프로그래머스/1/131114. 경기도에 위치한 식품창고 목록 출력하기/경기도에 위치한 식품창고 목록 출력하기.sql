-- address가 경기도인 창고의 ID, 이름, 주소, 냉동시설를 조회
-- 냉동시설 여부가 NULL인 경우 'N'으로 출력
-- 창고 ID를 기준으로 오름차순 정렬
SELECT
    warehouse_id,
    warehouse_name,
    address,
    IFNULL(freezer_yn, 'N') AS freezer_yn
FROM
    food_warehouse
WHERE
    address LIKE '%경기도%'
ORDER BY
    warehouse_id;