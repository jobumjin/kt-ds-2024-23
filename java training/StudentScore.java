package oop_exam;

public class StudentScore {
	int java;
	int python;
	int cpp;
	int csharp;
	
	public int getSumAllScores() {
		int sumAllScores = java + python + cpp + csharp; 
		return sumAllScores;
	}
	
	public double getAverage() {
		double average = getSumAllScores() / 4.0;
		return average;
	}
	
	public double getCourseCredit() {
		double cousCredit = (getAverage() - 55) / 10;
		return cousCredit;
	}
	
	public String getABCDE() {
		String grade;
		if(getCourseCredit() >= 4.1) {
			grade = "A+";
		}
		else if (getCourseCredit() >=3.6) {
			grade = "A";
		}
		else if (getCourseCredit() >=3.1) {
			grade = "B+";
		}
		else if (getCourseCredit() >=2.6) {
			grade = "B";
		}
		else if (getCourseCredit() >=1.6) {
			grade = "C";
		}
		else if (getCourseCredit() >=0.6) {
			grade = "D";
		}
		else {
			grade = "F";
		}
		return grade; 
	}
	
}
