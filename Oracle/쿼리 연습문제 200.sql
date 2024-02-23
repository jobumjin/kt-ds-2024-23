-- 1. 현재 시간을 조회한다.
SELECT SYSDATE 
  FROM DUAL
;

-- 2. 현재 시간을 "연-월-일" 포멧으로 조회한다.
SELECT TO_CHAR(SYSDATE, 'YYYY-MM-DD')  
  FROM DUAL
;

-- 3. 한 시간 전 시간을 "시:분:초" 포멧으로 조회한다.
SELECT TO_CHAR(SYSDATE - 1 / 24, 'HH:MI:SS')  -- 12시간 기준
	 , TO_CHAR(SYSDATE - 1 / 24, 'HH24:MI:SS') -- 24시간 기준
  FROM DUAL
;

SELECT SYSDATE -- 현재 날짜와 시간
     , SYSDATE - 1 -- 하루 전의 날짜와 시간
     , SYSDATE - 10 -- 10일 전의 날짜와 시간
     , ADD_MONTHS(SYSDATE, -1) -- 한 달 전의 날짜와 시간
     , ADD_MONTHS(SYSDATE, -2) -- 두 달 전의 날짜와 시간     
     , ADD_MONTHS(SYSDATE, -12) -- 1년 전의 날짜와 시간          
     , ADD_MONTHS(SYSDATE, 2 * -12) -- 2년 전의 날짜와 시간          
     , SYSDATE + 1 -- 하루 후의 날짜와 시간
     , SYSDATE + 10 -- 10일 후의 날짜와 시간
     , ADD_MONTHS(SYSDATE, 1) -- 한 달 후의 날짜와 시간
     , ADD_MONTHS(SYSDATE, 2) -- 두 달 후의 날짜와 시간     
     , ADD_MONTHS(SYSDATE, 12) -- 1년 후의 날짜와 시간          
     , ADD_MONTHS(SYSDATE, 2 * 12) -- 2년 후의 날짜와 시간          
  FROM DUAL
;

SELECT SYSDATE -- 현재 날짜와 시간
     , SYSDATE + 1 / 24 -- 한 시간 후의 날짜와 시간
     , SYSDATE + 2 / 24-- 두 시간 후의 날짜와 시간
     , SYSDATE + 1 / 24 / 60-- 1분 후의 날짜와 시간
     , SYSDATE + 10 / 24 / 60-- 10분 후의 날짜와 시간
     , SYSDATE + 1 / 24 / 60 / 60-- 1초 후의 날짜와 시간
	 , SYSDATE + 10 / 24 / 60 / 60 -- 30초 후의 날짜와 시간
  FROM DUAL
;

-- 4. EMPLOYEES 테이블의 모든 정보를 조회한다.
SELECT *
  FROM EMPLOYEES
;

-- 5. DEPARTMENTS 테이블의 모든 정보를 조회한다.
SELECT *
  FROM DEPARTMENTS
;

-- 6. JOBS 테이블의 모든 정보를 조회한다.
SELECT *
  FROM JOBS
;

-- 7. LOCATIONS 테이블의 모든 정보를 조회한다.
SELECT *
  FROM LOCATIONS
;

-- 8. COUNTRIES 테이블의 모든 정보를 조회한다.
SELECT *
  FROM COUNTRIES
;

-- 9. REGIONS 테이블의 모든 정보를 조회한다.
SELECT *
  FROM REGIONS
;

-- 10. JOB_HISTORY 테이블의 모든 정보를 조회한다.
SELECT *
  FROM JOB_HISTORY
;
-- 11. 90번 부서에서 근무하는 사원들의 모든 정보를 조회한다.
SELECT *
  FROM EMPLOYEES
 WHERE DEPARTMENT_ID = 90
;

-- 12. 90번, 100번 부서에서 근무하는 사원들의 모든 정보를 조회한다.
SELECT *
  FROM EMPLOYEES
 WHERE DEPARTMENT_ID IN (90, 100)
;

-- 13. 100번 상사의 직속 부하직원의 모든 정보를 조회한다.
SELECT *
  FROM EMPLOYEES
 WHERE MANAGER_ID = 100
;

-- 14. 직무 아이디가 AD_VP 인 사원의 모든 정보를 조회한다.
SELECT *
  FROM EMPLOYEES
 WHERE JOB_ID = 'AD_VP'
;

-- 15. 연봉이 7000 이상인 사원의 모든 정보를 조회한다.
SELECT *
  FROM EMPLOYEES
 WHERE SALARY >= 7000
;

-- 16. 2005년 09월에 입사한 사원들의 모든 정보를 조회한다.
SELECT *
  FROM EMPLOYEES
 WHERE HIRE_DATE >= TO_DATE('2005-09', 'YYYY-MM') 
;

-- 17. 111번 사원의 모든 정보를 조회한다.
SELECT *
  FROM EMPLOYEES
 WHERE EMPLOYEE_ID = 111
;

-- 18. 인센티브를 안받는 사원들의 모든 정보를 조회한다.
SELECT *
  FROM EMPLOYEES
 WHERE COMMISSION_PCT IS NULL
;

-- 19. 인센티브를 받는 사원들의 모든 정보를 조회한다.
SELECT *
  FROM EMPLOYEES
 WHERE COMMISSION_PCT IS NOT NULL 
;

-- 20. 이름의 첫 글자가 'D' 인 사원들의 모든 정보를 조회한다.
SELECT *
  FROM EMPLOYEES
 WHERE FIRST_NAME LIKE 'D%' 
;

-- 21. 성의 마지막 글자가 'a' 인 사원들의 모든 정보를 조회한다.
SELECT *
  FROM EMPLOYEES
 WHERE LAST_NAME LIKE '%a' 
;

-- 22. 전화번호에 '.124.'이 포함된 사원들의 모든 정보를 조회한다.
SELECT *
  FROM EMPLOYEES
 WHERE PHONE_NUMBER LIKE '%.124.%' 
;

-- 23. 직무 아이디가 'PU_CLERK'인 사원 중 연봉이 3000 이상인 사원들의 모든 정보를 조회한다.
SELECT *
  FROM EMPLOYEES
 WHERE JOB_ID = 'PU_CLERK'
   AND SALARY >= 3000
;

-- 24. 평균 연봉보다 많이 받는 사원들의 사원번호, 이름, 성, 연봉을 조회한다. (SUB QUERY)
SELECT EMPLOYEE_ID
     , FIRST_NAME
     , LAST_NAME
     , SALARY 
  FROM EMPLOYEES
 WHERE SALARY > (SELECT AVG(SALARY) 
				   FROM EMPLOYEES)
;

-- 25. 평균 연봉보다 적게 받는 사원들의 사원번호, 연봉, 부서번호를 조회한다. (SUB QUERY)
SELECT EMPLOYEE_ID
     , SALARY 
     , DEPARTMENT_ID 
  FROM EMPLOYEES
 WHERE SALARY < (SELECT AVG(SALARY) 
				   FROM EMPLOYEES)
;

-- 26. 가장 많은 연봉을 받는 사원의 사원번호, 이름, 연봉을 조회한다. (SUB QUERY)
SELECT EMPLOYEE_ID
     , FIRST_NAME
     , SALARY 
  FROM EMPLOYEES
 WHERE SALARY = (SELECT MAX(SALARY) 
				   FROM EMPLOYEES)
;

-- 27. 이름이 4글자인 사원의 모든 정보를 조회한다. (LIKE WILD CARD)
SELECT *
  FROM EMPLOYEES
 WHERE FIRST_NAME LIKE '____'
;

-- 28. 'SA_REP' 직무인 직원 중 가장 높은 연봉과 가장 낮은 연봉을 조회한다.
SELECT MAX(SALARY)
     , MIN(SALARY)
  FROM EMPLOYEES
 WHERE JOB_ID = 'SA_REP'
;

-- 29. 직원의 입사일자를 '연-월-일' 형태로 조회한다.
SELECT TO_CHAR(HIRE_DATE, 'YYYY-MM-DD')
  FROM EMPLOYEES
;

-- 30. 가장 늦게 입사한 사원의 모든 정보를 조회한다. (SUB QUERY)
SELECT *
  FROM EMPLOYEES
 WHERE HIRE_DATE = (SELECT MIN(HIRE_DATE)
 					  FROM EMPLOYEES)
;

-- 31. 가장 일찍 입사한 사원의 모든 정보를 조회한다. (SUB QUERY)
SELECT *
  FROM EMPLOYEES
 WHERE HIRE_DATE = (SELECT MAX(HIRE_DATE)
 					  FROM EMPLOYEES)
;

-- 32. 자신의 상사보다 더 많은 연봉을 받는 사원의 모든 정보를 조회한다. (SUB QUERY + a)
-- 알아야 할 것 : 자신의 상사가 연봉을 얼마나 받는가.
SELECT *
  FROM EMPLOYEES E
 WHERE SALARY > (SELECT SALARY
   				   FROM EMPLOYEES M
   				  WHERE E.MANAGER_ID = M.EMPLOYEE_ID)
;
-- 33. 자신의 상사보다 더 일찍 입사한 사원의 모든 정보를 조회한다. (SUB QUERY + a)
SELECT *
  FROM EMPLOYEES E
 WHERE HIRE_DATE < (SELECT HIRE_DATE 
   				   FROM EMPLOYEES M
   				  WHERE E.MANAGER_ID = M.EMPLOYEE_ID)
;

-- 34. 부서아이디별 평균 연봉을 조회한다.
SELECT DEPARTMENT_ID 
	 , AVG(SALARY)
  FROM EMPLOYEES
 GROUP BY DEPARTMENT_ID
;

-- 35. 직무아이디별 평균 연봉, 최고연봉, 최저연봉을 조회한다.
SELECT JOB_ID  
	 , AVG(SALARY)
	 , MAX(SALARY)
	 , MIN(SALARY)
  FROM EMPLOYEES
 GROUP BY JOB_ID 
;

