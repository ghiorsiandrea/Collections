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
    void givenDefaultList_WhenCreateEmptyList_ThenAssertionSucceeds() {
        assertEquals(0, myStack.size());
    }

    @Test
    void givenAnEmptyList_WhenAddElement_ThenElementIsInTheList() {
        myStack.add(PRIMERO);
        assertEquals(1, myStack.size());
        assertTrue(myStack.contains(PRIMERO));
    }

    @Test
    void givenAnEmptyList_WhenAddTwoElements_ThenElementsAreInTheList() {
        prepareContextTestsWithTwoFile();
        //Assert
        assertEquals(2, myStack.size());
        assertTrue(myStack.contains(PRIMERO));
        assertTrue(myStack.contains(SEGUNDO));
    }

    @ParameterizedTest
    @ValueSource(ints = {88, 100, 120})
    void givenAnEmptyList_WhenAddIElementsWithFor_ThenElementsAreInTheList(int length) {
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
    void givenAnEmptyStack_WhenAddElementsAndTop_ThenAssertionSucceeds() {
        prepareContextTestsWithTwoFile();

        assertEquals(SEGUNDO, myStack.top());
    }

    @Test
    void givenAnEmptyStack_WhenAddElementsAndPop_ThenAssertionSucceeds() {
        prepareContextTestsWithTwoFile();

        String actual = myStack.pop();

        assertEquals(1, myStack.size());
        assertFalse(myStack.contains(SEGUNDO));
        assertEquals(SEGUNDO, actual);
    }

    @Test
    void givenAnEmptyStack_WhenAddTwoElementsPopAndAdd_ThenAssertionSucceeds() {
        prepareContextTestsWithTwoFile();

        String actual = myStack.pop();

        assertEquals(1, myStack.size());
        assertFalse(myStack.contains(SEGUNDO));
        assertEquals(SEGUNDO, actual);

        myStack.add(SEGUNDO);

        assertTrue(myStack.contains(SEGUNDO));
    }

    @Test
    void givenAnEmptyStack_WhenAddTreeElementsPopAndAdd_ThenAssertionSucceeds() {
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
    void givenAStackWithTwoElements_WhenRemoveAll_ThenTheStackIsEmpty() {
        prepareContextTestsWithTwoFile();

        myStack.removeAll();

        assertEquals(0, myStack.size());
        assertFalse(myStack.contains(PRIMERO));
    }

    @Test
    void givenAnEmptyStack_WhenRemoveAll_ThenTheStackIsStillEmptyAndNotThrowsException() {
        myStack.removeAll();

        assertEquals(0, myStack.size());
        assertFalse(myStack.contains(PRIMERO));
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
