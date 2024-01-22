package oop_exam;

public class ReturnMethodQuiz3 {
	
	/**
	 * 섭씨온도를 파라미터로 받아 화씨온도를 구해주는 메소드
	 * @param celsius 섭씨온도
	 * @return processFahreheit 화씨온도
	 */
	public static int getFahreheit(int celsius) {
		int processFahreheit = (celsius * 9 / 5) + 32;
		return processFahreheit;
	}
	
	public static void main(String[] args) {
		/*
		 * 섭씨온도를 나타내는 celsius변수와
		 * 화씨온도를 나타내는 fahrenheit 변수가 있스비낟.
		 * celsius변수에는 30이 할당되어 있습니다.
		 * 섭씨 30도를 화씨온도로 변경하면
		 * 화씨 86도가 됩니다.
		 * 섭씨온도를 화씨온도로 변경해 fahrenheit 변수에 할당하고 출력해보세요
		 * 변경공식 : (섭씨 x 9/5) + 32 = 화씨
		 */
		int celsius = -5; //1월22일날씨..ㅜㅜ
		int fahreheit = getFahreheit(celsius);
		System.out.println(fahreheit);
	}
}
