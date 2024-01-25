package vending_machine;

public class Mart {
	
	/**
	 * 함수지향방식으로 개발한 코드
	 */
	public static void case1() {
		
		// VendingMachine 생성자를 호출해 인스턴스 생성
		VendingMachine drinkMachine = new VendingMachine();

		// Customer 생성자를 호출해 인스턴스 생성
		Customer musk = new Customer(0);
		// mask.wallet에 10000으로 값 재할당
//		musk.wallet = 10000;
//		musk.setWallet(10000); setter를 만들면 가능
//		musk.stock = 0;
		// 고객이 자판기에 돈을 넣는다.
		// 고객이 가진 돈을 빼주고
		musk.pay(1300);
		
		// 자판기의 돈을 증가시킨다.
//		drinkMachine.insertMoney();
		
		// 고객이 자판기의 음료 버튼을 누른다.
		// 자판기의 수량이 하나 줄어들고 
//		drinkMachine.pressButton();
		// 고객의 수량이 하나 증가한다.
		musk.addStock("",0);
		
		//결과 출력
		System.out.println("자판기의 잔액: " + drinkMachine.getMoney());
		//결과 출력
		System.out.println("자판기의 상품 수량: " + drinkMachine.getProduct().getQuantity());
		//결과 출력
		System.out.println("자판기의 상품 이름: " + drinkMachine.getProduct().getName());
		//결과 출력
		System.out.println("고객의 지갑 잔액: " + musk.getWallet());
		//결과 출력
		System.out.println("고객의 상품 수량: " + musk.getProduct().getQuantity());
	
		
	}
	
	public static void main(String[] args) {
		
		// 객체지향방식으로 개발
		// VendingMachine 생성자를 호출해 인스턴스 생성
		VendingMachine drinkMachine = new VendingMachine();
		//아래의 코드는 VendingMachine의 ㅐㅇ성자에서 대체함.
//		drinkMachine.money = 3000;
//		drinkMachine.productQuantity = 5;
		
		// Customer 생성자를 호출해 인스턴스 생성
		Customer musk = new Customer(200_000);
//		아래 코드는 Customer의 생성자에서 대체함
//		musk.wallet = 10000;
//		musk.stock = 0;
		
		//VendingMachine 생성자를 호출해 생성된 인스턴스 drinkMachine에 insertMoney기능 실행
		drinkMachine.insertMoney(musk);
		//VendingMachine 생성자를 호출해 생성된 인스턴스 drinkMachine에 pressButton기능 실행
		drinkMachine.pressButton(musk);
		
		//VendingMachine 생성자를 호출해 생성된 인스턴스 drinkMachine에 insertMoney기능 실행
		drinkMachine.insertMoney(musk);
		//VendingMachine 생성자를 호출해 생성된 인스턴스 drinkMachine에 pressButton기능 실행
		drinkMachine.pressButton(musk);

		//결과출력
		System.out.println("자판기의 잔액: " + drinkMachine.getMoney());
		//결과출력
		System.out.println("자판기의 상품 수량: " + drinkMachine.getProduct().getQuantity());
		//결과출력
		System.out.println("자판기의 상품 이름: " + drinkMachine.getProduct().getName());
		//결과출력
		System.out.println("고객의 지갑 잔액: " + musk.getWallet());
		//결과출력
		System.out.println("고객의 상품 수량: " + musk.getProduct().getQuantity());
		
		
		// 메소드 오버로딩 생성자 오버로딩 출력해보기
		VendingMachine snackMachine = new VendingMachine(400);

		snackMachine.insertMoney(musk);
		snackMachine.pressButton(musk, 4);
		
		//결과출력
		System.out.println("자판기의 잔액: " + snackMachine.getMoney());
		//결과출력
		System.out.println("자판기의 상품 수량: " + snackMachine.getProduct().getQuantity());
		//결과출력
		System.out.println("자판기의 상품 이름: " + snackMachine.getProduct().getName());
		//결과출력
		System.out.println("고객의 지갑 잔액: " + musk.getWallet());
		//결과출력
		System.out.println("고객의 상품 수량: " + musk.getProduct().getQuantity());
				
		}
	


}
