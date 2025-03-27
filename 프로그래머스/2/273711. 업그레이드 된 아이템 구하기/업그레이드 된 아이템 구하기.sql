SELECT item_id, item_name, rarity FROM item_info
WHERE item_id IN (SELECT t.item_id 
                  FROM item_info AS i
                  INNER JOIN item_tree AS t
                  ON i.item_id = t.parent_item_id
                  WHERE rarity = 'RARE'
                 )
ORDER BY item_id DESC;