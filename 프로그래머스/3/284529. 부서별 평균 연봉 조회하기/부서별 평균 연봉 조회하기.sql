-- 조회 : 부서별 부서 ID, 영문 부서명, 평균 연봉
-- 평균 연봉 : 소수점 첫째 자리에서 반올림 AS AVG_SAL
-- 그룹 : 부서
-- 정렬 : 부서별 평균 연봉 기준 내림차순
SELECT D.DEPT_ID, D.DEPT_NAME_EN, ROUND(AVG(SAL), 0) AS AVG_SAL
FROM HR_EMPLOYEES Y LEFT JOIN HR_DEPARTMENT D ON Y.DEPT_ID = D.DEPT_ID
GROUP BY Y.DEPT_ID
ORDER BY AVG_SAL DESC;
