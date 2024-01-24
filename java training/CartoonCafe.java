package cartooncafe;

public class CartoonCafe {
	
	/*
	 * 만화카페 보유비용
	 */
	private int money;
	/*
	 * 만화책정보
	 */
	private CartoonBook cartoonbook1;
	private CartoonBook cartoonbook2;
	private CartoonBook cartoonbook3;
	private CartoonBook cartoonbook4;
	
	public int getMoney() {
		return this.money;
	}
	
	public void setMoney(int money) {
		this.money = money;
	}
	
	/*
	 * 만화책 초기값..
	 */
	public CartoonCafe( ) {
		cartoonbook1 = new CartoonBook();
		cartoonbook1.setName("슬램덩크 1화");
		cartoonbook1.setRentcost(1500);
		cartoonbook1.setStatus(false);
		
		cartoonbook2 = new CartoonBook();
		cartoonbook2.setName("슬램덩크 2화");
		cartoonbook2.setRentcost(1500);
		cartoonbook2.setStatus(false);
		
		cartoonbook3 = new CartoonBook();
		cartoonbook3.setName("나루토");
		cartoonbook3.setRentcost(1500);
		cartoonbook3.setStatus(false);
		
		cartoonbook4 = new CartoonBook();
		cartoonbook4.setName("원피스");
		cartoonbook4.setRentcost(1500);
		cartoonbook4.setStatus(false);	
		
	}
	
	public void bookList() {		
		System.out.println("===============================");
		System.out.println("만화책 목록 출력");
		System.out.println("===============================");
		System.out.println("책이름: " + cartoonbook1.getName() + ",대여료: " + cartoonbook1.getRentcost() + ",대여여부: " + cartoonbook1.isStatus());
		System.out.println("책이름: " + cartoonbook2.getName() + ",대여료: " + cartoonbook2.getRentcost() + ",대여여부: " + cartoonbook2.isStatus());
		System.out.println("책이름: " + cartoonbook3.getName() + ",대여료: " + cartoonbook3.getRentcost() + ",대여여부: " + cartoonbook3.isStatus());
		System.out.println("책이름: " + cartoonbook4.getName() + ",대여료: " + cartoonbook4.getRentcost() + ",대여여부: " + cartoonbook4.isStatus());
		
	}
	
	public void rentCartoonBook(String name, int cmoney) {
		if (name == cartoonbook1.getName()) {
			if(cmoney >= cartoonbook1.getRentcost()) {
				if(cartoonbook1.isStatus()) {
					System.out.println("이미 대여중인 만화책은 대여할 수 없습니다.");
				}
				else {
					cartoonbook1.setStatus(true);
					int cost = this.money + this.cartoonbook1.getRentcost();
					this.setMoney(cost);
//					this.money,setMoney(money);
//					에러 이유 같은 클래스에서 가져오는데.. 중간에 money를 쓸 이유가 없다.
				}
			}
			else {
				System.out.println("만화책을 대여할 돈이 부족합니다.");
			}		
		}
		else if (name == cartoonbook2.getName()) {
			if(cmoney >= cartoonbook2.getRentcost()) {
				if(cartoonbook2.isStatus()) {
					System.out.println("이미 대여중인 만화책은 대여할 수 없습니다.");
				}
				else {
					cartoonbook2.setStatus(true);
					int cost = this.money + this.cartoonbook2.getRentcost();
					this.setMoney(cost);
//					this.money,setMoney(money); 
				}
			}
			else {
				System.out.println("만화책을 대여할 돈이 부족합니다.");
			}		
		}
		else if (name == cartoonbook3.getName()) {
			if(cmoney >= cartoonbook3.getRentcost()) {
				if(cartoonbook3.isStatus()) {
					System.out.println("이미 대여중인 만화책은 대여할 수 없습니다.");
				}
				else {
					cartoonbook3.setStatus(true);
					int cost = this.money + this.cartoonbook3.getRentcost();
					this.setMoney(cost);
//					this.money,setMoney(money);
				}
			}
			else {
				System.out.println("만화책을 대여할 돈이 부족합니다.");
			}		
		}
		else if (name == cartoonbook4.getName()) {
			if(cmoney >= cartoonbook4.getRentcost()) {
				if(cartoonbook4.isStatus()) {
					System.out.println("이미 대여중인 만화책은 대여할 수 없습니다.");
				}
				else {
					cartoonbook4.setStatus(true);
					int cost = this.money + this.cartoonbook4.getRentcost();
					this.setMoney(cost);
//					this.money,setMoney(money);
				}
			}
			else {
				System.out.println("만화책을 대여할 돈이 부족합니다.");
			}		
		}
		
	}
	
	public void returnCartoonBook(String name) {
		if(name == cartoonbook1.getName()) {
			if(cartoonbook1.isStatus()) {
				System.out.println("반납이 완료되었습니다.");
				cartoonbook1.setStatus(false);
			}
			else {
				System.out.println("빌려가지 않은 책입니다.");
			}
		}
		if(name == cartoonbook2.getName()) {
			if(cartoonbook2.isStatus()) {
				System.out.println("반납이 완료되었습니다.");
				cartoonbook2.setStatus(false);
			}
			else {
				System.out.println("빌려가지 않은 책입니다.");
			}
		}
		if(name == cartoonbook3.getName()) {
			if(cartoonbook3.isStatus()) {
				System.out.println("반납이 완료되었습니다.");
				cartoonbook3.setStatus(false);
			}
			else {
				System.out.println("빌려가지 않은 책입니다.");
			}
		}
		if(name == cartoonbook4.getName()) {
			if(cartoonbook4.isStatus()) {
				System.out.println("반납이 완료되었습니다.");
				cartoonbook4.setStatus(false);
			}
			else {
				System.out.println("빌려가지 않은 책입니다.");
			}
		}
	}
}
