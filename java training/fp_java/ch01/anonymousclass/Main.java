package fp_java.ch01.anonymousclass;

public class Main {
	
	// nested class
	public static class SubMain{
		
	}
	
	public static void main(String[] args) {
	
		Main main = new Main();
		System.out.println(main);
		
		SubMain subMain = new SubMain();
		System.out.println(subMain);
		
		Computable computer = new Computable() {
			@Override
			public int add(int num1, int num2) {
				return num1 + num2;
			}
		};
		System.out.println(computer);
		Computable computer2 = new Computable() {
			@Override
			public int add(int num1, int num2) {
				return num1 + num2;
			}
		};
		System.out.println(computer2);
		Computable computer3 = new Computable() {
			@Override
			public int add(int num1, int num2) {
				return num1 + num2;
			}
		};
		System.out.println(computer3);
		
		
		
		
	}
	
}
