SELECT DISTINCT
    d.id,
    d.email,
    d.first_name,
    d.last_name
FROM developers AS d
JOIN skillcodes AS s
  ON (d.skill_code & s.code) = s.code
WHERE s.name IN ('Python', 'C#')
ORDER BY d.id;