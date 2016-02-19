package com.olivebranch.mock;

/**
 * Created by bfpaige on 160218.
 */
public class CachedRecord<T> implements Record<T> {
    private final Record<T> record;
    private T cachedValue;

    public CachedRecord(Record<T> record) {
        this.record=record;
    }

    public T load() throws Exception {
        if(cachedValue == null)
            cachedValue=record.load();
       return cachedValue;
    }
}
