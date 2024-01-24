package vending_machine;

public class Customer {
	
	/**
	 * 고객이 가진돈
	 */
	private int wallet;
	
	/**
	 * 고객이 가진 상품의 수량
	 */
//	int stock;
	private Product product;
		
		
	public int getWallet() {
		return this.wallet;
	}

	public Product getProduct() {
		return this.product;
	}

	/**
	 * 생성자
	 */
//	public Customer(int wallet, int stock) {
	public Customer(int wallet) {
		this.wallet = wallet;
//		this.stock = stock;
		//프로덕트 생성자 호출
		this.product = new Product();
	}
	
	/**
	 * 지출한다.
	 */
	public void pay(int price) {
		//가지고있는 금액빼기 음료가격이 영보다 작으면
		if (this.wallet - price <= 0) {
			return; // 메소드 즉시 종료
		}
		// Customer이 갖고있던 돈에서 음료값 빼기
		this.wallet -= price;
	}
	
	/**
	 * 상품이 증가한다.
	 */
	public void addStock(String name, int price) {
//		this.stock++;
		// 고객이 제로콜라를 구매한 적이 있는지? 확인.
		// 고객이 제로콜라를 구매한 적이 없다면 
		if (this.product.getName() == null) {
			// 고객이 가진 상품의 정보를 제로콜라로 채워준다.
			this.product.setName(name);
			this.product.setPrice(price);
//			this.product.setQuantity(1);
			this.product.setQuantity(VendingMachine.PRODUCT_COUNT);
		}
		// 고객이 제로콜라를 구매한 적이 있다면.
		else {
			// 고객이 가진 제로콜라의 수량을 1개 증가 시킨다.
//			this.product.quantity++;
			int quantity = this.product.getQuantity();
//			quantity++;
			quantity += VendingMachine.PRODUCT_COUNT;
			this.product.setQuantity(quantity);
		}
	}
	
	


}
