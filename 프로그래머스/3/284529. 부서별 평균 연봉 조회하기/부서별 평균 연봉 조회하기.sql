-- 조회 : 부서ID, 영문 부서명, 평균 연봉
-- 평균 연봉 : 소수점 첫째 자리에서 반올림 AS AVG_SAL
-- 정렬 : 부서별 평균 연봉 기준 내림차순

SELECT D.DEPT_ID,
    DEPT_NAME_EN,
    ROUND(AVG(SAL), 0) AS AVG_SAL
FROM HR_EMPLOYEES E JOIN HR_DEPARTMENT D ON E.DEPT_ID = D.DEPT_ID
GROUP BY E.DEPT_ID
ORDER BY AVG_SAL DESC;
