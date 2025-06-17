-- 조회 : ID, 이메일, 이름, 성
-- 조건 : skill_1, skill_2, skill_3 중 하나가 python
-- 정렬 : ID 기준으로 오름차순
SELECT ID, EMAIL, FIRST_NAME, LAST_NAME
FROM DEVELOPER_INFOS
WHERE SKILL_1 = 'Python' 
    OR SKILL_2 = 'Python'
    OR SKILL_3 = 'Python'
ORDER BY ID;