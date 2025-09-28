-- 조회 : 식당ID, 식당이름, 음식종류, 즐겨찾기수, 주소, 리뷰평균점수
-- 조건 : 서울에 위치
-- 리뷰평균점수 : 소수점 세번째자리에서 반올림
-- 정렬 : 평균점수 기준 내림차순, 즐겨찾기수 기준 내림차순

SELECT I.REST_ID, 
    REST_NAME,
    FOOD_TYPE,
    FAVORITES,
    ADDRESS,
    ROUND(AVG(REVIEW_SCORE), 2) AS SCORE
FROM REST_REVIEW R LEFT JOIN REST_INFO I ON R.REST_ID = I.REST_ID
WHERE ADDRESS REGEXP '^서울'
GROUP BY I.REST_ID
ORDER BY SCORE DESC, FAVORITES DESC;