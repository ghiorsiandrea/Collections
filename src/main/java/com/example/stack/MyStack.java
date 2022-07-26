package com.example.stack;

public interface MyStack<T> {

    void add(T element);

    void removeAll();

    /**
     * Gives the last element of the pila
     */
    T top();

    /**
     * Remove the last element of the pila
     */
    T pop();

    int size();

    boolean contains(T element);
}
