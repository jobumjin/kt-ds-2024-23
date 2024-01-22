package oop_exam;

public class ReturnMethodQuiz4 {
	
	/**
	 * 과목별 점수를 파라미터로 받아 합계를 구해 반환하는 메소드
	 * @param KorScore 국어점수
	 * @param engScore 영어점수
	 * @param mathScore 수학점수
	 * @param progScore 프로그래밍점수
	 * @return processSum 점수 합계
	 */
	public static int getSum(int KorScore,
							int engScore,
							int mathScore,
							int progScore) {
		int processSum = KorScore; 
		processSum += engScore; 
		processSum += mathScore;
		processSum += progScore;
		
		return processSum;
	}
	
	/**
	 * 합계와 4를 파라미터로 받아 평균을 구해 반환하는 메소드
	 * @param sum 합계
	 * @param num 과목 수
	 * @return processAverage 평균
	 */
	public static int getAverage(int sum, int subjectCount) {
		int processAverage = sum / subjectCount;
		return processAverage;
	}
	
	/**
	 * 평균을 파라미터로 받아 등급을 반환하는 메소드
	 * @param average 평균
	 */
	public static String getLevel(int average) {
		String grade;
		if (average >= 95) {
			grade = "A+";
		}
		else if (average >= 90) {
			grade = "A";
		}
		else if (average >= 85) {
			grade = "B+";
		}
		else if (average >= 80) {
			grade = "B";
		}
		else if (average >= 70) {
			grade = "C";
		}
		else {
			grade = "F";			
		}
		return grade;
	}
	
	public static void main(String[] args) {
		/*
		 * 과목별 점수를 파라미터로 받아 합계를 구해반환하는 메소드
		 * 합계와 4를 파라미터로 받아 평균을 구해 반환하는 메소드
		 * 평균을 파라미터로 받아 등급을 반환하는 메소드
		 */
		int korScore = 90;
		int engScore = 88;
		int mathScore = 70;
		int progScore = 80;
		// 과목별 합계를 구한다.
		int sum = getSum(korScore, engScore, mathScore, progScore);
		System.out.println(sum);
		// 평균점수를 구한다.
		int average = getAverage(sum, 4);
		System.out.println(average);
		// 평균점수의 등급을 구한다.
		String grade = getLevel(average);
		System.out.println(grade);
	}
}
