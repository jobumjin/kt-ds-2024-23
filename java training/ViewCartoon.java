package cartooncafe;

public class ViewCartoon {
	
	public static void main(String[] args) {
		CartoonCafe cartoonCafe = new CartoonCafe();
		
		cartoonCafe.bookList();
		
		cartoonCafe.rentCartoonBook("나루토", 2000);
		cartoonCafe.rentCartoonBook("슬램덩크 1화", 20000);
		cartoonCafe.bookList();
		cartoonCafe.rentCartoonBook("나루토", 2000);
		cartoonCafe.rentCartoonBook("나루토", 1000);
		cartoonCafe.returnCartoonBook("나루토");
		cartoonCafe.returnCartoonBook("나루토");
		cartoonCafe.bookList();
	}
}
