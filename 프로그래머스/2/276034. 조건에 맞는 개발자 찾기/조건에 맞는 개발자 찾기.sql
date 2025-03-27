-- 코드를 작성해주세요
SELECT id, email, first_name, last_name FROM developers
WHERE skill_code & (SELECT code from skillcodes WHERE name = 'C#')
OR skill_code & (SELECT code from skillcodes WHERE name = 'Python')
ORDER BY id ASC;