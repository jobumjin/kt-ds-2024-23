-- INNER JOIN
-- 문법
SELECT A.*
     , B.*
  FROM TABLE A
 INNER JOIN TABLE B
    ON A.PK = B.FK
;

-- EMPLOYEES 와 DEPARTMENTS 의 모든 정보를 조회
-- 부서에서 근무중인 사원들의 사원정보와 부서정보를 모두 조회
SELECT E.*
	 , D.*
  FROM EMPLOYEES E
 INNER JOIN DEPARTMENTS D
    ON E.DEPARTMENT_ID = D.DEPARTMENT_ID 
;

-- 사원들이 근무하는 부서의 이름과 지역의 도시명, 사원들의 이름을 조회한다.
SELECT D.DEPARTMENT_ID 
     , E.FIRST_NAME 
     , L.CITY 
  FROM EMPLOYEES E
 INNER JOIN DEPARTMENTS D
    ON D.DEPARTMENT_ID = E.DEPARTMENT_ID
 INNER JOIN LOCATIONS L
    ON L.LOCATION_ID = D.LOCATION_ID
;

-- 103번 사원의 이름과 연봉, 사원번호, 부서의 이름, 도시명을 조회한다.
SELECT E.FIRST_NAME 
     , E.SALARY 
     , E.EMPLOYEE_ID
     , D.DEPARTMENT_NAME 
     , L.CITY 
  FROM EMPLOYEES E
 INNER JOIN DEPARTMENTS D
    ON D.DEPARTMENT_ID = E.DEPARTMENT_ID
 INNER JOIN LOCATIONS L
    ON L.LOCATION_ID = D.LOCATION_ID
 WHERE E.EMPLOYEE_ID = 103
;

-- JOIN을 표현하는 여러가지 단어
-- > JOIN
-- > EQUIP JOIN
-- > NATURAL JOIN
-- > INNER JOIN

-- 사원번호가 150번 이하인 사원들의 이름과 성, 연봉, 직무아이디, 직무명을 조회.
SELECT E.FIRST_NAME 
     , E.LAST_NAME 
     , E.SALARY 
     , J.JOB_ID  -- E.JOB_ID 도 가능하지만 성능상 PK를 가져오는 것이 유리하다. 
     , J.JOB_TITLE 
  FROM EMPLOYEES E
 INNER JOIN JOBS J
    ON J.JOB_ID = E.JOB_ID
 WHERE E.EMPLOYEE_ID <= 150
;

-- 부서번호, 부서명, 부서장의 사원번호, 부서장의 이름, 부서장의 성, 부서장의 직무명을 조회
SELECT D.DEPARTMENT_ID 
     , D.DEPARTMENT_NAME 
     , D.MANAGER_ID
     , E.FIRST_NAME 
     , E.LAST_NAME 
     , J.JOB_TITLE 
  FROM EMPLOYEES E
 INNER JOIN DEPARTMENTS D
    ON D.MANAGER_ID = E.EMPLOYEE_ID
 INNER JOIN JOBS J
    ON J.JOB_ID = E.JOB_ID
;

-- 대륙명, 국가명, 지역의 도시명 을 조회한다.
SELECT R.REGION_NAME
     , C.COUNTRY_NAME
     , L.CITY
  FROM REGIONS R
 INNER JOIN COUNTRIES C
    ON R.REGION_ID = C.REGION_ID 
 INNER JOIN LOCATIONS L
    ON C.COUNTRY_ID = L.COUNTRY_ID 
;

-- 사원의 모든 정보와 사원이 근무중인 부서의 이름, 부서가 있는 지역의 도시명, 도시가 있는 국가명, 국가가 있는 대륙명, 직무명을 조회한다.
SELECT E.*
     , D.DEPARTMENT_NAME
     , L.CITY
     , C.COUNTRY_NAME 
     , R.REGION_NAME 
     , J.JOB_TITLE 
  FROM EMPLOYEES E
 INNER JOIN DEPARTMENTS D
    ON D.DEPARTMENT_ID = E.DEPARTMENT_ID
 INNER JOIN LOCATIONS L
    ON L.LOCATION_ID = D.LOCATION_ID
 INNER JOIN COUNTRIES C
    ON C.COUNTRY_ID = L.COUNTRY_ID 
 INNER JOIN REGIONS R
    ON R.REGION_ID = C.REGION_ID
 INNER JOIN JOBS J
    ON J.JOB_ID = E.JOB_ID
 ORDER BY E.EMPLOYEE_ID
