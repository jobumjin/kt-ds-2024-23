package fp_java.ch01.lambda.custominf;

@FunctionalInterface
public interface Calculatable {
	
	public void printAddResult(int number1, int number2);
	
	default public void printSubResult(int number1, int number2) {
		System.out.println(number1 - number2);
	}

	default public void printMulResult(int number, int time) {
		System.out.println(number * time);
	}
	
	default public void printDivResult(int number1, int number2) {
		System.out.println(number1 / number2);
	}
	
}
