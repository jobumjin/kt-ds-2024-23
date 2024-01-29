package com.ktdsuniversity.terranunit;

public class Marine implements SpecialCommand{

	@Override
	public void attack() {
		System.out.println("공격!");
	}

	@Override
	public void move() {
		System.out.println("Move! Move! Move!");
	}

	@Override
	public void stop() {
		System.out.println("정지!");
	}

	@Override
	public void hold() {
		System.out.println("움직이지 않아요.");
	}

	@Override
	public void patrol() {
		System.out.println("정찰하세요.");	
	}

	@Override
	public void steampack() {
		System.out.println("더 빠르게 공격~~~");
		
	}
	
	public static void main(String[] args) {
		SpecialCommand marine1 = new Marine();
		Unit marine2 = new Marine();
		Attackable marine3 = new Marine();
		
		marine1.steampack();
		marine2.move();
		marine3.attack();
		
	}
	
}
