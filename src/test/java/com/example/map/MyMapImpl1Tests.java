package com.example.map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MyMapImpl1Tests {


    static final Integer KPRIMERO = 1;
    static final Integer KSEGUNDO = 2;

    static final String VPRIMERO = "Hola, soy el primer elemento";
    static final String VSEGUNDO = "Hola, soy el segundo elemento";

    private MyMap<Integer, String> myMap;

    @BeforeEach
    public void setupBefore() {
        myMap = new MyMapImpl1<>();
    }

    @Test
    void createEmptyListOk() {
        assertEquals(0, myMap.size());
        assertTrue(myMap.isEmpty());
    }

    @Test
    void getElementOK() {
        myMap.put(KPRIMERO, VPRIMERO);
        assertEquals(1, myMap.size());
        assertEquals(VPRIMERO, myMap.get(KPRIMERO));
        assertTrue(myMap.containsKey(KPRIMERO) && myMap.containsValue(VPRIMERO));
    }

    @Test
    public void putNullKeyWhenExceptionThrown_thenAssertionSucceeds() {
        Exception exception = assertThrows(IllegalArgumentException.class, ()
                -> myMap.put(null, VPRIMERO));
        String expectedMessage = "The key can not be null.";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }


    @Test
    void putMultipleElementWithNullValue() {
        myMap.put(KPRIMERO, VPRIMERO);
        myMap.put(KSEGUNDO, null);
        assertEquals(2, myMap.size());
        assertEquals(VPRIMERO, myMap.get(KPRIMERO));
        assertNull(myMap.get(KSEGUNDO));
    }

    @Test
    void putMultipleElementOk() {
        myMap.put(KPRIMERO, VPRIMERO);
        myMap.put(KSEGUNDO, VSEGUNDO);
        assertEquals(2, myMap.size());
        assertEquals(VPRIMERO, myMap.get(KPRIMERO));
        assertEquals(VSEGUNDO, myMap.get(KSEGUNDO));
    }

    @Test
    void putMultipleElementOKWithFor() {
        for (int i = 0; i < 88; i++) {
            myMap.put(i + 1, "A" + i);
        }
        //Assert
        assertEquals(88, myMap.size());
    }

    @Test
    void putMultipleElementOKGrowth() {
        for (int i = 0; i < 100; i++) {
            myMap.put(i + 1, "00" + i);
        }
        //Assert
        assertEquals(100, myMap.size());
        System.out.println(myMap);
    }

    @Test
    void remove() {
        myMap.put(KPRIMERO, VPRIMERO);
        myMap.remove(KPRIMERO);
        assertTrue(myMap.isEmpty());
    }

    @Test
    public void removeNullKeywhenExceptionThrown_thenAssertionSucceeds() {
        Exception exception = assertThrows(IllegalArgumentException.class, ()
                -> myMap.remove(null));
        String expectedMessage = "The key can not be null.";
        String actualMessage = exception.getMessage();
        assertEquals(actualMessage, expectedMessage);
    }

    @Test
    public void removeInexistentKeywhenExceptionThrown_thenAssertionSucceeds() {
        Exception exception = assertThrows(IllegalArgumentException.class, ()
                -> myMap.remove(50));
        String expectedMessage = "The key is not present in this Map";
        String actualMessage = exception.getMessage();
        assertEquals(actualMessage, expectedMessage);
    }


//    @Test
//    void RemoveMultipleElementOK() {
//        prepareContextMultipleFile();
//        assertEquals(2, myMap.size());
//        assertTrue(myMap.contains(KPRIMERO, VPRIMERO));
//        assertTrue(myMap.contains(KSEGUNDO, VSEGUNDO));
//        myMap.remove(0);
//        assertEquals(1, myMap.size());
//        assertFalse(myMap.contains(KPRIMERO, VPRIMERO));
//    }

//
//    @Test
//    void RemoveAllOk() {
//        prepareContextMultipleFile();
//        assertEquals(2, myMap.size());
//        assertTrue(myMap.contains(KPRIMERO, VPRIMERO));
//        assertTrue(myMap.contains(KSEGUNDO, VSEGUNDO));
//        myMap.removeAll();
//        assertEquals(0, myMap.size());
//        assertFalse(myMap.contains(KPRIMERO, VPRIMERO));
//    }
//
//    @Test
//    void RemoveAllEmpty() {
//        myMap.removeAll();
//        assertEquals(0, myMap.size());
//        assertFalse(myMap.contains(KPRIMERO, VPRIMERO));
//    }
//


}
