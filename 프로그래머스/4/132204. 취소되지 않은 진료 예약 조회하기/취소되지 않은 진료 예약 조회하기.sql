-- 조회 : 진료예약번호, 환자이름, 환자번호, 진료과코드, 의사이름, 진료예약일시
-- 조건 : 2022년 4월 13일 취소되지 않은 흉부외과(CS) 진료 예약
-- APNT_CNCL_YN : 예약취소여부, APNT_CNCL_YMD : 예약취소날짜
-- 정렬 : 진료예약일시 기준
SELECT A.APNT_NO, P.PT_NAME, P.PT_NO, A.MCDP_CD, D.DR_NAME, A.APNT_YMD
FROM APPOINTMENT A 
    JOIN PATIENT P ON A.PT_NO = P.PT_NO
    JOIN DOCTOR D ON A.MDDR_ID = D.DR_ID
WHERE A.MCDP_CD = 'CS' 
    AND DATE_FORMAT(A.APNT_YMD, '%Y-%m-%d') = '2022-04-13'
    AND (A.APNT_CNCL_YN = 'N' OR A.APNT_CNCL_YMD > '2022-04-13')
ORDER BY A.APNT_YMD;
