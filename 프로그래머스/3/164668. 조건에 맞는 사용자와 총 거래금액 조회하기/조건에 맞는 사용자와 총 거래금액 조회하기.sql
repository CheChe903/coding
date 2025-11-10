-- 코드를 입력하세요
SELECT
b.writer_id,
u.nickname,
sum(price) as total_sales
from used_goods_board as b
join used_goods_user as u
on b.writer_id = u.user_id
where b.status = 'DONE'
group by b.writer_id
HAVING SUM(price) >= 700000 
order by total_sales;