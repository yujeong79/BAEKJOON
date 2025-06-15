-- mcdp_cd가 cs이거나 gs인 의사의 이름 id, 진료과, 고용일자 조회
-- 고용일자를 기준으로 내림차순 정렬 -> 이름을 기준으로 오름차순 정렬
SELECT dr_name,
    dr_id,
    mcdp_cd,
    DATE_FORMAT(hire_ymd, '%Y-%m-%d') AS hire_ymd
FROM doctor
WHERE mcdp_cd IN ('CS', 'GS')
ORDER BY hire_ymd DESC, dr_name;