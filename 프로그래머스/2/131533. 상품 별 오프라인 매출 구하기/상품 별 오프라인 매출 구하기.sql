select
p.product_code,
sum(sales_amount) * p.price as sales
from product as p
join offline_sale as o
on o.product_id = p.product_id
group by p.product_id
order by sales desc, product_code;