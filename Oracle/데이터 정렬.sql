-- EMPLOYEES 테이블에서 모든 데이터를 LAST_NAME을 기준으로 오름차순 조회 (ORDER BY)
-- 기본적으로 PRIMARY KEY 로 오름차순이 된 상태로 조회가 된다.
SELECT *
  FROM EMPLOYEES
  -- ORDER BY 는 SELECT 조회문의 가장 아래쪽에 위치해야 한다.
 ORDER BY LAST_NAME -- <-- 오름차순 정렬.
;

SELECT *
  FROM EMPLOYEES
 ORDER BY LAST_NAME ASC -- <-- 오름차순 정렬.
;

/*
 * ASC 혹은 생략 : 오름차순
 * DESC : 내림차순
 */

-- EMPLOYEES 테이블에서 모든 데이터를 LAST_NAME을 기준으로 내림차순 조회 (ORDER BY)
SELECT *
  FROM EMPLOYEES
 ORDER BY LAST_NAME DESC -- <-- 내림차순 정렬.
;

-- EMPLOYEES 테이블에서 LAST_NAME으로 내림차순 정렬을 하고 FIRST_NAME으로 오름차순 정렬을 해서 모든 데이터를 조회
SELECT *
  FROM EMPLOYEES
 ORDER BY LAST_NAME DESC, FIRST_NAME ASC 
;

-- EMPLOYEES 테이블에서 SALARY(연봉)으로 오름차순 정렬을 하고 FIRST_NAME으로 내림차순 한 뒤 
-- HIRE_DATE(입사일)로 오름차순 정렬하여 모든 데이터를 조회한다.
SELECT *
  FROM EMPLOYEES
-- ORDER BY 는 항상 SELECT 문장의 가장 마지막에 온다. 
 ORDER BY SALARY ASC
     , FIRST_NAME DESC
     , HIRE_DATE ASC 
;


