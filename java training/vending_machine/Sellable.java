package vending_machine;

import java.util.List;

/**
 * <I extends Product> ==> Product 클래스를 상속한 타입만 가능(x)
 * 	`				   ==> Product 클래스를 상속한 타입 혹은
 * 					   ==> Product 인터페이스를 구현한 타입(o)
 * @param <I>
 */
public interface Sellable<I> {

	// interface 에서 상수를 정의할 때,
	// static final은 자동으로 적용되므로 생략한다.
	
//	public static final int PRODUCT_COUNT = 1;
//	public static final String MACHINE_NAME = "자판기";
	public int PRODUCT_COUNT = 1;
	public String MACHINE_NAME = "자판기";
	
	public List<I>  getProductArray();
	public int getMoney();
	public void setMoney(int money);
	// 제네릭으로 인한 에러로 추상화시키는 작업
	public void setInsertMoneyHandler(InsertMoneyHandler<I> handler);
	public void setPressButtonHandler(PressButtonHandler<I> handler);
	public void setPrintHandler(PrintHandler<I> handler);
	/**
	 * 돈을 넣는다.
	 * @param customer 돈을 넣은 고객
	 * @param productName 구매할 제품의 이름(제로펩시, 제로콜라, 제로스프라이트)
	 */
	public void insertMoney(Customer customer, String productName);
	
	/**
	 * 버튼을 누른다.
	 * @param customer 버튼을 누른 고객
	 * @param productName 구매할 제품의 이름(제로펩시, 제로콜라, 제로스프라이트)
	 */
	public void pressButton(Customer customer, String productName);
	
	public void pressButton(Customer customer, String productName, int orderCount);
	
//	/**
//	 * 고객에게 환불 처리 한다.
//	 * 상속된 클래스 에서만 상ㅇ할 수 있도록 한다.
//	 * @param customer 환불 받을 고객
//	 * @param refundMoney 환불 받을 금액
//	 */
//	public abstract void refund(Customer customer, int refundMoney);
	
	public void printProduct();

}
