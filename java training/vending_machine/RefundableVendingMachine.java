package vending_machine;

/**
 * 환불 기능이 있는 자판기
 */
// 상속을 받으면 어떻게되는 것인가? 코드가 사라진다. 코드는 항상 명확해야한다.
public class RefundableVendingMachine extends VendingMachine implements Sellable {

		
	public RefundableVendingMachine() {
		super();
	}

	public RefundableVendingMachine(int money) {
		super(money);
	}
	
	@Override
	protected void refund(Customer customer, int refundMoney) {
		System.out.println("재고가 없네요.");
		System.out.println(refundMoney + "환불 해드릴께요.");
		// 1. 자판기의 금액을 환불 해줄 금액만큼 감소시킨다.
		int money = super.getMoney();
		money -= refundMoney;
		super.setMoney(money);
		// 2. 고객에게 환불 해준다.
		customer.addMoney(refundMoney);
	}

	
//public class RefundableVendingMachine extends Seller {
	
//	public RefundableVendingMachine() {
//		super();
//	}
//	
//	public RefundableVendingMachine(int money) {
//		super(money);
//	}
//	
//	@Override
//	protected void refund(Customer customer, int refundMoney) {
//		System.out.println("재고가 없네요.");
//		System.out.println(refundMoney + "환불 해드릴께요.");
//		// 1. 자판기의 금액을 환불 해줄 금액만큼 감소시킨다.
//		int money = super.getMoney();
//		money -= refundMoney;
//		super.setMoney(money);
//		// 2. 고객에게 환불 해준다.
//		customer.addMoney(refundMoney);
//	}
	
	
}
