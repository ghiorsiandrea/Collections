package com.example.queue;

import java.util.Arrays;
import java.util.Objects;

public class MyQueueImpl1<T> implements MyQueue<T> {

    private Object[] elements;
    private int position;

    public MyQueueImpl1() {
        this.elements = new Object[100];
        this.position = 0;
    }

    @Override
    public void add(T element) {
        if (position >= elements.length - 10) {
            growthElementArray();
        }
//        for (Object elem: elements) {
//            int counter = 0;
//            elements[counter] = elements[0];
//
//        }
        elements[position++] = element;
    }

    @Override
    /**
     * Gives the first element of the queue - top
     */
    public T peek() {
        return (T) elements[0];
    }

    @Override
    /**
     * Remove the first element of the queue - po
     */
    public T poll() {
        Object removed= elements[0];
        for (int i = 0; i < size(); i++) {
            elements[i] = elements[i+1];
        }
        String log = String.format("The element:  %s was removed", removed);
        System.out.println(log);
        position--;
        return (T) removed;
    }

    @Override
    public void removeAll() {
//        int size = size();
//        for (int i = 0; i < size; i++) {
//            poll();
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
