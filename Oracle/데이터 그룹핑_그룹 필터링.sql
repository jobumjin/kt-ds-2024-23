-- 모든 사원들의 연봉 총합, 최대 연봉, 최소 연봉, 평균 연봉, 사원의 수를 조회.
SELECT SUM(SALARY)
	 , MAX(SALARY)
	 , MIN(SALARY)
	 , AVG(SALARY)
	 , COUNT(EMPLOYEE_ID) -- COUNT 함수의 파라미터는 PK를 쓰는 것이 원칙
	 , MAX(HIRE_DATE) -- 가장 최근의 입사일자
	 , MIN(HIRE_DATE) -- 가장 과거의 입사일자 
  FROM EMPLOYEES
;

-- 2007년에 입사한 사원의 수와 평균 연봉을 조회.
-- 문자 --> 날짜 변경
SELECT '2007-01-01' -- 날짜 형태의 문자
     , TO_DATE('2007-01-01','YYYY-MM-DD')
  FROM DUAL -- DUAL (Dummy 테이블 : 날짜, 시퀀셜할 번호등을 조회)
;

SELECT COUNT(EMPLOYEE_ID)
     , AVG(SALARY)
  FROM EMPLOYEES
 WHERE HIRE_DATE >= TO_DATE('2007-01-01','YYYY-MM-DD')
   AND HIRE_DATE <= TO_DATE('2007-12-31','YYYY-MM-DD')
;

-- GROUP BY 이용.
-- 부서별 근무중인 부서번호, 연봉의 합계, 최대 연봉, 가장 늦게 입사한 날짜, 가장 일찍 입사한 날짜, 사원의 수 조회.
-- 그룹함수는 일반함수와 함꼐 존재할 수 없다. ORA-00937: 단일 그룹의 그룹 함수가 아닙니다. 라는 에러가 발생한다.
SELECT DEPARTMENT_ID -- 기준 (안적어도 무방하다.) FIRST_NAME을 대신 적게되면 같은 에러 발생
	 , SUM(SALARY)
     , MAX(SALARY)
     , MAX(HIRE_DATE)
     , MIN(HIRE_DATE)
     , COUNT(EMPLOYEE_ID)
  FROM EMPLOYEES
 GROUP BY DEPARTMENT_ID -- ORA-00937: 단일 그룹의 그룹 함수가 아닙니다. <-- 이 에러가 나지 않는다.
;

-- 사원 정보에서 "직무 아이디" 별 사원의 수와 "직무 아이디"를 조회한다.
SELECT COUNT(EMPLOYEE_ID)
	 , JOB_ID 
  FROM EMPLOYEES
 GROUP BY JOB_ID
;

-- 사원 정보에서 "성"이 같은 사원들의 수 와 "성"을 조회한다.
SELECT COUNT(EMPLOYEE_ID)
	 , LAST_NAME 
  FROM EMPLOYEES
 GROUP BY LAST_NAME 
;

-- 2004년에 입사한 사원들 중
-- 부서 번호별 사원들의 수와 평균연봉, 연봉의 총합, 부서번호를 조회한다.
SELECT COUNT(EMPLOYEE_ID)
  	 , AVG(SALARY)
  	 , SUM(SALARY)
  	 , DEPARTMENT_ID 
  FROM EMPLOYEES
 WHERE HIRE_DATE BETWEEN TO_DATE('2004-01-01','YYYY-MM-DD')
   AND TO_DATE('2004-12-31','YYYY-MM-DD')
 GROUP BY DEPARTMENT_ID 
;

-- 사원 정보에서 동일한 "성"을 두 명 이상이 있는 사원들만 조회한다.
-- "성" 별 사원의 수 , "성"
SELECT COUNT(EMPLOYEE_ID)
	 , LAST_NAME 
  FROM EMPLOYEES
 GROUP BY LAST_NAME
HAVING COUNT(EMPLOYEE_ID) > 1
;

-- 사원 정보에서 직무 아이디별 사원의 수와 직무 아이디를 조회하는데
-- 사원의 수가 3명이상인 정보만 조회한다.
SELECT COUNT(EMPLOYEE_ID)
  	 , JOB_ID 
  FROM EMPLOYEES
 GROUP BY JOB_ID 
HAVING COUNT(EMPLOYEE_ID) >= 3
;