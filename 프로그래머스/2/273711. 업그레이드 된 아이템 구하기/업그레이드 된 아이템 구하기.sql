-- 코드를 작성해주세요
select I.ITEM_ID, ITEM_NAME, RARITY
from ITEM_INFO I
Join ITEM_TREE T
on I.ITEM_ID = T.ITEM_ID
where T.PARENT_ITEM_ID IN (select ITEM_ID
                           from ITEM_INFO
                           where RARITY = 'RARE'
                          )
ORDER BY ITEM_ID DESC;