package com.example.map;

import com.example.list.MyList;
import com.example.list.MyListImpl1;
import com.example.util.MyPair;

import java.util.Objects;

public class MyMapImpl1<K, V> implements MyMap<K, V> {

    //Not thread safe
    private final MyList<K> keys;

    private final MyList<V> values;

    public MyMapImpl1() {
        this.keys = new MyListImpl1<>();
        this.values = new MyListImpl1<>();
    }

    // Query Operations

    @Override
    public int size() {
        return keys.size();
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public boolean containsKey(K key) {
        return keys.contains(key);
    }

    @Override
    public boolean containsValue(V value) {
        return values.contains(value);
    }

    @Override
    public V get(K key) {

        if (Objects.isNull(key)) {
            throw new IllegalArgumentException("The key can not be null.");
        }

        V value = null;
        for (int i = 0; i < keys.size(); i++) {
            K keyI = keys.get(i);
            if (key.equals(keyI)) {
                value = values.get(i);
            }
        }

        return value;
    }

    // Modification Operations

    @Override
    public V put(K key, V value) {

        V oldValue = get(key);
        keys.add(key);
        values.add(value);
        return oldValue;
    }

    @Override
    public V remove(K key) {
        if (key == null) {
            throw new IllegalArgumentException("The key can not be null.");
        }
        if (!containsKey(key)) {
            throw new IllegalArgumentException("The key is not present in this Map");
        }
        V vRemoved = get(key);
        int iRemoved;
        for (int i = 0; i < keys.size(); i++) {
            K keyI = keys.get(i);
            if (key.equals(keyI)) {
                iRemoved = i;
                keys.remove(iRemoved);
                values.remove(iRemoved);
            }
        }
        return vRemoved;
    }

    // Bulk Operations
    @Override
    public MyList<MyPair<K, V>> getListOfKeysAndValues() {
        MyList<MyPair<K, V>> result = new MyListImpl1<>();

        for (int i = 0; i < keys.size(); i++) {
            K key = keys.get(i);
            V value = values.get(i);
            MyPair<K, V> newMyPair = new MyPair<>(key, value);
            result.add(newMyPair);
        }

        return result;
    }

    /**
     * Copies all the mappings from the specified map to this map
     * (optional operation).  The effect of this call is equivalent to that
     * of calling {@link #put(Object, Object) put(k, v)} on this map once
     * for each mapping from key {@code k} to value {@code v} in the
     * specified map.
     * The behavior of this operation is undefined if the specified map is
     * modified while the operation is in progress == (Not thread safe).
     *
     * @param m mappings to be stored in this map
     * @throws NullPointerException     if the specified map is null, or if
     *                                  this map does not permit null keys or values, and the
     *                                  specified map contains null keys or values
     * @throws IllegalArgumentException if some property of a key or value in
     *                                  the specified map prevents it from being stored in this map
     */
    @Override
    public void putAll(MyMap<? extends K, ? extends V> m) {
        MyList<? extends MyPair<? extends K, ? extends V>> myListOfPair = m.getListOfKeysAndValues();

        for (int i = 0; i < myListOfPair.size(); i++) {
            MyPair<? extends K, ? extends V> myPair = myListOfPair.get(i);
            K key = myPair.getLeft();
            V value = myPair.getRight();
            put(key, value);
        }
    }

    /**
     * Removes all the mappings from this map (optional operation).
     * The map will be empty after this call returns.
     */
    @Override
    public void clear() {
        keys.removeAll();
        values.removeAll();

    }

    /**
     * Compares the specified object with this entry for equality.
     * Returns {@code true} if the given object is also a map entry and
     * the two entries represent the same mapping.  More formally, two
     * entries {@code e1} and {@code e2} represent the same mapping
     * if<pre>
     *     (e1.getKey()==null ?
     *      e2.getKey()==null : e1.getKey().equals(e2.getKey()))  &amp;&amp;
     *     (e1.getValue()==null ?
     *      e2.getValue()==null : e1.getValue().equals(e2.getValue()))
     * </pre>
     * This ensures that the {@code equals} method works properly across
     * different implementations of the {@code Map.Entry} interface.
     *
     * @param o object to be compared for equality with this map entry
     * @return {@code true} if the specified object is equal to this map
     * entry
     */
    @Override
    public boolean equals(Object o) {
        return (this == o);
    }

    @Override
    public String toString() {

        StringBuilder result = new StringBuilder("MyMapImpl1 {\n");
        for (int i = 0; i < size(); i++) {
            result.append(getKeyAndValueLine(keys.get(i).toString(), values.get(i).toString()));
        }
        result.append("}\n");
        return result.toString();
    }

    private String getKeyAndValueLine(String key, String value) {
        int length = getSizeOfLongerString();
        String formattedKey = key + " ".repeat(Math.max(0, length - (key.length() - 1)));

        return "  " + formattedKey + "  " + value + " ".repeat(Math.max(0, length - (value.length() - 1))) + "\n";
    }

    private int getSizeOfLongerString() {
        int max = 0;
        for (int i = 0; i < size(); i++) {
            int keyLength = keys.get(i).toString().length();
            int valueLength = values.get(i).toString().length();

            if (keyLength > max) max = keyLength;
            if (valueLength > max) max = valueLength;
        }

        return max;
    }

}
