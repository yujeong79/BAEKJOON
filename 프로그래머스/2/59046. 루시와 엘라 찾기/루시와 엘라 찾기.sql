-- 조회 : 동물의 아이디, 이름, 성별 및 중성화 여부
-- 조건 : 이름이 lucy, ella, pickel, rogan, sabrina, mitty
-- 정렬 : 아이디 기준

SELECT ANIMAL_ID, NAME, SEX_UPON_INTAKE
FROM ANIMAL_INS
WHERE NAME IN ('Lucy', 'Ella', 'Pickle', 'Rogan', 'Sabrina', 'Mitty')
ORDER BY ANIMAL_ID;