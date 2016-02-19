package com.olivebranch.mock;

public interface Record<T> {
	
	T load() throws Exception;
}
