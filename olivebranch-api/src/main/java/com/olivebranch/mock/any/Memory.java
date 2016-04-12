package com.olivebranch.mock.any;

import java.util.HashMap;
import java.util.Map;

/**
 * Represents a heap block allocation: on the host machine, for a single object.
 * 
 * @author Benjamin Paige
 * @version %I% %G%
 * @since 1.0
 *
 * @param <ID> Generic identification type
 * @param <VALUE> Generic value type
 */
abstract class Memory<ID, VALUE> {
	
	private final Map<ID, VALUE> map;
	
	Memory(){
		this(new HashMap<ID, VALUE>());
	}

	Memory(int initialCapacity) {
		this(new HashMap<ID,VALUE>(initialCapacity));
	}
	
	/**
	 * Primary Constructor
	 */
	Memory(Map<ID, VALUE> map) {
		this.map=map;
	}

	/**
	 * Stores value in memory: accessible via given id.
	 * 
	 * @param id identification
	 * @param value
	 */
	protected void put(ID id, VALUE value) {
		map.put(id, value);
	}
	
	/**
	 * Retrieves value stored in memory that is accessible via the given id.
	 * 
	 * @param id identification
	 */
	protected VALUE get(ID id) {
		return map.get(id);
	}
}
