select count(*) as fish_count 
from fish_info as info
join fish_name_info as name
on info.fish_type = name.fish_type
where name.fish_name = 'BASS' OR name.fish_name = 'SNAPPER';