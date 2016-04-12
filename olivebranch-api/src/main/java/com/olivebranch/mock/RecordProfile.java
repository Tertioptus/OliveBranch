package com.olivebranch.mock;

/**
 * Created by bfpaige on 160218.
 */
public class RecordProfile<KEY, T extends Profile<KEY>> implements Profile<KEY> {

    private final Record<T> profileRecord;

    public RecordProfile(CachedRecord<T> profileRecord) {
        this.profileRecord = profileRecord;
    }

    public String field(KEY name) throws Exception {
        return profileRecord.load().field(name);
    }
}
