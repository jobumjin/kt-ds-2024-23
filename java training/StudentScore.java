package oop_exam;

public class StudentScore {
	
	// 멤버변수
	int java;
	int python;
	int cpp;
	int csharp;
	
	/**
	 * 전체 점수 합
	 * @return java + python + cpp + csharp
	 */
	public int getSumAllScores() {
		int sumAllScores = java + python + cpp + csharp; 
		return sumAllScores;
	}
	
	/**
	 * 전체 평균
	 * @return sumAllScores / 4
	 */
	public double getAverage() {
		double average = getSumAllScores() / 4.0;
		return average;
	}
	
	/**
	 * 학점 구하기
	 * @return (평균점수 - 55) / 10
	 */
	public double getCourseCredit() {
		double cousCredit = (getAverage() - 55) / 10;
		return cousCredit;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getABCDE() {
//		String grade;
		// 함수를 변수로 받아서 쓰는게.. 좋을 듯함
		double CoursCredit = getCourseCredit();
		if(CoursCredit >= 4.1) {
			return "A+";
		}
		else if (CoursCredit >= 3.6) {
			return "A";
		}
		else if (CoursCredit >= 3.1) {
			return "B+";
		}
		else if (CoursCredit >= 2.6) {
			return "B";
		}
		else if (CoursCredit >= 1.6) {
			return "C";
		}
		else if (CoursCredit >= 0.6) {
			return "D";
		}
//		else {
			return "F";
//		}
//		return grade; 
	}
	
}
