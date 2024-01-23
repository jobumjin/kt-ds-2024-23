package vending_machine;

public class Mart2 {
	
	public static void main(String[] args) {
		
		VendingMachine2 vendingMachine = new VendingMachine2();
		vendingMachine.printStock();
		
		Product2 orderdDrink = vendingMachine.orderProduct2("박카스", 10);
		System.out.println(">> 주문결과: "+ orderdDrink.name + ", " + orderdDrink.price + ", " + orderdDrink.quantity);
		
		orderdDrink = vendingMachine.orderProduct2("박카스", 5);
		System.out.println(">> 주문결과: "+ orderdDrink.name + ", " + orderdDrink.price + ", " + orderdDrink.quantity);
		
		orderdDrink = vendingMachine.orderProduct2("밀키스", 5);
		System.out.println(">> 주문결과: "+ orderdDrink.name + ", " + orderdDrink.price + ", " + orderdDrink.quantity);
		
		vendingMachine.printStock();
		
		vendingMachine.stockProduct2("박카스", 300);
		vendingMachine.stockProduct2("몬스터", 450);
		vendingMachine.stockProduct2("핫식스", 250);
		vendingMachine.stockProduct2("밀키스", 150);
		
		vendingMachine.stockProduct2("제로콜라", 500);
		
		vendingMachine.printStock();
		
	}
}