-- 36. 가장 많은 인센티브를 받는 사원의 모든 정보를 조회한다.
SELECT *
  FROM EMPLOYEES
 WHERE COMMISSION_PCT = (SELECT MAX(COMMISSION_PCT)
 						   FROM EMPLOYEES)
;

-- 37. 가장 적은 인센티브를 받는 사원의 연봉과 인센티브를 조회한다.
SELECT EMPLOYEE_ID
     , SALARY
     , COMMISSION_PCT 
  FROM EMPLOYEES
 WHERE COMMISSION_PCT = (SELECT MIN(COMMISSION_PCT)
 						   FROM EMPLOYEES)
;

-- 38. 직무아이디별 사원의 수를 조회한다.
SELECT JOB_ID 
     , COUNT(EMPLOYEE_ID)
  FROM EMPLOYEES
 GROUP BY JOB_ID
;

-- 39. 상사아이디별 부하직원의 수를 조회한다. 단, 부하직원이 2명 이하인 경우는 제외한다.
SELECT MANAGER_ID  
     , COUNT(EMPLOYEE_ID)
  FROM EMPLOYEES
 GROUP BY MANAGER_ID 
HAVING COUNT(EMPLOYEE_ID) > 2
;

-- 40. 사원이 속한 부서의 평균연봉보다 적게 받는 사원의 모든 정보를 조회한다. (SUB QUERY)
-- 알아야 할 것 : 사원이 속한 부서의 평균연봉.
SELECT AVG(SALARY)
  FROM EMPLOYEES E
 WHERE E.DEPARTMENT_ID  = (SELECT DEPARTMENT_ID 
 		   				     FROM EMPLOYEES D
		   				    WHERE D.EMPLOYEE_ID = E.EMPLOYEE_ID)
-- GROUP BY DEPARTMENT_ID
;

-- 알고싶은 것 : 사원이 속한 부서의 평균연봉보다 적게 받는 사원의 모든 정보
SELECT *
  FROM EMPLOYEES E
 WHERE SALARY < (SELECT AVG(SALARY)
				   FROM EMPLOYEES 
				  WHERE DEPARTMENT_ID  = (SELECT DEPARTMENT_ID 
				 		   				    FROM EMPLOYEES D
						   				   WHERE D.EMPLOYEE_ID = E.EMPLOYEE_ID))						   				     
;

-- 41. 사원이 근무하는 부서명, 이름, 성을 조회한다.
SELECT D.*
  FROM EMPLOYEES E
  JOIN DEPARTMENTS D
    ON E.DEPARTMENT_ID = D.DEPARTMENT_ID 
;

-- 42. 가장 적은 연봉을 받는 사원의 부서명, 이름, 성, 연봉, 부서장사원번호를 조회한다.
SELECT D.DEPARTMENT_NAME 
     , E.FIRST_NAME 
     , E.LAST_NAME 
     , E.SALARY 
     , D.MANAGER_ID 
  FROM EMPLOYEES E
  JOIN DEPARTMENTS D
    ON E.DEPARTMENT_ID = D.DEPARTMENT_ID 
 WHERE E.SALARY = (SELECT MIN(SALARY)
 					 FROM EMPLOYEES)
;

-- 43. 상사사원번호를 중복없이 조회한다.
SELECT DISTINCT MANAGER_ID -- DISTINCT 중복을 제거하는 KEYWORD
  FROM EMPLOYEES
;
-- 44. 50번 부서의 부서장의 이름, 성, 연봉을 조회한다.
SELECT E.FIRST_NAME 
     , E.LAST_NAME 
     , E.SALARY 
  FROM EMPLOYEES E
WHERE E.EMPLOYEE_ID  = (SELECT MANAGER_ID
                           FROM DEPARTMENTS
                          WHERE DEPARTMENT_ID = 50)
;

-- 45. 부서명별 사원의 수를 조회한다.
SELECT D.DEPARTMENT_NAME 
	 , COUNT(1) 
  FROM EMPLOYEES E
  JOIN DEPARTMENTS D 
    ON D.DEPARTMENT_ID = E.DEPARTMENT_ID 
 GROUP BY D.DEPARTMENT_NAME  
;

-- 46. 사원의 수가 가장 많은 부서명, 사원의 수를 조회한다.?????
SELECT D.DEPARTMENT_NAME 
     , COUNT(E.EMPLOYEE_ID) 
  FROM EMPLOYEES E
  JOIN DEPARTMENTS D
    ON E.DEPARTMENT_ID = D.DEPARTMENT_ID
 GROUP BY D.DEPARTMENT_NAME
HAVING COUNT(E.EMPLOYEE_ID) = (SELECT MAX(COUNT(E.EMPLOYEE_ID)) 
			 					 FROM EMPLOYEES E
								 JOIN DEPARTMENTS D
								   ON E.DEPARTMENT_ID = D.DEPARTMENT_ID
								GROUP BY D.DEPARTMENT_NAME)		
;

-- 47. 사원이 없는 부서명을 조회한다.
SELECT D.DEPARTMENT_NAME 
     , COUNT(E.EMPLOYEE_ID)
  FROM DEPARTMENTS D
  LEFT JOIN EMPLOYEES E
    ON E.DEPARTMENT_ID = D.DEPARTMENT_ID
 GROUP BY D.DEPARTMENT_NAME 
HAVING COUNT(E.EMPLOYEE_ID) = 0
;
-- 불필요한 성능저하를 없앨 수 있음..
SELECT DEPARTMENT_NAME
  FROM DEPARTMENTS
 WHERE DEPARTMENT_ID NOT IN (SELECT DISTINCT DEPARTMENT_ID
							   FROM EMPLOYEES
							  WHERE DEPARTMENT_ID IS NOT NULL)
;
 
-- 48. 직무가 변경된 사원의 모든 정보를 조회한다.
SELECT *
  FROM EMPLOYEES
 WHERE EMPLOYEE_ID IN (SELECT EMPLOYEE_ID
 						 FROM JOB_HISTORY)
;

-- 49. 직무가 변경된적 없는 사원의 모든 정보를 조회한다.
SELECT *
  FROM EMPLOYEES E
  LEFT JOIN JOB_HISTORY JH
    ON E.EMPLOYEE_ID = JH.EMPLOYEE_ID 
 WHERE JH.EMPLOYEE_ID IS NULL
;    
-- 50. 직무가 변경된 사원의 과거 직무명과 현재 직무명을 조회한다.
SELECT PAST_J.JOB_TITLE 
	 , NOW_J.JOB_TITLE
     , E.EMPLOYEE_ID 
  FROM EMPLOYEES E
 INNER JOIN JOBS NOW_J -- 현재 직무의 정보
    ON NOW_J.JOB_ID = E.JOB_ID 
 INNER JOIN JOB_HISTORY JH
    ON JH.EMPLOYEE_ID = E.EMPLOYEE_ID 
 INNER JOIN JOBS PAST_J -- 과거 직무의 정보
    ON PAST_J.JOB_ID = JH.JOB_ID
;
    
-- 51. 직무가 가장 많이 변경된 부서의 이름을 조회한다.
SELECT *
  FROM DEPARTMENTS D
  JOIN (SELECT *
  		  FROM (SELECT DEPARTMENT_ID 
					 , COUNT(1) AS DEPT_COUNT
		  		  FROM JOB_HISTORY 
				 GROUP BY DEPARTMENT_ID 
				 ORDER BY DEPT_COUNT DESC) JH
		  WHERE ROWNUM =1) JH2
    ON D.DEPARTMENT_ID = JH2.DEPARTMENT_ID
;

  
-- 52. 'Seattle' 에서 근무중인 사원의 이름, 성, 연봉, 부서명 을 조회한다.
SELECT *
  FROM EMPLOYEES E
  JOIN DEPARTMENTS D
    ON D.DEPARTMENT_ID  = E.DEPARTMENT_ID 
 WHERE D.LOCATION_ID IN(SELECT LOCATION_ID
  						  FROM LOCATIONS
  						 WHERE CITY = 'Seattle')
;

-- 53. 'Seattle' 에서 근무하지 않는 모든 사원의 이름, 성, 연봉, 부서명, 도시를 조회한다.
SELECT *
  FROM EMPLOYEES E
  JOIN DEPARTMENTS D
    ON D.DEPARTMENT_ID  = E.DEPARTMENT_ID 
 WHERE D.LOCATION_ID IN(SELECT LOCATION_ID
  						  FROM LOCATIONS
  						 WHERE CITY != 'Seattle')
;  						 
  						 
-- 54. 근무중인 사원이 가장 많은 도시와 사원의 수를 조회한다.  
SELECT L.CITY 
     , COUNT(E.EMPLOYEE_ID)
  FROM EMPLOYEES E
  JOIN DEPARTMENTS D
    ON D.DEPARTMENT_ID = E.DEPARTMENT_ID 
  JOIN LOCATIONS L
    ON L.LOCATION_ID = D.LOCATION_ID
 GROUP BY L.CITY 
;

-- 55. 근무중인 사원이 없는 도시를 조회한다. (NOT IN, IN)
-- 근무중인 사원이 있는 부서만 조회. (IN)
-- 근무중인 사원이 있는 부서를 제외한 나머지 도시. (NOT IN)
SELECT CITY
  FROM LOCATIONS
 WHERE LOCATION_ID NOT IN (SELECT LOCATION_ID 
							 FROM DEPARTMENTS
							WHERE DEPARTMENT_ID IN (SELECT DEPARTMENT_ID
							 						  FROM EMPLOYEES))
; 						   

-- 56. 연봉이 7000 에서 12000 사이인 사원이 근무중인 도시를 조회한다.
SELECT CITY
  FROM LOCATIONS
 WHERE LOCATION_ID IN(SELECT LOCATION_ID 
					    FROM DEPARTMENTS
					   WHERE DEPARTMENT_ID IN ( SELECT DEPARTMENT_ID
											      FROM EMPLOYEES
											     WHERE SALARY BETWEEN 7000 AND 12000))
;

