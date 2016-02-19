package com.olivebranch.mock;

/**
 * Created by bfpaige on 160218.
 */
public class RecordProfile<T extends Profile> implements Profile {

    private final Record<T> profileRecord;

    public RecordProfile(CachedRecord<T> profileRecord) {
        this.profileRecord = profileRecord;
    }

    public String field(String name) throws Exception {
        return profileRecord.load().field(name);
    }
}
