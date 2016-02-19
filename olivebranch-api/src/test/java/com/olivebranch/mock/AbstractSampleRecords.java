package com.olivebranch.mock;
/**
 * Created by bfpaige on 160219.
 */
abstract class AbstractSampleRecords<T> implements Records<T> {

   private T[] payload;

   protected AbstractSampleRecords(T[] payload) {
     this.payload=payload;
   }

   public Record<T> retrieve(final long number) {
      return new Record<T>() {
         public T load() {
            return payload[(int)number];
         }
      };
   }

   public long size() {
      return payload.length;
   }
}
