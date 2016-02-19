package com.olivebranch;

public final class Input {

	private String value;
	
	Input(String value) {
		this.value = value;
	}
	
	public String value() {
		return value;
	}

	@Override
	public String toString() {
		return this.value();
	}
}
