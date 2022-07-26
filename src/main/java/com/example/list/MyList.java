package com.example.list;

public interface MyList<T> {

    void add(T element);

    void remove(int position);

    void removeAll();

    T get(int position);

    int size();

    boolean contains(T element);

}
