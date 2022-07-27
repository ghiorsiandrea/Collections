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

    static final String VPRIMERO = "Hola, soy el primero";
    static final String VSEGUNDO = "Hola, soy el 2";
    static final String VTERCERO = "Hola, soy el 3 LCDTM";

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

//    @Test
//    void addElementOK() {
//        prepareContextSingleFile();
//        assertEquals(1, myMap.size());
//        assertTrue(myMap.contains(PRIMERO));
//    }
//
//    @Test
//    void addElementErrorSize() {
//        prepareContextSingleFile();
//        assertNotEquals(2, myMap.size());
//        assertTrue(myMap.contains(PRIMERO));
//    }
//
//    @Test
//    void addElementErrorContains() {
//        prepareContextSingleFile();
//        assertEquals(1, myMap.size());
//        assertFalse(myMap.contains("A"));
//    }
//
//    @Test
//    void addMultipleElementOK() {
//        prepareContextMultipleFile();
//        //Assert
//        assertEquals(2, myMap.size());
//        assertTrue(myMap.contains(PRIMERO));
//        assertTrue(myMap.contains(SEGUNDO));
//    }
//
//    @Test
//    void addMUltipleElementErrorSize() {
//        prepareContextMultipleFile();
//        //Assert
//        assertNotEquals(3, myMap.size());
//        assertTrue(myMap.contains(PRIMERO));
//        assertTrue(myMap.contains(SEGUNDO));
//    }
//
//    @Test
//    void addMUltipleElementErrorContains() {
//        prepareContextMultipleFile();
//        //Assert
//        assertEquals(2, myMap.size());
//        assertTrue(myMap.contains(PRIMERO));
//        assertTrue(myMap.contains(SEGUNDO));
//        assertFalse(myMap.contains("aaaa"));
//    }
//
//    @Test
//    void addMultipleElementOKWithFor() {
//        for (int i = 0; i < 88; i++) {
//            myMap.add("A" + i);
//        }
//        //Assert
//        assertEquals(88, myMap.size());
//        System.out.println(myMap);
//    }
//
//    @Test
//    void addMultipleElementOKGrowth() {
//        for (int i = 0; i < 100; i++) {
//            myMap.add("A" + i);
//        }
//        //Assert
//        assertEquals(100, myMap.size());
//        System.out.println(myMap);
//    }
//
//    @Test
//    void RemoveMultipleElementOK() {
//        prepareContextMultipleFile();
//        assertEquals(2, myMap.size());
//        assertTrue(myMap.contains(PRIMERO));
//        assertTrue(myMap.contains(SEGUNDO));
//        myMap.remove(0);
//        assertEquals(1, myMap.size());
//        assertFalse(myMap.contains(PRIMERO));
//    }
//
//    @Test
//    void RemoveMultipleElementError() {
//        prepareContextMultipleFile();
//        assertEquals(2, myMap.size());
//        assertTrue(myMap.contains(PRIMERO));
//        assertTrue(myMap.contains(SEGUNDO));
//        myMap.remove(0);
//        assertNotEquals(2, myMap.size());
//        assertFalse(myMap.contains(PRIMERO));
//    }
//
//    @Test
//    void RemoveMultipleElementChangingState() {
//        prepareContextMultipleFile();
//        assertEquals(2, myMap.size());
//        assertTrue(myMap.contains(PRIMERO));
//        assertTrue(myMap.contains(SEGUNDO));
//        myMap.remove(0);
//        assertEquals(1, myMap.size());
//        assertFalse(myMap.contains(PRIMERO));
//        prepareContextSingleFile();
//        assertTrue(myMap.contains(PRIMERO));
//    }
//
//    @Test
//    void RemoveAllOk() {
//        prepareContextMultipleFile();
//        assertEquals(2, myMap.size());
//        assertTrue(myMap.contains(PRIMERO));
//        assertTrue(myMap.contains(SEGUNDO));
//        myMap.removeAll();
//        assertEquals(0, myMap.size());
//        assertFalse(myMap.contains(PRIMERO));
//    }
//
//    @Test
//    void RemoveAllEmpty() {
//        myMap.removeAll();
//        assertEquals(0, myMap.size());
//        assertFalse(myMap.contains(PRIMERO));
//    }
//
//    @Test
//    public void whenExceptionThrown_thenAssertionSucceedsINexistentElement() {
//        int prueba = 50;
//        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
//            myMap.remove(prueba);
//        });
//
//        String expectedMessage = String.format("There is no element into %s", prueba);
//        String actualMessage = exception.getMessage();
//
//        assertTrue(actualMessage.contains(expectedMessage));
//    }
//
//    @Test
//    public void whenExceptionThrown_thenAssertionSucceedsNegativeElement() {
//        int prueba = -100;
//        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
//            myMap.remove(prueba);
//        });
//
//        String expectedMessage = "The position can not be negative";
//        String actualMessage = exception.getMessage();
//
//        assertTrue(actualMessage.contains(expectedMessage));
//    }
//
//    void prepareContextSingleFile() {
//        myMap.add(PRIMERO);
//    }
//
//    void prepareContextMultipleFile() {
//        myMap.add(PRIMERO);
//        myMap.add(SEGUNDO);
//    }

}
