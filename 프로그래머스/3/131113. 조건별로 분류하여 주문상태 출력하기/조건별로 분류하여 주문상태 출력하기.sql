-- 코드를 입력하세요
SELECT
    ORDER_ID,
    PRODUCT_ID,
    DATE_FORMAT(OUT_DATE, '%Y-%m-%d') AS OUT_DATE,
    CASE
        WHEN OUT_DATE IS NULL THEN '출고미정'
        WHEN OUT_DATE <='2022-05-01' THEN '출고완료'
        ELSE '출고대기'
    END AS '출고여부'
FROM FOOD_ORDER
ORDER BY ORDER_ID;

# SELECT   order_id
#        , product_id
#        , TO_CHAR(out_date, 'YYYY-MM-DD') AS out_date
#        , CASE 
#              WHEN out_date <= DATE '2022-05-01'THEN '출고완료'
#              WHEN out_date > DATE '2022-05-01' THEN '출고대기'
#              ELSE '출고미정'
#          END AS 출고여부
#           -- 기준일보다 작다면 출고완료, 크다면 출고대기, 그 외는 출고미정 
# FROM     food_order
# ORDER BY order_id ASC;