-- 57. 'Seattle' 에서 근무중인 사원의 직무명을 중복없이 조회한다.
SELECT DISTINCT JOB_TITLE
  FROM JOBS
 WHERE JOB_ID IN (SELECT JOB_ID
 					FROM EMPLOYEES 
 				   WHERE DEPARTMENT_ID IN (SELECT DEPARTMENT_ID
						 				     FROM DEPARTMENTS
						 				    WHERE LOCATION_ID = (SELECT LOCATION_ID
								 				  			       FROM LOCATIONS
								 				  				  WHERE CITY = 'Seattle')))
;

-- 58. 사내의 최고연봉과 최저연봉의 차이를 조회한다.
SELECT MAX(SALARY) - MIN(SALARY) AS SALARY_GAP
  FROM EMPLOYEES
;


-- 59. 이름이 'Renske' 인 사원의 연봉과 같은 연봉을 받는 사원의 모든 정보를 조회한다. 
-- 단, 'Renske' 사원은 조회에서 제외한다.
SELECT *
  FROM EMPLOYEES
 WHERE SALARY = (SELECT SALARY
				   FROM EMPLOYEES
				  WHERE FIRST_NAME = 'Renske')
   AND FIRST_NAME != 'Renske'
;

-- 60. 회사 전체의 평균 연봉보다 많이 받는 사원들 중 이름에 'u' 가 포함된 사원과 동일한 부서에서 근무중인 사원들의 모든 정보를 조회한다.
SELECT *
  FROM EMPLOYEES 
 WHERE DEPARTMENT_ID IN (SELECT DISTINCT DEPARTMENT_ID
						   FROM EMPLOYEES
						  WHERE SALARY > (SELECT AVG(SALARY)
											FROM EMPLOYEES)
							AND FIRST_NAME LIKE '%u%')
;
 
-- 61. 부서가 없는 국가명을 조회한다.
SELECT COUNTRY_NAME
  FROM COUNTRIES
 WHERE COUNTRY_ID IN (SELECT COUNTRY_ID
  					    FROM LOCATIONS
  					   WHERE LOCATION_ID NOT IN (SELECT LOCATION_ID
  					                               FROM DEPARTMENTS))
 ;
-- 62. 'Europe' 에서 근무중인 사원들의 모든 정보를 조회한다.
SELECT *
  FROM EMPLOYEES 
 WHERE DEPARTMENT_ID IN (SELECT DEPARTMENT_ID
 						   FROM DEPARTMENTS
 						  WHERE LOCATION_ID IN (SELECT LOCATION_ID
 						  						  FROM LOCATIONS
 						  						 WHERE COUNTRY_ID IN( SELECT COUNTRY_ID 
 						  						 						FROM COUNTRIES
 						  						 					   WHERE REGION_ID = (SELECT REGION_ID
 						  						 					   					    FROM REGIONS R
 						  						 					   					   WHERE REGION_NAME = 'Europe'))))
;

-- 63. 'Europe' 에서 가장 많은 사원들이 있는 부서명을 조회한다.
SELECT *
  FROM (SELECT COUNT(DEPARTMENT_NAME)
	         , DEPARTMENT_NAME
	      FROM EMPLOYEES E
	      LEFT JOIN DEPARTMENTS D 
	        ON E.DEPARTMENT_ID = D.DEPARTMENT_ID 
	     WHERE D.DEPARTMENT_NAME IN (SELECT DEPARTMENT_NAME
 		 						       FROM DEPARTMENTS
		 						      WHERE LOCATION_ID IN (SELECT LOCATION_ID
		 						  						      FROM LOCATIONS
		 						  						     WHERE COUNTRY_ID IN( SELECT COUNTRY_ID 
		 						  						 	 					    FROM COUNTRIES
		 						  						 					       WHERE REGION_ID = (SELECT REGION_ID
		 						  						 					   					        FROM REGIONS R
		 						  						 					   					       WHERE REGION_NAME = 'Europe'))))
	     GROUP BY DEPARTMENT_NAME
 	     ORDER BY COUNT(DEPARTMENT_NAME) DESC)
 WHERE ROWNUM =1
;

-- 64. 대륙 별 사원의 수를 조회한다.
SELECT R.REGION_NAME
	 , COUNT(E.EMPLOYEE_ID)
  FROM EMPLOYEES E
  LEFT JOIN DEPARTMENTS D
    ON D.DEPARTMENT_ID = E.DEPARTMENT_ID 
  LEFT JOIN LOCATIONS L
    ON L.LOCATION_ID = D.LOCATION_ID 
  LEFT JOIN COUNTRIES C
    ON C.COUNTRY_ID = L.COUNTRY_ID 
  LEFT JOIN REGIONS R
    ON C.REGION_ID = R.REGION_ID
 GROUP BY R.REGION_NAME 
;

-- 65. 연봉이 2500, 3500, 7000 이 아니며 직업이 SA_REP 이나 ST_CLERK 인 사람들을 조회한다.
SELECT *
  FROM EMPLOYEES
 WHERE SALARY NOT IN (2500, 3500, 7000)
   AND JOB_ID NOT IN ('SA_REP', 'ST_CLERK')
;
-- 66. 사원의 사원번호, 이름, 성, 상사의 사원번호, 상사의 이름, 상사의 성을 조회한다.
SELECT E.EMPLOYEE_ID
     , E.FIRST_NAME
     , E.LAST_NAME
     , M.EMPLOYEE_ID 
     , M.FIRST_NAME 
     , M.LAST_NAME
  FROM EMPLOYEES E
  LEFT JOIN EMPLOYEES M
    ON E.MANAGER_ID = M.EMPLOYEE_ID 
;
-- 67. 101번 사원의 모든 부하직원 들의 이름, 성, 상사사원번호, 상사사원명을 조회한다.  (SCALA QUERY)
/*
SELECT (SELECT ... FROM ... WHERE ...) -- SCALA QUERY 
  FROM (SELECT ... FROM ... WHERE ...) -- INLINE VIEW
 WHERE COL = (SELECT ... FROM ... WHERE ...) -- SUB QUERY
;
*/
-- 스칼라 쿼리를 이용해 모든 사원들의 JOB_ID 와 JOB_TITLE을 조회한다.
SELECT EMPLOYEE_ID
     , JOB_ID
     , (SELECT JOB_TITLE -- 스칼라 쿼리의 결과는 반드시 1개의 컬럼만 작성.
     				     -- 스칼라 쿼리의 결과는 반드시 1개의 ROW만 조회.
          FROM JOBS J 
         WHERE J.JOB_ID = E.JOB_ID) AS JOB_TITLE
  FROM EMPLOYEES E
 ORDER BY EMPLOYEE_ID 
;

SELECT FIRST_NAME
     , LAST_NAME 
     , MANAGER_ID 
     , (SELECT FIRST_NAME
          FROM EMPLOYEES
         WHERE EMPLOYEE_ID = 101)
  FROM EMPLOYEES
 WHERE MANAGER_ID = 101
;

-- 68. 114번 직원의 모든 상사들의 이름, 성, 상사사원번호, 상사사원명을 조회한다.  (SCALA QUERY)
 SELECT LEVEL
      , EMPLOYEE_ID
      , FIRST_NAME
      , LAST_NAME 
 ; 
-- 69. 114번 직원의 모든 상사들의 이름, 성, 상사사원번호, 상사사원명을 조회한다. 단, 역순으로 조회한다.  (SCALA QUERY)
 
 
-- 70. 모든 사원들을 연봉 오름차순 정렬하여 조회한다.
SELECT *
  FROM EMPLOYEES
 ORDER BY SALARY ;

-- 71. 모든 사원들을 이름 내림차순 정렬하여 조회한다.
SELECT *
  FROM EMPLOYEES
 ORDER BY FIRST_NAME DESC;

-- 72. 모든 사원들의 이름, 성, 연봉, 부서명을 부서번호로 내림차순 정렬하여 조회한다.
SELECT E.FIRST_NAME
     , E.LAST_NAME 
     , E.SALARY 
     , D.DEPARTMENT_NAME 
  FROM EMPLOYEES E
  LEFT JOIN DEPARTMENTS D
    ON D.DEPARTMENT_ID = E.DEPARTMENT_ID
 ORDER BY D.DEPARTMENT_ID DESC
;

-- 73. 부서명별 연봉의 합을 내림차순 정렬하여 조회한다.
SELECT D.DEPARTMENT_NAME 
     , SUM(E.SALARY)
  FROM EMPLOYEES E
 INNER JOIN DEPARTMENTS D
    ON D.DEPARTMENT_ID = E.DEPARTMENT_ID 
 GROUP BY D.DEPARTMENT_NAME
 ORDER BY SUM(E.SALARY) DESC
;

-- 74. 직무명별 사원의 수를 오름차순 정렬하여 조회한다.
SELECT J.JOB_TITLE 
     , COUNT(E.EMPLOYEE_ID) 
  FROM EMPLOYEES E
 INNER JOIN JOBS J
    ON J.JOB_ID = E.JOB_ID
 GROUP BY J.JOB_TITLE
 ORDER BY COUNT(E.EMPLOYEE_ID)
;
-- 75. 모든 사원들의 모든 정보를 조회한다. 단, 인센티브를 받는 사원은 "인센티브여부" 컬럼에 "Y"를, 아닌 경우 "N"으로 조회한다.
-- CASE WHEN THEN ELSE END(JAVA IF ~ ELSE IF ~ ELSE)
SELECT SALARY
     , COMMISSION_PCT 
     , CASE
     	WHEN COMMISSION_PCT IS NOT NULL THEN
     		'Y'
     	ELSE 
     		'N'
       END AS 인센티브여부
  FROM EMPLOYEES
;
-- 76. 모든 사원들의 이름을 10자리로 맞추어 조회한다.
-- LPAD 함수, RPAD 함수
SELECT 'A'
     , '         A' -- LPAD (LEFT PADDING)
     , LPAD('A', 10, ' ') 
     , 'A         ' -- RPAD (RIGHT PADDING)
     , RPAD('A', 10, ' ') 
  FROM DUAL
;

