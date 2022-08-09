package com.example.list;

import java.util.Arrays;
import java.util.Objects;

public class MyListImpl1<T> implements MyList<T> {

    private Object[] elements;
    private int position;

    public MyListImpl1() {
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

    @Override
    public void remove(int pos) {
        validatePosition(pos);

        for (int i = pos + 1; i < position; i++) {
            elements[i - 1] = elements[i];
        }
        position--;
    }

    @Override
    public void removeAll() {
        position = 0;
        for (int i = 0; i < position; i++) {
            remove(i);
        }
    }

    @Override
    public T get(int pos) {
        validatePosition(pos);
        return (T) elements[pos];
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

    private void validatePosition(int pos) {
        if (pos >= position) {
            throw new IllegalArgumentException(String.format("There is no element into %s", pos));
        }
        if (pos < 0) {
            throw new IllegalArgumentException("The position can not be negative");
        }
    }

    @Override
    public String toString() {
        return "MyListImpl1{" +
                "elements=" + "\n" + Arrays.toString(elements) + ",\n" +
                "position = " + position +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (!(o instanceof MyList<?>)) {
            return false;
        }

        MyList<?> myList = (MyList<?>) o;
        if (myList.size()!= this.size()) {
            return false;
        }
        for (int i = 0; i < size(); i++) {
            Object t = myList.get(i);
            Object t2 = this.get(i);
            if (!Objects.equals(t, t2)) {
                return false;
            }
        }
        return true;
    }
}
