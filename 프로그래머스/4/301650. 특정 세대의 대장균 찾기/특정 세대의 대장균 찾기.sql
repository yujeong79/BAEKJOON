-- 코드를 작성해주세요
SELECT id FROM ecoli_data
WHERE parent_id IN (SELECT id FROM ecoli_data
                    WHERE parent_id IN (SELECT id FROM ecoli_data
                                        WHERE parent_id IS NULL))
ORDER BY id ASC;