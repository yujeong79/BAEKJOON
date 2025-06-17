-- 조회 : ID, 이메일, 이름, 성
-- 조건 : skill_1, skill_2, skill_3 중 하나가 python
-- 정렬 : ID 기준으로 오름차순
SELECT ID, EMAIL, FIRST_NAME, LAST_NAME
FROM DEVELOPER_INFOS
WHERE 'Python' IN (SKILL_1, SKILL_2, SKILL_3)
ORDER BY ID;