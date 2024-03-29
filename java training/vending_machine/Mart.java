package vending_machine;

import java.util.ArrayList;
import java.util.List;

import vending_machine.util.FileUtil;
import vending_machine.util.NIOFileUtil;

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
	/*
	 * Refactoring ==> 코드를 깔끔하게 개선하는 과정
	 * 1. 메소드 Body 라인 수 : 20라인 이하 작성할 것
	 * 2. 클래스명, 메소드명, 변수(인스턴스)명은 명확하게(축약, 애매모호X) 지을 것
	 * 3. 메소드 구성은 신문기사처럼 쓸 것.
	 * 		- 기사의 내용처럼, 편하게 읽을 수 있도록 만든다.
	 * 			- 메소드 Chain을 순서대로 작성.
	 * 			  - 주문 -> 재고수 감소() -> 돈을 증가() -> 고객에게 재고를 증가()시킨다.
	 * 			  - 주문()
	 * 			  - 재고수 감소()
	 * 			  - 돈을 증가()
	 * 			  - 고객에게 재고를 증가()
	 */
	
	public static List<Product> initiateProduct() {
		
//		List<Product> productList = FileUtil.readCSVFile("C:\\Java Exam", "goods.csv");
	
		List<Product> productList = NIOFileUtil.readCSVFile("goods.csv");
		
		return productList;
	}
	
	public static void initiateInsertMoneyHandler(Sellable<Product> sellable) {
		sellable.setInsertMoneyHandler(new InsertMoneyHandler<Product>() {
			@Override
			public void handle(VendingMachine<Product> machine, Customer customer, Product item, String productName) {
				if(item.equals(productName)) {
					int money = machine.getMoney();
					money += item.getPrice();
					machine.setMoney(money);
					customer.pay(item.getPrice());
				}
			}});
	}
	
	public static void initiatePressButtonHandler(Sellable<Product> sellable) {
		sellable.setPressButtonHandler(new PressButtonHandler<Product>() {

			@Override
			public void handle(VendingMachine<Product> machine, Customer customer, Product item, String productName, int orderCount) {
				if(item.equals(productName)) {
					if (item.getQuantity() <= 0) {
						machine.refund(customer, item.getPrice());
						return; //메소드 종료
					}
				int quantity = item.getQuantity();
				quantity -= orderCount;
				item.setQuantity(quantity);
				customer.addStock(productName, item.getPrice(), orderCount);
			}
			}});
	}
	
	public static void initiateSetPrintHandler(Sellable<Product> sellable) {
		sellable.setPrintHandler(new PrintHandler<Product> () {

			@Override
			public void handle(Product item) {
				System.out.println("자판기의 상품 수량: " + item.getQuantity());
				System.out.println("자판기의 상품 이름: " + item.getName());
			}});
	}
	
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
		
//		Product p = new Product();
//		p.setName("보드마카");
//		p.setPrice(500);
//		p.setQuantity(40);
//		
//		System.out.println(p); // overriding을 통해 클래스@해시태그 가 아닌 재정의한대로 출력
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
		
		// VendingMachine에 있던 코드 가져와서 Mart에서 실행 // 제네릭연습
		
		
		// 객체지향방식으로 개발
		// VendingMachine 생성자를 호출해 인스턴스 생성
		Sellable<Product> drinkMachine = new VendingMachine<>(100_000, initiateProduct());
		initiateInsertMoneyHandler(drinkMachine);
		initiatePressButtonHandler(drinkMachine);
		initiateSetPrintHandler(drinkMachine);
		
		drinkMachine.addProduct("보이차", 4000, 20);
		
		Customer musk = new Customer(200_000);

		drinkMachine.insertMoney(musk, "제로펩시");
		drinkMachine.pressButton(musk, "제로펩시",50);
		
		drinkMachine.insertMoney(musk, "제로펩시");
		drinkMachine.pressButton(musk, "제로펩시", 2);

		drinkMachine.printProduct();
		musk.printProducts();
		
		
		// 메소드 오버로딩 생성자 오버로딩 출력해보기
		Sellable<Product> snackMachine = new RefundableVendingMachine<>(400, initiateProduct());
		
		initiateInsertMoneyHandler(snackMachine);
		initiatePressButtonHandler(snackMachine);
		initiateSetPrintHandler(snackMachine);

		snackMachine.addProduct("엔쵸", 700, 10);

		snackMachine.insertMoney(musk, "제로펩시");
		snackMachine.pressButton(musk, "제로펩시",50);
		snackMachine.insertMoney(musk, "제로펩시");
		snackMachine.pressButton(musk, "제로펩시", 2);
		
		snackMachine.printProduct();
		musk.printProducts();
	
	}
}