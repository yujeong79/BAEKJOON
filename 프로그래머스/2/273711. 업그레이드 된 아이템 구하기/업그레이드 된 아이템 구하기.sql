SELECT item_id, item_name, rarity
FROM item_info
WHERE item_id IN (SELECT c.item_id
                    FROM item_info AS p
                    JOIN item_tree AS c
                    ON p.item_id = c.parent_item_id
                    WHERE p.rarity = 'RARE')
ORDER BY item_id DESC;