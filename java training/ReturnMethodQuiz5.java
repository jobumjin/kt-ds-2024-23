package oop_exam;

public class ReturnMethodQuiz5 {
	
	/**
	 * 19살이 넘으면 어른임을 판단하는 메소드 
	 * @param age 나이
	 * @return
	 */
	public static int getAdultAge(int age) {
		if (age >= 19) {			
			return 1;
		}
		return 0;
	}
	
	/**
	 * 19살이 되지 않으면 아이임을 판단하는 메소드
	 * @param age
	 * @return
	 */
	public static int getKidAge(int age) {
		if (age < 19) {			
			return 1;
		}
		return 0;
	}
	
	/**
	 * 어른 항공료와 어른수를 파라미터로 받아 어른 항공료총액을 구하는 메소드
	 * @param adultOneWayFlightFare 어른 항공료
	 * @param adult
	 * @return 어른 항공료 총액
	 */
	public static int getAdultOneWayFlightFare(int adultOneWayFlightFare,int adult) {
		int processAdultOneWayFlightFare = adultOneWayFlightFare * adult;
		return processAdultOneWayFlightFare;
	}

	/**
	 * 아이 항공료와 아이수를 파라미터로 받아 아이 항공료총액을 구하는 메소드
	 * @param kidOneWayFlightFare 아이항공료
	 * @param kid 아이
	 * @return 아이 항공료 총핵
	 */
	public static int getKidOneWayFlightFare(int kidOneWayFlightFare,int kid) {
		int processKidOneWayFlightFare = kidOneWayFlightFare * kid;
		return processKidOneWayFlightFare;
	}
	
	/**
	 * 아이항공료총액과 어른항공료총액을 파라미터로 받아 총항공료액을 구하는 메소드
	 * @param kidOneWayFlightFare 아이항공료
	 * @param adultOneWayFlightFare 어른항공료
	 * @return 전체 항공료
	 */
	public static int getOneWayFlightFare(int kidOneWayFlightFare,int adultOneWayFlightFare) {
		int processOneWayFlightFare = kidOneWayFlightFare + adultOneWayFlightFare;
		return processOneWayFlightFare;
	}
	
	/**
	 * 편도여행예산과 전체항공료를 파라미터로 받아 여행여부를 결정하는 메소드
	 * @param money 편도여행예산
	 * @param OneWayFlightFare 전체행공료
	 */
	public static void getTrip(int money, int OneWayFlightFare) {
		if (money >= OneWayFlightFare) {
			System.out.println("여행가자!");
		}
		else {
			System.out.println("다음에가자 ㅠㅠ");
		}
	}
	
	public static void main(String[] args) {
		int money = 1_000_000;		
		int father = 40;
		int mother = 36;
		int daughter = 11;
		int adult = getAdultAge(father) + getAdultAge(mother) + getAdultAge(daughter);
		int kid = getKidAge(father) + getKidAge(mother) + getKidAge(daughter); 		
		int adultOneWayFlightFare = getAdultOneWayFlightFare(adult,300_000);
		int kidOneWayFlightFare = getKidOneWayFlightFare(kid,120_000);
		int OneWayFlightFare = getOneWayFlightFare(kidOneWayFlightFare,adultOneWayFlightFare);
		getTrip(money,OneWayFlightFare);
	}
}
