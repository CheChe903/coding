SELECT COUNT(*) AS COUNT
FROM ECOLI_DATA
WHERE (GENOTYPE & 2) = 0    -- 2번 형질(비트값 2)이 없고
  AND (
       (GENOTYPE & 1) = 1  -- 1번 형질(비트값 1)이 있거나
    OR (GENOTYPE & 4) = 4  -- 3번 형질(비트값 4)이 있을 때
      );