SELECT FIRST_NAME
	 , LPAD(FIRST_NAME, 10, ' ')
	 , RPAD(FIRST_NAME, 10, ' ')
  FROM EMPLOYEES
;
-- 77. 2007년에 직무가 변경된 사원들의 현재 직무명, 부서명, 사원번호, 이름, 성을 조회한다.
SELECT J.JOB_TITLE 
     , D.DEPARTMENT_NAME 
     , E.EMPLOYEE_ID 
     , E.FIRST_NAME 
     , E.LAST_NAME 
  FROM EMPLOYEES E
 INNER JOIN DEPARTMENTS D
    ON D.DEPARTMENT_ID = E.DEPARTMENT_ID
 INNER JOIN JOBS J
    ON J.JOB_ID = E.JOB_ID
 WHERE E.EMPLOYEE_ID IN (SELECT EMPLOYEE_ID
  						   FROM JOB_HISTORY JH
  						  WHERE START_DATE >= '2007-01-01'
  						    AND END_DATE <= '2007-12-31')
 ; 						  

-- 78. 직무별 최대연봉보다 더 많은 연봉을 받는 사원의 모든 정보를 조회한다. -- 이게 말이되나?
SELECT *
  FROM EMPLOYEES E
  LEFT JOIN JOBS J
    ON J.JOB_ID = E.JOB_ID 
 WHERE J.MAX_SALARY < E.SALARY
;
 
SELECT *
  FROM EMPLOYEES E
 WHERE E.SALARY > (SELECT J.MAX_SALARY
 					 FROM JOBS J
 					WHERE J.JOB_ID = E.JOB_ID)
;

-- 79. 사원들의 입사일자 중 이름, 성, 연도만 조회한다.
SELECT FIRST_NAME
     , LAST_NAME 
     , TO_CHAR(HIRE_DATE ,'YYYY')
  FROM EMPLOYEES
;
-- 80. 사원들의 입사일자 중 이름, 성, 연도, 월 만 조회한다.
SELECT FIRST_NAME
     , LAST_NAME 
     , TO_CHAR(HIRE_DATE ,'YYYY')
     , TO_CHAR(HIRE_DATE ,'MM')
  FROM EMPLOYEES
;
-- 81. 100번 사원의 모든 부하직원을 계층조회한다. 단, LEVEL이 4인 사원은 제외한다. -- 물어보기
 SELECT LEVEL
	  , EMPLOYEE_ID
      , FIRST_NAME || ' ' || LAST_NAME AS NAME
      , MANAGER_ID
   FROM EMPLOYEES
  START WITH EMPLOYEE_ID = 100 
CONNECT BY PRIOR EMPLOYEE_ID = MANAGER_ID AND LEVEL != 4
;

-- 82. 많은 연봉을 받는 10명을 조회한다.
SELECT *
  FROM (SELECT *
	      FROM EMPLOYEES
	     ORDER BY SALARY DESC)
 WHERE ROWNUM <= 10;

-- 83. 가장 적은 연봉을 받는 사원의 상사명, 부서명을 조회한다.
SELECT *
  FROM (SELECT M.FIRST_NAME 
		     , D.DEPARTMENT_NAME
		  FROM EMPLOYEES E
		  LEFT JOIN DEPARTMENTS D
		    ON D.DEPARTMENT_ID = E.DEPARTMENT_ID
		  LEFT JOIN EMPLOYEES M
		    ON M.EMPLOYEE_ID = E.MANAGER_ID
		 ORDER BY E.SALARY)
 WHERE ROWNUM = 1
;
-- 84. 많은 연봉을 받는 사원 중 11번 째 부터 20번째를 조회한다.
-- INLINE VIEW 두 번 사용 (PAGINATION)
SELECT *
  FROM (SELECT EMP.*
   		     , ROWNUM AS RNUM
 		  FROM (SELECT *
				  FROM EMPLOYEES
				 ORDER BY SALARY DESC) EMP
	 	 WHERE ROWNUM <= 20) EMP2
 WHERE RNUM > 10
;

-- 85. 가장 적은 연봉을 받는 중 90번 째 부터 100번째를 조회한다.
-- INLINE VIEW 두 번 사용 (PAGINATION)
SELECT *
  FROM (SELECT EMP.*
   		     , ROWNUM AS RNUM
 		  FROM (SELECT *
				  FROM EMPLOYEES
				 ORDER BY SALARY ) EMP
	 	 WHERE ROWNUM <= 100) EMP2
 WHERE RNUM >= 90
;

-- 86. 'PU_CLERK' 직무인 2번째 부터 5번째 사원의 부서명, 직무명을 조회한다.
-- INLINE VIEW 두 번 사용 (PAGINATION)



-- 87. 모든 사원의 정보를 직무 오름차순, 연봉 내림차순으로 조회한다.
SELECT *
  FROM EMPLOYEES
 ORDER BY JOB_ID ASC , SALARY DESC
;
-- 88. 직무별 평균연봉을 평균연봉순으로 오름차순 정렬하여 조회한다.
SELECT JOB_ID 
     , AVG(SALARY)
  FROM EMPLOYEES
 GROUP BY JOB_ID
 ORDER BY AVG(SALARY)
;
-- 89. 부서별 평균연봉을 내림차순 정렬하여 조회한다.
SELECT DEPARTMENT_ID
     , AVG(SALARY)
  FROM EMPLOYEES
 GROUP BY DEPARTMENT_ID
 ORDER BY AVG(SALARY) DESC
;
-- 90. 이름의 첫 번째 글자별 평균연봉을 조회한다.
-- SUBSTR 함수
SELECT 'ABCD'
     , SUBSTR('ABCD', 1, 1) -- 'A'
     , SUBSTR('ABCD', 2, 1) -- 'B'
     , SUBSTR('ABCD', 3, 2) -- 'CD'
  FROM DUAL
;

SELECT SUBSTR(FIRST_NAME, 1, 1)
     , AVG(SALARY)
  FROM EMPLOYEES
 GROUP BY SUBSTR(FIRST_NAME, 1, 1)
 ORDER BY SUBSTR(FIRST_NAME, 1, 1)
;

-- 91. 입사연도별 최소연봉을 조회한다.
SELECT TO_CHAR(HIRE_DATE,'YYYY' )
     , MIN(SALARY)
  FROM EMPLOYEES  
 GROUP BY TO_CHAR(HIRE_DATE,'YYYY' )
;
-- 92. 월별 최대연봉 중 2번째 부터 4번째 데이터만 조회한다.
-- INLINE VIEW 두 번 사용 (PAGINATION)

-- 93. 직무명별 최소연봉을 조회한다.
SELECT J.JOB_TITLE
     , MIN(E.SALARY) 
  FROM EMPLOYEES E
  LEFT JOIN JOBS J
    ON J.JOB_ID = E.JOB_ID 
 GROUP BY J.JOB_TITLE
;
  
-- 94. 부서명별 최대연봉을 조회한다.
SELECT D.DEPARTMENT_NAME 
     , MAX(E.SALARY) 
  FROM EMPLOYEES E
  LEFT JOIN DEPARTMENTS D
    ON D.DEPARTMENT_ID = E.DEPARTMENT_ID 
 GROUP BY D.DEPARTMENT_NAME 
;

-- 95. 직무명, 부서명 별 사원 수, 평균연봉을 조회한다. -----???어려운데?
SELECT COUNT(E.EMPLOYEE_ID)
     , AVG(E.SALARY) 
     , D.DEPARTMENT_NAME
  FROM EMPLOYEES E
  LEFT JOIN DEPARTMENTS D
    ON D.DEPARTMENT_ID = E.DEPARTMENT_ID 
  LEFT JOIN JOBS J
    ON J.JOB_ID = E.JOB_ID 
 GROUP BY D.DEPARTMENT_NAME
;

-- 96. 도시별 사원 수를 조회한다.
SELECT L.CITY
     , COUNT(E.EMPLOYEE_ID)
  FROM EMPLOYEES E
  LEFT JOIN DEPARTMENTS D
    ON D.DEPARTMENT_ID = E.DEPARTMENT_ID
  LEFT JOIN LOCATIONS L
    ON L.LOCATION_ID = D.LOCATION_ID
 GROUP BY L.CITY;

-- 97. 국가별 사원 수, 최대연봉, 최소연봉을 조회한다.
SELECT C.COUNTRY_NAME 
     , COUNT(E.EMPLOYEE_ID)
     , MAX(E.SALARY) 
     , MIN(E.SALARY) 
  FROM EMPLOYEES E
  LEFT JOIN DEPARTMENTS D
    ON D.DEPARTMENT_ID = E.DEPARTMENT_ID
  LEFT JOIN LOCATIONS L
    ON L.LOCATION_ID = D.LOCATION_ID
  LEFT JOIN COUNTRIES C
    ON C.COUNTRY_ID = L.COUNTRY_ID 
 GROUP BY C.COUNTRY_NAME
;

-- 98. 대륙별 사원 수를 대륙명으로 오름차순 정렬하여 조회한다.
SELECT R.REGION_NAME 
     , COUNT(E.EMPLOYEE_ID)
  FROM EMPLOYEES E
  LEFT JOIN DEPARTMENTS D
    ON D.DEPARTMENT_ID = E.DEPARTMENT_ID
  LEFT JOIN LOCATIONS L
    ON L.LOCATION_ID = D.LOCATION_ID
  LEFT JOIN COUNTRIES C
    ON C.COUNTRY_ID = L.COUNTRY_ID
  LEFT JOIN REGIONS R
    ON R.REGION_ID = C.REGION_ID 
 GROUP BY R.REGION_NAME 
 ORDER BY R.REGION_NAME 
;

-- 99. 이름이나 성에 'A' 혹은 'a' 가 포함된 사원의 모든 정보를 조회한다.
SELECT *
  FROM EMPLOYEES
 WHERE FIRST_NAME LIKE '%A%'
    OR FIRST_NAME LIKE '%a%'
    OR LAST_NAME LIKE '%A%'
    OR LAST_NAME LIKE '%a%'
;

