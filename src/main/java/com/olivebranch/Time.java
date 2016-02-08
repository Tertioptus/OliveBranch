package com.olivebranch;

/**
 * Time represents a length of time in milliseconds.  This class should only maintain
 * one package-private constructor, such that the @{see Just} class will have sole responsibility
 * for creating a Time instance.
 * 
 * @author Benjamin Paige
 * @version 1.0
 * @since 1.0
 *
 */
public final class Time {
	
	private final int milliseconds;

	Time(final int milliseconds) {
		this.milliseconds = milliseconds;
	}
	
	public int milliseconds() {
		return milliseconds;
	}

}
