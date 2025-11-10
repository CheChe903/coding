select 
i.ingredient_type,
sum(total_order)
from icecream_info as i
join first_half as f
on i.flavor = f.flavor
group by i.ingredient_type;