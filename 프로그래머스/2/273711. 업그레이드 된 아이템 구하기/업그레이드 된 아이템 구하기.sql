-- 조회 : 아이템ID, 아이템명, 희귀도
-- 조건 : 희귀도가 'RARE'인 아이템들의 모든 다음 업그레이드 아이템
-- 정렬 : 아이템ID 기준 내림차순

SELECT I.ITEM_ID, ITEM_NAME, RARITY
FROM ITEM_INFO I LEFT JOIN ITEM_TREE T ON I.ITEM_ID = T.ITEM_ID
WHERE PARENT_ITEM_ID IN (SELECT ITEM_ID
                        FROM ITEM_INFO
                        WHERE RARITY = 'RARE')
ORDER BY ITEM_ID DESC;
