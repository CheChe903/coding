select DISTINCT r.item_id, r.item_name, r.rarity
from item_info as p
join item_tree as t on p.item_id = t.parent_item_id
join item_info as r on t.item_id = r.item_id
where p.rarity = 'RARE'
order by r.item_id desc;