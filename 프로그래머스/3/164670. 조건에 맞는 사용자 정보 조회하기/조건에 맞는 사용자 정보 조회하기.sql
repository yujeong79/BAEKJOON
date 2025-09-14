-- 조회 : 사용자ID, 닉네임, 전체주소, 전화번호
-- 전제 주소 : 시 + 도로명 주소 + 상세 주소
-- 전화번호 : xxx-xxxx-xxxx
-- 조건 : 게시물을 3건 이상 등록한 사용자
-- 정렬 : 회원ID 기준 내림차순

SELECT USER_ID,
    NICKNAME,
    CONCAT(CITY, ' ', STREET_ADDRESS1, ' ', STREET_ADDRESS2) AS '전체주소',
    CONCAT(LEFT(TLNO, 3), '-', SUBSTRING(TLNO, 4, 4), '-', RIGHT(TLNO, 4)) AS '전화번호'    
FROM USED_GOODS_BOARD D JOIN USED_GOODS_USER U ON D.WRITER_ID = U.USER_ID
GROUP BY USER_ID
HAVING COUNT(*) >= 3
ORDER BY USER_ID DESC;
