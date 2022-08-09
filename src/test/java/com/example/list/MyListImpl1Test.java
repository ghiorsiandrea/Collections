package com.example.list;

import com.example.map.MyMapImpl1;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class MyListImpl1Test {
    static final String PRIMERO = "Hola, soy el primer elemento";
    static final String SEGUNDO = "Hola, soy el segundo elemento";

    MyList<String> myList;

    @BeforeEach
    public void setupBefore() {
        myList = new MyListImpl1<>();
    }

    @Test
    void createEmptyListOk() {
        assertEquals(0, myList.size());
    }

    @Test
    void addElementOK() {
        prepareContextSingleFile();
        assertEquals(1, myList.size());
        assertTrue(myList.contains(PRIMERO));
    }

    @Test
    void addElementErrorSize() {
        prepareContextSingleFile();
        assertNotEquals(2, myList.size());
        assertTrue(myList.contains(PRIMERO));
    }

    @Test
    void addElementErrorContains() {
        prepareContextSingleFile();
        assertEquals(1, myList.size());
        assertFalse(myList.contains("A"));
    }

    @Test
    void addMultipleElementOK() {
        prepareContextTwoFile();
        //Assert
        assertEquals(2, myList.size());
        assertTrue(myList.contains(PRIMERO));
        assertTrue(myList.contains(SEGUNDO));
    }

    @Test
    void addMUltipleElementErrorSize() {
        prepareContextTwoFile();
        //Assert
        assertNotEquals(3, myList.size());
        assertTrue(myList.contains(PRIMERO));
        assertTrue(myList.contains(SEGUNDO));
    }

    @Test
    void addMUltipleElementErrorContains() {
        prepareContextTwoFile();
        //Assert
        assertEquals(2, myList.size());
        assertTrue(myList.contains(PRIMERO));
        assertTrue(myList.contains(SEGUNDO));
        assertFalse(myList.contains("aaaa"));
    }

    @Test
    void addMultipleElementOKWithFor() {
        for (int i = 0; i < 88; i++) {
            myList.add("A" + i);
        }
        //Assert
        assertEquals(88, myList.size());
        System.out.println(myList);
    }

    @Test
    void addMultipleElementOKGrowth() {
        for (int i = 0; i < 100; i++) {
            myList.add("A" + i);
        }
        //Assert
        assertEquals(100, myList.size());
        System.out.println(myList);
    }

    @ParameterizedTest
    @ValueSource(ints = {88, 100, 120})
    void addMultipleElementOKWithFor(int length) {
        for (int i = 0; i < length; i++) {
            myList.add("A" + i);
        }
        //Assert
        assertEquals(length, myList.size());
        for (int i = 0; i < length; i++) {
            assertTrue(myList.contains("A" + i));
        }
    }

    @Test
    void RemoveMultipleElementOK() {
        prepareContextTwoFile();
        assertEquals(2, myList.size());
        assertTrue(myList.contains(PRIMERO));
        assertTrue(myList.contains(SEGUNDO));
        myList.remove(0);
        assertEquals(1, myList.size());
        assertFalse(myList.contains(PRIMERO));
    }

    @Test
    void RemoveMultipleElementError() {
        prepareContextTwoFile();
        assertEquals(2, myList.size());
        assertTrue(myList.contains(PRIMERO));
        assertTrue(myList.contains(SEGUNDO));
        myList.remove(0);
        assertNotEquals(2, myList.size());
        assertFalse(myList.contains(PRIMERO));
    }

    @Test
    void RemoveMultipleElementChangingState() {
        prepareContextTwoFile();
        assertEquals(2, myList.size());
        assertTrue(myList.contains(PRIMERO));
        assertTrue(myList.contains(SEGUNDO));
        myList.remove(0);
        assertEquals(1, myList.size());
        assertFalse(myList.contains(PRIMERO));
        prepareContextSingleFile();
        assertTrue(myList.contains(PRIMERO));
    }

    @Test
    void RemoveAllOk() {
        prepareContextTwoFile();
        assertEquals(2, myList.size());
        assertTrue(myList.contains(PRIMERO));
        assertTrue(myList.contains(SEGUNDO));
        myList.removeAll();
        assertEquals(0, myList.size());
        assertFalse(myList.contains(PRIMERO));
    }

    @Test
    void RemoveAllEmpty() {
        myList.removeAll();
        assertEquals(0, myList.size());
        assertFalse(myList.contains(PRIMERO));
    }

    @Test
    public void whenExceptionThrown_thenAssertionSucceedsINexistentElement() {
        int prueba = 50;
        Exception exception = assertThrows(IllegalArgumentException.class, ()
                -> myList.remove(prueba));

        String expectedMessage = String.format("There is no element into %s", prueba);
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void whenExceptionThrown_thenAssertionSucceedsNegativeElement() {
        int prueba = -100;
        Exception exception = assertThrows(IllegalArgumentException.class, ()
                -> myList.remove(prueba));

        String expectedMessage = "The position can not be negative";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void getPos() {
        prepareContextTwoFile();

        assertEquals(myList.get(0), PRIMERO);
        assertEquals(myList.get(1), SEGUNDO);
    }

    @ParameterizedTest
    @ValueSource(ints = {88, 100, 120})
    void getPosWithFor(int length) {
        for (int i = 0; i < length; i++) {
            myList.add("A" + i);
        }
        //Assert
        assertEquals(length, myList.size());
        for (int i = 0; i < length; i++) {
            assertEquals(myList.get(i), "A" + i);
        }
    }

    @Test
    void equalsCaseSameObjectEmptyList() {
        assertEquals(myList, myList);
    }

    @Test
    void equalsCaseSameObjectNewList() {
        prepareContextTwoFile();
        MyList<String> myList2 = myList;
        assertEquals(myList, myList2);
    }

    @Test
    void Given_TheSameList_Then_EqualsShouldReturnTrue() {
        prepareContextTwoFile();
        MyList<String> myList2 = new MyListImpl1<>();
        myList2.add(PRIMERO);
        myList2.add(SEGUNDO);
        assertEquals(myList, myList2);
    }

    @Test
    void Given_ListsWithDifferentLength_Then_EqualsShouldReturnFalse() {
        prepareContextTwoFile();
        MyList<String> myList2 = new MyListImpl1<>();
        myList2.add(PRIMERO);
        myList2.add(SEGUNDO);
        myList2.add("A");
        assertNotEquals(myList, myList2);
    }
    @Test
    void Given_DifferentLists_Then_EqualsShouldReturnFalse() {
        prepareContextTwoFile();
        MyList<String> myList2 = new MyListImpl1<>();
        myList2.add(PRIMERO);
        myList2.add("A");
        assertNotEquals(myList, myList2);
    }

    @Test
    void WhenHasDifferentClassesThenIsNotEquals() {
        prepareContextTwoFile();
        MyMapImpl1<String, String> myMap = new MyMapImpl1<>();
        myMap.put(PRIMERO, PRIMERO);
        myMap.put(SEGUNDO, SEGUNDO);
        assertNotEquals(myList, myMap);
    }

    @Test
    void given_DifferentClasses_Then_EqualsShouldReturnFalse() {
        prepareContextTwoFile();
        MyMapImpl1<String, String> myMap = new MyMapImpl1<>();
        myMap.put(PRIMERO, PRIMERO);
        myMap.put(SEGUNDO, SEGUNDO);
        assertNotEquals(myList, myMap);
    }

    void prepareContextSingleFile() {
        myList.add(PRIMERO);
    }

    void prepareContextTwoFile() {
        myList.add(PRIMERO);
        myList.add(SEGUNDO);
    }
}
