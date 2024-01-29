package com.ktdsuniversity.terranunit;


					// extends (abstract) class
public class Scv implements Attackable, Mineable{

	@Override
	public void mining() {
		System.out.println("자원을 캡니다.");
	}
//	 상속을 통해 코드를 지워낼 수 있다. 
//	 인터페이스와 상속을 동시에 사용이 가능하다.
//	하지만.. 잘못된 상속이라서 적용은 안해봄..
	@Override
	public void move() {
		System.out.println("이동");
	}

	@Override
	public void stop() {
		System.out.println("정지");
	}

	@Override
	public void hold() {
		System.out.println("홀드");		
	}

	@Override
	public void patrol() {
		System.out.println("정찰");		
	}

	@Override
	public void attack() {
		System.out.println("공격");
	}


}
