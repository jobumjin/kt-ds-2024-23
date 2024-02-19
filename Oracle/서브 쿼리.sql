-- Sub Query
-- 1. 부서명 "IT" 부서에서 근무중인 사원들의 정보를 조회.(IT부서의 부서번호를 모르는 상황)
-- 1. IT부서의 부서번호를 찾는다. ==> 60
SELECT DEPARTMENT_ID
  FROM DEPARTMENTS
 WHERE DEPARTMENT_NAME = 'IT'
;
-- 2. 60번 부서에서 일을 하는 사원들의 정보를 조회한다.
SELECT *
  FROM EMPLOYEES
 WHERE DEPARTMENT_ID = 60
;
-- 3. 합체.. Sub Query 이용
-- * Sub Query를 항상 먼저 작성해야한다. (우리가 알기위해 필요한 코드를 먼저 작성한다.)
SELECT *
  FROM EMPLOYEES
 WHERE DEPARTMENT_ID = (SELECT DEPARTMENT_ID
  						  FROM DEPARTMENTS
 						 WHERE DEPARTMENT_NAME = 'IT')
;

-- 2. 지역번호가 1700인 부서에서 근무중인 사원들의 모든 정보를 조회. (지역번호가1700인 부서의 번호를 모르는 상황)
-- 1. 지역번호가 1700인 부서의 부서 번호를 조회
SELECT DEPARTMENT_ID -- 10, 30, 90, 100, 110, 120, 130, 140, 150, 160, 170, ...
  FROM DEPARTMENTS
 WHERE LOCATION_ID = 1700
;
-- 2. 위 부서에서 근무중인 사원들의 모든 정보를 조회.
SELECT *
  FROM EMPLOYEES
 WHERE DEPARTMENT_ID IN (10, 30, 90, 100, 110) -- 더있지만.. 일단..
;
-- 3. 합체.. Sub Query 이용
SELECT *
  FROM EMPLOYEES
 WHERE DEPARTMENT_ID IN (SELECT DEPARTMENT_ID
						   FROM DEPARTMENTS
 						  WHERE LOCATION_ID = 1700)
;

-- 3. 145번 사원이 부서장인 부서에서 근무중인 사원들의 모든 정보를 조회하는데
--    결과에서 145번 사원은 제외시킨다.
--  알아야할 정보
--    145번 사원은 몇 번 부서의 부서장인가?
--  알고싶은 정보
--	  145번 사원의 부서에서 근무중인 사원들의 정보.
SELECT *
  FROM EMPLOYEES
 WHERE DEPARTMENT_ID = (SELECT DEPARTMENT_ID 
  						  FROM DEPARTMENTS
 						 WHERE MANAGER_ID = 145)
   AND EMPLOYEE_ID != 145
;

-- 4. 직무명이 "Marketing Manager" 인 사원의 모든 정보를 조회한다.
-- 알아야 할 정보
-- 		직무명 "Marketing Manager" 인 직무의 아이디(MK_MAN)
-- 알고싶은 정보
-- 		사원의 직무아이디가 "MK_MAN" 인 사람의 모든 정보
SELECT *
  FROM EMPLOYEES
 WHERE JOB_ID = (SELECT JOB_ID 
 	               FROM JOBS
 	              WHERE JOB_TITLE = 'Marketing Manager')
;

-- 5. 도시명이 "Seattle" 인 지역에 존재하는 부서의 모든 정보를 조회한다.
-- 알아야할 정보
-- 		도시명이 "Seattle" 인 지역의 지역번호
-- 알고싶은 정보
-- 		"Seattle" 과 지역번호가 같은 부서의 모든 정보
SELECT *
  FROM DEPARTMENTS
 WHERE LOCATION_ID = (SELECT LOCATION_ID
  						FROM LOCATIONS
 					   WHERE CITY = 'Seattle')
;

-- 대륙명이 "Americas" 인 국가 정보를 모두 조회한다.
-- 알아야할 정보
--		대륙명이 "Americas" 인 대륙아이디
-- 알고싶은 정보
--		대륙명이 "Americas" 인 대륙아이디와 같은 모든 국가 정보
-- 테이블간의 연결은 항상 PK -- FK 로 한다.
SELECT *
  FROM COUNTRIES
 WHERE REGION_ID = (SELECT REGION_ID
 					  FROM REGIONS
 					 WHERE REGION_NAME = 'Americas')
;

-- 도시명이 "Seattle" 인 지역에서 근무중인 모든 사원들의 정보를 조회한다.
-- 알아야 할 정보 1: 도시명이 "Seattle" 인 지역의 지역번호 (1700)
-- 알아야 할 정보 2: 지역번호가 1700번인 부서번호 10, 30, 90, 100, 110, 120, 130, 140, 150, 160, 170, ...
-- 알고싶은 정보: 10, 30, 90, 100, 110, 120, 130, 140, 150, 160, 170, ...이 부서에서 근무중인 사원의 정보 
SELECT *
  FROM EMPLOYEES
 WHERE DEPARTMENT_ID IN (SELECT DEPARTMENT_ID
						   FROM DEPARTMENTS
						  WHERE LOCATION_ID = (SELECT LOCATION_ID
						   	   					 FROM LOCATIONS
						 	 				    WHERE CITY = 'Seattle'))
;

-- 대륙명이 'Europe' 인 국가에서 근무하는 모든 사원들의 정보를 조회.
-- 알아야 할 정보1: 대륙명이 'Europe' 인 국가의 대륙 아이디 (1)
-- 알아야 할 정보2: 대륙 아이디가 1인 국가의 아이디 (BE, CH, DE, DK, FR, IT, NL, UK)
-- 알아야 할 정보3: 국가의 아이디가 (BE, CH, DE, DK, FR, IT, NL, UK)인 국가의 지역번호 (1000, 1100, 2400, 2500, 2600, 2700, 2900, 3000, 3100)
-- 알아야 할 정보4: 지역번호가 (1000, 1100, 2400, 2500, 2600, 2700, 2900, 3000, 3100)인 부서 번호 (40, 80, 70)
-- 알고싶은 정보: 부서 번호 (40, 80, 70) 인 사원의 모든 정보 = 대륙명이 'Europe' 인 국가에서 근무하는 모든 사원들의 정보

SELECT *
  FROM EMPLOYEES
 WHERE DEPARTMENT_ID IN (SELECT DEPARTMENT_ID
 						   FROM DEPARTMENTS
						  WHERE LOCATION_ID IN (SELECT LOCATION_ID
												  FROM LOCATIONS
												 WHERE COUNTRY_ID IN (SELECT COUNTRY_ID
												   					    FROM COUNTRIES
																	   WHERE REGION_ID = (SELECT REGION_ID
																						   FROM REGIONS
																						  WHERE REGION_NAME = 'Europe'))))
;

