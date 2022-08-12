package com.example.stack;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

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
        prepareContextTestsWithASingleFile();
        assertEquals(1, myStack.size());
        assertTrue(myStack.contains(PRIMERO));
    }

    @Test
    void addMultipleElementOK() {
        prepareContextTestsWithTwoFile();
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
    void top_Ok() {
        prepareContextTestsWithTwoFile();

        assertEquals(SEGUNDO, myStack.top());
    }

    @Test
    void pop_OK() {
        prepareContextTestsWithTwoFile();

        String actual = myStack.pop();

        assertEquals(1, myStack.size());
        assertFalse(myStack.contains(SEGUNDO));
        assertEquals(SEGUNDO, actual);
    }

    @Test
    void given_ChangingStateTwoFiles_ReturnsPopOk() {
        prepareContextTestsWithTwoFile();

        String actual = myStack.pop();

        assertEquals(1, myStack.size());
        assertFalse(myStack.contains(SEGUNDO));
        assertEquals(SEGUNDO, actual);

        myStack.add(SEGUNDO);

        assertTrue(myStack.contains(SEGUNDO));
    }

    @Test
    void given_ChangingStateTreeFiles_ReturnsPopOK() {
        prepareContextTestsWithTreeFile();
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
    void given_AStack_RemoveAllOk() {
        prepareContextTestsWithTwoFile();

        myStack.removeAll();

        assertEquals(0, myStack.size());
        assertFalse(myStack.contains(PRIMERO));
    }

    @Test
    void given_anEmptyStack_RemoveAllOk() {
        myStack.removeAll();

        assertEquals(0, myStack.size());
        assertFalse(myStack.contains(PRIMERO));
    }

    void prepareContextTestsWithASingleFile() {
        myStack.add(PRIMERO);
    }

    void prepareContextTestsWithTwoFile() {
        myStack.add(PRIMERO);
        myStack.add(SEGUNDO);
    }

    void prepareContextTestsWithTreeFile() {
        myStack.add(PRIMERO);
        myStack.add(SEGUNDO);
        myStack.add(TERCERO);
    }
}