-- 100. 국가별로 연봉이 5000 이상인 사원의 수를 조회한다.
SELECT C.COUNTRY_NAME
     , COUNT(E.EMPLOYEE_ID)
  FROM EMPLOYEES E
  LEFT JOIN DEPARTMENTS D
    ON D.DEPARTMENT_ID = E.DEPARTMENT_ID
  LEFT JOIN LOCATIONS L
    ON L.LOCATION_ID = D.LOCATION_ID
  LEFT JOIN COUNTRIES C
    ON C.COUNTRY_ID = L.COUNTRY_ID 
 WHERE E.SALARY > 5000
 GROUP BY C.COUNTRY_NAME
;

-- 101. 인센티브를 안받는 사원이 근무하는 도시를 조회한다.
SELECT CITY
  FROM LOCATIONS
 WHERE LOCATION_ID IN (SELECT LOCATION_ID
                         FROM DEPARTMENTS
                        WHERE DEPARTMENT_ID IN (SELECT DEPARTMENT_ID
                                                  FROM EMPLOYEES
                                                 WHERE COMMISSION_PCT IS NULL))
;

-- 102. 인센티브를 포함한 연봉이 10000 이상인 사원의 모든 정보를 조회한다.
SELECT *
  FROM EMPLOYEES
 WHERE SALARY + SALARY * COMMISSION_PCT >= 10000
;

-- 103. 가장 많은 부서가 있는 도시를 조회한다.
SELECT CITY
  FROM LOCATIONS 
 WHERE LOCATION_ID = (SELECT LOCATION_ID
						 FROM (SELECT LOCATION_ID
							        , COUNT(DEPARTMENT_ID)
							     FROM DEPARTMENTS 
							    GROUP BY LOCATION_ID
							    ORDER BY COUNT(DEPARTMENT_ID) DESC)
					    WHERE ROWNUM =1)			
;

-- 104. 가장 많은 사원이 있는 부서의 국가명을 조회한다.
SELECT COUNTRY_NAME
  FROM COUNTRIES
 WHERE COUNTRY_ID = (SELECT COUNTRY_ID
                       FROM LOCATIONS
                      WHERE LOCATION_ID = (SELECT LOCATION_ID
                                             FROM DEPARTMENTS
                                            WHERE DEPARTMENT_ID = (SELECT DEPARTMENT_ID 
																	 FROM (SELECT DEPARTMENT_ID
																			    , COUNT(EMPLOYEE_ID)
																			 FROM EMPLOYEES
																			GROUP BY DEPARTMENT_ID
																			ORDER BY COUNT(EMPLOYEE_ID) DESC)
																	WHERE ROWNUM = 1)))
;

 
-- 105. 우편번호가 5자리인 도시에서 근무하는 사원명, 부서명, 도시명, 우편번호를 조회한다.
SELECT E.FIRST_NAME
 	 , D.DEPARTMENT_NAME
 	 , L.CITY 
 	 , L.POSTAL_CODE 
  FROM EMPLOYEES E
  LEFT JOIN DEPARTMENTS D
    ON D.DEPARTMENT_ID = E.DEPARTMENT_ID
  LEFT JOIN LOCATIONS L
    ON L.LOCATION_ID = D.LOCATION_ID 
 WHERE L.POSTAL_CODE LIKE '_____'
;

-- 106. 우편번호에 공백이 없는 도시에서 근무하는 사원의 이름, 부서명, 우편번호를 조회한다.
SELECT E.FIRST_NAME
 	 , D.DEPARTMENT_NAME
 	 , L.POSTAL_CODE 
  FROM EMPLOYEES E
  LEFT JOIN DEPARTMENTS D
    ON D.DEPARTMENT_ID = E.DEPARTMENT_ID
  LEFT JOIN LOCATIONS L
    ON L.LOCATION_ID = D.LOCATION_ID 
 WHERE L.POSTAL_CODE NOT LIKE '% %'
   AND L.POSTAL_CODE NOT LIKE '% '
   AND L.POSTAL_CODE NOT LIKE ' %'
;
-- 107. "주"가 없는 도시에서 근무하는 사원의 이름, 도시를 조회한다.
SELECT E.FIRST_NAME
 	 , L.CITY  
  FROM EMPLOYEES E
  LEFT JOIN DEPARTMENTS D
    ON D.DEPARTMENT_ID = E.DEPARTMENT_ID
  LEFT JOIN LOCATIONS L
    ON L.LOCATION_ID = D.LOCATION_ID 
 WHERE L.STATE_PROVINCE IS NULL
;

-- 108. 국가명이 6자리인 국가의 모든 정보를 조회한다.
SELECT *
  FROM COUNTRIES
 WHERE COUNTRY_NAME LIKE '______'
;

-- 109. 사원의 이름과 성을 이용해 EMAIL과 같은 값으로 만들어 조회한다. 
-- 고민해보자.. 앞에하나 LAST_NAME 갔다붙이기
SELECT *
  FROM EMPLOYEES
 WHERE 
;

-- 110. 모든 사원들의 이름을 10자리로 변환해 조회한다. 예> 이름 => "        이름"
-- LPAD 함수
SELECT LPAD(FIRST_NAME, 10, ' ')
  FROM EMPLOYEES
;
-- 111. 모든 사원들의 성을 10자리로 변환해 조회한다. 예> 성 => "성         "
-- RPAD 함수
SELECT RPAD(LAST_NAME , 10, ' ')
  FROM EMPLOYEES
;
-- 112. 109번 사원의 입사일 부터 1년 내에 입사한 사원의 모든 정보를 조회한다.
SELECT *
  FROM EMPLOYEES
 WHERE HIRE_DATE >= (SELECT HIRE_DATE 
  					   FROM EMPLOYEES
 				      WHERE EMPLOYEE_ID = 109)
   AND HIRE_DATE <= (SELECT ADD_MONTHS(HIRE_DATE ,12) 
  					   FROM EMPLOYEES
 				      WHERE EMPLOYEE_ID = 109)
;

-- 113. 가장 먼저 입사한 사원의 입사일로부터 2년 내에 입사한사원의 모든 정보를 조회한다.
SELECT *
  FROM EMPLOYEES
 WHERE HIRE_DATE >= (SELECT MIN(HIRE_DATE)
  					   FROM EMPLOYEES)
   AND HIRE_DATE <= (SELECT ADD_MONTHS(MIN(HIRE_DATE) ,24) 
  					   FROM EMPLOYEES)
;

-- 114. 가장 늦게 입사한 사원의 입사일 보다 1년 앞서 입사한 사원의 모든 정보를 조회한다.
SELECT *
  FROM EMPLOYEES
 WHERE HIRE_DATE <= (SELECT MAX(HIRE_DATE)
  					   FROM EMPLOYEES)
   AND HIRE_DATE >= (SELECT ADD_MONTHS(MAX(HIRE_DATE) ,-12) 
  					   FROM EMPLOYEES)
;

-- 115. 도시명에 띄어쓰기 " " 가 포함된 도시에서 근무중인 사원들의 부서명, 도시명, 사원명을 조회한다.
SELECT D.DEPARTMENT_NAME
 	 , L.CITY 
 	 , E.FIRST_NAME 
  FROM EMPLOYEES E
  LEFT JOIN DEPARTMENTS D
    ON D.DEPARTMENT_ID = E.DEPARTMENT_ID
  LEFT JOIN LOCATIONS L
    ON L.LOCATION_ID = D.LOCATION_ID 
 WHERE L.CITY LIKE '% %'
;
-- 116. MOD 함수를 통해 사원번호가 홀수면 남자, 짝수면 여자 로 구분해 조회한다. MOD(값, 나눌값)
-- CASE WHEN THEN ELSE END | DECODE 함수 ----??
SELECT MOD(101, 2)
	 , DECODE(MOD(101, 2), 1, '남자', 0, '여자') 
  FROM DUAL
;

SELECT EMPLOYEE_ID
     , CASE
     	WHEN MOD(EMPLOYEE_ID,2) = 1 THEN
     		'남자'
     	ELSE 
     		'여자'
       END AS 성별
     , CASE MOD(EMPLOYEE_ID,2)
        WHEN 1 THEN
            '남자'
        ELSE 
     		'여자'
       END AS 성별
  FROM EMPLOYEES
;

SELECT EMPLOYEE_ID 
     , DECODE(MOD(EMPLOYEE_ID , 2), 1, '남자', 0, '여자') 
  FROM EMPLOYEES e 
;


-- 117. '20230222' 문자 데이터를 날짜로 변환해 조회한다.(DUAL)
-- TO_DATE 함수
SELECT TO_DATE('20230222','YYYYMMDD')
  FROM DUAL
;
-- 118. '20230222' 문자 데이터를 'YYYY-MM' 으로 변환해 조회한다.(DUAL) -- 틀렸나..
-- TO_DATE 함수
SELECT TO_DATE('2023-02','YYYY-MM')
  FROM DUAL
;
-- 119. '20230222130140' 문자 데이터를 'YYYY-MM-DD HH24:MI:SS' 으로 변환해 조회한다. (DUAL)
-- TO_DATE 함수
SELECT TO_DATE('20230222130140','YYYY-MM-DD HH24:MI:SS')
  FROM DUAL
;

-- 120. '20230222' 날짜의 열흘 후의 날짜를 'YYYY-MM-DD' 으로 변환해 조회한다. (DUAL)
-- TO_DATE 함수
SELECT TO_DATE('20230222','YYYY-MM-DD') + 10
  FROM DUAL
;
-- 121. 사원 이름의 글자수 별 사원의 수를 조회한다.
-- LEN | LENGTH 함수 
SELECT LENGTH(FIRST_NAME)
	 , COUNT(EMPLOYEE_ID) 
  FROM EMPLOYEES
 GROUP BY LENGTH(FIRST_NAME)
;

-- 122. 사원 성의 글자수 별 사원의 수를 조회한다.
-- LEN | LENGTH 함수 
SELECT LENGTH(LAST_NAME)
	 , COUNT(EMPLOYEE_ID) 
  FROM EMPLOYEES
 GROUP BY LENGTH(LAST_NAME)
