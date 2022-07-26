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

    // ......................................................................................

    @Override
    public int size() {
        return keys.size() ;
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
    public void putAll(MyMap<? extends K, ? extends V> m) {

    }

    @Override
    public void clear() {

    }


}
