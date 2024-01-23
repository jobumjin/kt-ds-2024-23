package oop_exam;

/**
 * 자판기를 이용하는 고객
 */
public class Customer {
	
	/**
	 * 고객이 가진돈
	 */
	int wallet;
	
	/**
	 * 고객이 가진 상품의 수량
	 */
	int stock;
	
	/**
	 * 생성자
	 */
	public Customer(int wallet, int stock) {
		this.wallet = wallet;
		this.stock = stock;
	}
	
	/**
	 * 지출한다.
	 */
	public void pay(int price) {
		if (wallet - price <= 0) {
			return; // 메소드 즉시 종료
		}
		wallet -= price;
	}
	
	/**
	 * 상품이 증가한다.
	 */
	public void addStock() {
		stock++;
	}
	
	
}
