package oop_exam;

public class ReturnMethodQuiz2 {
	
	/**
	 * 수행시간(분)을 받아서 초(seconds)로 변환하여 반환하는 메소드 
	 * @param minutes 수행시간(분)
	 * @return prosessSeconds 초
	 */
	public static int getMinutes(int minutes) {
		int prosessSeconds = minutes * 60;
		return prosessSeconds;
	}
	
	/**
	 * 수행시간(초)를 받아서 초(seconds)로 변환하여 반환하는 메소드
	 * @param seconds 수행시간(초)
	 * @return seconds 초
	 */
	public static int getSeconds(int seconds) {
		return seconds;
	}
	
	public static void main(String[] args) {
		/*
		 * 산술연산자를 이용해
		 * minutes와 seconds의 값을 초로 변환해
		 * time 변수에 할당하고 출력하시오
		 */
		int minutes = 5;
		int seconds = 50;
		int time = getMinutes(minutes) + getSeconds(seconds);
		System.out.println(time);
	}
}
