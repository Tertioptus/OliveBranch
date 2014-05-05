package com.xmenus.commons.test.olivebranch.time;

public class MultiCountTimeUnit {
	
	private int unitCount;

	MultiCountTimeUnit(int unitCount) {
		this.unitCount = unitCount;
	}

	public Accordingly milliseconds() {
		return new Accordingly(unitCount);
	}
	
	public Accordingly seconds() {
	
		return new Accordingly(unitCount *= 1000);
	}
	
	public Accordingly minutes() {
		
		return new Accordingly(unitCount *= 60000);
	}
}
