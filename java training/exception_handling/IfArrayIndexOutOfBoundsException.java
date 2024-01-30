package exception_handling;

public class IfArrayIndexOutOfBoundsException {
	
	public static void main(String[] args) {
		
		// 배열의 간단한 정의
		int [] scores = {100, 200, 300};
		
		if(scores.length > 0) {
			System.out.println(scores[0]); // 100
		}
		if(scores.length > 1) {
			System.out.println(scores[1]); // 200
		}
		if(scores.length > 2) {
			System.out.println(scores[2]); // 300
		}
		if(scores.length > 3) {
			System.out.println(scores[3]); // IfArrayIndexOutOfBoundsException
		}
	}
	
	
}
