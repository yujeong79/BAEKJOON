SELECT id, CASE
            WHEN size_of_colony > 1000 THEN 'HIGH'
            WHEN size_of_colony > 100 THEN 'MEDIUM'
            ELSE 'LOW'
           END AS size
FROM ecoli_data
ORDER BY id ASC;