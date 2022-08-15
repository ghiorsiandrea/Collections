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
    void givenDefaultQueue_WhenCreateEmptyQueue_ThenAssertionSucceeds() {
        assertEquals(0, myQueue.size());
    }

    @Test
    void givenAnEmptyQueue_WhenAddElement_ThenElementIsInTheQueue() {
        myQueue.add(PRIMERO);
        assertEquals(1, myQueue.size());
        assertTrue(myQueue.contains(PRIMERO));
    }

    @Test
    void givenAnEmptyQueue_WhenAddTwoElements_ThenElementsAreInTheQueue() {
        givenAnEmptyQueue_ThenPrepareContextTestsWithTwoFile_Success();
        //Assert
        assertEquals(2, myQueue.size());
        assertTrue(myQueue.contains(PRIMERO));
        assertTrue(myQueue.contains(SEGUNDO));
    }

    @ParameterizedTest
    @ValueSource(ints = { 88, 100, 120 })
    void givenAnEmptyQueue_WhenAddIElementsWithFor_ThenElementsAreInTheQueue(int length) {
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
    void givenAnEmptyQueue_WhenAddElementsAndPeek_ThenAssertionSucceeds() {
        givenAnEmptyQueue_ThenPrepareContextTestsWithTwoFile_Success();

        assertEquals(PRIMERO, myQueue.peek());
    }

    @Test
    void givenAnEmptyQueue_WhenAddElementsAndPoll_ThenAssertionSucceeds() {
        givenAnEmptyQueue_ThenPrepareContextTestsWithTwoFile_Success();

        String actual = myQueue.poll();

        assertEquals(1, myQueue.size());
        assertFalse(myQueue.contains(PRIMERO));
        assertEquals(PRIMERO, actual);
    }

    @Test
    void givenAnEmptyQueue_WhenAddTwoElementsPollAndAdd_ThenAssertionSucceeds() {
        givenAnEmptyQueue_ThenPrepareContextTestsWithTwoFile_Success();

        String actual = myQueue.poll();

        assertEquals(1, myQueue.size());
        assertFalse(myQueue.contains(PRIMERO));
        assertEquals(PRIMERO, actual);

        myQueue.add(PRIMERO);

        assertTrue(myQueue.contains(PRIMERO));
    }

    @Test
    void givenAnEmptyQueue_WhenAddTreeElementsPollAndAdd_ThenAssertionSucceeds() {
        givenAnEmptyQueue_ThenPrepareContextTestsWithTwoFile_Success();
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
//        assertTrue(myQueue.contains(PRIMERO));
    }

    @Test
    void givenAQueueWithTwoElements_WhenRemoveAll_ThenTheQueueIsEmpty() {
        givenAnEmptyQueue_ThenPrepareContextTestsWithTwoFile_Success();

        myQueue.removeAll();

        assertEquals(0, myQueue.size());
        assertFalse(myQueue.contains(PRIMERO));
    }

    @Test
    void givenAnEmptyQueue_WhenRemoveAll_ThenTheQueueIsStillEmptyAndNotThrowsException() {
        myQueue.removeAll();

        assertEquals(0, myQueue.size());
        assertFalse(myQueue.contains(PRIMERO));
    }

    void givenAnEmptyQueue_ThenPrepareContextTestsWithTwoFile_Success() {
        myQueue.add(PRIMERO);
        myQueue.add(SEGUNDO);
    }

    void givenAnEmptyQueue_ThenPrepareContextTestsWithTreeFile_Success() {
        myQueue.add(PRIMERO);
        myQueue.add(SEGUNDO);
        myQueue.add(TERCERO);
    }
}
