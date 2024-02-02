package oop_exam;

public enum CalcType {

	ADD("+"), SUB("-"), MUL("*"), DIV("/");
	
	private String symbol;
	
	CalcType(String str) {
		this.symbol = str;
	}
	
	public String getSymbol() {
		return this.symbol;
	}
}
