-- 조회 : 아이템ID, 아이템이름
-- 조건 : PARENT_ITEM_ID가 NULL
-- 정렬 : 아이템 ID
SELECT i.ITEM_ID, ITEM_NAME
FROM ITEM_INFO i LEFT JOIN ITEM_TREE t ON i.ITEM_ID =  t.ITEM_ID
WHERE PARENT_ITEM_ID IS NULL
ORDER BY i.ITEM_ID;