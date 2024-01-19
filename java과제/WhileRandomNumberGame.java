package hello_java_world;

import java.util.Scanner;

public class WhileRandomNumberGame {
	public static void main(String[] args) {
		
		// ctrl + shift + o
		// 키보드의 입력을 변수로 받아올 수 있도록 도와주는 코드.
		Scanner keyboard = new Scanner(System.in);
		
		// 난수를 생성. (0.00000000)
		double randomNumber = Math.random();
		
		// 난수를 0 ~ 99 사이의 정소로 변환
		int answer = (int) (randomNumber * 100);
		
		// 사용자가 입력한 값을 할당 받을 변수를 선언.
		int value = 0;
		
		// 맞출때까지 무한반복하기위해서 while에 담아준다.
		while(true) {
			
			//사용자에게 숫자를 입력하라고 알려준다.
			System.out.println("숫자를 입력하세요.");
			
			// 사용자가 keyboard 변수를 이요해 숫자를 입력한 후
			// 엔터를 입력하면 value 변수에 값이 할당된다.
			value = keyboard.nextInt();
			
			// 컴퓨터가 만든 난수와 사용자가 입력한 숫자가 일치하는지 확인하고
			// 일치한다면 '정답입니다' 를 출력한다.
			if (answer == value) {
				System.out.println("정답입니다.");		
				break; // 무한 반복을 종료한다.
			}
			// 컴퓨터가 만든 난수와 사용자가 입력한 숫자를 비교했을 때
			// 사용자가 입력한 값이 더 작다면 "Up!"을 출력한다.
			else if (answer > value){
				System.out.println("Up!");
			}
			// 컴퓨터가 만든 난수와 사용자가 입력한 숫자를 비교했을 때
			// 일치하지도 않고 사용자가 입력한 값이 더 작지도 않다면 
			// 'Down!' 을 출력한다.
			else {
				System.out.println("Down!");
			}
		}	
	}
}