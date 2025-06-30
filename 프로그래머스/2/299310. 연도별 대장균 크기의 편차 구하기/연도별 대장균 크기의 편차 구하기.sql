-- 조회 : 분화된 연도, 분화된 연도별 대장균 크기의 편차, 대장균 개체의 ID
-- 분화된 연도별 대장균 크기의 편차 : 분화된 연도별 가장 큰 대장균 크기 - 각 대장균 크기
-- 정렬 : 연도 기준, 대장균 크기의 편차 기준
SELECT YEAR(DIFFERENTIATION_DATE) AS YEAR, 
    MAX(SIZE_OF_COLONY) OVER(PARTITION BY YEAR(DIFFERENTIATION_DATE)) - SIZE_OF_COLONY AS YEAR_DEV, 
    ID
FROM ECOLI_DATA
ORDER BY YEAR, YEAR_DEV;