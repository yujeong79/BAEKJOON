-- 조회 : 저자 ID, 저자명, 카테고리, 매출액
-- 조건 : 2022년 1월의 도서 판매 데이터
-- 그룹 : 저자, 카테고리
-- 정렬 : 저자 ID 기준, 카테고리 기준 내림차순
SELECT b.author_id, a.author_name, b.category, sum(s.sales*b.price) AS TOTAL_SALES
FROM book b 
    JOIN author a ON b.author_id = a.author_id
    JOIN book_sales s ON b.book_id = s.book_id
WHERE DATE_FORMAT(s.sales_date, '%Y%m') = '202201'
GROUP BY b.author_id, b.category
ORDER BY b.author_id, b.category DESC;