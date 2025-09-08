-- 조회 : 게시물 ID, 작성자 ID, 게시글 제목, 가격, 거래 상태
-- 거래상태 : SALE -> 판매중, RESERVED -> 예약중, DONE -> 거래완료
-- 조건 : 2022년 10월 5일 등록
-- 정렬 : 게시글 ID 기준 내림차순
SELECT BOARD_ID, 
    WRITER_ID, 
    TITLE, 
    PRICE,
    CASE STATUS 
        WHEN 'SALE' THEN '판매중'
        WHEN 'RESERVED' THEN '예약중'
        ELSE '거래완료'
    END AS STATUS
FROM USED_GOODS_BOARD
WHERE DATE_FORMAT(CREATED_DATE, '%Y%m%d') = '20221005'
ORDER BY BOARD_ID DESC;