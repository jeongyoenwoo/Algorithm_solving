select ICECREAM_INFO.flavor
from FIRST_HALF JOIN ICECREAM_INFO using(FLAVOR)
where total_order > 3000 and ingredient_type = "fruit_based"
order by total_order desc