;

-- 과거에 직무가 변경된 적이 있는 사원들의 모든 정보를 조회.
-- 사원들의 모든 정보만 조회. -- JOIN X SUB QUERY O
SELECT *
  FROM EMPLOYEES
 WHERE EMPLOYEE_ID IN (SELECT EMPLOYEE_ID
 						 FROM JOB_HISTORY)
;

-- 직무가 변경된 적이 있는 사원의 과거 직무명과 현재직무명 조회
SELECT PAST_J.JOB_TITLE 
	 , JH.START_DATE 
	 , JH.END_DATE 
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


-- 메뉴를 출력.
-- 계단식 정보를 관리.
-- 183번 사원 이름과 상사 정보를 조회한다.
SELECT E.FIRST_NAME
     , M.*
  FROM EMPLOYEES E -- 사원 정보
  JOIN EMPLOYEES M -- 상사 정보 
    ON E.MANAGER_ID = M.EMPLOYEE_ID 
 WHERE E.EMPLOYEE_ID = 183
;

-- LEFT OUTER JOIN
-- 모든 사원들의 이름, 성, 부서명을 조회한다. 만약 부서에 속해있지 않는 사원이라면 NULL 로 표기한다.
-- 예상되는건 수 107건

SELECT *
  FROM EMPLOYEES E
  LEFT JOIN DEPARTMENTS D
    ON D.DEPARTMENT_ID = E.DEPARTMENT_ID 
;

SELECT *
  FROM DEPARTMENTS D
  LEFT JOIN EMPLOYEES E
    ON D.DEPARTMENT_ID = E.DEPARTMENT_ID 
;

-- 근무하는 사원이 없는 부서의 정보를 LEFT OUTER JOIN 으로 조회한다.
SELECT D.*
  FROM DEPARTMENTS D
  LEFT OUTER JOIN EMPLOYEES E
    ON D.DEPARTMENT_ID = E.DEPARTMENT_ID 
 WHERE E.EMPLOYEE_ID IS NULL
;

-- 부서가 존재하지 않는 도시의 이름을 LEFT OUTER JOIN 으로 조회한다.
SELECT L.CITY
  FROM LOCATIONS L
  LEFT JOIN DEPARTMENTS D
    ON D.LOCATION_ID = L.LOCATION_ID 
 WHERE D.DEPARTMENT_ID  IS NULL
;

-- 1. 대륙에 존재하는 국가를 모두 조회한다. 국가가 없을 경우 NULL로 표기한다. (대륙명과 국가명을 조회)
SELECT R.REGION_NAME 
     , C.COUNTRY_NAME 
  FROM REGIONS R
  LEFT OUTER JOIN COUNTRIES C
    ON C.REGION_ID = R.REGION_ID
;

-- 2. 대륙명별 국가의 수를 모두 조회한다. 국가가 없을 경우 0으로 표기한다.
SELECT R.REGION_NAME  
     , COUNT(C.COUNTRY_ID)
  FROM REGIONS R
  LEFT OUTER JOIN COUNTRIES C
    ON C.REGION_ID = R.REGION_ID
 GROUP BY R.REGION_NAME 
;
-- 3. 직무명별 사원의 수를 모두 조회한다. 사원의 수가 없을 경우 0으로 표기한다.
SELECT J.JOB_TITLE  
     , COUNT(E.EMPLOYEE_ID)
  FROM JOBS J
  LEFT OUTER JOIN EMPLOYEES E
    ON J.JOB_ID = E.JOB_ID 
 GROUP BY J.JOB_TITLE 
;

