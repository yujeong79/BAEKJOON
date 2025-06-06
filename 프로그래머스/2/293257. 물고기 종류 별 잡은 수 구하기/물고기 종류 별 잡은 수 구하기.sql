SELECT COUNT(ID) AS FISH_COUNT, NAME.FISH_NAME
FROM FISH_INFO AS FISH
JOIN FISH_NAME_INFO AS NAME ON FISH.FISH_TYPE = NAME.FISH_TYPE
GROUP BY NAME.FISH_NAME
ORDER BY FISH_COUNT DESC;
