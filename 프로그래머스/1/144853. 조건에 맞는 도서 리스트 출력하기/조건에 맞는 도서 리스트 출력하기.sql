-- 코드를 입력하세요
SELECT book_id, DATE_FORMAT(published_date, '%Y-%m-%d') FROM book
WHERE YEAR(published_date) = 2021 AND category IN ('인문')
ORDER BY published_date;