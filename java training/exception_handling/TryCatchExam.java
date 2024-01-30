package exception_handling;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

import exception_handling.exceptions.ReadFailException;

public class TryCatchExam {

	// 예외 위임하기... 이건 코드가 정말 .... 답이없어요.. 풀 수 있지만 하면 안됨
	public static List<String> readFile(File path) throws IOException {
		return Files.readAllLines(path.toPath());
	}
	
	// 이렇게.. 예외의 원인도 알아볼 수 있는 편리함이 있는 코드
	public static List<String> readFile2(File path) {
		try {
			return Files.readAllLines(path.toPath());
		} 
		catch (IOException ioe) {
			throw new ReadFailException("파일을 읽을 수 없습니다.", ioe);
		}		
	}
	
	
	// 말도안되는 코드지만 이런 방법도 있음을 생각해보기..
	public static int convertToInt(String str) throws Exception {
		
		try {
			int number = Integer.parseInt(str);
			return number;
		}
		catch (NumberFormatException nfe) {
			// Reference type instance
			Exception exception = new Exception(str + "는 숫자로 변환할 수 없습니다.", nfe);
			// 예외를 발생시키는 것 예외를 던지는것..!!
			throw exception; // 예외를 던지고 메소드를 종료시킨다.
//			System.out.println("asdfjlk"); // throw 아래에는 죽은코드가 되어버림
		}
		finally {
			System.out.println("변환이 완료되었습니다.");
		}
		
//		return 0;
	}
	
	
	public static void main(String[] args) {
		
		File imageFile = new File("c;\\sadflkjsdalkfd");
		
		// try-catch를 할 필요 없게 만들었음!!! 아주 깔끔하다...
		readFile2(imageFile);
		
		try {
			int num = convertToInt("AAA");
		}
		catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		
		
		// 시스템 드라이브에서 특정 경로에 있는 파일또는 폴더를 읽어온다.
		
		
		try {			
			Files.readAllLines(imageFile.toPath());
		}
		catch (IOException ioe) {
			String message = ioe.getMessage();
			System.out.println(message);
			// 실무에서는 잘 사용하지 않고 잠깐 살펴보고 지우는 코드가 된다..
			ioe.printStackTrace();
		}
		finally {
			System.out.println("File을 읽고 finally가 실행되었습니다.");
		}
		
		
		try {
			Class.forName("IfArrayIndexOutOfBoundsException2");			
			Files.readAllLines(imageFile.toPath());
		}
		catch (ClassNotFoundException | IOException cnfe) {
			String message = cnfe.getMessage();
			System.out.println(message);
			
			// 아주 상세한 예외 목록 (호출 스택)
			cnfe.printStackTrace();
		}
		
//		catch (IOException ioe) {
//			String message = ioe.getMessage();
//			System.out.println(message);
//			
//			// 아주 상세한 예외 목록 (호출 스택)
//			ioe.printStackTrace();
//			
//		}
		
		
	}
	
}
