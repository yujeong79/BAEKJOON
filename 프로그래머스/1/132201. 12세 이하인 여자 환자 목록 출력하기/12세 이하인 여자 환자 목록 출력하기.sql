-- 환자 이름, 환자 번호, 성별 코드, 나이, 전화번호 조회
-- AGE가 12세 이하인 여자 환자
-- 전화번호가 없는 경우 'NONE' 으로 출력
-- 나이를 기준으로 내림차순 정렬, 환자 이름 오름차순 정렬
SELECT PT_NAME, PT_NO, GEND_CD, AGE, IFNULL(TLNO, 'NONE') AS TLNO
FROM PATIENT
WHERE AGE <= 12 AND GEND_CD LIKE 'W'
ORDER BY AGE DESC, PT_NAME;