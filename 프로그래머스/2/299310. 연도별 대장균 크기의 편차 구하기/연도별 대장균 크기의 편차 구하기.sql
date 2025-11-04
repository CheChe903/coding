SELECT YEAR(DIFFERENTIATION_DATE) AS YEAR,
    MAX(size_of_colony) over (partition by year(DIFFERENTIATION_DATE)) - size_of_colony as YEAR_DEV,
ID
from ecoli_data
order by year, year_dev;