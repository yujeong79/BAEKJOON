-- 조회 : 식당ID, 식당이름, 음식종류, 즐겨찾기수, 주소, 리뷰평균점수
-- 리뷰평균점수 : 소수점 세 번째 자리에서 반올림
-- 조건 : 서울에 위치한 식당들
-- 정렬 : 평균점수 기준 내림차순, 즐겨찾기 기준 내림차순
SELECT I.REST_ID, 
    REST_NAME, 
    FOOD_TYPE, 
    FAVORITES, 
    ADDRESS, 
    ROUND(AVG(REVIEW_SCORE), 2) AS SCORE
FROM REST_INFO I JOIN REST_REVIEW R ON I.REST_ID = R.REST_ID
GROUP BY I.REST_ID
HAVING ADDRESS LIKE '서울%'
ORDER BY SCORE DESC, FAVORITES DESC;