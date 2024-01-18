package hello_java_world;

public class ArtithmaticProblem3 {
	public static void main(String[] args) {
		int celsius = 32;
		double fahrenheit = 0;
		// 좀 더 명확한 값을 내기위해 더블을 사용..
		fahrenheit = ((double)celsius * 9 / 5) + 32;
		System.out.println(fahrenheit);
	}
}
