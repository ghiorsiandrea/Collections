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
    void givenAnEmptyList_WhenAddElement_ThenElementIsInTheList() {
        myList.add(PRIMERO);

        assertEquals(1, myList.size());
        assertTrue(myList.contains(PRIMERO));
    }

    @Test
    void givenAnEmptyAnEList_WhenAddOneElement_ThenTheExpectedSizeIsOne() {
        myList.add(PRIMERO);

        assertNotEquals(2, myList.size());
        assertTrue(myList.contains(PRIMERO));
    }

    @Test
    void givenAnEmptyAnEList_WhenAddOneElement_ThenAssertNotContainsAnotherElement() {
        myList.add(PRIMERO);

        assertEquals(1, myList.size());
        assertFalse(myList.contains("A"));
    }

    @Test
    void givenAnEmptyList_WhenAddTwoElements_ThenElementsAreInTheList() {
        prepareContextTestsWithTwoFile();

        assertEquals(2, myList.size());
        assertTrue(myList.contains(PRIMERO));
        assertTrue(myList.contains(SEGUNDO));
    }

    @Test
    void givenAnEmptyList_WhenAddIElementsWithFor_ThenElementsAreInTheList() {
        for (int i = 0; i < 88; i++) {
            myList.add("A" + i);
            assertTrue(myList.contains("A" + i));
        }

        assertEquals(88, myList.size());

    }

    @Test
    void givenAnEmptyList_WhenAddIElementsWithFor_ThenElementsAreInTheListAndTheListGrowth() {
        for (int i = 0; i < 100; i++) {
            myList.add("A" + i);
            assertTrue(myList.contains("A" + i));
        }

        assertEquals(100, myList.size());
    }

    @ParameterizedTest
    @ValueSource(ints = {88, 100, 120})
    void givenAnEmptyList_WhenAddIElementsWithFor_ThenElementsAreInTheList(int length) {
        for (int i = 0; i < length; i++) {
            myList.add("A" + i);
        }

        assertEquals(length, myList.size());
        for (int i = 0; i < length; i++) {
            assertTrue(myList.contains("A" + i));
        }
    }

    @Test
    void givenAListWithTwoElements_WhenRemoveElement_ThenElementIsNotInTheList() {
        prepareContextTestsWithTwoFile();

        myList.remove(0);
        assertEquals(1, myList.size());
        assertFalse(myList.contains(PRIMERO));
    }

    @Test
    void givenAListWithOneElement_WhenRemoveAndAddElement_ThenElementIsInTheList() {
        myList.add(PRIMERO);

        myList.remove(0);

        assertEquals(0, myList.size());
        assertFalse(myList.contains(PRIMERO));

        myList.add(PRIMERO);

        assertTrue(myList.contains(PRIMERO));
    }

    @Test
    void givenAListWithTwoElements_WhenRemoveAll_ThenTheListIsEmpty() {
        prepareContextTestsWithTwoFile();

        myList.removeAll();

        assertEquals(0, myList.size());
        assertFalse(myList.contains(PRIMERO));
    }

    @Test
    void givenAnEmptyList_WhenRemoveAll_ThenTheListIsStillEmptyAndNotThrowsException() {
        myList.removeAll();

        assertEquals(0, myList.size());
        assertFalse(myList.contains(PRIMERO));
    }

    @Test
    public void givenAnEmptyList_WhenExceptionThrown_ThenAssertionSucceedsINexistentElement() {
        int prueba = 50;
        Exception exception = assertThrows(IllegalArgumentException.class, ()
                -> myList.remove(prueba));

        String expectedMessage = String.format("There is no element into %s", prueba);
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void givenAnEmptyList_WhenExceptionThrown_ThenAssertionSucceedsNegativeElement() {
        int prueba = -100;
        Exception exception = assertThrows(IllegalArgumentException.class, ()
                -> myList.remove(prueba));

        String expectedMessage = "The position can not be negative";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void givenAListWithTwoElemnets_WhenGetPosition_ThenResponseOk() {
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
    void givenAnEmptyList_WhenInCaseSameObject_ThenEqualsShouldReturnTrue() {
        assertEquals(myList, myList);
    }

    @Test
    void givenTheSameList_WhenUseEquals_ThenShouldReturnTrue() {
        prepareContextTestsWithTwoFile();

        MyList<String> myList2 = myList;
        assertEquals(myList, myList2);
    }

    @Test
    void givenAList_WhenEqualsInCaseSameObjectInANewList_ThenShouldReturnTrue() {
        prepareContextTestsWithTwoFile();

        MyList<String> myList2 = new MyListImpl1<>();
        myList2.add(PRIMERO);
        myList2.add(SEGUNDO);
        assertEquals(myList, myList2);
    }

    @Test
    void givenAListsWithDifferentLength_WhenUseEquals_ThenShouldReturnFalse() {
        prepareContextTestsWithTwoFile();
        MyList<String> myList2 = new MyListImpl1<>();
        myList2.add(PRIMERO);
        myList2.add(SEGUNDO);
        myList2.add("A");

        assertNotEquals(myList, myList2);
    }

    @Test
    void givenDifferentLists_WhenUseEquals_ThenShouldReturnFalse() {
        prepareContextTestsWithTwoFile();
        MyList<String> myList2 = new MyListImpl1<>();
        myList2.add(PRIMERO);
        myList2.add("A");

        assertNotEquals(myList, myList2);
    }

    @Test
    void givenTwoObjects_WhenHasDifferentClasses_ThenEqualsShouldReturnFalse() {
        prepareContextTestsWithTwoFile();
        MyMapImpl1<String, String> myMap = new MyMapImpl1<>();
        myMap.put(PRIMERO, PRIMERO);
        myMap.put(SEGUNDO, SEGUNDO);

        assertNotEquals(myList, myMap);
    }

    void prepareContextTestsWithTwoFile() {
        myList.add(PRIMERO);
        myList.add(SEGUNDO);
    }

}
