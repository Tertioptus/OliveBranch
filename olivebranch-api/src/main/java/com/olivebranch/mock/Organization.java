package com.olivebranch.mock;

public interface Organization {
	
	String name();

	Address address();
	
	Address mailingAddress();
	
	Address billingAddress();
}
