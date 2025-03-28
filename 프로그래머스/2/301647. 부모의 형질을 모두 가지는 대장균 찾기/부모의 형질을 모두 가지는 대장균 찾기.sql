SELECT id, genotype, parent_genotype 
FROM (SELECT child.id, child.genotype, parent.genotype AS parent_genotype
        FROM ecoli_data AS parent
        JOIN ecoli_data AS child
        ON parent.id = child.parent_id
        WHERE (parent.genotype & child.genotype) = parent.genotype) 
    AS temp
ORDER BY id ASC;