-- 조회 : 아이디, 이름, 중성화 여부
-- 조건 : 이름이 lucy, ella, pickle, rogan, sabrina, mitty
SELECT ANIMAL_ID, NAME, SEX_UPON_INTAKE
FROM ANIMAL_INS
WHERE NAME IN ('Lucy', 'Ella', 'Pickle', 'Rogan', 'Sabrina', 'Mitty');