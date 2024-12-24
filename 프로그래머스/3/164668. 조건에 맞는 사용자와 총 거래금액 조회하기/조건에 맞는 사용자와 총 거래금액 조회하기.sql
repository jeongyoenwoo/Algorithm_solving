SELECT B.WRITER_ID, U.NICKNAME, SUM(PRICE) AS TOTAL_SALES
FROM USED_GOODS_BOARD B
INNER JOIN USED_GOODS_USER U
ON B.WRITER_ID = U.USER_ID
WHERE B.STATUS='DONE'
GROUP BY B.WRITER_ID
HAVING TOTAL_SALES>=700000
ORDER BY TOTAL_SALES
