package com.example.util;

import com.example.map.MyMapImpl1;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MyPairTests {

    static final String L = "Hola, soy el izquierdo";
    static final String R = "Hola, soy el derecho";

    MyPair<String, String> myPair;

    @BeforeEach
    public void setupBefore() {
        myPair = new MyPair<>(L, R);
    }

    @Test
    void givenADefaultPair_WhenCreateAPair_ThenAssertionsSucceeds() {
        assertEquals(L, myPair.getLeft());
        assertEquals(R, myPair.getRight());
    }

    @Test
    void givenTheSamePair_WhenUseEquals_ThenReturnTrue() {
        assertEquals(myPair, myPair);
    }

    @Test
    void givenANewIdenticPair_WhenUseEquals_ThenReturnTrue() {
        assertEquals(myPair, new MyPair<>(L, R));
    }

    @Test
    void givenANewDifferentPair_WhenUseEquals_ThenReturnFalse() {
        assertNotEquals(myPair, new MyPair<>(L, "B"));
    }

    @Test
    void givenADifferentPairWithNull_WhenUseEquals_ThenReturnFalse() {
        assertNotEquals(myPair, new MyPair<>(L, null));
    }

    @Test
    void givenDifferentClasses_WhenUseEquals_ThenShouldReturnFalse() {
        MyMapImpl1<String, String> myMap = new MyMapImpl1<>();
        myMap.put("AA", "A");
        myMap.put("BB", "B");
        assertNotEquals(myPair, myMap);
    }

}
