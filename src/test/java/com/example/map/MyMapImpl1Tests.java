package com.example.map;

import com.example.list.MyList;
import com.example.list.MyListImpl1;
import com.example.util.MyPair;
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
    public void putNullKey_WhenExceptionThrown_thenAssertionSucceeds() {
        Exception exception = assertThrows(IllegalArgumentException.class, ()
                -> myMap.put(null, VPRIMERO));
        String expectedMessage = "The key can not be null.";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }


    @Test
    void given_AnEntryWithNullValue_putMultipleElementOk() {
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
    void putMultipleElementWithFor_Ok() {
        for (int i = 0; i < 88; i++) {
            myMap.put(i + 1, "A" + i);
        }
        //Assert
        assertEquals(88, myMap.size());
    }

    @Test
    void putMultipleElementWithGrowth_Ok() {
        for (int i = 0; i < 100; i++) {
            myMap.put(i + 1, "00" + i);
        }
        //Assert
        assertEquals(100, myMap.size());
        System.out.println(myMap);
    }

    @Test
    void remove_Ok() {
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


    @Test
    void clearOk() {
        myMap.put(KPRIMERO, VPRIMERO);
        myMap.put(KSEGUNDO, VSEGUNDO);
        myMap.clear();
        assertEquals(0, myMap.size());
        assertFalse(myMap.containsKey(KPRIMERO));

    }

    @Test
    void given_AnEmptyMap_ClearOk() {
        myMap.clear();
        assertEquals(0, myMap.size());
        assertFalse(myMap.containsKey(KPRIMERO));
    }

    @Test
    void given_AMap_getPairOfKeysAndValues_Ok() {
        myMap.put(KPRIMERO, VPRIMERO);
        myMap.put(KSEGUNDO, VSEGUNDO);
        MyList<MyPair<Integer, String>> expected = new MyListImpl1<>();
        expected.add(new MyPair<>(KPRIMERO, VPRIMERO));
        expected.add(new MyPair<>(KSEGUNDO, VSEGUNDO));

        MyList<MyPair<Integer, String>> actual = myMap.getListOfKeysAndValues();

        assertEquals(expected, actual);

    }


}
