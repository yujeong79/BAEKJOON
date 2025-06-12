-- 동물 보호소에 가장 먼저 들어온 동물의 이름 조회
SELECT name
FROM (
    SELECT
        name,
        RANK() OVER (ORDER BY datetime) AS rnk
    FROM animal_ins
) temp
WHERE rnk = 1;
