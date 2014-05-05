package com.xmenus.commons.test.olivebranch.time;

public class Accordingly {
	
	private long milliseconds;
	
	Accordingly(long milliseconds) {
		this.milliseconds = milliseconds;
	}
	
	public static SingleTimeUnit after() {
		
		return new SingleTimeUnit();
	}
	
	public static MultiCountTimeUnit after(int count) {
		
		return new MultiCountTimeUnit(count);
	}

	public long getMilliseconds() {
		return milliseconds;
	}
}
