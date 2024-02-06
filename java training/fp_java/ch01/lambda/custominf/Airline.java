package fp_java.ch01.lambda.custominf;

@FunctionalInterface
public interface Airline {
	
	public int ADULT_FEE = 1_000_000;
	public int CHILD_FEE = 500_000;
	
	public int getAdultFee(int personCount);
	
	default public int getChildFee(int personCount) {
		return personCount * CHILD_FEE;
	}
}
