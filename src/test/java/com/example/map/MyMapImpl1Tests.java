package com.example.map;

import com.example.list.MyListImpl1;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MyMapImpl1Tests {


    static final Integer KPRIMERO = 1;
    static final Integer KSEGUNDO = 2;
    static final Integer KTERCERO = 3;

    static final String VPRIMERO = "Hola, soy el primer elemento";
    static final String VSEGUNDO = "Hola, soy el segundo elemento";
    static final String VTERCERO = "Hola, soy el tercer elemento";

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
    }

    @Test
    public void whenExceptionThrown_thenAssertionSucceedsNullElement() {
        Exception exception = assertThrows(IllegalArgumentException.class, ()
                -> myMap.put(null, VPRIMERO));

        String expectedMessage = "The key can not be null.";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }


    @Test
    void addMultipleElementWithNullValue() {
        myMap.put(KPRIMERO, VPRIMERO);
        myMap.put(KSEGUNDO, null);
        assertEquals(2, myMap.size());
        assertEquals(VPRIMERO, myMap.get(KPRIMERO));
        assertEquals(null, myMap.get(KSEGUNDO));
    }


    @Test
    void addMultipleElementOKWithFor() {
        for (int i = 0; i < 88; i++) {
            myMap.put(i+1, "A" + i);
        }
        //Assert
        assertEquals(88, myMap.size());
        System.out.println(myMap);
    }

    @Test
    void addMultipleElementOKGrowth() {
        for (int i = 0; i < 100; i++) {
            myMap.put(i+1, "A" + i);
        }
        //Assert
        assertEquals(100, myMap.size());
        System.out.println(myMap);
    }
//
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
//    void RemoveMultipleElementError() {
//        prepareContextMultipleFile();
//        assertEquals(2, myMap.size());
//        assertTrue(myMap.contains(KPRIMERO, VPRIMERO));
//        assertTrue(myMap.contains(KSEGUNDO, VSEGUNDO));
//        myMap.remove(0);
//        assertNotEquals(2, myMap.size());
//        assertFalse(myMap.contains(KPRIMERO, VPRIMERO));
//    }
//
//    @Test
//    void RemoveMultipleElementChangingState() {
//        prepareContextMultipleFile();
//        assertEquals(2, myMap.size());
//        assertTrue(myMap.contains(KPRIMERO, VPRIMERO));
//        assertTrue(myMap.contains(KSEGUNDO, VSEGUNDO));
//        myMap.remove(0);
//        assertEquals(1, myMap.size());
//        assertFalse(myMap.contains(KPRIMERO, VPRIMERO));
//        prepareContextSingleFile();
//        assertTrue(myMap.contains(KPRIMERO, VPRIMERO));
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