;

-- 123. 사원의 연봉이 5000 이하이면 "사원", 7000 이하이면 "대리", 9000 이하이면 "과장", 그 외에는 임원 으로 조회한다.
-- CASE WHEN THEN ELSE END
SELECT EMPLOYEE_ID
     , SALARY
     , CASE
     	WHEN SALARY <= 5000 THEN
     		'사원'
     	WHEN SALARY <= 7000 THEN
     		'대리'
     	WHEN SALARY <= 9000 THEN
     		'과장'
     	ELSE '임원'
       END AS 직급
  FROM EMPLOYEES
;
-- 124. 부서별 사원의 수를 조인을 이용해 다음과 같이 조회한다."부서명 (사원의 수)"
SELECT D.DEPARTMENT_NAME || ' (' || COUNT(E.EMPLOYEE_ID) || ')' AS NAME
  FROM EMPLOYEES E
  JOIN DEPARTMENTS D
    ON D.DEPARTMENT_ID = E.DEPARTMENT_ID
 GROUP BY D.DEPARTMENT_NAME 
 
-- 125. 부서별 사원의 수를 스칼라쿼리를 이용해 다음과 같이 조회한다. "부서명 (사원의 수)"
-- 떠오르지 않음..
 
-- 126. 사원의 정보를 다음과 같이 조회한다. "사원번호 번 사원의 이름은 성이름 입니다."
SELECT '사원번호 ' || EMPLOYEE_ID || '번 사원의 이름은 ' || LAST_NAME || ' ' || FIRST_NAME || ' 입니다.'AS NAME
  FROM EMPLOYEES
;
-- 127. 사원의 정보를 스칼라쿼리를 이용해 다음과 같이 조회한다. "사원번호 번 사원의 상사명은 상사명 입니다."
-- SCALA QUERY 사용

-- 128. 사원의 정보를 조인을 이용해 다음고 같이 조회한다. "사원명 (직무명)"
SELECT FIRST_NAME || ' (' || JOB_TITLE || ')'
  FROM EMPLOYEES E
  JOIN JOBS J
    ON J.JOB_ID = E.JOB_ID 

-- 129. 사원의 정보를 스칼라쿼리를 이용해 다음과 같이 조회한다. "사원명 (직무명)"
-- SCALA QUERY 사용

-- 130. 부서별 연봉 차이(최고연봉 - 최저연봉)가 가장 큰 부서명을 조회한다.
SELECT D.DEPARTMENT_NAME 
     , MAX(E.SALARY) - MIN(E.SALARY)
  FROM EMPLOYEES E
  LEFT JOIN DEPARTMENTS D
    ON D.DEPARTMENT_ID = E.DEPARTMENT_ID 
 GROUP BY D.DEPARTMENT_NAME;
 
-- 131. 부서별 연봉 차이(최고연봉 - 최저연봉)가 가장 큰 부서에서 근무하는 사원들의 직무명을 중복없이 조회한다.
SELECT DISTINCT JOB_TITLE 
  FROM JOBS J
  LEFT JOIN EMPLOYEES E
    ON E.JOB_ID = J.JOB_ID 
 WHERE E.DEPARTMENT_ID = (SELECT DEPARTMENT_ID 
 							FROM (SELECT D.DEPARTMENT_ID
					   				   , MAX(E.SALARY) - MIN(E.SALARY)
					  				FROM EMPLOYEES E
					  				LEFT JOIN DEPARTMENTS D
					   				  ON D.DEPARTMENT_ID = E.DEPARTMENT_ID 
								   GROUP BY D.DEPARTMENT_ID 
								   ORDER BY MAX(E.SALARY) - MIN(E.SALARY) DESC)
					       WHERE ROWNUM = 1)
					 
;

-- 132. 부서장이 없는 부서명 중 첫 글자가 'C' 로 시작하는 부서명을 조회한다.
SELECT DEPARTMENT_NAME 
  FROM DEPARTMENTS
 WHERE MANAGER_ID IS NULL
   AND DEPARTMENT_NAME LIKE 'C%'

-- 133. 부서장이 있는 부서명 중 첫 글자가 'S' 로 시작하는 부서에서 근무중인 사원의 이름과 직무명, 부서명을 조회한다.
SELECT E.FIRST_NAME 
     , J.JOB_TITLE 
     , D.DEPARTMENT_NAME 
  FROM EMPLOYEES E
  LEFT JOIN DEPARTMENTS D
    ON D.DEPARTMENT_ID = E.DEPARTMENT_ID 
  LEFT JOIN JOBS J
    ON J.JOB_ID = E.JOB_ID 
 WHERE D.MANAGER_ID IS NOT NULL
   AND DEPARTMENT_NAME LIKE 'S%'
;  
-- 134. 지역변호가 1000 ~ 1999 사이인 지역내 부서의 모든 정보를 조회한다.
SELECT *
  FROM DEPARTMENTS 
 WHERE LOCATION_ID BETWEEN 1000 AND 1999
;

-- 135. 90, 60, 100번 부서에서 근무중인 사원의 이름, 성, 부서명을 조회한다.
SELECT E.FIRST_NAME
     , E.LAST_NAME
     , D.DEPARTMENT_NAME
  FROM EMPLOYEES E
  LEFT JOIN DEPARTMENTS D
    ON D.DEPARTMENT_ID = E.DEPARTMENT_ID 
 WHERE D.DEPARTMENT_ID IN (135, 90, 60, 100)
;
-- 136. 부서명이 5글자 미만인 부서에서 근무중인 사원의 이름, 부서명을 조회한다.
-- LEN | LENGTH 함수 
SELECT E.FIRST_NAME
     , D.DEPARTMENT_NAME
  FROM EMPLOYEES E
  LEFT JOIN DEPARTMENTS D
    ON D.DEPARTMENT_ID = E.DEPARTMENT_ID 
 WHERE LENGTH(D.DEPARTMENT_NAME) < 5
;

-- 137. 국가 아이디가 'C'로 시작하는 국가의 지역을 모두 조회한다.
SELECT L.*
  FROM LOCATIONS L
  LEFT JOIN COUNTRIES C
    ON C.COUNTRY_ID = L.COUNTRY_ID
 WHERE C.COUNTRY_NAME LIKE 'C%'
;

-- 138. 국가 아이디의 첫 글자와 국가명의 첫 글자가 다른 모든 국가를 조회한다.
SELECT *
  FROM COUNTRIES
 WHERE SUBSTR(COUNTRY_ID,1,1) = SUBSTR(COUNTRY_NAME,1,1) 

-- 139. 사원 모든 정보 중 이메일만 모두 소문자로 변경하여 조회한다.
SELECT EMPLOYEE_ID
     , FIRST_NAME
     , LAST_NAME
     , LOWER(EMAIL) AS EMAIL
     , PHONE_NUMBER
     , HIRE_DATE
     , JOB_ID
     , SALARY
     , COMMISSION_PCT
     , MANAGER_ID
     , DEPARTMENT_ID
  FROM EMPLOYEES
;
-- 140. 사원의 연봉을 TRUNC(소수점 버림) 함수를 사용해 100 단위는 버린채 다음과 같이 조회한다. 예> 3700 -> 3000, 12700 -> 12000
SELECT EMPLOYEE_ID
     , FIRST_NAME
     , LAST_NAME
     , EMAIL
     , PHONE_NUMBER
     , HIRE_DATE
     , JOB_ID
     , TRUNC(SALARY,-3)
     , COMMISSION_PCT
     , MANAGER_ID
     , DEPARTMENT_ID
  FROM EMPLOYEES
;

-- 141. 100단위를 버린 사원의 연봉 별 사원의 수를 조회한다.
SELECT TRUNC(SALARY,-3)
     , COUNT(EMPLOYEE_ID)
  FROM EMPLOYEES
 GROUP BY TRUNC(SALARY,-3)
;

-- 142. 현재 시간으로부터 20년 전 보다 일찍 입사한 사원의 모든 정보를 조회한다.
SELECT *
  FROM EMPLOYEES
 WHERE HIRE_DATE < ADD_MONTHS(SYSDATE, 20 * -12)
;

-- 143. 부서번호별 현재 시간으로부터 15년 전 보다 일찍 입사한 사원의 수를 조회한다.
SELECT DEPARTMENT_ID
     , COUNT(EMPLOYEE_ID)
  FROM (SELECT *
  		  FROM EMPLOYEES
 	     WHERE HIRE_DATE < ADD_MONTHS(SYSDATE, 20 * -12))
 GROUP BY DEPARTMENT_ID
;

-- 144. 부서명, 직무명 별 평균 연봉을 조회한다.
SELECT D.DEPARTMENT_NAME
     , J.JOB_TITLE 
	 , AVG(SALARY) 
  FROM EMPLOYEES E
  LEFT JOIN DEPARTMENTS D
    ON D.DEPARTMENT_ID = E.EMPLOYEE_ID 
  LEFT JOIN JOBS J
    ON J.JOB_ID = E.JOB_ID 
 GROUP BY D.DEPARTMENT_NAME, J.JOB_TITLE 


-- 145. 도시명, 국가명 별 사원의 수를 조회한다.
SELECT L.CITY
     , C.COUNTRY_NAME
     , COUNT(E.EMPLOYEE_ID)
  FROM EMPLOYEES E
  LEFT JOIN DEPARTMENTS D
    ON D.DEPARTMENT_ID = E.DEPARTMENT_ID 
  LEFT JOIN LOCATIONS L
    ON L.LOCATION_ID = D.LOCATION_ID 
  LEFT JOIN COUNTRIES C
    ON C.COUNTRY_ID = L.COUNTRY_ID 
 GROUP BY L.CITY, C.COUNTRY_NAME 
; 

