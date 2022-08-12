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
        prepareContextTestWithASingleFile();

        assertEquals(1, myList.size());
        assertTrue(myList.contains(PRIMERO));
    }

    @Test
    void given_AListWithOneElement_TheExpectedSizeIs1() {
        prepareContextTestWithASingleFile();

        assertNotEquals(2, myList.size());
        assertTrue(myList.contains(PRIMERO));
    }

    @Test
    void given_AListWithOneElement_ThenAssertNotContainsAnotherElement() {
        prepareContextTestWithASingleFile();

        assertEquals(1, myList.size());
        assertFalse(myList.contains("A"));
    }

    @Test
    void given_AnEmptyList_addMultipleElement_OK() {
        prepareContextTestsWithTwoFile();

        assertEquals(2, myList.size());
        assertTrue(myList.contains(PRIMERO));
        assertTrue(myList.contains(SEGUNDO));
    }

    @Test
    void addMultipleElementWithForOk() {
        for (int i = 0; i < 88; i++) {
            myList.add("A" + i);
        }

        assertEquals(88, myList.size());
    }

    @Test
    void addMultipleElementGrowthOk() {
        for (int i = 0; i < 100; i++) {
            myList.add("A" + i);
        }

        assertEquals(100, myList.size());
    }

    @ParameterizedTest
    @ValueSource(ints = {88, 100, 120})
    void addMultipleElementWithForOk(int length) {
        for (int i = 0; i < length; i++) {
            myList.add("A" + i);
        }

        assertEquals(length, myList.size());
        for (int i = 0; i < length; i++) {
            assertTrue(myList.contains("A" + i));
        }
    }

    @Test
    void given_AListWithTwoElemnets_RemoveMultipleElements_OK() {
        prepareContextTestsWithTwoFile();

        myList.remove(0);
        assertEquals(1, myList.size());
        assertFalse(myList.contains(PRIMERO));
    }

    @Test
    void given_AListWithTwoElemnets_ChangingState_RemoveMultipleElement_Ok() {
        prepareContextTestsWithTwoFile();


        myList.remove(0);

        assertEquals(1, myList.size());
        assertFalse(myList.contains(PRIMERO));

        prepareContextTestWithASingleFile();

        assertTrue(myList.contains(PRIMERO));
    }

    @Test
    void given_AListWithTwoElemnets_removeAllOk() {
        prepareContextTestsWithTwoFile();

        myList.removeAll();

        assertEquals(0, myList.size());
        assertFalse(myList.contains(PRIMERO));
    }

    @Test
    void given_AnEmptyList_RemoveAllOk() {
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
    void given_AListWithTwoElemnets_GetPositionOk() {
        prepareContextTestsWithTwoFile();

        assertEquals(myList.get(0), PRIMERO);
        assertEquals(myList.get(1), SEGUNDO);
    }

    @ParameterizedTest
    @ValueSource(ints = {88, 100, 120})
    void getPosWithForOk(int length) {
        for (int i = 0; i < length; i++) {
            myList.add("A" + i);
        }

        assertEquals(length, myList.size());

        for (int i = 0; i < length; i++) {
            assertEquals(myList.get(i), "A" + i);
        }
    }

    @Test
    void given_AnEmptyList_equalsInCaseSameObject_ShouldReturnTrue() {
        assertEquals(myList, myList);
    }

    @Test
    void given_TheSameList_Then_EqualsShouldReturnTrue() {
        prepareContextTestsWithTwoFile();

        MyList<String> myList2 = myList;
        assertEquals(myList, myList2);
    }

    @Test
    void given_AList_equalsInCaseSameObjectInANewList_ShouldReturnTrue() {
        prepareContextTestsWithTwoFile();

        MyList<String> myList2 = new MyListImpl1<>();
        myList2.add(PRIMERO);
        myList2.add(SEGUNDO);
        assertEquals(myList, myList2);
    }

    @Test
    void given_ListsWithDifferentLength_Then_EqualsShouldReturnFalse() {
        prepareContextTestsWithTwoFile();
        MyList<String> myList2 = new MyListImpl1<>();
        myList2.add(PRIMERO);
        myList2.add(SEGUNDO);
        myList2.add("A");

        assertNotEquals(myList, myList2);
    }

    @Test
    void given_DifferentLists_Then_EqualsShouldReturnFalse() {
        prepareContextTestsWithTwoFile();
        MyList<String> myList2 = new MyListImpl1<>();
        myList2.add(PRIMERO);
        myList2.add("A");

        assertNotEquals(myList, myList2);
    }

    @Test
    void whenHasDifferentClassesThenIsNotEquals() {
        prepareContextTestsWithTwoFile();
        MyMapImpl1<String, String> myMap = new MyMapImpl1<>();
        myMap.put(PRIMERO, PRIMERO);
        myMap.put(SEGUNDO, SEGUNDO);

        assertNotEquals(myList, myMap);
    }

    @Test
    void given_DifferentClasses_Then_EqualsShouldReturnFalse() {
        prepareContextTestsWithTwoFile();
        MyMapImpl1<String, String> myMap = new MyMapImpl1<>();
        myMap.put(PRIMERO, PRIMERO);
        myMap.put(SEGUNDO, SEGUNDO);

        assertNotEquals(myList, myMap);
    }

    void prepareContextTestWithASingleFile() {
        myList.add(PRIMERO);
    }

    void prepareContextTestsWithTwoFile() {
        myList.add(PRIMERO);
        myList.add(SEGUNDO);
    }
}
