select count(*) as fish_count, MONTH(time) as MONTH
from fish_info
group by month
order by month