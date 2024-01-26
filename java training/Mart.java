package vending_machine;

public class Mart {
	
	public static void main(String[] args) {
		
		// 객체지향방식으로 개발
		// VendingMachine 생성자를 호출해 인스턴스 생성
		VendingMachine drinkMachine = new VendingMachine();
		Customer musk = new Customer(200_000);

		drinkMachine.insertMoney(musk, "제로펩시");
		drinkMachine.pressButton(musk, "제로펩시");
		
		drinkMachine.insertMoney(musk, "제로콜라");
		drinkMachine.pressButton(musk, "제로콜라");

		drinkMachine.pringProduct();
		musk.printProducts();
		
		
		// 메소드 오버로딩 생성자 오버로딩 출력해보기
		VendingMachine snackMachine = new VendingMachine(400);

		snackMachine.insertMoney(musk, "제로스프라이트");
		snackMachine.pressButton(musk, "제로스프라이트",4);
		snackMachine.insertMoney(musk, "제로펩시");
		snackMachine.pressButton(musk, "제로펩시", 2);
		
		snackMachine.pringProduct();
		musk.printProducts();
	
	}
}