-- 146. 부서명, 직무명 별 평균 연봉 중 가장 작은 평균연봉을 받는 부서명, 직무명을 조회한다.
SELECT *
  FROM (SELECT D.DEPARTMENT_NAME
		     , J.JOB_TITLE 
			 , AVG(SALARY) 
		  FROM EMPLOYEES E
		  LEFT JOIN DEPARTMENTS D
		    ON D.DEPARTMENT_ID = E.EMPLOYEE_ID 
		  LEFT JOIN JOBS J
		    ON J.JOB_ID = E.JOB_ID 
		 GROUP BY D.DEPARTMENT_NAME, J.JOB_TITLE
		 ORDER BY AVG(SALARY))
 WHERE ROWNUM = 1
;

-- 147. 102번 직원의 모든 부하직원의 수를 조회한다.
SELECT COUNT(EMPLOYEE_ID) 
   FROM EMPLOYEES
  START WITH EMPLOYEE_ID = 102
CONNECT BY PRIOR EMPLOYEE_ID = MANAGER_ID
;

-- 148. 113번 직원의 모든 부하직원의 수를 조회한다.
SELECT COUNT(EMPLOYEE_ID) 
   FROM EMPLOYEES
  START WITH EMPLOYEE_ID = 113
CONNECT BY PRIOR EMPLOYEE_ID = MANAGER_ID
;
-- 149. 부하직원이 없는 사원의 모든 정보를 조회한다.
SELECT *
  FROM EMPLOYEES
 WHERE EMPLOYEE_ID NOT IN (SELECT MANAGER_ID
 							 FROM EMPLOYEES
 							WHERE MANAGER_ID IS NOT NULL)
;  

-- 150. 사원번호가 100번인 사원의 사원번호, 이름과 사원번호로 내림차순 정렬된 사원의 사원번호, 이름 조회한다.
-- UNION ALL
SELECT EMPLOYEE_ID
	 , FIRST_NAME 
  FROM EMPLOYEES 
 WHERE EMPLOYEE_ID = 100
 UNION ALL
SELECT EMPLOYEE_ID
     , FIRST_NAME 
  FROM EMPLOYEES E2
 ORDER BY EMPLOYEE_ID DESC
;
/*조회 예
--------------------
100    Steven
206    William
205    Shelley
204    Hermann
203    Susan
202    Pat
201    Michael
200    Jennifer
199    Douglas
198    Donald
197    Kevin
196    Alana
...
*/

-- 151. 모든 사원의 모든 정보를 조회한다.
SELECT *
  FROM EMPLOYEES
;

-- 152. 부서가 없는 사원의 모든 정보를 조회한다.
SELECT *
  FROM EMPLOYEES
 WHERE DEPARTMENT_ID IS NULL
;

-- 153. 직무가 없는 사원의 모든 정보를 조회한다.
SELECT *
  FROM EMPLOYEES
 WHERE JOB_ID IS NULL
;

-- 154. 부서와 직무가 모두 있는 사원의 모든 정보를 조회한다.
SELECT *
  FROM EMPLOYEES
 WHERE DEPARTMENT_ID IS NOT NULL
   AND JOB_ID IS NOT NULL
;

-- 155. 부서장이 없는 모든 부서의 모든 정보를 조회한다.
SELECT *
  FROM DEPARTMENTS
 WHERE MANAGER_ID IS NULL
;

-- 156. 부서장이 있는 모든 부서의 모든 정보를 조회한다.
SELECT *
  FROM DEPARTMENTS
 WHERE MANAGER_ID IS NOT NULL
;

-- 157. 부서장의 모든 사원 정보를 조회한다.
SELECT *
  FROM EMPLOYEES e 
 WHERE EMPLOYEE_ID IN (SELECT MANAGER_ID
                        FROM DEPARTMENTS
                       WHERE MANAGER_ID IS NOT NULL)
;

-- 158. 사원의 이름만 조회한다.
SELECT FIRST_NAME
  FROM EMPLOYEES
;

-- 159. 사원의 이름이 7자리인 사원의 모든 정보를 조회한다.
SELECT *
  FROM EMPLOYEES
 WHERE FIRST_NAME LIKE '_______'
;

-- 160. 사원의 이메일이 6자리인 사원의 모든 정보를 조회한다.
SELECT *
  FROM EMPLOYEES
 WHERE EMAIL LIKE '______'
;

-- 161. 모든 지역의 모든 정보를 조회한다.
SELECT *
  FROM LOCATIONS
;

-- 162. 지역이 없는 모든 부서의 정보를 조회한다. (SUB QUERY | LEFT OUTER JOIN)
SELECT *
  FROM DEPARTMENTS D
  LEFT JOIN LOCATIONS L
    ON L.LOCATION_ID = D.LOCATION_ID
 WHERE D.LOCATION_ID IS NULL
;

-- 163. 지역이 있는 모든 부서의 정보와 도시 정보를 조회한다. (SUB QUERY | INNER JOIN)
SELECT *
  FROM DEPARTMENTS D
  LEFT JOIN LOCATIONS L
    ON L.LOCATION_ID = D.LOCATION_ID
 WHERE D.LOCATION_ID IS NOT NULL
;

-- 164. 모든 사원의 모든 정보와 부서명을 조회한다.
SELECT E.*
     , D.DEPARTMENT_NAME
  FROM EMPLOYEES E
  LEFT JOIN DEPARTMENTS D
    ON D.DEPARTMENT_ID = E.DEPARTMENT_ID 
;

-- 165. 111번 사원의 모든 정보와 부서명을 조회한다.
SELECT E.*
     , D.DEPARTMENT_NAME
  FROM EMPLOYEES E
  LEFT JOIN DEPARTMENTS D
    ON D.DEPARTMENT_ID = E.DEPARTMENT_ID 
 WHERE E.EMPLOYEE_ID = 111
;

-- 166. 115번의 사원의 모든 정보와 부서명, 직무명을 조회한다.
SELECT E.*
     , D.DEPARTMENT_NAME
     , J.JOB_TITLE 
  FROM EMPLOYEES E
  LEFT JOIN DEPARTMENTS D
    ON D.DEPARTMENT_ID = E.DEPARTMENT_ID 
  LEFT JOIN JOBS J
    ON J.JOB_ID = E.JOB_ID 
 WHERE E.EMPLOYEE_ID = 115
;

-- 167. 100번 사원의 모든 정보와 부서명, 직무명, 도시명을 조회한다.
SELECT E.*
     , D.DEPARTMENT_NAME
     , J.JOB_TITLE 
     , L.CITY 
  FROM EMPLOYEES E
  LEFT JOIN DEPARTMENTS D
    ON D.DEPARTMENT_ID = E.DEPARTMENT_ID 
  LEFT JOIN JOBS J
    ON J.JOB_ID = E.JOB_ID
  LEFT JOIN LOCATIONS L
    ON L.LOCATION_ID = D.LOCATION_ID 
 WHERE E.EMPLOYEE_ID = 100
;

-- 168. 부서아이디별 사원의 평균연봉을 조회한다.
SELECT DEPARTMENT_ID
     , AVG(SALARY)
  FROM EMPLOYEES
 GROUP BY DEPARTMENT_ID
;

-- 169. 직무아이디별 사원의 최고연봉을 조회한다.
SELECT JOB_ID 
     , MAX(SALARY)
  FROM EMPLOYEES
 GROUP BY JOB_ID 
;

-- 170. 부서명별 사원의 수를 조회한다.
SELECT D.DEPARTMENT_NAME 
     , COUNT(EMPLOYEE_ID)
  FROM EMPLOYEES E
  LEFT JOIN DEPARTMENTS D
    ON D.DEPARTMENT_ID = E.DEPARTMENT_ID
 GROUP BY D.DEPARTMENT_NAME  
;     

-- 171. 직무명별 사원의 평균연봉을 조회한다.
SELECT J.JOB_TITLE  
     , AVG(SALARY)
  FROM EMPLOYEES E
  LEFT JOIN JOBS J
    ON J.JOB_ID = E.JOB_ID 
 GROUP BY J.JOB_TITLE  
;   

-- 172. 부서명, 직무명별 사원의 수와 평균연봉을 조회한다.
SELECT D.DEPARTMENT_NAME
     , J.JOB_TITLE  
     , AVG(SALARY)
     , COUNT(EMPLOYEE_ID)
  FROM EMPLOYEES E
  LEFT JOIN DEPARTMENTS D
    ON D.DEPARTMENT_ID = E.DEPARTMENT_ID
  LEFT JOIN JOBS J
    ON J.JOB_ID = E.JOB_ID 
 GROUP BY D.DEPARTMENT_NAME, J.JOB_TITLE  
;     

-- 173. 인센티브를 안받는 사원의 모든 정보를 조회한다.
SELECT *
  FROM EMPLOYEES
 WHERE COMMISSION_PCT IS NULL
;

-- 174. 인센티브를 받는 사원의 부서아이디를 중복없이 조회한다.
SELECT DISTINCT DEPARTMENT_ID 
  FROM EMPLOYEES
 WHERE COMMISSION_PCT IS NOT NULL
;

-- 175. 인센티브를 받는 사원의 직무아이디를 중복없이 조회한다.
SELECT DISTINCT JOB_ID  
  FROM EMPLOYEES
 WHERE COMMISSION_PCT IS NOT NULL
;

-- 176. 사원이 있는 부서의 지역아이디를 조회한다.
SELECT LOCATION_ID
  FROM DEPARTMENTS
 WHERE DEPARTMENT_ID IN (SELECT DISTINCT DEPARTMENT_ID
                           FROM EMPLOYEES) 
;

-- 177. 사원이 없는 부서의 부서명을 조회한다.
SELECT D.DEPARTMENT_NAME
  FROM DEPARTMENTS D
 WHERE D.DEPARTMENT_ID NOT IN (SELECT DISTINCT E.DEPARTMENT_ID
                                 FROM EMPLOYEES E
                                WHERE E.DEPARTMENT_ID IS NOT NULL)
;

-- 178. 지역별 부서의 수를 조회한다. (부서가 없으면 부서의 수는 0으로 조회한다.)

SELECT L.LOCATION_ID
	 , COUNT(D.DEPARTMENT_ID) 
  FROM LOCATIONS L
  LEFT JOIN DEPARTMENTS D
    ON L.LOCATION_ID = D.LOCATION_ID
 GROUP BY L.LOCATION_ID 
