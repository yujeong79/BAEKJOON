wITH temp AS (SELECT fish.fish_type, MAX(length) AS length
            FROM fish_info AS fish
            JOIN fish_name_info AS name ON fish.fish_type = name.fish_type
            GROUP BY fish.fish_type
)

SELECT id, name.fish_name, temp.length
FROM fish_info AS fish 
JOIN temp AS temp ON fish.fish_type = temp.fish_type
JOIN fish_name_info AS name ON fish.fish_type = name.fish_type
WHERE fish.length = temp.length;