-- 4. 직무명별 사원의 수를 모두 조회한다. 단 사원의 수가 2명이상인 경우만 조회한다.
SELECT J.JOB_TITLE  
     , COUNT(E.EMPLOYEE_ID)
  FROM JOBS J
  LEFT OUTER JOIN EMPLOYEES E
    ON J.JOB_ID = E.JOB_ID 
 GROUP BY J.JOB_TITLE 
HAVING COUNT(E.EMPLOYEE_ID) >= 2
;

-- 5. 근무하는 사원이 단 한명도 없는 도시를 조회한다. (LEFT OUTER JOIN)
SELECT L.CITY
  FROM LOCATIONS L
  LEFT JOIN DEPARTMENTS D
    ON D.LOCATION_ID = L.LOCATION_ID
  LEFT JOIN EMPLOYEES E
    ON D.DEPARTMENT_ID = E.DEPARTMENT_ID   
 GROUP BY L.CITY
HAVING COUNT(E.EMPLOYEE_ID) = 0
;

-- INLINE VIEW
SELECT *
  FROM EMP_DETAILS_VIEW
;
-- 위와 같은 방법은 실무에서는 사용하지 않아 잠깐동안 보기위해 사용하게된다.
-- INLINE VIEW 문법
/*
SELECT COLUMN ....
  FROM (SELECT *
  		  FROM TABLE) A
 INNER JOIN (SELECT *
  		  	   FROM TABLE) B
 WHERE ....
*/

-- 사원의 정보를 INLINE VIEW를 이용해 조회한다.
SELECT EMPLOYEE_ID
	 , SALARY
  FROM (-- INLINE VIEW로 이용할 SELECT 문장을 먼저 작성.
		SELECT EMPLOYEE_ID
		     , FIRST_NAME
		     , LAST_NAME
		     , SALARY
		  FROM EMPLOYEES) TEMP_E
;

-- EMPLOYEES 테이블에서 ROW 3개만 조회한다.
SELECT *
  FROM EMPLOYEES
 WHERE EMPLOYEE_ID <= 102
;

-- Oracle 만 가능
SELECT *
  FROM EMPLOYEES
 WHERE ROWNUM <= 3
;

-- EMPLOYEES 테이블에서 연봉을 가장 많이 받는 사원 3명만 조회한다.
SELECT *
  FROM EMPLOYEES
 WHERE ROWNUM <= 3
 ORDER BY SALARY DESC
; -- 이런 방식으로는 풀 수 없다.

-- INLINE VIEW 이용해서 풀기
SELECT *
  FROM ( -- 1. EMPLOYEES 테이블에서 연봉을 기준으로 내림차순 정렬한다.
		SELECT *
		  FROM EMPLOYEES
		 ORDER BY SALARY DESC) ORDERED_EMPLOYEES
 WHERE ROWNUM <= 3
;

-- EMPLOYEES 테이블에서 연봉을 가장 적게 받는 사원 3명만 조회한다.
SELECT *
  FROM EMPLOYEES
 WHERE ROWNUM <= 3
 ORDER BY SALARY ASC
; -- 이런 방식으로는 풀 수 없다.

-- INLINE VIEW 이용해서 풀기
SELECT *
  FROM ( -- 1. EMPLOYEES 테이블에서 연봉을 기준으로 오름차순 정렬한다.
		SELECT *
		  FROM EMPLOYEES
		 ORDER BY SALARY ASC) ORDERED_EMPLOYEES
 WHERE ROWNUM <= 3
;

-- 가장 많은 사원이 근무중인 부서의 모든 정보를 조회한다.
-- 부서별 사원의 수 (부서에 사원이 존재하지 않는다면 0으로 조회한다.)
SELECT D.*
  FROM (-- 사원의 수로 내림차순
		SELECT D.DEPARTMENT_ID 
		     , COUNT(E.EMPLOYEE_ID) E_COUNT -- AS생략가능 
		  FROM DEPARTMENTS D
		  LEFT OUTER JOIN EMPLOYEES E
		    ON D.DEPARTMENT_ID = E.DEPARTMENT_ID 
		 GROUP BY D.DEPARTMENT_ID
		-- ORDER BY COUNT(E.EMPLOYEE_ID) DESC
		 ORDER BY E_COUNT DESC) ORDERED_DEPT_EMP_COUNT
 INNER JOIN DEPARTMENTS D
    ON D.DEPARTMENT_ID = ORDERED_DEPT_EMP_COUNT.DEPARTMENT_ID 
