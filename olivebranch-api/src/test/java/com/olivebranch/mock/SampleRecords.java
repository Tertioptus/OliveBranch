package com.olivebranch.mock;

/**
 * Created by bfpaige on 160222.
 */
public interface SampleRecords<T> extends Records<T> {
    T[] getPayload();
}
