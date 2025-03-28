SELECT parent.id, IFNULL(COUNT(child.id), 0) AS child_count
FROM ecoli_data AS parent
LEFT OUTER JOIN ecoli_data AS child
ON parent.id = child.parent_id
GROUP BY parent.id
ORDER BY parent.id ASC;