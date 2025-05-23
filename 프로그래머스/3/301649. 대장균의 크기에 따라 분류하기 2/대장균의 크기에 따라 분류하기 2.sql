SELECT id, CASE NTILE(4) OVER (ORDER BY size_of_colony DESC)
            WHEN 1 THEN 'CRITICAL'
            WHEN 2 THEN 'HIGH'
            WHEN 3 THEN 'MEDIUM'
            ELSE 'LOW'
           END AS colony_name
FROM ecoli_data
ORDER BY id ASC;