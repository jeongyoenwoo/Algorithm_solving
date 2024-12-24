SELECT YEAR(YM) AS YEAR, ROUND(AVG(PM_VAL1),2) AS PM10, ROUND(AVG(PM_VAL2),2) AS 'PM2.5'
FROM AIR_POLLUTION
GROUP BY YEAR, LOCATION1, LOCATION2
HAVING LOCATION2 = '수원'
ORDER BY YEAR