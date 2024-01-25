package string_exam;

import java.util.Scanner;

public class StringProblem {
	
	public static void main(String[] args) {
		
		String word1 = "자전거";
		int wordCount = 0;
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("다음 단어를 입력해주세요.");
			String word2 =	sc.nextLine();
			word2 = word2.trim();
//			word2 = word2.replaceAll("[^가-힣$]", "");
			if(word2.length() < 3) {
				System.out.println("글자수가 3글자가 안됩니다.");
				break;
			}
			else {
				String str = word1.substring(word1.length() - 1);
				if (word2.startsWith(str)) {
					word1 = word2;
					wordCount++;
				}
				else {
					System.out.println("첫 글자가 맞지 않습니다.");
					break;
				}
			}
		}
		System.out.println("끝말잇기 게임이 종료되었습니다.");
		System.out.println("게임 내 입력한 단어의 수: "+ wordCount);
		
	}
	
}
