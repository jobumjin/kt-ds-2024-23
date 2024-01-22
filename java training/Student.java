package oop_exam;

public class Student {
	
	public static void main(String[] args) {
		
		StudentScore student1 = new StudentScore();
		student1.java = 90;
		student1.python = 97;
		student1.cpp= 96;
		student1.csharp= 99;
		
		System.out.println("합계: " + student1.getSumAllScores());
		System.out.println("평균: " + student1.getAverage());
		System.out.println("학점: " + student1.getCourseCredit());
		System.out.println("등급: " + student1.getABCDE());
	}
}
