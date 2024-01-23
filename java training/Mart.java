package oop_exam;

/**
 * 자판기와 고객이 만나는 마트
 */
public class Mart {
	
	/**
	 * 함수지향방식으로 개발한 코드
	 */
	public static void case1() {
		
		VendingMachine drinkMachine = new VendingMachine();
		drinkMachine.money = 3000;
		drinkMachine.productQuantity = 5;
		
		Customer musk = new Customer(0, 0);
		musk.wallet = 10000;
		musk.stock = 0;
		// 고객이 자판기에 돈을 넣는다.
		// 고객이 가진 돈을 빼주고
		musk.pay(1300);
		
		// 자판기의 돈을 증가시킨다.
//		drinkMachine.insertMoney();
		
		// 고객이 자판기의 음료 버튼을 누른다.
		// 자판기의 수량이 하나 줄어들고 
//		drinkMachine.pressButton();
		// 고객의 수량이 하나 증가한다.
		musk.addStock();
		
		System.out.println("자판기의 잔액: " + drinkMachine.money);
		System.out.println("자판기의 상품 수량: " + drinkMachine.productQuantity);
		System.out.println("고객의 지갑 잔액: " + musk.wallet);
		System.out.println("고객의 상품 수량: " + musk.stock);
	
		
	}
	
	public static void main(String[] args) {
		
		// 객체지향방식으로 개발
		
		VendingMachine drinkMachine = new VendingMachine();
		drinkMachine.money = 3000;
		drinkMachine.productQuantity = 5;
		
		VendingMachine snackMachine = new VendingMachine();
		
		Customer musk = new Customer(200_000,50);
		musk.wallet = 10000;
		musk.stock = 0;
		
		drinkMachine.insertMoney(musk);
		drinkMachine.pressButton(musk);
		
		System.out.println("자판기의 잔액: " + drinkMachine.money);
		System.out.println("자판기의 상품 수량: " + drinkMachine.productQuantity);
		System.out.println("고객의 지갑 잔액: " + musk.wallet);
		System.out.println("고객의 상품 수량: " + musk.stock);
	
		}
	
}
