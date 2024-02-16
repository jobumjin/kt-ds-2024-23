package com.ktdsuniversity.edu.hr.employees;

import java.util.List;

import com.ktdsuniversity.edu.hr.DBSupporter;

public class EmployeesExplorer {
	
	public static void main(String[] args) {
	
		DBSupporter dbSupporter = new DBSupporter("hr", "hr");
		
		// SELECT *
		//   FROM EMPLOYEES
		StringBuffer query = new StringBuffer();
		query.append(" SELECT EMPLOYEE_ID ");
		query.append("      , FIRST_NAME ");
		query.append("      , LAST_NAME ");
		query.append("      , EMAIL ");
		query.append("      , PHONE_NUMBER ");
		query.append("      , HIRE_DATE ");
		query.append("      , JOB_ID ");
		query.append("      , SALARY ");
		query.append("      , COMMISSION_PCT ");
		query.append("      , MANAGER_ID ");
		query.append("      , DEPARTMENT_ID ");
		query.append("   FROM EMPLOYEES ");
		
		List<EmployeesVO> employees = dbSupporter.selectList(query.toString(), null, EmployeesVO.class);
		employees.forEach(employee -> {
			System.out.println(employee.getEmployeeId());
			System.out.println(employee.getFirstName());
			System.out.println(employee.getLastName());
			System.out.println(employee.getEmail());
			System.out.println(employee.getPhoneNumber());
			System.out.println(employee.getHireDate());
			System.out.println(employee.getJobId());
			System.out.println(employee.getSalary());
			System.out.println(employee.getCommissionPct());
			System.out.println(employee.getManagerId());
			System.out.println(employee.getDepartmentId());
			System.out.println("=".repeat(30));
		});
		
		query = new StringBuffer();
		query.append(" SELECT EMPLOYEE_ID ");
		query.append(" 	    , JOB_ID ");
		query.append(" 	 	, SALARY ");
		query.append("   FROM EMPLOYEES ");
		query.append("  WHERE JOB_ID NOT IN (?, ?) ");
		// ? 의 의미
		// ? --> Query Parameter
		// 실제 데이터베이스에서 실행될 SQL 문장의 파라미터를 전달하는 방법.
		// ? 를 대신해 Binding(? 대신에 값을 변경)할 값 전달.
		
		employees = dbSupporter.selectList(query.toString(), new Object[] {"IT_PROG","AD_VP"}, EmployeesVO.class);
		employees.forEach(employee -> {
			System.out.println(employee.getEmployeeId());
			System.out.println(employee.getJobId());
			System.out.println(employee.getSalary());
			System.out.println("=".repeat(30));
		});
		
		
	}
	
}
