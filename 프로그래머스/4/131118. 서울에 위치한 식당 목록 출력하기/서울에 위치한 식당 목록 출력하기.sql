# SELECT ROUND(AVG(review_score), 2) AS score
# FROM rest_review
# GROUP BY rest_id;

SELECT rest.rest_id, rest_name, food_type, favorites, address, score
FROM rest_info AS rest
JOIN (SELECT rest_id, ROUND(AVG(review_score), 2) AS score
        FROM rest_review
        GROUP BY rest_id) AS temp
ON rest.rest_id = temp.rest_id
WHERE address LIKE '서울%'
ORDER BY score DESC, favorites DESC;