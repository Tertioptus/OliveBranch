package com.olivebranch;

/**
 * Time represents a length of time in milliseconds.  This class should only maintain
 * one package-private constructor, such that the @{link Just} class will have sole responsibility
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

	/**
	 * Returns time represented in milliseconds
	 * 
	 * @return time represented in milliseconds
	 */
	public int milliseconds() {
		return milliseconds;
	}

}
