-- 조회: 첨부파일 경로
-- 첨부파일 경로: /home/grep/src/BOARD_ID/FILD_IDFILENAMEFILE_EXT
-- 조건: 조회수가 가장 높은 중고거래 게시물
-- 정렬: FILE_ID 기준 내림차순

SELECT CONCAT('/home/grep/src/', BOARD_ID, '/', FILE_ID, FILE_NAME, FILE_EXT) AS FILE_PATH
FROM USED_GOODS_FILE
WHERE BOARD_ID = (SELECT BOARD_ID
                    FROM USED_GOODS_BOARD
                    ORDER BY VIEWS DESC
                    LIMIT 1)
ORDER BY FILE_ID DESC;
