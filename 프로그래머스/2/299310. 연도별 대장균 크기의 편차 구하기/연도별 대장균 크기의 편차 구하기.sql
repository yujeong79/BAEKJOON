-- 코드를 작성해주세요
SELECT YEAR(differentiation_date) AS year, (max_size - size_of_colony) AS year_dev, id
FROM (SELECT id, size_of_colony, differentiation_date, MAX(size_of_colony) OVER (PARTITION BY YEAR(differentiation_date)) AS max_size
     FROM ecoli_data) AS TEMP
ORDER BY year ASC, year_dev ASC;