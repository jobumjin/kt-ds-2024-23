package hello_java_world;

public class ForProblem3 {
	public static void main(String[] args) {
		/*
		 * 1 부터 100중 3, 5, 6의 배수만 출력해보세요.
		 */
		for (int i = 1; i <101; i++) {
			if (i % 3 == 0 && i % 5 == 0 && i % 6 == 0) {
				System.out.println(i);
			}
		}
	}
}
