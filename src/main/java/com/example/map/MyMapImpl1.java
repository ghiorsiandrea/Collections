package com.example.map;
import java.util.Map;
import java.util.Optional;

public class MyMapImpl1<K, V> implements MyMap<K, V> {
//(Objects.equals(PRIMERO, myQueue.peek())

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean containsKey(Object key) {
        return false;
    }

    @Override
    public boolean containsValue(Object value) {
        return false;
    }

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
    public void putAll(Map<? extends K, ? extends V> m) {

    }

    @Override
    public void clear() {

    }




}
