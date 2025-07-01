select count(*) as fish_count, n.fish_name
from fish_info as t
inner join fish_name_info as n 
on n.fish_type = t.fish_type
group by n.fish_name
order by 1 desc;
# SELECT COUNT(FI.ID) AS FISH_COUNT
#   ,FNI.FISH_NAME
# FROM FISH_INFO FI
#  INNER JOIN FISH_NAME_INFO FNI ON FI.FISH_TYPE = FNI.FISH_TYPE 
# GROUP BY FNI.FISH_NAME
# ORDER BY FISH_COUNT DESC