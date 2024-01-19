package hello_java_world;

public class ForProblem2 {
	public static void main(String[] args) {
		/*
		 * 1부터 100중 홀수의 합을 구해 출력해 보세요.
		 */
		int answer = 0;
		for (int i = 1; i < 101; i++) {
			if(i % 2 == 0) {
				answer += i;
			}
		}
		System.out.println(answer);
		System.out.println();
		
		// 다른 방법 하지만 이렇게 잘쓰지는 않는다..
		answer = 0;
		for (int i = 0; i < 101; i+=2) {
				answer += i;
		}
		System.out.println(answer);
	}
}
