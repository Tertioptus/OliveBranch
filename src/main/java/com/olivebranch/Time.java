package com.olivebranch;

public class Time {
	
	private final int milliseconds;

	Time(final int milliseconds) {
		this.milliseconds = milliseconds;
	}
	
	public int milliseconds() {
		return milliseconds;
	}

}
