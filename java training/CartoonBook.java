package cartooncafe;

/**
 * 만화책 (데이터클래스)
 */
public class CartoonBook {
	
	/*
	 * 만화책 이름
	 */
	private String name;
	
	/*
	 * 대여상태
	 */
	private boolean status;
	
	/*
	 * 대여비
	 */
	private int rentcost;
	
	// 각 멤버변수의 은닉화를 위한 getter setter 작성
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public boolean isStatus() {
		return this.status;
	}
	
	public void setStatus(boolean status) {
		this.status = status;
	}
	
	public int getRentcost() {
		return this.rentcost;
	}
	
	public void setRentcost(int rentcost) {
		this.rentcost = rentcost;
	}
	
}
