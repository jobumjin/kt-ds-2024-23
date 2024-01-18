package hello_java_world;

public class ArtithmaticProblem1 {
	public static void main(String[] args) {
		int minutes =5;
		int seconds = 50;
		int time = 0;
		
		time = seconds + minutes*60;
		System.out.println(time);
		
		// 다른방법?
		time += seconds;
		time += minutes*60;
		System.out.println(time);
		
		
	}
}
