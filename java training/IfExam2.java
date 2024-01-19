package hello_java_world;

public class IfExam2 {
	
	public static void main(String[] args) {
		
		/*
		 * 1. 만약 나이가 15세 이상이고 19세 미만이면 앤드게임을 영활르 관람할 수 있다. 
		 */
		int age = 10 ;
		if (age >= 15 && age < 19) {
			System.out.println("앤드게임을 관람할 수 있습니다.");
		}
		else {
			System.out.println("앤드게임을 관람할 수 없습니다.");			
		}
		/*
		 * 2. 만약, 지금 시간이 오후 1시(13시)가 지났고
		 * 내 체크카드에 8000원 보다 많은 돈이 있다면
		 * 식당에서 점심식사를 할 수 있다.
		 * 그렇지 않다면 편의점에서 라면을 사 먹을 수 있다.
		 */
		int hour =13;
		int creditCard = 6000;
		
		if (hour >= 13) {
			System.out.println("점심식사를 할 수 있다.");
			if (creditCard > 8000) {
				System.out.println("식당에서 점심식사를 할 수 없다.");
			}
			else {
				System.out.println("편의점에서 라면을 사먹을 수 있다.");
			}
		}
		else {
			System.out.println("점심식사를 할 수 없다.");
		}
		
		
		/*
		 * 3. 만약 나이가 19세 이상이면
		 * 범죄도시 1편을 관람할 수 있고
		 * 나이가 15세 이상이고 19세 미만이면
		 * '엔드게임' 영화를 관람할 수 있고
		 * 나이가 12세 이상이고 15세 미만이면 
		 * '헤리포터' 영화를 관람할 수 있고
		 * 그렇지 않다면 '뽀로로 극장판 공룡섬 대모험'을 관람할 수 있다.
		 */
		int age2 = 14;
		
		if (age2 >= 19) {
			System.out.println("범죄도시 1편을 관람할 수 있다.");
		}
		else if (age2 >= 15) {
			System.out.println("앤드게임을 관람할 수 있다.");			
		}
		else if (age2 >= 12) {
			System.out.println("헤리포터을 관람할 수 있다.");			
		}
		else {
			System.out.println("뽀로로 극장판 공룡섬 대모험을 관람할 수 있다.");						
		}
		// 숫자의 경우 숫자가 큰곳에서 작은곳으로 가게되면 괜찮지만 작은곳에서 올라가게되면 어렵다. 
		// ex - 뽀로로가 나오게됨.. 한가지 값을 받고 빠져나오는 것을 잊지말자...
		if (age2 >= 0) {
			System.out.println("뽀로로 극장판 공룡섬 대모험을 관람할 수 있다.");						
		}
		else if (age2 >= 12) {
			System.out.println("헤리포터을 관람할 수 있다.");			
		}
		else if (age2 >= 15) {
			System.out.println("앤드게임을 관람할 수 있다.");			
		}
		else {
			System.out.println("범죄도시 1편을 관람할 수 있다.");
		}
	}
}
