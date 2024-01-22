package oop_exam;

public class ReturnMethodExam {
	
	/**
	 * 숫자를 원하는 수만큼 곱한 결과를 반환한다.
	 * @param num 곱할 숫자
	 * @param time 곱할 횟수
	 * @return 숫자를 곱한 결과 
	 */
	public static int getMultiply(int num, int time) {
		int result = num * time;
		return result;
	}
	
	public static void main(String[] args) {
		int multiplyResult = getMultiply(10,4);
		System.out.println(multiplyResult);
		
		multiplyResult = getMultiply(20, 6);
		System.out.println(multiplyResult);
	}
}
