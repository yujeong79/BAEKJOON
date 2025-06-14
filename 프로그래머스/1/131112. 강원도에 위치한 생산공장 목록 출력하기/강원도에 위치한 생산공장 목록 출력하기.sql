-- food_factory 테이블에서 강원도에 위치한 공장 id, 공장 이름, 주소 조회
-- 공장 id를 기준으로 오름차순 정렬
SELECT
    factory_id,
    factory_name,
    address
FROM
    food_factory
WHERE
    address LIKE '%강원도%'
ORDER BY
    factory_id;