-- 정렬된 데이터에서 1개만 조회.
 WHERE ROWNUM = 1
;

SELECT 10000
     , NVL(NULL, 0) -- NULL 일경우 숫자 0으로 변경
  FROM DUAL
;

-- 연봉의 총 합이 가장 높은 부서의 모든 정보를 조회한다.
-- 정렬된 데이터에서 1개만 조회.
SELECT D.*
     , ORDERED_DEPT_SAL.SUM_SALARY
  FROM (
		-- 부서별 연봉의 총합
		-- 연봉 총합으로 내림차순 정렬.
		SELECT D.DEPARTMENT_ID
		     , NVL(SUM(E.SALARY), 0) AS SUM_SALARY
		  FROM DEPARTMENTS D
		  LEFT OUTER JOIN EMPLOYEES E
		    ON D.DEPARTMENT_ID = E.DEPARTMENT_ID 
		-- WHERE E.EMPLOYEE_ID IS NOT NULL
		 GROUP BY D.DEPARTMENT_ID
		 ORDER BY SUM_SALARY DESC) ORDERED_DEPT_SAL
-- 부서의 정보를 알기 위해 JOIN 해야함.
 INNER JOIN DEPARTMENTS D
    ON D.DEPARTMENT_ID = ORDERED_DEPT_SAL.DEPARTMENT_ID
 WHERE ROWNUM =1
;

-- 사원의 수가 가장 많은 직무의 모든정보 상위 3개를 조회한다.
SELECT J.*
     , ORDERED_JOB_EMP_COUNT.E_COUNT
  FROM (-- 직무별 사원의 수
		-- 사원의 수로 내림차순 정렬.
		SELECT J.JOB_ID
		     , COUNT(E.JOB_ID) AS E_COUNT
		  FROM JOBS J
		  LEFT JOIN EMPLOYEES E
		    ON E.JOB_ID = J.JOB_ID 
		 GROUP BY J.JOB_ID
		 ORDER BY E_COUNT DESC) ORDERED_JOB_EMP_COUNT
 INNER JOIN JOBS J
    ON J.JOB_ID = ORDERED_JOB_EMP_COUNT.JOB_ID
 WHERE ROWNUM <= 3
;

-- 재귀 조인 (RECURSIVE JOIN)
-- 100번 사원의 모든 부하직원을 계층형(조직도) 구조로 조회한다.
 SELECT LEVEL
 	  , EMPLOYEE_ID
      , FIRST_NAME || ' ' || LAST_NAME AS NAME
      , MANAGER_ID
   FROM EMPLOYEES
  START WITH EMPLOYEE_ID = 100 -- Root Node 지정.
CONNECT BY PRIOR EMPLOYEE_ID = MANAGER_ID -- 연결 조건 지정. 
										  -- 사원번호 100번은 누군가의 상사 사원번호다.
-- 100번 부터 시작해서 모든 부하직원들을 계층 구조로 조회하게된다.
;
  
-- 108번 사원의 모든 부하직원들을 계층형(조직도) 구조로 조회한다.
 SELECT LEVEL
 	  , EMPLOYEE_ID
      , FIRST_NAME || ' ' || LAST_NAME AS NAME
      , MANAGER_ID
   FROM EMPLOYEES
  START WITH EMPLOYEE_ID = 108
CONNECT BY PRIOR EMPLOYEE_ID = MANAGER_ID
;
  
-- 113번의 모든 상사를 계층형 (조직도) 구조로 조회한다.
 SELECT LEVEL
 	  , EMPLOYEE_ID
      , FIRST_NAME || ' ' || LAST_NAME AS NAME
      , MANAGER_ID
   FROM EMPLOYEES
  START WITH EMPLOYEE_ID = 113
CONNECT BY PRIOR MANAGER_ID = EMPLOYEE_ID
  ORDER BY LEVEL DESC
;
  
