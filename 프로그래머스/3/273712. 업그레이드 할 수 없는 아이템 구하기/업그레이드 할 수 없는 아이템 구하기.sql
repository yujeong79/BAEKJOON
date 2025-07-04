-- 조회 : 아이템ID, 아이템명, 아이템 희귀도
-- 조건 : 더 이상 업그레이드 할 수 없는 아이템
-- 정렬 : 아이템 ID 기준 내림차순
SELECT I.ITEM_ID, ITEM_NAME, RARITY
FROM ITEM_INFO I LEFT JOIN ITEM_TREE T ON I.ITEM_ID = T.PARENT_ITEM_ID
WHERE T.ITEM_ID IS NULL
ORDER BY I.ITEM_ID DESC;
