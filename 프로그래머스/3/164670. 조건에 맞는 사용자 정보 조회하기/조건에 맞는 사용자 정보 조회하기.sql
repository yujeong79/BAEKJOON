-- 조회 : 사용자 ID, 닉네임, 전체주소, 전화번호
-- 전체주소 : CITY + ADDRESS1 + ADDRESS2
-- 전화번호 : - 삽입
-- 조건 : 중고 거래 게시물을 3건 이상 등록한 사용자
-- 정렬 : 회원ID 기준 내림차순
SELECT U.USER_ID, 
    NICKNAME, 
    CONCAT(CITY, " ", STREET_ADDRESS1, " ", STREET_ADDRESS2) AS '전체주소', 
    CONCAT(LEFT(TLNO, 3), "-", SUBSTRING(TLNO, 4, 4), "-", RIGHT(TLNO, 4)) AS '전화번호'
FROM USED_GOODS_BOARD B LEFT JOIN USED_GOODS_USER U ON B.WRITER_ID = U.USER_ID
GROUP BY B.WRITER_ID
HAVING COUNT(BOARD_ID) >= 3
ORDER BY U.USER_ID DESC;