package com.example.queue;

public interface MyQueue<T>{

    void add(T element);

    /**
     * Gives the first element of the pila
     */
    T peek();

    /**
     * Remove the first element of the pila
     */
    T poll();

    void removeAll();

    int size();

    boolean contains(T element);
}
