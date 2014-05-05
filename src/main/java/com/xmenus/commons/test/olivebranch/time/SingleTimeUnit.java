package com.xmenus.commons.test.olivebranch.time;

public class SingleTimeUnit {
	
	SingleTimeUnit() {
		
	}
	
	public static Accordingly half_a_second() {
		return new Accordingly(500);
	}
	
	public static Accordingly one_second() {
		return new Accordingly(1000);
	}
	
	public static Accordingly half_a_minute() {
		return new Accordingly(30000);
	}

	public static Accordingly one_minute() {
		return new Accordingly(60000);
	
	}
}
