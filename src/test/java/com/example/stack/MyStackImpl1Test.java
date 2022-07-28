package com.example.stack;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

public class MyStackImpl1Test {

    static final String PRIMERO = "Hola, soy el primer elemento";
    static final String SEGUNDO = "Hola, soy el segundo elemento";
    static final String TERCERO = "Hola, soy el tercer elemento";
    MyStack<String> myStack;

    @BeforeEach
    public void setupBefore() {
        myStack = new MyStackImpl1<>();
    }

    @Test
    void createEmptyListOk() {
        assertEquals(0, myStack.size());
    }

    @Test
    void addElementOK() {
        prepareContextSingleFile();
        assertEquals(1, myStack.size());
        assertTrue(myStack.contains(PRIMERO));
    }

    @Test
    void addMultipleElementOK() {
        prepareContextTwoFile();
        //Assert
        assertEquals(2, myStack.size());
        assertTrue(myStack.contains(PRIMERO));
        assertTrue(myStack.contains(SEGUNDO));
    }

    @ParameterizedTest
    @ValueSource(ints = {88, 100, 120})
    void addMultipleElementOKWithFor(int length) {
        for (int i = 0; i < length; i++) {
            myStack.add("A" + i);
        }
        //Assert
        assertEquals(length, myStack.size());
        for (int i = 0; i < length; i++) {
            assertTrue(myStack.contains("A" + i));
        }
    }

    @Test
    void topOk() {
        prepareContextTwoFile();

        assertEquals(SEGUNDO, myStack.top());
    }

    @Test
    void popOK() {
        prepareContextTwoFile();

        String actual = myStack.pop();

        assertEquals(1, myStack.size());
        assertFalse(myStack.contains(SEGUNDO));
        assertEquals(SEGUNDO, actual);
    }

    @Test
    void popChangingStateTwoFiles() {
        prepareContextTwoFile();

        String actual = myStack.pop();

        assertEquals(1, myStack.size());
        assertFalse(myStack.contains(SEGUNDO));
        assertEquals(SEGUNDO, actual);

        myStack.add(SEGUNDO);

        assertTrue(myStack.contains(SEGUNDO));
    }

    @Test
    void popChangingStateTreeFiles() {
        prepareContextTreeFile();
        assertEquals(3, myStack.size());
        assertTrue(myStack.contains(PRIMERO));
        assertTrue(myStack.contains(SEGUNDO));
        assertTrue(myStack.contains(TERCERO));
        myStack.pop();
        assertEquals(2, myStack.size());
        assertFalse(myStack.contains(TERCERO));
        myStack.add(TERCERO);
        assertTrue(myStack.contains(TERCERO));
    }

    @Test
    void RemoveAllOk() {
        prepareContextTwoFile();

        myStack.removeAll();

        assertEquals(0, myStack.size());
        assertFalse(myStack.contains(PRIMERO));
    }

    @Test
    void RemoveAllEmpty() {
        myStack.removeAll();

        assertEquals(0, myStack.size());
        assertFalse(myStack.contains(PRIMERO));
    }

    void prepareContextSingleFile() {
        myStack.add(PRIMERO);
    }

    void prepareContextTwoFile() {
        myStack.add(PRIMERO);
        myStack.add(SEGUNDO);
    }

    void prepareContextTreeFile() {
        myStack.add(PRIMERO);
        myStack.add(SEGUNDO);
        myStack.add(TERCERO);
    }
}
