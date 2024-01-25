package string_exam;

import java.util.Scanner;

public class StringExam {
	
	public static void main(String[] args) {
	
	//contains
	String address = "서울특별시 서초구 효령로 176";
	boolean isSeoul = address.contains("서울");
	System.out.println(isSeoul);
	
	//endsWith
	isSeoul = address.endsWith("176");
	System.out.println(isSeoul);
	
	//equals
	String name = "ktdsuniversity";
	boolean isEqual = name.equals("ktdsUniversity");
	System.out.println(isEqual);
	
	//equalsIgnoreCase
	isEqual = name.equalsIgnoreCase("ktdsUniversity");
	System.out.println(isEqual);
	
	//format
	String format = "%s에서 교육하는 과정 %s과정";
	String str = String.format(format, "ktdsuniversity","Java");
	System.out.println(str);
	
	//indexOf
	String alphabets = "abcdefg";
	int letterCIndex = alphabets.indexOf("c");
	System.out.println(letterCIndex);
	letterCIndex = alphabets.indexOf("C");
	System.out.println(letterCIndex);
	letterCIndex = alphabets.indexOf("def");
	System.out.println(letterCIndex);
	
	//isBlank
	str = "    ";
	boolean isBlank = str.isBlank();
	System.out.println(isBlank);
	
	//isEmpty
	str = "    ";
	boolean isEmpty = str.isEmpty();
	System.out.println(isEmpty);
	
	//join
	String message = "안녕하세요";
	name = "홍길동님";
	String helloMessage = String.join(", ", message, name);
	System.out.println(helloMessage);
	
	//lastIndexOf
	message = "abcdefgaijkb";
	int letterALastIndex = message.lastIndexOf("a");
	System.out.println(letterALastIndex);
	letterALastIndex = message.lastIndexOf("jj");
	System.out.println(letterALastIndex);
	
	//length
	message = "abcdefgaijkb";
	int length = message.length();
	System.out.println(length);
	
	//matches
	String phone = "01012341234";
	boolean isNumber = phone.matches("^[0-9]+$");
	System.out.println(isNumber);
	
	//replace
	message = "안녕하세요, 홍길동님, 안녕히 가세요, 홍길동님.";
	message = message.replace("홍길동","ktds");
	System.out.println(message);
	
	//replaceAll
	phone = "010-1234-1234";
	phone = phone.replaceAll("[^0-9]","");
	System.out.println(phone);
	
	//split
	phone = "010-1234-1234";
	String[] phoneArea = phone.split("-");
	System.out.println(phoneArea[0]);
	System.out.println(phoneArea[1]);
	System.out.println(phoneArea[2]);
	
	//startsWith
	phone = "+82 010-1234-1234";
	boolean isKoreaNum = phone.startsWith("+82");
	System.out.println(isKoreaNum);
	
	//substring
	String datetime = "2023-05-02 14:56:13";
	String year = datetime.substring(0,4);
	System.out.println(year);
	String hour = datetime.substring(11,13);
	System.out.println(hour);
	String time= datetime.substring(11);
	System.out.println(time);
	
	//trim
	datetime = "    2023-05-02 14:56:13     ";
	System.out.println(datetime.length());
	System.out.println(datetime);
	datetime = datetime.trim();
	System.out.println(datetime.length());
	System.out.println(datetime);
	
	String iStr = String.valueOf(1);
	System.out.println(iStr);
	
	Scanner keyboard = new Scanner(System.in);
	
	// 문자열 비교
	String str1 = "한글"; // Reference Type (메모리 주소)
	String str2 = "한글"; // Reference Type (메모리 주소)
	
	// str1 == str2 <= 메모리 주소가 같은가?
		
	System.out.println(str1 == str2);
	
	String str3 = keyboard.nextLine();
	String str4 = keyboard.nextLine();
	
	System.out.println(str3 == str4); // 메모리 주소 비교
	System.out.println(str3.equals(str4)); // 값을 비교
	
	}
	
	
}
