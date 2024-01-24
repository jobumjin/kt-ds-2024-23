package vending_machine;

/**
 * 자판기에서 판매하는 상품의 정보 (데이터 클래스)
 */
public class Product {
	
	/**
	 * 상품의 이름
	 */
	private String name; //name 멤버변수 생성.
	
	/**
	 * 상품의 가격
	 */
	private int price; //price 멤버변수 생성.
	
	/**
	 * 상품의 재고
	 */
	private int quantity; //quantity 멤버변수 생성.

	public String getName() {
		return this.name;
	}

	public int getPrice() {
		return this.price;
	}

	public int getQuantity() {
		return this.quantity;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
	
}
