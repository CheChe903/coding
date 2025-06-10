select count(*) as 'fish_count'
from fish_info
where length <=10 or length is null;

# SELECT 
# COUNT(*) AS 'FISH_COUNT'
# FROM FISH_INFO f
# WHERE f.LENGTH IS NULL;