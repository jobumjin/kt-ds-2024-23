package hello_java_world;

public class ForProblem4 {
	public static void main(String[] args) {
		/*
		 * 아래의 결과가 나오게 반복문을 작성하시오.
		 * *
		 * **
		 * ***
		 * ****
		 * *****
		 */
		String answer = "*";
		for (int i = 1; i < 6; i++) {
			System.out.println(answer);
			answer += "*";
		}
		
		System.out.println();
		
		// 다른 방법? -> String 을 사용하지 않고 풀어보기
		for (int i = 1;i < 6 ; i++) {
			for (int j = 1; j < 6; j++) {
				if (i>=j) {
					System.out.print("*");
				}
			}
			System.out.println();
		}
		
	}
}