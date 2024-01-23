package vending_machine;

public class VendingMachine2 {
	
	Product2 product1;
	Product2 product2;
	Product2 product3;
	Product2 product4;
	
	int money;
	
	public VendingMachine2() {
		this.product1 = new Product2(); 
		this.product1.name = "박카스";
		this.product1.price = 900;
		this.product1.quantity = 15;
		
		this.product2 = new Product2(); 
		this.product2.name = "몬스터";
		this.product2.price = 1500;
		this.product2.quantity = 20;
		
		this.product3 = new Product2(); 
		this.product3.name = "핫식스";
		this.product3.price = 1300;
		this.product3.quantity = 10;
		
		this.product4 = new Product2(); 
		this.product4.name = "밀키스";
		this.product4.price = 1400;
		this.product4.quantity = 5;
	}
	
	public Product2 orderProduct2(String name, int quantity) {
		Product2 orderedDrink = null;
		
		if (name == product1.name) {
			if (quantity > product1.quantity) {
				System.out.println("상품이 품절 되었습니다. ");
				return null;
			}
			else {
				product1.quantity -= quantity;
				orderedDrink = new Product2();
				orderedDrink.name = this.product1.name;
				orderedDrink.quantity = quantity;
				orderedDrink.price = this.product1.price;
			}
		}
		else if (name == product2.name) {
			if (quantity > product1.quantity) {
				System.out.println("상품이 품절 되었습니다. ");
				return null;
			}
			else {
				product2.quantity -= quantity;
				orderedDrink = new Product2();
				orderedDrink.name = this.product2.name;
				orderedDrink.quantity = quantity;
				orderedDrink.price = this.product2.price;
			}
		}
		else if (name == product3.name) {
			if (quantity > product3.quantity) {
				System.out.println("상품이 품절 되었습니다. ");
				return null;
			}
			else {
				product3.quantity -= quantity;
				orderedDrink = new Product2();
				orderedDrink.name = this.product3.name;
				orderedDrink.quantity = quantity;
				orderedDrink.price = this.product3.price;
			}
		}
		else if (name == product4.name) {
			if (quantity > product4.quantity) {
				System.out.println("상품이 품절 되었습니다. ");
				return null;
			}
			else {
				product4.quantity -= quantity;
				orderedDrink = new Product2();
				orderedDrink.name = this.product4.name;
				orderedDrink.quantity = quantity;
				orderedDrink.price = this.product4.price;
			}
		}
		return orderedDrink;
	}
	
	
	public void stockProduct2(String name, int quantity) {
		if(name == product1.name) {
			product1.quantity += quantity;
		}
		else if(name == product2.name) {
			product2.quantity += quantity;
		}
		else if(name == product3.name) {
			product3.quantity += quantity;
		}
		else if(name == product4.name) {
			product4.quantity += quantity;
		}
	}
	
	public void printStock() {
		System.out.println("===============================");
		System.out.println("자판기 재고 상황 출력");
		System.out.println("===============================");
		System.out.println("상품1: " + this.product1.name + ", " + this.product1.price + ", " + this.product1.quantity);
		System.out.println("상품2: " + this.product2.name + ", " + this.product2.price + ", " + this.product2.quantity);
		System.out.println("상품3: " + this.product3.name + ", " + this.product3.price + ", " + this.product3.quantity);
		System.out.println("상품4: " + this.product4.name + ", " + this.product4.price + ", " + this.product4.quantity);
		System.out.println();
	}
	
}
