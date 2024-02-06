package fp_java.ch01.lambda.custominf;

public class CustomInfMain {
	
	public static void main(String[] args) {
	
		Airline airlineFee = (personCount) -> Airline.ADULT_FEE * personCount;
		
		int childFee = airlineFee.getChildFee(3);
		int adultFee = airlineFee.getAdultFee(3);
		System.out.println(childFee);
		System.out.println(adultFee);
		
		System.out.println("======================");

		Calculatable printAddResult = (num1, num2) -> System.out.println(num1 + num2);;
		printAddResult.printAddResult(20, 10);
		printAddResult.printSubResult(20, 10);
		printAddResult.printMulResult(20, 10);
		printAddResult.printDivResult(20, 10);
		
	}
	
}
