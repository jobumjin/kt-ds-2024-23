package hello_java_world;

public class ForProblem1 {
	public static void main(String[] agrs) {
		/*
		 * 1 부터 100까지의 합을 구해 출력하시오
		 */
		
		int answer = 0;
		for(int i = 1; i < 101; i++) {
			answer += i;
		}
		System.out.println(answer);
		
	}
}
