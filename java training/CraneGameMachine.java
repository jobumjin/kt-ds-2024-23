package oop_exam;

import java.util.Random;

/**
 * 인형뽑기게임..
 */
public class CraneGameMachine {
	
	boolean isInsertCoin;
	int dolls;
	/**
	 * 동전을 넣으면 게임이 실행되고 그렇지 않으면 실행되지 않는기능
	 * 인형이 없으면 게임이 실행되지 않고 동전을 돌려주는 기능
	 */
	public void isInsertCoin() {
		if (dolls<=0) {
			isInsertCoin = false;
			System.out.println("인형이 없어 게임을 진행할 수 없습니다.");
			System.out.println("동전을 돌려드릴께요!");
		}
		else {
			isInsertCoin = true;
		}
	}
	
	/**
	 * 동전을 넣었다면 게임을 시작하고 
	 * 0과1의 랜덤수를 배정하여
	 * 1이 나왔을때 인형을 뽑고 인형전체 갯수가 줄어들며 게임이 끝나고
	 * 0이 나왔을대 인형을 뽑지 못하고 게임이 끝나는 기능
	 * @return 인형의 뽑힘 유무
	 */
	public int doGame() {
		if (isInsertCoin) {
			System.out.println("게임을 시작합니다.");
			Random random = new Random();
			int n = random.nextInt(2);
			if (n == 1) {
				
				dolls -= 1;
				System.out.println("현재 인형 갯수 :" + dolls);
				isInsertCoin = false;
				return 1;
			}
			else {
				System.out.println("인형을 뽑지 못했습니다.");
				isInsertCoin = false;
				return 0;
			}
		}
		System.out.println("게임을 하고 싶으면 동전을 넣어주세요.");
		isInsertCoin = false;
		return 0;
	}
}
