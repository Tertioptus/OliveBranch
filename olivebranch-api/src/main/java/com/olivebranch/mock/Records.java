package com.olivebranch.mock;

public interface Records<T> {

	Record<T> retrieve(long number) throws Exception;
	
	long size() throws Exception;
}
