package oop_exam;

public class PlayTheCraneGame {
	
	public static void main(String[] args) {
		CraneGameMachine player1 = new CraneGameMachine();
		player1.dolls = 4;
		player1.isInsertCoin = false;
		player1.isInsertCoin();
		player1.doGame();
		player1.isInsertCoin();
		player1.doGame();
		player1.doGame();
		player1.doGame();
		player1.doGame();
		player1.isInsertCoin();
		System.out.println("--------------------");
		CraneGameMachine player2 = new CraneGameMachine();
		player2.dolls = 2;
		player2.isInsertCoin = false;
		player2.doGame();
		player2.isInsertCoin();
		player2.doGame();
		player2.isInsertCoin();
		player2.doGame();
		// 2가지로 테스트 보았다.
		
	}
	
}
