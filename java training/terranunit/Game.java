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
