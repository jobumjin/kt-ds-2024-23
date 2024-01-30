package oop_exam;

/**
 * 숫자와 관련된 유틸리티 입니다.
 */
public class NumberUtil {
	
	/**
	 * 문자를 숫자로 변경한다.
	 * @param str 숫자형태의 문자열
	 * @return 문자를 숫자로 변경한 결과(숫자형태의 문자가 아니라면 NumberFormatException에러가 발생한다.)
	 */
	public static int convertToInt(String str) {
		
		// 숫자를 문자로 바꾸는 방법.
		int number = Integer.parseInt(str);
		return number;
	}
	
	/**
	 * 문자를 숫자로 변경한다.
	 * @param str 숫자형태의 문자열
	 * @param defaultValue str이 숫자형태의 문자가 아닐 때. 반환될 값
	 * @return 문자를 숫자로 변경한 결과
	 */
	public static int convertToInt(String str, int defaultValue) {

		int number = 0;

		try {
			number = Integer.parseInt(str);			
		}
		catch(NumberFormatException nfe) {			
			return defaultValue;
		}
		return number;
	}
	
	public static void main(String[] args) {
		
		// 0 1 2
		// exception 예제 java.lang.ArrayIndexOutOfBoundsException
		int[] scoreArray = new int[3];
		scoreArray[3] = 3;
		
		// exception 예제 java.lang.NullPointerException
		String address = null;
		System.out.println(address.contains("서울"));
		
		// exception 예제 java.lang.NumberFormatException
		// if를 활용한 예외처리 matches
		String name = "슈퍼맨";
		if (name.matches("^[0-9]+$")) {			
			int number = NumberUtil.convertToInt(name);
			System.out.println(number);
		}
		
		String str = "10000";
		int number = NumberUtil.convertToInt(str);
		System.out.println(number);
		
//		str = "이름";
//		// java.lang.NumberFormatException: For input string: "이름"
////		number = NumberUtil.convertToInt(str);
//		number = NumberUtil.convertToInt(str, -1);
//		System.out.println(number);
		
	}
}
