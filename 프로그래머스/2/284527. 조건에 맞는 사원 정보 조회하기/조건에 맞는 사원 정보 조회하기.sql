-- 조회 : 점수, 사번, 성명, 직책, 이메일
-- 조건 : 2022년도 한 해 평가 점수가 가장 높은 사원
SELECT SUM(SCORE) AS SCORE, e.EMP_NO, EMP_NAME, POSITION, EMAIL
FROM HR_GRADE g LEFT JOIN HR_EMPLOYEES e ON g.EMP_NO = e.EMP_NO
GROUP BY e.EMP_NO
HAVING SCORE >= (SELECT SUM(SCORE)
                 FROM HR_GRADE
                 GROUP BY EMP_NO
                 ORDER BY SUM(SCORE) DESC
                 LIMIT 1
                );