-- MANAGER_ID가 NULL 인 사원의 모든 부하직원을 조회한다.
 SELECT LEVEL
 	  , EMPLOYEE_ID
      , FIRST_NAME || ' ' || LAST_NAME AS NAME
      , MANAGER_ID
   FROM EMPLOYEES
  START WITH MANAGER_ID IS NULL
CONNECT BY PRIOR EMPLOYEE_ID = MANAGER_ID
;
-- 113번 사원의 모든 부하직원을 조회한다. 
SELECT LEVEL
 	  , EMPLOYEE_ID
      , FIRST_NAME || ' ' || LAST_NAME AS NAME
      , MANAGER_ID
   FROM EMPLOYEES
  START WITH EMPLOYEE_ID = 113
CONNECT BY PRIOR EMPLOYEE_ID = MANAGER_ID
;
-- 60번 부서 부서장의 모든 부하직원을 조회한다.   
SELECT LEVEL
 	  , EMPLOYEE_ID
      , FIRST_NAME || ' ' || LAST_NAME AS NAME
      , MANAGER_ID
   FROM EMPLOYEES 
  START WITH DEPARTMENT_ID = 60
CONNECT BY PRIOR EMPLOYEE_ID = MANAGER_ID
;  
-- 1번방법 START WITH 60 대신에 서브쿼리로.. 
  SELECT MANAGER_ID
    FROM DEPARTMENTS
   WHERE DEPARTMENT_ID = 60
 
-- 2번방법
 SELECT * 
   FROM EMPLOYEES E
  INNER JOIN DEPARTMENTS D
     ON D.DEPARTMENT_ID = E.DEPARTMENT_ID
    AND D.DEPARTMENT_ID = 60 -- START WITH CONNECT BY PRIOR와 WHERE가 함께 있을 경우
  							 -- START WITH CONNECT BY PRIOR가 먼저 실행된다.
  -- 따라서 WHERE 가 아닌 AND를 쓰면된다.

-- 3번 방법
-- 60 대신에 D.MANAGER_ID AND D.DEPARTMENT_ID = 60 을 쓰면됨
  
-- 60번 부서 부서장의 상사를 역순으로 조회한다.
SELECT LEVEL
 	  , EMPLOYEE_ID
      , FIRST_NAME || ' ' || LAST_NAME AS NAME
      , MANAGER_ID
   FROM EMPLOYEES 
  START WITH EMPLOYEE_ID = (SELECT MANAGER_ID
    							FROM DEPARTMENTS
   							   WHERE DEPARTMENT_ID = 60)
CONNECT BY PRIOR MANAGER_ID = EMPLOYEE_ID
  ORDER BY EMPLOYEE_ID DESC 
;  

-- 부하직원이 없는 사원을 모두 조회한다. (START WITH CONNECT BY PRIOR X)
SELECT *
  FROM EMPLOYEES
 WHERE EMPLOYEE_ID NOT IN (SELECT MANAGER_ID
 							 FROM EMPLOYEES
 							WHERE MANAGER_ID IS NOT NULL)
;  

SELECT *
  FROM EMPLOYEES MAN
  LEFT OUTER JOIN EMPLOYEES EMP 
    ON MAN.EMPLOYEE_ID = EMP.MANAGER_ID 
 WHERE EMP.EMPLOYEE_ID IS NULL
 ORDER BY MAN.EMPLOYEE_ID ASC
;  

-- 부하직원이 없는 사원의 상사를 모두 조회한다. 
 SELECT LEVEL
 	  , EMPLOYEE_ID
      , FIRST_NAME || ' ' || LAST_NAME AS NAME
      , MANAGER_ID
   FROM EMPLOYEES
  START WITH EMPLOYEE_ID IN (SELECT MAN.EMPLOYEE_ID
							   FROM EMPLOYEES MAN 
							   LEFT OUTER JOIN EMPLOYEES EMP
							     ON MAN.EMPLOYEE_ID = EMP.MANAGER_ID
							  WHERE EMP.EMPLOYEE_ID IS NULL)
CONNECT BY PRIOR EMPLOYEE_ID = MANAGER_ID
;    


