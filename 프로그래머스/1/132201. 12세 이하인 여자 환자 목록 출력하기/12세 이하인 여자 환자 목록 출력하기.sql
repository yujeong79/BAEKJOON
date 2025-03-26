-- 코드를 입력하세요
SELECT PT_NAME, PT_NO, GEND_CD, AGE, IFNULL(tlno, 'NONE') AS tlno FROM patient
WHERE age <= 12 AND gend_cd IN ('W')
ORDER BY age DESC, pt_name ASC;