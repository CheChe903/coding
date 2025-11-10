SELECT
    category,
    price AS max_price,
    product_name
FROM food_product
WHERE category IN ('식용유', '과자', '국', '김치')
  AND (category, price) IN (
      SELECT category, MAX(price)
      FROM food_product
      WHERE category IN ('식용유', '과자', '국', '김치')
      GROUP BY category
  )
ORDER BY max_price DESC;