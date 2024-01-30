package exception_handling;

public class IfstringIndexOutOfBoundsException {
	
	public static void main(String[] args) {
		
		String logoFilePath = "C:\\images\\logo.png";
		/*
		 * logoFilePath 인스턴스에서 logo.png만 추출해 출력해보세요.
		 */
		// substring + indexOf + lastIndexOf
		int lastIndexOfBackslass = logoFilePath.lastIndexOf("\\") + 1;
		String filename = logoFilePath.substring(lastIndexOfBackslass);
		System.out.println(filename);
		// 그저 답만 원한 풀이법
//		System.out.println(logoFilePath.substring(logoFilePath.length() - 8,logoFilePath.length()));
		
		/*
		 * logoFilePath 인스턴스에서 "image" 만 추출해 보세요.
		 */
		int IndexOfImages = logoFilePath.indexOf("images");
		System.out.println(IndexOfImages);
		filename = logoFilePath.substring(IndexOfImages,lastIndexOfBackslass - 1);
		System.out.println(filename);
		
		/* 중요!!
		 * logoFilePath 인스턴스에서 "user_images"만 추출해 출력해보세요.
		 */
		// IndexOfUserImages가 없기때문에 -1이 나오게되서 예외가 발생하기됨
		if (logoFilePath.contains("user_images")) {
			int IndexOfUserImages = logoFilePath.indexOf("user_images");
//		if (IndexOfUserImages >= 0) {			
			filename = logoFilePath.substring(IndexOfUserImages,lastIndexOfBackslass - 1);
			System.out.println(filename);
//		}
		}
		
		/*
		 * logoFilePath 인스턴스에서 홪장자("png")만 추출해 보세요.
		 */
		int lastIndexOfDot = logoFilePath.lastIndexOf(".") + 1;
		filename = logoFilePath.substring(lastIndexOfDot);
		System.out.println(filename);
		
		
		String downloadFilePath = "C:\\images\\logo";
		
		/* if를 활용한 예외처리!! 문자열을 처리할때 이런 예외처리가 나오게된다.
		 * downlogoFilePath 인스턴스에서 파일의 확장자를 추출해 출력해보세요.
		 */
		if (downloadFilePath.contains(".")) {
			lastIndexOfDot = downloadFilePath.lastIndexOf(".") + 1;
			filename = downloadFilePath.substring(lastIndexOfDot);
			System.out.println(filename);
		}
		
			
		
	}
}
