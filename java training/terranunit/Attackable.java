package com.ktdsuniversity.terranunit;

/**
 * 공격가능한 유닛
 * 인터페이스는 인터페이스만 상속할 수 있다.
 */
public interface Attackable extends Unit {

	
	public void attack();
	
}
