-- 조회 : 다음 업그레이드 아이템의 아이템ID, 아이템명, 아이템의 희귀도
-- 조건 : 아이템의 희귀도가 'RARE'인 아이템
-- 정렬 : 아이템ID 기준 내림차순
SELECT ITEM_ID, ITEM_NAME, RARITY
FROM ITEM_INFO
WHERE ITEM_ID IN (SELECT t.ITEM_ID FROM ITEM_INFO i LEFT JOIN ITEM_TREE t ON i.ITEM_ID = t.PARENT_ITEM_ID
                  WHERE i.RARITY = 'RARE' AND t.ITEM_ID IS NOT NULL
                 )
ORDER BY ITEM_ID DESC;

