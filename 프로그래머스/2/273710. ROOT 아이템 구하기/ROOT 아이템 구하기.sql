select distinct i.item_id, i.item_name 
from item_info as i
join item_tree as t
where t.parent_item_id is null and i.item_id = t.item_id