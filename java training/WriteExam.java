package file_io.writefile;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

public class WriteExam {
	
	
	public static List<String> getAllLines(File file) {

		if(file.exists() && file.isFile()) {
			FileReader reader = null;
			BufferedReader bufferedReader = null;
			try {
				reader = new FileReader(file, Charset.forName("UTF-8"));
				bufferedReader = new BufferedReader(reader);
				
				List<String> lineList = new ArrayList<>();
				
				String line = null;
				while((line = bufferedReader.readLine()) != null) {
					lineList.add(line + "\n");
				}
				
				return lineList;
			}
			catch (IOException ioe) {
				System.out.println(ioe.getMessage());
				ioe.printStackTrace();
			}
			finally {
				// 파일을 연순서의 역순으로 닫아주어야 한다. 그래야 안전하게 닫을 수 있다. 
				if (bufferedReader != null) {
					try {
						bufferedReader.close();
					}
					catch (IOException ioe) {}
				}
				
				if(reader != null) {
					try {
						reader.close();
					}
					catch(IOException ioe) {}
				}	
			}
		}
		
		// 텅빈 리스트 반환..
		return new ArrayList<>();
	
	}
	
	/**
	 * 파일을 쓴다.
	 * @param parent 파일을 쓸 경로
	 * @param filename 쓸 파일의 이름
	 * @param append 이어서 쓸것인지 여부
	 */
	public static void WriteFile(String parent, String filename, boolean append) {

		File file = new File(parent, filename);
		if(!file.getParentFile().exists()) {
			file.getParentFile().mkdirs();
		}
		
		List<String> originalFileDescription = new ArrayList<>();
		if ( ! append ) {		
			// 이어스 쓰지 않을 것이라면.. 영역 
			int index = 2;
			while(file.exists()) {
				file = new File(file.getParent(), "java_output (" + (index++) + ").txt");
			}
		}
		else {
			// 이어서 쓸 것이라면 .. 영역
			// 기존의 파일 내용을 읽어와서 List<String>으로 반환 받는다.
			originalFileDescription.addAll(WriteExam.getAllLines(file));
			// 반환 받은 내용을 originalFileDescription 에 addAll 한다.
			
		}
		// 파일을 이어서 쓸 수는 없을까?
		// 파일을 이어서 쓸 수 있는 메소드는 X
		// java1.8 도입 ==> 이어쓰기 O
		// java 1.8 미만
		// 기존의 파일 내용을 다 읽어와서 새롭게 파일을 쓴다.
		
		FileWriter fileWriter = null;
		BufferedWriter bufferedWriter = null;
		
		try {
			fileWriter = new FileWriter(file, Charset.forName("UTF-8"));
			bufferedWriter = new BufferedWriter(fileWriter);
			
			if(append) {
				for(String originalFileLine : originalFileDescription) {
					bufferedWriter.write(originalFileLine);
				}
			}
			bufferedWriter.write("파일을 씁니다1.\n");
			bufferedWriter.write("파일을 씁니다2.\n");
			bufferedWriter.write("파일을 씁니다3.\n");
			bufferedWriter.flush();
		}
		catch (IOException ioe) {
			System.out.println(ioe.getMessage());
		}
		finally {
			if(bufferedWriter != null) {
				try {
					bufferedWriter.close();
				}
				catch(IOException ioe) {}
			}
			if(fileWriter != null) {
				try {
					fileWriter.close();
				}
				catch(IOException ioe) {}
			}
		}
		
		System.out.println(file.getAbsolutePath());
	
	}
	
	public static void main(String[] args) {
		WriteFile("C:\\java\\outputs","java_output.txt",false);
		WriteFile("C:\\java\\outputs","java_output.txt",true);
		WriteFile("C:\\java\\outputs","java_output.txt",true);
		WriteFile("C:\\java\\outputs","java_output.txt",false);
	}
}
