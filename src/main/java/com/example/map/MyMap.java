package com.example.map;

import com.example.list.MyList;
import com.example.util.Pair;

public interface MyMap<K, V> {

    // Query Operations

    /**
     * Returns the number of key-value mappings in this map.  If the
     * map contains more than {@code Integer.MAX_VALUE} elements, returns
     * {@code Integer.MAX_VALUE}.
     *
     * @return the number of key-value mappings in this map
     */
    int size();

    /**
     * Returns {@code true} if this map contains no key-value mappings.
     *
     * @return {@code true} if this map contains no key-value mappings
     */
    boolean isEmpty();

    /**
     * Returns {@code true} if this map contains a mapping for the
     * specified key.
     *
     * @param key The key whose presence in this map is to be tested
     * @return {@code true} if this map contains a mapping for the specified
     * key.
     */

    boolean containsKey(K key);

    /**
     * Returns {@code true} if this map maps one or more keys to the
     * specified value.
     *
     * @param value value whose presence in this map is to be tested
     * @return {@code true} if this map maps one or more keys to the
     * specified value
     */
    boolean containsValue(V value);

    /**
     * @throws ClassCastException   {@inheritDoc}
     * @throws NullPointerException {@inheritDoc}
     * @implSpec This implementation iterates over {@code entrySet()} searching
     * for an entry with the specified key.  If such an entry is found,
     * the entry's value is returned.  If the iteration terminates without
     * finding such an entry, {@code null} is returned.
     */
    V get(K key);


    // Modification Operations

    /**
     * Associates the specified value with the specified key in this map.
     * If the map previously contained a mapping for the key, the old
     * value is replaced.
     *
     * @param key   key with which the specified value is to be associated
     * @param value value to be associated with the specified key
     * @return the previous value associated with {@code key}, or
     * {@code null} if there was no mapping for {@code key}.
     * (A {@code null} return can also indicate that the map
     * previously associated {@code null} with {@code key}.)
     */
    V put(K key, V value);

    /**
     * Removes the mapping for a key from this map if it is present.
     * <p>Returns the value to which this map previously associated the key,
     * or {@code null} if the map contained no mapping for the key.
     *
     * @param key key whose mapping is to be removed from the map
     * @return the previous value associated with {@code key}, or
     * {@code null} if there was no mapping for {@code key}.
     * (<a href="{@docRoot}/java.base/java/util/Collection.html#optional-restrictions">optional</a>)
     * @throws IllegalArgumentException if the specified key is null and this
     *                                  map does not permit null keys
     */
    V remove(K key);

    // Bulk Operations

    /**
     * Get a list containing each key and the associated value of this Map inside a Pair.
     * @return A MyList of Pairs
     */
    MyList<Pair<K, V>> getListOfKeysAndValues();

    /**
     * Copies all the mappings from the specified map to this map
     * (optional operation).  The effect of this call is equivalent to that
     * of calling {@link #put(Object, Object) put(k, v)} on this map once
     * for each mapping from key {@code k} to value {@code v} in the
     * specified map.  The behavior of this operation is undefined if the
     * specified map is modified while the operation is in progress.
     *
     * @param m mappings to be stored in this map
     * @throws NullPointerException     if the specified map is null, or if
     *                                  this map does not permit null keys or values, and the
     *                                  specified map contains null keys or values
     * @throws IllegalArgumentException if some property of a key or value in
     *                                  the specified map prevents it from being stored in this map
     */
    void putAll(MyMap<? extends K, ? extends V> m);

    /**
     * Removes all the mappings from this map (optional operation).
     * The map will be empty after this call returns.
     */
    void clear();


}
