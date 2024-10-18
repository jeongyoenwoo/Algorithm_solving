select count(*) as FISH_COUNT, FISH_NAME
from FISH_INFO I
join FISH_NAME_INFO NI
on I.FISH_TYPE = NI.FISH_TYPE
group by NI.FISH_NAME
order by FISH_COUNT DESC