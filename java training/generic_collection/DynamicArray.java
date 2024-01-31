package generic_collection;

public class DynamicArray {
	public static void main(String[] args) {
		
		int[] scoreArray = new int [10];
		scoreArray[0] = 100;
		scoreArray[1] = 90;
		scoreArray[2] = 80;
		scoreArray[3] = 70;
		scoreArray[4] = 60;
		scoreArray[5] = 50;
		scoreArray[6] = 40;
		scoreArray[7] = 30;
		scoreArray[8] = 20;
		scoreArray[9] = 10;
		
		// scoreArray에 값 하나를 더 넣으려면 어떻게 해야하는가?
		// 학급의 학생이 10명이 있었다.
		// 선생은 10명의 학생 점수를 관리하고 있었다.
		// int[] scoreArray = new int[10];
		// 학기가 종료되기 전에 1명의 학생이 전학을왔다.
		// 11명의 학생 점수를 관리해야 한다.
		int [] scoreArray2 = new int[scoreArray.length + 1];
//		scoreArray2 = scoreArray; // 메모리 자체를 복사하는 것이라서.. 
//		System.out.println(scoreArray2.length);
		// 아래처럼하면 되기는한다..
//		scoreArray2[0] = scoreArray[0];
//		System.out.println(scoreArray2.length);
//		System.out.println(scoreArray[0]);
//		System.out.println(scoreArray2[0]);
//		scoreArray2[0] = 99;
//		System.out.println(scoreArray[0]);
//		System.out.println(scoreArray2[0]);
		// 아래 코드를 구성할 한줄짜리 코드
//		for(int i = 0; i < scoreArray.length; i++) {
//			scoreArray2[i] = scoreArray[i];
//		}
		
		System.arraycopy(scoreArray, 0, scoreArray2, 0, scoreArray.length);
		
		for(int score: scoreArray2) {
			System.out.println(score);
		}	
	}
}
