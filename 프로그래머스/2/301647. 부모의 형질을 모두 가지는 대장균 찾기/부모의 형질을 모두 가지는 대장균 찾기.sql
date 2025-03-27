-- 코드를 작성해주세요
SELECT c.id, c.genotype, p.genotype AS parent_genotype
FROM ecoli_data AS p
JOIN ecoli_data AS c ON p.id = c.parent_id
WHERE (c.genotype & p.genotype) = p.genotype
ORDER BY id ASC;
