package com.example.stack;

import java.util.Arrays;
import java.util.Objects;

public class MyStackImpl1<T> implements MyStack<T> {

    private Object[] elements;
    private int position;

    public MyStackImpl1() {
        this.elements = new Object[100];
        this.position = 0;
    }

    @Override
    public void add(T element) {
        if (position >= elements.length - 10) {
            growthElementArray();
        }
        elements[position++] = element;
    }


    /**
     * Gives the last element of the pila
     */
    @Override
    public T top() {
        return (T) elements[position - 1];
    }

    /**
     * Remove the last element of the pila
     */
    @Override
    public T pop() {
        String log = String.format("The position %s was removed", position-1);
        System.out.println(log);
        return (T) elements[--position];
    }

    @Override
    public void removeAll() {
//        int size = size();
//        for (int i = 0; i < size; i++) {
//            pop();
//        }
        position = 0;
    }

    @Override
    public int size() {
        return position;
    }

    @Override
    public boolean contains(T element) {
        for (int i = 0; i < position; i++) {
            Object[] elem = elements;
            if (Objects.equals(elem[i], element)) {
                return true;
            }
        }
        return false;
    }

    private void growthElementArray() {
        Object[] newBiggerArray = new Object[elements.length * 2];
        for (int i = 0; i < position; i++) {
            newBiggerArray[i] = elements[i];
        }
        this.elements = newBiggerArray;
    }


    @Override
    public String toString() {
        return "MyListImpl1{" +
                "elements=" + "\n" + Arrays.toString(elements) + ",\n" +
                "position = " + position +
                '}';
    }
}
