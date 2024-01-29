package vending_machine;

public class Mart {
	
//	// Object 를 파라미터로 쓸 수는 있는데.. 잘 안쓴다..
//	public static void printProduct(Product p) {
//		System.out.println(p.getName()); // null
//
//		// 이렇게 넣어주지 않으면 파라미터로 p product()타입의 인스턴스 를 받아올 수 없다.
//		if(p instanceof TemperatureProduct) {			
//			TemperatureProduct tp = (TemperatureProduct) p;
//			tp.setIsHot(true);
//			System.out.println(tp.getIsHot());
//		}
//		
//	}
	
	public static void main(String[] args) {
		
		// 모든 클래스의 슈퍼클래스는 Object 이다. 
		/*
		 * Object
		 * --> Product
		 * 		--> TemperatureProduct
		 * Product is a Object
		 * TemperatureProduct is a Product
		 * TemperatureProduct is a Object
		 */
//		Product p = new Product();
//		TemperatureProduct tp = new TemperatureProduct();
//		tp.setName("티피");
////		PrintTemperatureProduct(p); 안된다.. 상속의 관계를 보아야함 
//		printProduct(p);
////		PrintTemperatureProduct(tp);
//		printProduct(tp);
//		
		
		Product p = new Product();
		p.setName("보드마카");
		p.setPrice(500);
		p.setQuantity(40);
		
		System.out.println(p); // overriding을 통해 클래스@해시태그 가 아닌 재정의한대로 출력
//		출력결과
//		vending_machine.Product@279f2327
//		제품명 : 보드마카, 가격 : 500, 재고 : 40
		
		
		// Seller
		// --> VendingMachine
		// --> RefundableVendingMachine
		// IS A (다형성이 이루어진다..)
		// VendingMarchine is Seller
		// RefundableVendingMachine is Seller
		// Seller drinkMachine = new VendingMachine();
		// Seller drinkMachine = new RefundableVendingMachine();
		
		// Sellable(인터페이스)
		// --> (구현) VendingMachine
		// --> (구현) RefundableVendingMachine
		// IS A (다형성이 이루어진다..)
		// VendingMarchine is Seller
		// RefundableVendingMachine is Seller
		// Seller drinkMachine = new VendingMachine();
		// Seller drinkMachine = new RefundableVendingMachine();
		
		
		// 객체지향방식으로 개발
		// VendingMachine 생성자를 호출해 인스턴스 생성
		Sellable drinkMachine = new VendingMachine();
		Customer musk = new Customer(200_000);

		drinkMachine.insertMoney(musk, "제로펩시");
		drinkMachine.pressButton(musk, "제로펩시",50);
		
		drinkMachine.insertMoney(musk, "제로펩시");
		drinkMachine.pressButton(musk, "제로펩시", 2);

		drinkMachine.printProduct();
		musk.printProducts();
		
		
		// 메소드 오버로딩 생성자 오버로딩 출력해보기
		Sellable snackMachine = new RefundableVendingMachine(400);

		snackMachine.insertMoney(musk, "제로펩시");
		snackMachine.pressButton(musk, "제로펩시",50);
		snackMachine.insertMoney(musk, "제로펩시");
		snackMachine.pressButton(musk, "제로펩시", 2);
		
		snackMachine.printProduct();
		musk.printProducts();
	
	}
}