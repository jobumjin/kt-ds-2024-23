package fp_java.ch01.lambda;

// 추가를 못하게 막아주는.. 방어막 같은것..
@FunctionalInterface
public interface Computable {

	public int add(int num1, int num2);
	
	// 이렇게 쓰면 안된다.. 
	// 람다가 바라봐야할 추상메소드가 하나여야되는데 그렇지 못하기 때문에
	/**
	 * 인터페이스의 printMessage 기본코드를 작성.
	 * default 키워드를 가장 앞에 붙이면
	 * 인터페이스도 기능을 구현할 수 있다.
	 * implementable class에서 overriding 가능하다.
	 * overriding을 해주지 않으면 기본 코드가 동작된다.
	 */
	default public void printMessage() {
		System.out.println("기본 메세지 입니다.");
	}
	
}
