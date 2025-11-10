select
he.emp_no,
he.emp_name,
case 
    when avg(hg.score) >=96 then 'S'
    when avg(hg.score) >=90 then 'A'
    when avg(hg.score) >=80 then 'B'
    else 'C'
    end as grade,
    CASE 
        WHEN AVG(hg.score) >= 96 THEN he.sal * 0.2
        WHEN AVG(hg.score) >= 90 THEN he.sal * 0.15
        WHEN AVG(hg.score) >= 80 THEN he.sal * 0.1
        ELSE 0
    END AS bonus
from hr_employees as he
join hr_grade as hg
    on he.emp_no = hg.emp_no
group by he.emp_no, he.emp_name
order by he.emp_no;
    