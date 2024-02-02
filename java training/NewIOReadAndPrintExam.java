package readfile;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

/**
 * Java 1.8 버전 이상에서 사용할 수 있는 파일 읽기 예제.
 * new io 사용
 */
public class NewIOReadAndPrintExam {
	public static void main(String[] args) {
		File file = new File("C:\\Java Exam", "Java Exam.txt");
		if( file.exists() && file.isFile()) {
			List<String> fileLine = new ArrayList<>();
			try {
				// 파일을 처음부터 끝까지 모두 읽어와 List에 할당합니다. 
//				Path filePath = Paths.get("C:\\Java Exam", "Java Exam.txt");
//				Charset utf8 = Charset.forName("UTF-8");
//				fileLine.addAll(Files.readAllLines(filePath, utf8));
				// 굳이 풀어쓸필요없이 한줄로 잘 적어보면 좋을 것 같다. 
				fileLine.addAll(Files.readAllLines(file.toPath(),Charset.forName("UTF-8")));
				
			}
			catch(IOException ioe) {
				// 파일을 읽다가 예외가 발생했을 때, 예외 내용만 출력합니다.
				System.out.println(ioe.getMessage());
			}
			
			// 읽어온 파일을 모두 출력합니다.
			for (String line : fileLine) {
				System.out.println(line);
			}
		}
	}
}
