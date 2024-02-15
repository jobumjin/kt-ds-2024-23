-- single line comment 아마 오라클에서만..이렇게..?
/*
 * Multi line comment 
 */

/*
 * 데이터 조회 구조
 * SELECT [COLUMN],[COLUMN],[...]
 * FROM [TABLE]
 */

-- EMPLOYEES 테이블에서 모든 컬럼들의 모든 데이터를 조회.
SELECT * 
  FROM EMPLOYEES
;

-- EMPLOYEES 테이블에서 EMPLOYEE_ID의 모든 데이터를 조회.
SELECT EMPLOYEE_ID
  FROM EMPLOYEES
;

-- EMPLOYEES 테이블에서 EMPLOYEE_ID, FIRST_NAME의 모든 데이터를 조회.
SELECT EMPLOYEE_ID
	 , FIRST_NAME
  FROM EMPLOYEES
;

-- DEPARTMENT 테이블에서 DEPARTMENT_NAME, LOCATION_ID의 모든 데이터를 조회.
SELECT DEPARTMENT_NAME
	 , LOCATION_ID
  FROM DEPARTMENTS
;

-- LOCATIONS 테이블에서 모든 컬럼들의 모든 데이터를 조회.
SELECT *
  FROM LOCATIONS
;





