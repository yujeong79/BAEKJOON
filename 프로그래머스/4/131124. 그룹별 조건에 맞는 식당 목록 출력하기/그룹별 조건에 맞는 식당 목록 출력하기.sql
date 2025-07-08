-- 조회 : 회원 이름, 리뷰 텍스트, 리뷰 작성일
-- 조건 : 리뷰를 가장 많이 작성한 회원
-- 정렬 : 리뷰 작성일 기준, 리뷰 텍스트 기준
SELECT MEMBER_NAME, REVIEW_TEXT, DATE_FORMAT(REVIEW_DATE, '%Y-%m-%d') AS REVIEW_DATE
FROM REST_REVIEW R LEFT JOIN MEMBER_PROFILE F ON R.MEMBER_ID = F.MEMBER_ID
WHERE R.MEMBER_ID = (SELECT MEMBER_ID
                        FROM REST_REVIEW
                        GROUP BY MEMBER_ID
                        ORDER BY COUNT(*) DESC
                        LIMIT 1)
ORDER BY REVIEW_DATE, REVIEW_TEXT;