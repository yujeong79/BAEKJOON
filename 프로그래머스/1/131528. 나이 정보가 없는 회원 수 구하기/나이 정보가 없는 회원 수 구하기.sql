-- GENDER 0인 경우 남자, 1인 경우 여자
-- 나이 정보가 없는 회원을 출력
SELECT COUNT(*) AS USERS FROM USER_INFO
WHERE AGE IS NULL;