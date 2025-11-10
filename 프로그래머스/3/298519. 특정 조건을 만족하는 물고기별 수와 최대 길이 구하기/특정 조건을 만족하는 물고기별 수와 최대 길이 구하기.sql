SELECT 
    COUNT(id) AS fish_count,
    MAX(length) AS max_length,
    fish_type
FROM fish_info
GROUP BY fish_type
HAVING AVG(CASE WHEN length < 10 THEN 10 ELSE length END) >= 33
order by fish_type;
