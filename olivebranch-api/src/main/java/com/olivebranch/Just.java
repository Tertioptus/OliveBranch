package com.olivebranch;

/**
 * Just is an enumerator that produces a length of time in units of milliseconds from a human readable java code expression.
 * 
 * @author Benjamin Paige
 * @version 1.0
 * @since 1.0
 *
 */
public enum Just {

	ONE(1), TWO(2), THREE(3), FOUR(4), FIVE(5), SIX(6), SEVEN(7), EIGHT(8), NINE(9), TEN(10), TWENTY(20), THIRTY(30);
	
	private static final int TOTAL_MILLISECONDS_IN_A_SECOND = 1000;
	private static final int TOTAL_SECONDS_IN_A_MINUTE = 60;

	private final int count;
	
	Just(int count) {
		this.count = count;
	}

	/**
	 * Returns the number of seconds in milliseconds.
	 * 
	 * @return seconds in milliseconds
	 */
	public Time seconds() {
		checkPlurality();
		return new Time(count * TOTAL_MILLISECONDS_IN_A_SECOND);
	}

	/**
	 * Returns 1000 to represent one second in milliseconds.
	 * 
	 * @return 1000 the number of milliseconds in a second
	 */
	public Time second() {
		return new Time(TOTAL_MILLISECONDS_IN_A_SECOND);
	}
	
	/**
	 * Returns the number of minutes in milliseconds.
	 * 
	 * @return minutes in milliseconds
	 */
	public Time minutes() {
		checkPlurality();
		return new Time(count * TOTAL_SECONDS_IN_A_MINUTE * TOTAL_MILLISECONDS_IN_A_SECOND);
	}
	
	/**
	 * Return a the number of minutes in milliseconds.
	 * 
	 * @return 60000 the number milliseconds in a minute
	 */
	public Time minute() {
		return new Time(TOTAL_SECONDS_IN_A_MINUTE * TOTAL_MILLISECONDS_IN_A_SECOND);
	}
	
	private void checkPlurality() {
		if(count == 1) {
			throw new RuntimeException("Bad grammar:  Please choose the 'ONE' token when using this method");
		}
	}
}