;
  
-- 179. 지역별 사원의 평균연봉을 조회한다. (사원이 없으면 평균연봉은 0으로 조회한다.)
SELECT L.LOCATION_ID
	 , NVL(AVG(SALARY),0) 
  FROM LOCATIONS L
  LEFT JOIN DEPARTMENTS D
    ON L.LOCATION_ID = D.LOCATION_ID
  LEFT JOIN EMPLOYEES E
    ON D.DEPARTMENT_ID = E.DEPARTMENT_ID
 GROUP BY L.LOCATION_ID 
;

-- 180. Seattle의 부서 아이디를 조회한다.
SELECT DEPARTMENT_ID
  FROM DEPARTMENTS D
  LEFT JOIN LOCATIONS L
    ON L.LOCATION_ID = D.LOCATION_ID
 WHERE L.CITY = 'Seattle'
;
  
-- 181. Seattle에서 근무중인 사원의 모든 직무명을 중복없이 조회한다.
SELECT JOB_TITLE
  FROM JOBS
 WHERE JOB_ID IN (SELECT JOB_ID 
                    FROM EMPLOYEES
                   WHERE DEPARTMENT_ID IN (SELECT DEPARTMENT_ID
                                             FROM DEPARTMENTS
                                            WHERE LOCATION_ID IN (SELECT LOCATION_ID
                                                                    FROM LOCATIONS
                                                                   WHERE CITY = 'Seattle')))
;

-- 182. 사원이 한명도 없는 도시를 조회한다.
SELECT CITY
  FROM LOCATIONS
 WHERE LOCATION_ID NOT IN (SELECT LOCATION_ID
                         FROM DEPARTMENTS
                        WHERE DEPARTMENT_ID  IN (SELECT DEPARTMENT_ID
                                                   FROM EMPLOYEES
                                                  WHERE DEPARTMENT_ID IS NOT NULL))
;

-- 183. 사원이 한명이라도 있는 도시를 조회한다.
SELECT CITY
  FROM LOCATIONS
 WHERE LOCATION_ID IN (SELECT LOCATION_ID
                         FROM DEPARTMENTS
                        WHERE DEPARTMENT_ID IN (SELECT DEPARTMENT_ID
                                                  FROM EMPLOYEES
                                                 WHERE DEPARTMENT_ID IS NOT NULL))
;

-- 184. 모든 사원의 정보를 연봉으로 오름차순 정렬하여 조회한다.
SELECT *
  FROM EMPLOYEES
 ORDER BY SALARY 
  
-- 185. 부서명별 평균연봉을 부서명으로 내림차순 정렬하여 조회한다.
SELECT D.DEPARTMENT_NAME
     , AVG(E.SALARY) 
  FROM EMPLOYEES E
  LEFT JOIN DEPARTMENTS D
    ON D.DEPARTMENT_ID = E.DEPARTMENT_ID
 GROUP BY D.DEPARTMENT_NAME
 ORDER BY D.DEPARTMENT_NAME 
;

-- 186. 부서명별 최고연봉을 최고연봉으로 오름차순 정렬하여 조회한다.
SELECT D.DEPARTMENT_NAME
     , MAX(E.SALARY) 
  FROM EMPLOYEES E
  LEFT JOIN DEPARTMENTS D
    ON D.DEPARTMENT_ID = E.DEPARTMENT_ID
 GROUP BY D.DEPARTMENT_NAME
 ORDER BY MAX(E.SALARY)  
;

-- 187. 부서명이 가장 긴 부서에서 근무중인 사원의 모든 정보를 조회한다.
SELECT *
  FROM (SELECT E.*
		  FROM EMPLOYEES E
		  LEFT JOIN DEPARTMENTS D
		    ON D.DEPARTMENT_ID = E.DEPARTMENT_ID
		 ORDER BY LENGTH(D.DEPARTMENT_NAME))
 WHERE ROWNUM = 1
;

-- 188. 도시명 별 사원의 수를 도시명으로 오름차순 정렬하여 조회한다.
SELECT L.CITY
     , COUNT(E.EMPLOYEE_ID) 
  FROM EMPLOYEES E
  LEFT JOIN DEPARTMENTS D
    ON D.DEPARTMENT_ID = E.DEPARTMENT_ID
  LEFT JOIN LOCATIONS L 
    ON L.LOCATION_ID = D.LOCATION_ID 
 GROUP BY L.CITY 
 ORDER BY L.CITY 
;

-- 189. 모든 사원의 사원번호, 이름, 성, 연봉, 인센티브를 포함한 연봉 정보를 조회한다.
SELECT EMPLOYEE_ID
     , FIRST_NAME 
     , LAST_NAME 
     , SALARY 
     , SALARY + NVL(COMMISSION_PCT,0) * SALARY
  FROM EMPLOYEES
;

-- 190. 매년 10%의 상여금을 받는다고 했을 때, 사원별로 현재까지 받은 상여금의 합과 사원번호, 연봉을 조회한다.
SELECT EMPLOYEE_ID
     , TRUNC(MONTHS_BETWEEN(SYSDATE, HIRE_DATE) / 12) * 0.1 * SALARY AS 상여금 
     , SALARY
  FROM EMPLOYEES
;

-- 191. 직무가 변경되었던 사원들의 모든 정보를 조회한다.
SELECT *
  FROM EMPLOYEES
 WHERE EMPLOYEE_ID IN (SELECT EMPLOYEE_ID
                         FROM JOB_HISTORY)
;                        
 
-- 192. 모든 사원들의 현재 직무명과 과거의 직무명을 조회한다.
-- 만약 직무가 한번도 변경되지 않았다면, 과거의 직무명은 '없음' 으로 조회한다.
SELECT E.EMPLOYEE_ID
     , NVL(PAST_J.JOB_TITLE, '없음') 
     , NVL(NOW_J.JOB_TITLE, '없음') 
  FROM EMPLOYEES E
  LEFT JOIN JOBS NOW_J -- 현재 직무의 정보
    ON NOW_J.JOB_ID = E.JOB_ID 
  LEFT JOIN JOB_HISTORY JH
    ON JH.EMPLOYEE_ID = E.EMPLOYEE_ID 
  LEFT JOIN JOBS PAST_J -- 과거 직무의 정보
    ON PAST_J.JOB_ID = JH.JOB_ID
;
    

-- 193. 직무가 변경될 때마다 연봉이 15% 감소한다고 했을 때, 직무가 변경된 사원들의 감소된 연봉을 조회한다.
SELECT GG.EMPLOYEE_ID
     , SALARY - SALARY * 0.15 * JHCOUNT 
  FROM EMPLOYEES E
 INNER JOIN (SELECT EMPLOYEE_ID 
     , COUNT(EMPLOYEE_ID) AS JHCOUNT
  FROM JOB_HISTORY
 GROUP BY EMPLOYEE_ID) GG
    ON GG.EMPLOYEE_ID = E.EMPLOYEE_ID  
;

         
 
-- 194. 2003년에 입사한 사원은 몇 명인지 조회한다.
SELECT TO_CHAR(HIRE_DATE,'YYYY')
     , COUNT(EMPLOYEE_ID)
  FROM EMPLOYEES
 GROUP BY TO_CHAR(HIRE_DATE,'YYYY')
HAVING TO_CHAR(HIRE_DATE,'YYYY') = 2003
;

-- 195. 2002년부터 2006년까지 입사한 사원은 몇명인지 연도별로 조회한다.
SELECT TO_CHAR(HIRE_DATE,'YYYY')
     , COUNT(EMPLOYEE_ID)
  FROM EMPLOYEES
 GROUP BY TO_CHAR(HIRE_DATE,'YYYY')
HAVING TO_CHAR(HIRE_DATE,'YYYY') BETWEEN 2002 AND 2006
 ORDER BY TO_CHAR(HIRE_DATE,'YYYY')
;

-- 196. 113번 사원의 상사의 모든 정보를 조회한다.
SELECT *
  FROM EMPLOYEES
 WHERE EMPLOYEE_ID = (SELECT MANAGER_ID
                         FROM EMPLOYEES
                        WHERE EMPLOYEE_ID = 113)
;                        

-- 197. 100번 사원의 모든 부하직원을 계층조회한다.
 SELECT LEVEL
 	  , EMPLOYEE_ID
      , FIRST_NAME || ' ' || LAST_NAME AS NAME
      , MANAGER_ID
   FROM EMPLOYEES
  START WITH EMPLOYEE_ID = 100
CONNECT BY PRIOR EMPLOYEE_ID = MANAGER_ID
;

-- 198. 113번 사원의 모든 상사를 계증조회한다.
 SELECT LEVEL
 	  , EMPLOYEE_ID
      , FIRST_NAME || ' ' || LAST_NAME AS NAME
      , MANAGER_ID
   FROM EMPLOYEES
  START WITH EMPLOYEE_ID = 113
CONNECT BY PRIOR MANAGER_ID = EMPLOYEE_ID
  ORDER BY LEVEL DESC
;

-- 199. IT 부서장의 모든 부하직원을 계층조회한다.
SELECT LEVEL
 	  , EMPLOYEE_ID
      , FIRST_NAME || ' ' || LAST_NAME AS NAME
      , MANAGER_ID
   FROM EMPLOYEES
  START WITH DEPARTMENT_ID = (SELECT DEPARTMENT_ID
                                FROM DEPARTMENTS
                               WHERE DEPARTMENT_NAME = 'IT')
CONNECT BY PRIOR EMPLOYEE_ID = MANAGER_ID
;  

-- 200. 모든 부서의 부서장들의 부하직원을 계층조회한다.
SELECT LEVEL
 	  , EMPLOYEE_ID
      , FIRST_NAME || ' ' || LAST_NAME AS NAME
      , MANAGER_ID
   FROM EMPLOYEES
  START WITH DEPARTMENT_ID IN (SELECT DEPARTMENT_ID
                                FROM DEPARTMENTS)
CONNECT BY PRIOR EMPLOYEE_ID = MANAGER_ID
;  