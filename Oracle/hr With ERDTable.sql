-- 사원 정보 테이블에서 이름과 성, 연봉, 이메일을 조회한다.
SELECT FIRST_NAME
	 , LAST_NAME
	 , SALARY
	 , EMAIL
  FROM EMPLOYEES
;

-- 지역정보 테이블에서 도시명이 'Seattle' 인 지역의 주소와 우편번호를 조회
SELECT STREET_ADDRESS
	 , POSTAL_CODE
  FROM LOCATIONS
 WHERE CITY = 'Seattle'
;