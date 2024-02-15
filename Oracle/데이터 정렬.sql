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