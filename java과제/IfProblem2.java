package hello_java_world;

public class IfProblem2 {
	public static void main(String[] args) {
		int money = 1_000_000;
		
		int father = 40;
		int mother = 36;
		int daughter = 11;
		
		int adultOneWayFlightFare = 300_000;
		int kidOneWayFlighFare = 120_000;
	
//		int adult = 0;
//		int kid = 0;
//		
//		if(father > 19) {
//			adult += 1;
//		}
//		else {
//			kid += 1;
//		}
//		if(mother > 19) {
//			adult += 1;
//		}
//		else {
//			kid += 1;
//		}
//		if(daughter > 19) {
//			adult += 1;
//		}
//		else {
//			kid += 1;
//		}
//		
//		money = money - adult * adultOneWayFlightFare - kid * kidOneWayFlighFare;
//		
//		if (money < 0){
//			System.out.println("다음에 가자 ㅠㅠ");
//		}
//		else {
//			System.out.println("여행가자!");
//		}
		
		//다른방법
//		if (father > 19) {
//			money -= adultOneWayFlightFare;
//		}
//		else {
//			money -= kidOneWayFlighFare;
//		}
//		if (mother > 19) {
//			money -= adultOneWayFlightFare;
//		}
//		else {
//			money -= kidOneWayFlighFare;
//		}
//		if (daughter > 19) {
//			money -= adultOneWayFlightFare;
//		}
//		else {
//			money -= kidOneWayFlighFare;
//		}
//		
//		if (money < 0) {
//			System.out.println("다음에가자 ㅠㅠ");
//		}
//		else {
//			System.out.println("여행가자!");			
//		}

		
		// 삼항 연산자 
		money -= father >= 19 ? adultOneWayFlightFare : kidOneWayFlighFare;
		money -= mother >= 19 ? adultOneWayFlightFare : kidOneWayFlighFare;
		money -= daughter >= 19 ? adultOneWayFlightFare : kidOneWayFlighFare;
		
		if (money < 0) {
			System.out.println("다음에가자 ㅠㅠ");
		}
		else {
			System.out.println("여행가자!");			
		}
		
	}
}
