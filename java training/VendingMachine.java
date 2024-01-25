package vending_machine;

public class VendingMachine {
	
	// 클래스 상수 (공용 상수)
	/**
	 * 한번에 구매할 수 있는 제품의 수
	 */
	public static final int PRODUCT_COUNT;
	public static final String MACHINE_NAME;
	
	// 클래스 상수에 값을 할당하는 방법
	// static block
	static {
		// static 변수 / 상수의 값을 초기화하는 공간
		PRODUCT_COUNT = 1;
		MACHINE_NAME = "자판기";
	}
	
	// 상수 자리 
//	final int PRICE = 1300;
	
	
	// 멤버변수 자리
	/**
	 * 상품 수량
	 */
//	int productQuantity;
	private Product product; //product 멤버변수 생성..
	
	/**
	 * 돈
	 */
	private int money; //money 멤버변수 생성
		
	public Product getProduct() {
		return product;
	}

	public int getMoney() {
		return money;
	}

	// 생성자 자리
	/**
	 * VendingMachine의 인스턴스를 생성할 때 호출된다.
	 */
	public VendingMachine() {
		// "자판기 인스턴스를 만들었습니다." 출력
		System.out.println("자판기 인스턴스를 만들었습니다.");
//		this.productQuantity = 10;
		// 생성자가 만들어준 인스턴스의 멤버변수에 값을 할당한다. (초기화)
		this.product = new Product();
		this.product.setName("제로펩시");
		this.product.setPrice(1600);
		this.product.setQuantity(50);
		this.money = 100_000;
		/*
		 * 생성자를 직접 만드는 이유 (두 가지)
		 * 1. 멤버변수 초기화 (멤버변수에 기본 값을 별도로 할당을 하기 위해서)
		 * 	- Reference Type 위주로 쵝화.
		 * 		- 배열, 컬렉션
		 * 2. 인스턴스 생성과 동시에 다른 메소드를 호출하기 위해.
		 * 	- 예> 인스턴스를 생성함과 동시에 insertMoney메소드를 호출하기 위해서.
		 */
	}
	
	//생성자 오버로딩
	public VendingMachine (int money) {
		this.money = money;
		// 돈을 넣어주면 그 돈만큼 가지는 자판기 생성..
		this.product = new Product();
		this.product.setName("제로펩시");
		this.product.setPrice(1600);
		this.product.setQuantity(50);
	}
	
	/**
	 * 돈을 넣는다.
	 * @param 돈을 넣은 고객
	 */
	public void insertMoney(Customer customer) {
		// 원래 갖고있던 금액에 팔린 음료값 더하기
		this.money += this.product.getPrice();
		// customer에 this.product.price를 파라미터로 갖는 pay기능을실행 ==> customer 금액 상실 
		customer.pay(this.product.getPrice());
	}
	
	/**
	 * 버튼을 누른다.
	 * @param 버튼을 누른 고객
	 */
	public void pressButton(Customer customer) {
////		if(this.productQuantity <= 0) {
//		// 만약 음료재고가 없다면
//		if(this.product.getQuantity() <= 0) {
//			return; // 메소드 즉시 종료
//		}
////		this.productQuantity--;
//		//재고가 있다면 재고 하나 감소
//		int quantity = this.product.getQuantity();
////		quantity--;
//		quantity -= VendingMachine.PRODUCT_COUNT;
//		this.product.setQuantity(quantity);
//		// 소비자의 재고는 상승 
//		// this.product.name, this.product.price를 파라미터로 갖는 addStock 기능 실행
//		customer.addStock(this.product.getName(), this.product.getPrice());
		
		//같은 코드가 사라지게된다... 메소드 체이닝..
		this.pressButton(customer, VendingMachine.PRODUCT_COUNT);
	}
	
	// 메소드 오버러딩 -- 문제점 같은코드를 사용하게됨.. 
	public void pressButton(Customer customer, int orderCount) {

		if(this.product.getQuantity() <= 0) {
			return; 
		}
		int quantity = this.product.getQuantity();
		// orderCount만큼 판매하게됨
		quantity -= orderCount;
		this.product.setQuantity(quantity);
		customer.addStock(this.product.getName(), this.product.getPrice(), orderCount);
	
	}
	
	
 }


