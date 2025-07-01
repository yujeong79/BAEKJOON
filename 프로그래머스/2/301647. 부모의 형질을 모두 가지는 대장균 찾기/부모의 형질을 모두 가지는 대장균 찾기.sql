-- 조회 : 대장균의 ID, 대장균의 형질, 부모 대장균의 형질
-- 조건 : 부모의 형질을 모두 보유한 대장균
-- 정렬 : ID 기준 
select c.id, c.genotype, p.genotype as parent_genotype
from ecoli_data c left join ecoli_data p on c.parent_id = p.id
where c.genotype & p.genotype = p.genotype
order by c.id;
