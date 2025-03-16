/* Prepare data */

/* Your_test_table */
SELECT 'Furniture' AS dept, 'Chair_model_1' AS item, 50 AS sales FROM dual UNION all 
SELECT 'Furniture' AS dept, 'Chair_model_2' AS item, 80 AS sales FROM dual UNION ALL
SELECT 'Furniture' AS dept, 'Chair_model_3' AS item, 72 AS sales FROM dual UNION all
SELECT 'Furniture' AS dept, 'Table_model_1' AS item, 120 AS sales FROM dual UNION all 
SELECT 'Furniture' AS dept, 'Table_model_1' AS item, 125 AS sales FROM dual UNION ALL
SELECT 'Furniture' AS dept, 'Table_model_1' AS item, 128 AS sales FROM dual UNION ALL
SELECT 'Furniture' AS dept, 'Sofa_model_1' AS item, 115 AS sales FROM dual UNION all 
SELECT 'Furniture' AS dept, 'Sofa_model_1' AS item, 118 AS sales FROM dual UNION ALL
SELECT 'Furniture' AS dept, 'Sofa_model_1' AS item, 120 AS sales FROM dual UNION ALL
SELECT 'Apparel' AS dept, 'Shirt_men_1' AS item, 150 AS sales FROM dual UNION ALL
SELECT 'Apparel' AS dept, 'Shirt_men_2' AS item, 165 AS sales FROM dual UNION ALL
SELECT 'Apparel' AS dept, 'Shirt_men_3' AS item, 172 AS sales FROM dual UNION ALL
SELECT 'Apparel' AS dept, 'Jeans_women_1' AS item, 178 AS sales FROM dual UNION ALL
SELECT 'Apparel' AS dept, 'Jeans_women_2' AS item, 145 AS sales FROM dual UNION ALL
SELECT 'Apparel' AS dept, 'Jeans_women_3' AS item, 150 AS sales FROM dual UNION ALL
SELECT 'Apparel' AS dept, 'Jeans_men_1' AS item, 182 AS sales FROM dual UNION ALL
SELECT 'Apparel' AS dept, 'Jeans_men_1' AS item, 188 AS sales FROM dual UNION ALL
SELECT 'Apparel' AS dept, 'Jeans_men_1' AS item, 191 AS sales FROM dual 

/* To check the difference, observe the difference between the results fort below 3 queries
Ranks 7, 8, 9 for Apprel and
Ranks 3, 4, 5 for Furniture
*/

SELECT dept, 
item, 
sales, 
dense_rank() OVER (PARTITION BY dept ORDER BY sales desc) AS best_selling
FROM your_test_table
ORDER BY 1, 4

SELECT dept, 
item, 
sales, 
rank() OVER (PARTITION BY dept ORDER BY sales desc) AS best_selling
FROM your_test_table
ORDER BY 1, 4

SELECT dept, 
item, 
sales, 
row_number() OVER (PARTITION BY dept ORDER BY sales desc) AS best_selling
FROM your_test_table
ORDER BY 1, 4

/*
Notice the ranks 3, 4, 5 for Furniture to see the difference between rank, row_number and dense_rank - rows with the same sales units
*/

/*
ntile is used to group the data to "n" tiles - 3 in the below case -
*/
SELECT dept, 
item, 
sales, 
ntile(3) OVER (PARTITION BY dept ORDER BY sales desc) AS grouping_to_3s
FROM your_test_table
ORDER BY 1, 4
