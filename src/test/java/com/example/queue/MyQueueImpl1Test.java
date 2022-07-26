package com.example.queue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class MyQueueImpl1Test {

    static final String PRIMERO = "Hola, soy el primero";
    static final String SEGUNDO = "Hola, soy el 2";

    static final String TERCERO = "Hola, soy el 3 LCDTM";

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
        prepareContextSingleFile();
        assertEquals(1, myQueue.size());
        assertTrue(myQueue.contains(PRIMERO));
    }

    @Test
    void addMultipleElementOK() {
        prepareContextTwoElements();
        //Assert
        assertEquals(2, myQueue.size());
        assertTrue(myQueue.contains(PRIMERO));
        assertTrue(myQueue.contains(SEGUNDO));
    }

    @ParameterizedTest
    @ValueSource(ints = { 88, 100, 120 })
    void addMultipleElementOKGrowth(int length) {
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
        prepareContextTwoElements();

        assertEquals(PRIMERO, myQueue.peek());
    }

    @Test
    void pollOK() {
        prepareContextTwoElements();

        String actual = myQueue.poll();

        assertEquals(1, myQueue.size());
        assertFalse(myQueue.contains(PRIMERO));
        assertEquals(PRIMERO, actual);
    }

    @Test
    void pollChangingStateTwoFiles() {
        prepareContextTwoElements();

        String actual = myQueue.poll();

        assertEquals(1, myQueue.size());
        assertFalse(myQueue.contains(PRIMERO));
        assertEquals(PRIMERO, actual);

        myQueue.add(PRIMERO);

        assertTrue(myQueue.contains(PRIMERO));
    }

    @Test
    void popChangingStateTreeFiles() {
        prepareContextTreeFile();
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
    void RemoveAllOk() {
        prepareContextTwoElements();

        myQueue.removeAll();

        assertEquals(0, myQueue.size());
        assertFalse(myQueue.contains(PRIMERO));
    }

    @Test
    void RemoveAllEmpty() {
        myQueue.removeAll();

        assertEquals(0, myQueue.size());
        assertFalse(myQueue.contains(PRIMERO));
    }

    void prepareContextSingleFile() {
        myQueue.add(PRIMERO);
    }

    void prepareContextTwoElements() {
        myQueue.add(PRIMERO);
        myQueue.add(SEGUNDO);
    }

    void prepareContextTreeFile() {
        myQueue.add(PRIMERO);
        myQueue.add(SEGUNDO);
        myQueue.add(TERCERO);
    }
}
