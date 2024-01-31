package generic_collection;

public class GenericMain {
	
	public static void main(String[] args) {
		// 제네릭은 코드가 같은데 타입만 다를 때 사용하기 좋다..!!
		ScoreList<Integer> score = new ScoreList<>();
		score.add(100);
		score.add(90);
		score.add(80);
		score.add(70);
		score.add(60);
		
//		Integer score1 = score.get(0);
		int score1 = score.get(0);
		int score2 = score.get(1);
		int score3 = score.get(2);
		int score4 = score.get(3);
		int score5 = score.get(4);
		
		System.out.println(score1);
		System.out.println(score2);
		System.out.println(score3);
		System.out.println(score4);
		System.out.println(score5);
		
		int size = score.size();
		System.out.println(size);
		
		System.out.println(score);
	}
}
