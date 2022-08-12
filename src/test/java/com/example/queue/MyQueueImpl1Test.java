package com.example.queue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class MyQueueImpl1Test {

    static final String PRIMERO = "Hola, soy el primer elemento";
    static final String SEGUNDO = "Hola, soy el segundo elemento";
    static final String TERCERO = "Hola, soy el tercer elemento";

    private MyQueue<String> myQueue;

    @BeforeEach
    public void setupBefore() {
        myQueue = new MyQueueImpl1<>();
    }

    @Test
    void createEmptyListOk() {
        assertEquals(0, myQueue.size());
    }

    @Test
    void addElementOK() {
        prepareContextTestsWithASingleFile();
        assertEquals(1, myQueue.size());
        assertTrue(myQueue.contains(PRIMERO));
    }

    @Test
    void addMultipleElementOK() {
        prepareContextTestsWithTwoElements();
        //Assert
        assertEquals(2, myQueue.size());
        assertTrue(myQueue.contains(PRIMERO));
        assertTrue(myQueue.contains(SEGUNDO));
    }

    @ParameterizedTest
    @ValueSource(ints = { 88, 100, 120 })
    void addMultipleElementWithGrowth_Ok(int length) {
        for (int i = 0; i < length; i++) {
            myQueue.add("A" + i);
        }
        //Assert
        assertEquals(length, myQueue.size());
        for (int i = 0; i < length; i++) {
            assertTrue(myQueue.contains("A" + i));
        }
    }

    @Test
    void peekOk() {
        prepareContextTestsWithTwoElements();

        assertEquals(PRIMERO, myQueue.peek());
    }

    @Test
    void pollOK() {
        prepareContextTestsWithTwoElements();

        String actual = myQueue.poll();

        assertEquals(1, myQueue.size());
        assertFalse(myQueue.contains(PRIMERO));
        assertEquals(PRIMERO, actual);
    }

    @Test
    void given_ChangingStateTwoFiles_pollOk() {
        prepareContextTestsWithTwoElements();

        String actual = myQueue.poll();

        assertEquals(1, myQueue.size());
        assertFalse(myQueue.contains(PRIMERO));
        assertEquals(PRIMERO, actual);

        myQueue.add(PRIMERO);

        assertTrue(myQueue.contains(PRIMERO));
    }

    @Test
    void given_ChangingStateTreeFiles_PopOk() {
        prepareContextTestsWithTreeFile();
        assertEquals(3, myQueue.size());
        assertTrue(myQueue.contains(PRIMERO));
        assertTrue(myQueue.contains(SEGUNDO));
        assertTrue(myQueue.contains(TERCERO));

        String actual = myQueue.poll();

        assertEquals(2, myQueue.size());
        assertFalse(myQueue.contains(PRIMERO));
        assertEquals(PRIMERO, actual);

        String actual2 = myQueue.poll();

        assertEquals(1, myQueue.size());
        assertFalse(myQueue.contains(SEGUNDO));
        assertEquals(SEGUNDO, actual2);

//        myQueue.add(PRIMERO);
//
//        assertTrue(myQueue.contains(PRIMERO));
    }

    @Test
    void removeAllOk() {
        prepareContextTestsWithTwoElements();

        myQueue.removeAll();

        assertEquals(0, myQueue.size());
        assertFalse(myQueue.contains(PRIMERO));
    }

    @Test
    void given_AnEmptyQueue_RemoveAllOk() {
        myQueue.removeAll();

        assertEquals(0, myQueue.size());
        assertFalse(myQueue.contains(PRIMERO));
    }

    void prepareContextTestsWithASingleFile() {
        myQueue.add(PRIMERO);
    }

    void prepareContextTestsWithTwoElements() {
        myQueue.add(PRIMERO);
        myQueue.add(SEGUNDO);
    }

    void prepareContextTestsWithTreeFile() {
        myQueue.add(PRIMERO);
        myQueue.add(SEGUNDO);
        myQueue.add(TERCERO);
    }
}
