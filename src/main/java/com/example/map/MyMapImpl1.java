package com.example.map;

import com.example.list.MyList;
import com.example.list.MyListImpl1;

import java.util.Map;

public class MyMapImpl1<K, V> implements MyMap<K, V> {


    private final MyList<K> keys;

    private final MyList<V> values;

    public MyMapImpl1() {
        this.keys = new MyListImpl1<>();
        this.values = new MyListImpl1<>();
    }

    // Query Operations

    /**
     * Returns the number of key-value mappings in this map.  If the
     * map contains more than {@code Integer.MAX_VALUE} elements, returns
     * {@code Integer.MAX_VALUE}.
     * @return the number of key-value mappings in this map
     */
    @Override
    public int size() {
        int size = keys.size();
        if (size > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }
        return  size;
    }

    /**
     * Returns {@code true} if this map contains no key-value mappings.
     * @return {@code true} if this map contains no key-value mappings
     */
    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    /**
     * Returns {@code true} if this map contains a mapping for the
     * specified key.
     * @param   key   The key whose presence in this map is to be tested
     * @return {@code true} if this map contains a mapping for the specified
     * key.
     */
    @Override
    public boolean containsKey(K key) {
        return keys.contains(key);
    }

    /**
     * Returns {@code true} if this map maps one or more keys to the
     * specified value.
     * @param value value whose presence in this map is to be tested
     * @return {@code true} if this map maps one or more keys to the
     *         specified value
     */
    @Override
    public boolean containsValue(V value) {
        return values.contains(value);
    }

    /**
     * {@inheritDoc}
     *
     * @implSpec
     * This implementation iterates over {@code entrySet()} searching
     * for an entry with the specified key.  If such an entry is found,
     * the entry's value is returned.  If the iteration terminates without
     * finding such an entry, {@code null} is returned.
     *
     * @throws ClassCastException            {@inheritDoc}
     * @throws NullPointerException          {@inheritDoc}
     */
    @Override
    public V get(Object key) {
        return null;
    }

    @Override
    public V put(K key, V value) {
        //if (Optional.ofNullable(key).isEmpty() && Optional.ofNullable(value).isEmpty()); {
        //           //Optional.class.myMap.(key, value);
        //       }
        return null;
    }

    @Override
    public V remove(Object key) {
        return null;
    }

    @Override
    public void putAll(MyMap<? extends K, ? extends V> m) {

    }

    @Override
    public void clear() {

    }


}
