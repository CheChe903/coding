select e.dept_id, d.dept_name_en, round(AVG(e.SAL), 0) as avg_sal
from hr_employees as e
join hr_department as d
on d.dept_id = e.dept_id
group by d.dept_id
order by avg_sal desc;
