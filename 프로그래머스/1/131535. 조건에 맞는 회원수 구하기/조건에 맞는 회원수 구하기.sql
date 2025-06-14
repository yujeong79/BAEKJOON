-- 2021년에 가입했고 나이가 20세 이상 29세 이하인 회원의 수
SELECT COUNT(*) AS users
FROM user_info
WHERE joined LIKE '2021%'
    AND age BETWEEN 20 AND 29;