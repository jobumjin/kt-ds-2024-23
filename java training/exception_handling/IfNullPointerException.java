package exception_handling;

public class IfNullPointerException {
	public static void main(String[] args) {
		String name = null;
		
		// NullPointerException - null.equals("이름")
		if (name != null) {			
			System.out.println(name.equals("이름"));
		}
	}
}
