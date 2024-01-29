package com.ktdsuniversity.terranunit;

public class Game {

	
	public static void move(Attackable unit) {
		unit.attack();
		unit.move();
		unit.stop();
		unit.hold();
		unit.patrol();
		
//		잘못된 호출 방법.
//		if(unit instanceof Scv) {
//			Scv scv = (Scv) unit;
//			scv.mining();
//		}
		
		if (unit instanceof Mineable) {
			Mineable worker = (Mineable) unit;
			worker.mining();
		}
		
	}
	
	public static void main(String[] args) {
		
		// 익명클래스
		// 한번 쓰고 안 쓸 클래스를 쉽게 만드는 방법
		// Stream API를 사용할 때 주로 사용하는 방법
		Mineable drone = new Mineable() {

			@Override
			public void mining() {
				System.out.println("드론이 미네랄을 채굴합니다.");
			}
			
		};
		
		drone.mining();
		
		SpecialCommand marine = new Marine();
	
	
		Attackable scv = new Scv();
		
		marine.attack();
		marine.steampack();
		marine.move();
		
		scv.attack();
		scv.move();
		scv.patrol();
		scv.hold();
//		scv.steampack();
		
		move(scv);
		move(marine);
		
		
	}
}
