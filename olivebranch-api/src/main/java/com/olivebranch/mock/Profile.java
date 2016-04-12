package com.olivebranch.mock;

public interface Profile<KEY> {

	String field(KEY name) throws Exception;
}
