-- 코드를 입력하세요
SELECT p.product_code, sum(o.sales_amount * p.price) as sales
from product as p
join offline_sale as o
on o.product_id = p.product_id
group by o.product_id
order by sales desc, p.product_code asc;

# SELECT 
# p.product_code
# , SUM(p.price*o.sales_amount) AS sales
# FROM product p
# INNER JOIN offline_sale o ON p.product_id = o.product_id
# GROUP BY p.product_code
# ORDER BY sales DESC, p.product_code ASC;