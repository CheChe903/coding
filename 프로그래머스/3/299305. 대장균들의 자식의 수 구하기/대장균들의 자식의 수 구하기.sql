SELECT e.id, COUNT(e2.id) as child_count
FROM ecoli_data as e
left join ecoli_data as e2
on e.id = e2.parent_id
GROUP BY e.id;